// Generated from /home/katchow/Interpreter/XML_Interpreter/src/main/kotlin/grammar/XQLParser.g4 by ANTLR 4.13.2
package grammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link XQLParser}.
 */
public interface XQLParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link XQLParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(XQLParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQLParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(XQLParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQLParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(XQLParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQLParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(XQLParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQLParser#load}.
	 * @param ctx the parse tree
	 */
	void enterLoad(XQLParser.LoadContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQLParser#load}.
	 * @param ctx the parse tree
	 */
	void exitLoad(XQLParser.LoadContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQLParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(XQLParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQLParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(XQLParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQLParser#save}.
	 * @param ctx the parse tree
	 */
	void enterSave(XQLParser.SaveContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQLParser#save}.
	 * @param ctx the parse tree
	 */
	void exitSave(XQLParser.SaveContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(XQLParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(XQLParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQLParser#path}.
	 * @param ctx the parse tree
	 */
	void enterPath(XQLParser.PathContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQLParser#path}.
	 * @param ctx the parse tree
	 */
	void exitPath(XQLParser.PathContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQLParser#pathStep}.
	 * @param ctx the parse tree
	 */
	void enterPathStep(XQLParser.PathStepContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQLParser#pathStep}.
	 * @param ctx the parse tree
	 */
	void exitPathStep(XQLParser.PathStepContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQLParser#countExpr}.
	 * @param ctx the parse tree
	 */
	void enterCountExpr(XQLParser.CountExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQLParser#countExpr}.
	 * @param ctx the parse tree
	 */
	void exitCountExpr(XQLParser.CountExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQLParser#mapExpr}.
	 * @param ctx the parse tree
	 */
	void enterMapExpr(XQLParser.MapExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQLParser#mapExpr}.
	 * @param ctx the parse tree
	 */
	void exitMapExpr(XQLParser.MapExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQLParser#aggregateExpr}.
	 * @param ctx the parse tree
	 */
	void enterAggregateExpr(XQLParser.AggregateExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQLParser#aggregateExpr}.
	 * @param ctx the parse tree
	 */
	void exitAggregateExpr(XQLParser.AggregateExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQLParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(XQLParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQLParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(XQLParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQLParser#xmlTemplate}.
	 * @param ctx the parse tree
	 */
	void enterXmlTemplate(XQLParser.XmlTemplateContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQLParser#xmlTemplate}.
	 * @param ctx the parse tree
	 */
	void exitXmlTemplate(XQLParser.XmlTemplateContext ctx);
}