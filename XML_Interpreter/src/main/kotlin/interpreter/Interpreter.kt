package interpreter

import ast.*
import parser.XmlParser
import java.io.File

sealed class Value {
    data class XmlNodeVal(val node: XmlNode) : Value()
    data class XmlListVal(val nodes: List<XmlNode>) : Value()
    data class StringVal(val value: String) : Value()
    data class NumberVal(val value: Double) : Value()
}

class Interpreter(private val args: List<String>) {
    val environment = mutableMapOf<String, Value>()

    init {
        args.forEachIndexed { index, arg -> environment["\$${index + 1}"] = Value.StringVal(arg) }
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
                val value = environment[statement.variable] ?: throw Exception("Variable not found")
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

    private fun evaluateExpression(expr: Expression): Value = when (expr) {
        is Path -> evaluatePath(expr)
        is CountExpr -> {
            val pathValue = evaluatePath(expr.path)
            if (pathValue is Value.XmlListVal) Value.NumberVal(pathValue.nodes.size.toDouble())
            else throw Exception("Cannot count non-list")
        }
        is MapExpr -> evaluateMapExpr(expr)
        is AggregateExpr -> evaluateAggregateExpr(expr)
        is Literal -> if (expr.isNumber) Value.NumberVal(expr.value.toDouble()) else Value.StringVal(expr.value)
        is XmlTemplate -> Value.StringVal(processTemplate(expr.template))
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
                                val children = node.children.filterIsInstance<Element>().filter { it.name == step.name }
                                if (children.size == 1 && children[0].children.all { it is Text }) {
                                    Value.StringVal(children[0].children.joinToString("") { (it as Text).content })
                                } else if (children.size == 1) {
                                    Value.XmlNodeVal(children[0])
                                } else {
                                    Value.XmlListVal(children)
                                }
                            } else {
                                throw Exception("Cannot apply child step to non-element node")
                            }
                        }
                        is Value.XmlListVal -> {
                            val children = current.nodes.flatMap { node ->
                                if (node is Element) {
                                    node.children.filterIsInstance<Element>().filter { it.name == step.name }
                                } else emptyList()
                            }
                            Value.XmlListVal(children)
                        }
                        else -> throw Exception("Cannot apply child step to ${current::class.simpleName}")
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
                                Value.StringVal(node.attributes[step.name] ?: "")
                            } else {
                                throw Exception("Cannot apply attribute to non-element node")
                            }
                        }
                        is Value.XmlListVal -> {
                            Value.XmlListVal(current.nodes.map { node ->
                                if (node is Element) Text(node.attributes[step.name] ?: "") else Text("")
                            })
                        }
                        else -> throw Exception("Cannot apply attribute to ${current::class.simpleName}")
                    }
                }
            }
        }
        return current
    }

    private fun evaluateMapExpr(mapExpr: MapExpr): Value {
        val pathValue = evaluatePath(mapExpr.path)
        if (pathValue is Value.XmlListVal) {
            val values = pathValue.nodes.map { node ->
                if (node is Element) {
                    Text(node.attributes[mapExpr.target] ?: "")
                } else {
                    Text("")
                }
            }
            return Value.XmlListVal(values)
        } else {
            throw Exception("Cannot map non-list")
        }
    }

    private fun evaluateAggregateExpr(aggregateExpr: AggregateExpr): Value {
        val pathValue = evaluatePath(aggregateExpr.path)
        if (pathValue is Value.XmlListVal) {
            val sum = pathValue.nodes.sumOf { node ->
                if (node is Element) {
                    val creditNode = node.children.filterIsInstance<Element>().find { it.name == aggregateExpr.target }
                    creditNode?.children?.filterIsInstance<Text>()?.joinToString("") { it.content }?.toDoubleOrNull() ?: 0.0
                } else {
                    0.0
                }
            }
            return Value.NumberVal(sum)
        } else {
            throw Exception("Cannot aggregate non-list")
        }
    }

    private fun processTemplate(template: String): String {
        val placeholderTemplate = template.replace(Regex("\\$([a-zA-Z0-9_]+)")) { "__${it.groupValues[1]}__" }
        val root = XmlParser.parse("<root>$placeholderTemplate</root>")
        val processed = processNode((root as Element).children.first())
        return serializeXml(processed)
    }

    private fun processNode(node: XmlNode): XmlNode = when (node) {
        is Element -> {
            val (tag, listVar) = if ('$' in node.name) node.name.split('$').let { it[0] to it.getOrNull(1) } else node.name to null
            if (listVar != null) {
                val list = (environment[listVar] as? Value.XmlListVal)?.nodes ?: emptyList()
                val children = list.map { item ->
                    if (item !is Element) return@map Element(tag, emptyMap(), emptyList())
                    val attrs = node.attributes.mapValues { (k, v) ->
                        if (v.startsWith("__") && v.endsWith("__")) {
                            item.attributes[v.removeSurrounding("__")] ?: ""
                        } else {
                            v
                        }
                    }
                    Element(tag, attrs, node.children.map { processNode(it) })
                }
                Element(tag, emptyMap(), children)
            } else {
                val attrs = node.attributes.mapValues { (k, v) ->
                    if (v.startsWith("__") && v.endsWith("__")) {
                        val varName = v.removeSurrounding("__")
                        when (val value = environment[varName]) {
                            is Value.StringVal -> value.value
                            is Value.NumberVal -> value.value.toString()
                            else -> v
                        }
                    } else {
                        v
                    }
                }
                Element(node.name, attrs, node.children.map { processNode(it) })
            }
        }
        is Text -> Text(node.content.replace(Regex("__([a-zA-Z0-9_]+)__")) {
            when (val value = environment[it.groupValues[1]]) {
                is Value.StringVal -> value.value
                is Value.NumberVal -> value.value.toString()
                else -> it.value
            }
        })
    }

    private fun serializeXml(node: XmlNode): String = when (node) {
        is Element -> {
            val attrs = node.attributes.entries.joinToString(" ") { "${it.key}=\"${it.value}\"" }
            if (node.children.isEmpty()) "<${node.name}${if (attrs.isNotEmpty()) " $attrs" else ""}/>"
            else "<${node.name}${if (attrs.isNotEmpty()) " $attrs" else ""}>${node.children.joinToString("") { serializeXml(it) }}</${node.name}>"
        }
        is Text -> node.content
    }
}