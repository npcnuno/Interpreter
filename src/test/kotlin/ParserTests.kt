import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream

import Kotlin.Test.assertEquals
import CsvLexer
import CsvParser
import CsvParser.CsvContext
import CsvParser.LineContext

class ParserTests {



    fun CsvContext.toAst(): CSV =
        CSV(
            this.line().map {
                it.toAst()
            }
        )

    fun LineContext.toAst(): Line =
        Line(
            this.value().map {
                when {
                    it.BOOLEAN() != null -> Bool(it.BOOLEAN().text == "true")
                    it.NUMBER() != null -> Numeric(it.NUMBER().text.toInt())
                    it.STRING() != null -> Text(it.STRING().text.trim('"'))
                    else -> None
                }
            }
        )

    fun test() {
        val text = """
           "Alan Kay", 1940, ,true
           "Donald Knuth", 1938, ,true
           "Alan Turing", 1912, 1954, false
        """.trimIndent()

        val expected = CSV(
            listOf(
                Line(listOf(Text("Alan Kay"), Numeric(1940), None, Bool(true))),
                Line(listOf(Text("Donald Knuth"), Numeric(1938), None, Bool(true))),
                Line(listOf(Text("Alan Turing"), Numeric(1912), Numeric(1954), Bool(false)))
            )
        )

        val lexer = CsvLexer(CharStreams.fromString(text))
        val parser = CsvParser(CommonTokenStream(lexer))
        val csvContext = parser.csv()
        val csv = csvContext.toAst()

        assertEquals(expected, csv)
    }
}
