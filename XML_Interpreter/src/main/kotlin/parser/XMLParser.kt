package parser

import ast.*
import org.antlr.v4.runtime.*
import grammar.*

object XmlParser {
    fun parse(xml: String): XmlNode {
        val charStream = CharStreams.fromString(xml)
        val lexer = XMLLexer(charStream)
        val tokens = CommonTokenStream(lexer)
        val parser = XMLParser(tokens)
        val visitor = XmlVisitor()
        return visitor.visit(parser.document())
    }
}

private class XmlVisitor : XMLParserBaseVisitor<XmlNode>() {
    override fun visitDocument(ctx: XMLParser.DocumentContext): XmlNode {
        return visitElement(ctx.element())
    }

    override fun visitElement(ctx: XMLParser.ElementContext): XmlNode {
        val name = ctx.Name().first().text
        val attributes = ctx.attribute().associate {
            it.Name().text to it.STRING().text.removeSurrounding("\"", "\"")
        }
        val children = ctx.content()?.let { content ->
            content.element().map { visitElement(it) } +
                    content.chardata().filter { it.TEXT() != null }.map { Text(it.TEXT().text.trim()) }
        } ?: emptyList()
        return Element(name, attributes, children.filter { it !is Text || it.content.isNotBlank() })
    }
}