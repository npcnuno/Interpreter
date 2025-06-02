package parser

import ast.*
import org.antlr.v4.runtime.*
import grammar.*

object XQLScriptParser {
    fun parse(script: String): List<Statement> {
        val charStream = CharStreams.fromString(script)
        val lexer = XQLLexer(charStream)
        val tokens = CommonTokenStream(lexer)
        val parser = XQLParser(tokens)
        val visitor = XQLVisitor()
        val statements = visitor.visit(parser.program()) as List<Statement>
        validateVariables(statements)
        return statements
    }

    private fun validateVariables(statements: List<Statement>) {
        val defined = mutableSetOf<String>("doc")
        val used = mutableSetOf<String>()
        statements.forEach {
            when (it) {
                is Load -> {
                    defined.add(it.variable)
                    used.addAll(collectUsedVariables(it.source))
                }
                is Assignment -> {
                    defined.add(it.variable)
                    used.addAll(collectUsedVariables(it.expression))
                }
                is Save -> {
                    used.add(it.variable)
                    used.addAll(collectUsedVariables(it.destination))
                }
            }
        }
        // Exclude template-specific variables defined in iteration context
        val templateVars = setOf("code", "title", "instructor")
        val undefined = used.filter {
            !it.startsWith("$") || it.drop(1).toIntOrNull() == null
        }.filter { it !in defined && it !in templateVars }
        if (undefined.isNotEmpty()) throw Exception("Undefined variables: $undefined")
    }

    private fun collectUsedVariables(expr: Expression): Set<String> {
        return when (expr) {
            is Path -> setOf(expr.base) + expr.steps.filterIsInstance<Attribute>().map { it.name }
            is CountExpr -> collectUsedVariables(expr.path)
            is MapExpr -> collectUsedVariables(expr.path)
            is AggregateExpr -> collectUsedVariables(expr.path)
            is Literal -> emptySet()
            is XmlTemplate -> {
                val regex = Regex("\\$[a-zA-Z0-9_]+")
                regex.findAll(expr.template).map { it.value.removePrefix("$") }.toSet()
            }
        }
    }
}

private class XQLVisitor : XQLParserBaseVisitor<Any>() {
    override fun visitProgram(ctx: XQLParser.ProgramContext): List<Statement> {
        return ctx.statement().map { visitStatement(it) as Statement }
    }

    override fun visitStatement(ctx: XQLParser.StatementContext): Statement {
        return when {
            ctx.load() != null -> visitLoad(ctx.load())
            ctx.assignment() != null -> visitAssignment(ctx.assignment())
            ctx.save() != null -> visitSave(ctx.save())
            else -> throw IllegalStateException("Unknown statement")
        }
    }

    override fun visitLoad(ctx: XQLParser.LoadContext): Statement {
        val source = visitExpr(ctx.expr()) as Expression
        val variable = ctx.ID().text
        return Load(source, variable)
    }

    override fun visitAssignment(ctx: XQLParser.AssignmentContext): Statement {
        val variable = ctx.ID().text
        val expression = visitExpr(ctx.expr()) as Expression
        return Assignment(variable, expression)
    }

    override fun visitSave(ctx: XQLParser.SaveContext): Statement {
        val variable = ctx.ID().text
        val destination = visitExpr(ctx.expr()) as Expression
        return Save(variable, destination)
    }

    override fun visitExpr(ctx: XQLParser.ExprContext): Expression {
        return when {
            ctx.path() != null -> visitPath(ctx.path())
            ctx.countExpr() != null -> visitCountExpr(ctx.countExpr())
            ctx.mapExpr() != null -> visitMapExpr(ctx.mapExpr())
            ctx.aggregateExpr() != null -> visitAggregateExpr(ctx.aggregateExpr())
            ctx.literal() != null -> visitLiteral(ctx.literal())
            ctx.xmlTemplate() != null -> visitXmlTemplate(ctx.xmlTemplate())
            else -> throw IllegalStateException("Unknown expression")
        }
    }

    override fun visitPath(ctx: XQLParser.PathContext): Expression {
        val base = ctx.ID().text
        val steps = ctx.pathStep().map { step ->
            when {
                step.DOT() != null -> {
                    val name = step.ID().text
                    if (step.text.startsWith(".@")) Attribute(name)
                    else Child(name)
                }
                step.LEFT_BRACKET() != null -> Index(step.NUMBER().text.toInt())
                else -> throw IllegalStateException("Unknown path step")
            }
        }
        return Path(base, steps)
    }

    override fun visitCountExpr(ctx: XQLParser.CountExprContext): Expression {
        return CountExpr(visitPath(ctx.path()) as Path)
    }

    override fun visitMapExpr(ctx: XQLParser.MapExprContext): Expression {
        val path = visitPath(ctx.path()) as Path
        val targetParts = mutableListOf(ctx.ID(0).text)
        for (i in 1 until ctx.ID().size) {
            targetParts.add(ctx.ID(i).text)
        }
        val target = targetParts.joinToString(".")
        return MapExpr(path, target)
    }

    override fun visitAggregateExpr(ctx: XQLParser.AggregateExprContext): Expression {
        return AggregateExpr(visitPath(ctx.path()) as Path, ctx.ID().text)
    }

    override fun visitLiteral(ctx: XQLParser.LiteralContext): Expression {
        return when {
            ctx.STRING() != null -> Literal(ctx.STRING().text.removeSurrounding("\""), false)
            ctx.NUMBER() != null -> Literal(ctx.NUMBER().text, true)
            else -> throw IllegalStateException("Unknown literal")
        }
    }

    override fun visitXmlTemplate(ctx: XQLParser.XmlTemplateContext): Expression {
        return XmlTemplate(ctx.XML_TEMPLATE().text.removeSurrounding("***"))
    }
}