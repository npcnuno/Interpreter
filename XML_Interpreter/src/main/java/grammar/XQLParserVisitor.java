// Generated from /home/katchow/Projects/ISCTE/3ano/compiladores/semana3/XML_Interpreter/src/main/kotlin/grammar/XQLParser.g4 by ANTLR 4.13.2
package grammar;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link XQLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface XQLParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link XQLParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(XQLParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQLParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(XQLParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQLParser#load}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoad(XQLParser.LoadContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQLParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(XQLParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQLParser#save}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSave(XQLParser.SaveContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(XQLParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQLParser#path}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPath(XQLParser.PathContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQLParser#pathStep}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPathStep(XQLParser.PathStepContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQLParser#countExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCountExpr(XQLParser.CountExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQLParser#mapExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMapExpr(XQLParser.MapExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQLParser#aggregateExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAggregateExpr(XQLParser.AggregateExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQLParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(XQLParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQLParser#xmlTemplate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlTemplate(XQLParser.XmlTemplateContext ctx);
}