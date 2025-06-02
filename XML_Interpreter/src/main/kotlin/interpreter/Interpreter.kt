package interpreter

import ast.*
import parser.XmlParser
import java.io.File

sealed class Value {
    data class XmlNodeVal(val node: XmlNode) : Value() {
        override fun toString(): String = serializeXml(node)
    }
    data class XmlListVal(val nodes: List<XmlNode>) : Value() {
        override fun toString(): String = nodes.joinToString("") { serializeXml(it) }
    }
    data class StringVal(val value: String) : Value() {
        override fun toString(): String = value
    }
    data class NumberVal(val value: Double) : Value() {
        override fun toString(): String = value.toString()
    }
}

fun serializeXml(node: XmlNode): String = when (node) {
    is Element -> {
        val attrs = node.attributes.entries.joinToString(" ") { "${it.key}=\"${it.value}\"" }
        if (node.name == "wrapper") node.children.joinToString("") { serializeXml(it) }
        else if (node.children.isEmpty()) "<${node.name}${if (attrs.isNotEmpty()) " $attrs" else ""}/>"
        else "<${node.name}${if (attrs.isNotEmpty()) " $attrs" else ""}>${node.children.joinToString("") { serializeXml(it) }}</${node.name}>"
    }
    is Text -> node.content
}

class Interpreter(private val args: List<String>, private val statements: List<Statement> = emptyList()) {
    val environment = mutableMapOf<String, Value>()

    init {
        val paramCount = statements.flatMap { findParameters(it) }.distinct().size
        if (args.size < paramCount) throw Exception("Expected at least $paramCount arguments, got ${args.size}")
        args.forEachIndexed { index, arg -> environment["\$${index + 1}"] = Value.StringVal(arg) }
    }

    private fun findParameters(statement: Statement): List<String> {
        val params = mutableListOf<String>()
        when (statement) {
            is Load -> params.addAll(findParametersInExpr(statement.source))
            is Assignment -> params.addAll(findParametersInExpr(statement.expression))
            is Save -> {
                params.add(statement.variable)
                params.addAll(findParametersInExpr(statement.destination))
            }
        }
        if (statement is Assignment && statement.expression is XmlTemplate) {
            params.addAll(findParametersInTemplate((statement.expression as XmlTemplate).template))
        }
        return params
    }

    private fun findParametersInExpr(expr: Expression): List<String> {
        return when (expr) {
            is Path -> if (expr.base.startsWith("$") && expr.base.drop(1).toIntOrNull() != null) listOf(expr.base) else emptyList()
            is CountExpr -> findParametersInExpr(expr.path)
            is MapExpr -> findParametersInExpr(expr.path)
            is AggregateExpr -> findParametersInExpr(expr.path)
            is Literal -> emptyList()
            is XmlTemplate -> findParametersInTemplate(expr.template)
        }
    }

    private fun findParametersInTemplate(template: String): List<String> {
        val regex = Regex("\\$[0-9]+|\\$[a-zA-Z0-9_]+")
        return regex.findAll(template).map { it.value }.toList()
    }

    fun interpret(statements: List<Statement>) {
        statements.forEach { executeStatement(it) }
    }

    private fun executeStatement(statement: Statement) {
        when (statement) {
            is Load -> {
                val source = evaluateExpression(statement.source)
                if (source is Value.StringVal) {
                    val xmlText = File(source.value).readText()
                    environment[statement.variable] = Value.XmlNodeVal(XmlParser.parse(xmlText))
                } else throw Exception("Load source must be a string")
            }
            is Assignment -> environment[statement.variable] = evaluateExpression(statement.expression)
            is Save -> {
                val value = environment[statement.variable] ?: throw Exception("Variable not found: ${statement.variable}")
                val dest = evaluateExpression(statement.destination)
                if (dest is Value.StringVal) {
                    val content = when (value) {
                        is Value.StringVal -> value.value
                        is Value.XmlNodeVal -> serializeXml(value.node)
                        else -> throw Exception("Cannot save value of type ${value::class.simpleName}")
                    }
                    File(dest.value).writeText(content)
                } else throw Exception("Save destination must be a string")
            }
        }
    }

    private fun evaluateExpression(expr: Expression): Value {
        return when (expr) {
            is Path -> evaluatePath(expr)
            is CountExpr -> {
                val pathValue = evaluatePath(expr.path)
                if (pathValue is Value.XmlListVal) Value.NumberVal(pathValue.nodes.size.toDouble())
                else throw Exception("Count operation requires a list")
            }
            is MapExpr -> evaluateMapExpr(expr)
            is AggregateExpr -> evaluateAggregateExpr(expr)
            is Literal -> {
                if (expr.isNumber) Value.NumberVal(expr.value.toDouble())
                else Value.StringVal(expr.value.removeSurrounding("\""))
            }
            is XmlTemplate -> Value.XmlNodeVal(processTemplate(expr.template))
        }
    }

    private fun evaluatePath(path: Path): Value {
        var current = environment[path.base] ?: throw Exception("Variable not found: ${path.base}")
        for (step in path.steps) {
            current = when (step) {
                is Child -> {
                    when (current) {
                        is Value.XmlNodeVal -> {
                            val node = current.node
                            if (node is Element) {
                                node.attributes[step.name]?.let { Value.StringVal(it) } ?:
                                node.children.filterIsInstance<Element>().filter { it.name == step.name }.let { children ->
                                    if (children.size == 1 && children[0].children.all { it is Text }) {
                                        Value.StringVal(children[0].children.joinToString("") { (it as Text).content })
                                    } else if (children.size == 1) {
                                        Value.XmlNodeVal(children[0])
                                    } else {
                                        Value.XmlListVal(children)
                                    }
                                } ?: throw Exception("Child or attribute '${step.name}' not found")
                            } else {
                                throw Exception("Cannot apply child step to non-element node")
                            }
                        }
                        is Value.XmlListVal -> {
                            val children = current.nodes.flatMap { node ->
                                if (node is Element) node.children.filterIsInstance<Element>().filter { child -> child.name == step.name }
                                else emptyList<Element>()
                            }
                            Value.XmlListVal(children)
                        }
                        else -> throw Exception("Cannot apply child step to '${current::class.simpleName}'")
                    }
                }
                is Index -> {
                    if (current is Value.XmlListVal) {
                        if (step.index < current.nodes.size) {
                            Value.XmlNodeVal(current.nodes[step.index])
                        } else {
                            throw Exception("Index out of bounds: ${step.index}")
                        }
                    } else {
                        throw Exception("Cannot apply index to non-list")
                    }
                }
                is Attribute -> {
                    when (current) {
                        is Value.XmlNodeVal -> {
                            val node = current.node
                            if (node is Element) {
                                Value.StringVal(node.attributes[step.name] ?: throw Exception("Attribute '${step.name}' not found"))
                            } else {
                                throw Exception("Cannot apply attribute to non-element node")
                            }
                        }
                        is Value.XmlListVal -> {
                            Value.XmlListVal(current.nodes.map { node ->
                                if (node is Element) Text(node.attributes[step.name] ?: throw Exception("Attribute '${step.name}' not found"))
                                else Text("")
                            })
                        }
                        else -> throw Exception("Cannot apply attribute to '${current::class.simpleName}'")
                    }
                }
            }
        }
        return current
    }

    private fun evaluateMapExpr(expr: MapExpr): Value {
        val pathValue = evaluatePath(expr.path)
        if (pathValue is Value.XmlListVal) {
            val values = pathValue.nodes.map { node: XmlNode ->
                if (node is Element) {
                    val targetParts = expr.target.split(".")
                    var current: XmlNode? = node
                    var result: String = ""
                    for (part in targetParts) {
                        if (current is Element) {
                            if (part.startsWith("@")) {
                                result = current.attributes[part.removePrefix("@")] ?: throw Exception("Attribute '$part' not found")
                                break
                            } else {
                                current = current.children.filterIsInstance<Element>().find { it.name == part }
                                if (current != null && current.children.all { it is Text }) {
                                    result = current.children.joinToString("") { (it as Text).content }
                                    break
                                }
                            }
                        } else {
                            throw Exception("Cannot access '$part' on non-element node")
                        }
                    }
                    Value.StringVal(result)
                } else {
                    Value.StringVal("")
                }
            }
            return Value.XmlListVal(values.map { Text(it.toString()) })
        } else {
            throw Exception("Cannot map non-list")
        }
    }

    private fun evaluateAggregateExpr(expr: AggregateExpr): Value {
        val pathValue = evaluatePath(expr.path)
        if (pathValue is Value.XmlListVal) {
            val sum = pathValue.nodes.sumOf { node ->
                if (node is Element) {
                    val value = node.children.filterIsInstance<Element>().find { it.name == expr.target }
                        ?.children?.filterIsInstance<Text>()?.joinToString("") { it.content }?.toDoubleOrNull()
                    value ?: throw Exception("Sum operation requires numeric values for '${expr.target}'")
                } else {
                    0.0
                }
            }
            return Value.NumberVal(sum)
        } else {
            throw Exception("Cannot aggregate non-list")
        }
    }

    private fun processTemplate(template: String): XmlNode {
        val cleanedTemplate = template.trim().removeSurrounding("***").trim()
        // Pré-processar tags com $ para torná-las compatíveis com XML
        val processedTemplate = cleanedTemplate.replace(Regex("<([a-zA-Z_][a-zA-Z0-9_]*)\\$([a-zA-Z_][a-zA-Z0-9_]*)"), "<$1 iter=\"\$2\"")
        val node = XmlParser.parse(processedTemplate)
        return transformNode(node)
    }

    private fun transformNode(node: XmlNode, context: Map<String, Value> = environment): XmlNode {
        if (node is Element) {
            if (node.attributes.containsKey("iter")) {
                val listVar = node.attributes["iter"]?.removePrefix("$") ?: throw Exception("Invalid iteration attribute")
                val tag = node.name
                val list = context[listVar] as? Value.XmlListVal ?: throw Exception("Iteration variable '$listVar' must be a list")
                val items = list.nodes.map { item ->
                    val itemContext = context + when (item) {
                        is Element -> mapOf(
                            listVar to Value.XmlNodeVal(item),
                            "code" to Value.StringVal(item.attributes["code"] ?: "")
                            // Add other necessary fields like "title" or "instructor" here if applicable
                        )
                        else -> emptyMap()
                    }
                    // Calculate newAttrs using itemContext
                    val newAttrs = node.attributes.mapValues { (k, v) ->
                        if (k != "iter" && v.startsWith("$")) {
                            val varName = v.removePrefix("$")
                            val value = itemContext[varName] ?: throw Exception("Variable '$varName' not found")
                            when (value) {
                                is Value.StringVal -> value.value
                                is Value.NumberVal -> value.value.toString()
                                else -> throw Exception("Variable '$varName' must be a string or number")
                            }
                        } else v
                    }.filterKeys { it != "iter" }
                    Element(tag, newAttrs, node.children.map { transformNode(it, itemContext) })
                }
                // Return a wrapper or adjust as needed for the final output
                return Element("wrapper", emptyMap(), items)
            } else {
                val newAttrs = node.attributes.mapValues { (k, v) ->
                    if (v.startsWith("$")) {
                        val varName = v.removePrefix("$")
                        val value = context[varName] ?: throw Exception("Variable '$varName' not found")
                        when (value) {
                            is Value.StringVal -> value.value
                            is Value.NumberVal -> value.value.toString()
                            else -> throw Exception("Variable '$varName' must be a string or number")
                        }
                    } else v
                }
                return Element(node.name, newAttrs, node.children.map { transformNode(it, context) })
            }
        }
        return node
    }
}