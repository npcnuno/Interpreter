package ast

sealed class XmlNode

data class Element(
    val name: String,
    val attributes: Map<String, String>,
    val children: List<XmlNode>
) : XmlNode()

data class Text(val content: String) : XmlNode()