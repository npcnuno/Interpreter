import interpreter.Interpreter
import interpreter.Value
import parser.XQLScriptParser
import parser.XmlParser
import java.io.File
import ast.*

fun main(args: Array<String>) {
  if (args.size != 2) {
    println("Usage: <script-file.xql> <input-file.xml>")
    return
  }

  val scriptFile = args[0]
  val xmlFile = args[1]

  // Validate file extensions and existence
  if (!scriptFile.endsWith(".xql")) {
    println("Error: Script file must have .xql extension")
    return
  }
  if (!xmlFile.endsWith(".xml")) {
    println("Error: Input file must have .xml extension")
    return
  }
  if (!File(scriptFile).exists()) {
    println("Error: Script file '$scriptFile' does not exist")
    return
  }
  if (!File(xmlFile).exists()) {
    println("Error: XML file '$xmlFile' does not exist")
    return
  }

  // Read the XQL script
  val script = try {
    File(scriptFile).readText()
  } catch (e: Exception) {
    println("Error reading script file: ${e.message}")
    return
  }

  // Parse the XML file
  val xmlText = try {
    File(xmlFile).readText()
  } catch (e: Exception) {
    println("Error reading XML file: ${e.message}")
    return
  }

  // Parse the script
  val statements = try {
    XQLScriptParser.parse(script)
  } catch (e: Exception) {
    println("Error parsing script: ${e.message}")
    return
  }

  // Initialize interpreter
  val interpreter = Interpreter(emptyList())

  // Load XML into 'doc' variable
  try {
    interpreter.environment["doc"] = Value.XmlNodeVal(XmlParser.parse(xmlText))
  } catch (e: Exception) {
    println("Error parsing XML: ${e.message}")
    return
  }

  // Execute the script and capture results
  try {
    interpreter.interpret(statements)
    // Print the 'xml' variable if it exists
    interpreter.environment["xml"]?.let { value ->
      when (value) {
        is Value.StringVal -> println("Output XML:\n${value.value}")
        is Value.XmlNodeVal -> println("Output XML:\n${serializeXml(value.node)}")
        else -> println("Output XML: (unsupported type)")
      }
    } ?: println("No output XML generated (variable 'xml' not found)")
  } catch (e: Exception) {
    println("Error executing script: ${e.message}")
  }
}

// Serialize XmlNode for display
private fun serializeXml(node: XmlNode): String = when (node) {
  is Element -> {
    val attrs = node.attributes.entries.joinToString(" ") { "${it.key}=\"${it.value}\"" }
    if (node.children.isEmpty()) "<${node.name}${if (attrs.isNotEmpty()) " $attrs" else ""}/>"
    else "<${node.name}${if (attrs.isNotEmpty()) " $attrs" else ""}>${node.children.joinToString("") { serializeXml(it) }}</${node.name}>"
  }
  is Text -> node.content
}