package ast

sealed class Statement

data class Load(val source: Expression, val variable: String) : Statement()

data class Assignment(val variable: String, val expression: Expression) : Statement()

data class Save(val variable: String, val destination: Expression) : Statement()

sealed class Expression

data class Path(val base: String, val steps: List<PathStep>) : Expression()

data class CountExpr(val path: Path) : Expression()

data class MapExpr(val path: Path, val target: String) : Expression()

data class AggregateExpr(val path: Path, val target: String) : Expression()

data class Literal(val value: String, val isNumber: Boolean) : Expression()

data class XmlTemplate(val template: String) : Expression()

sealed class PathStep

data class Child(val name: String) : PathStep()

data class Index(val index: Int) : PathStep()

data class Attribute(val name: String) : PathStep()