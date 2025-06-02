// Generated from /home/katchow/Projects/ISCTE/3ano/compiladores/semana3/XML_Interpreter/src/main/kotlin/grammar/XQLParser.g4 by ANTLR 4.13.2
package grammar;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class XQLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LOAD=1, TO=2, SAVE=3, EQUALS=4, DOT=5, LEFT_BRACKET=6, RIGHT_BRACKET=7, 
		AT=8, HASH=9, ARROW=10, PLUSPLUS=11, STRING=12, NUMBER=13, ID=14, XML_TEMPLATE=15, 
		WS=16;
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_load = 2, RULE_assignment = 3, 
		RULE_save = 4, RULE_expr = 5, RULE_path = 6, RULE_pathStep = 7, RULE_countExpr = 8, 
		RULE_mapExpr = 9, RULE_aggregateExpr = 10, RULE_literal = 11, RULE_xmlTemplate = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "statement", "load", "assignment", "save", "expr", "path", 
			"pathStep", "countExpr", "mapExpr", "aggregateExpr", "literal", "xmlTemplate"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'load'", "'to'", "'save'", "'='", "'.'", "'['", "']'", "'@'", 
			"'#'", "'->'", "'++'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LOAD", "TO", "SAVE", "EQUALS", "DOT", "LEFT_BRACKET", "RIGHT_BRACKET", 
			"AT", "HASH", "ARROW", "PLUSPLUS", "STRING", "NUMBER", "ID", "XML_TEMPLATE", 
			"WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "XQLParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public XQLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(XQLParser.EOF, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQLParserListener ) ((XQLParserListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQLParserListener ) ((XQLParserListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQLParserVisitor ) return ((XQLParserVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 16394L) != 0)) {
				{
				{
				setState(26);
				statement();
				}
				}
				setState(31);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(32);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public LoadContext load() {
			return getRuleContext(LoadContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public SaveContext save() {
			return getRuleContext(SaveContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQLParserListener ) ((XQLParserListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQLParserListener ) ((XQLParserListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQLParserVisitor ) return ((XQLParserVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(37);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LOAD:
				enterOuterAlt(_localctx, 1);
				{
				setState(34);
				load();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(35);
				assignment();
				}
				break;
			case SAVE:
				enterOuterAlt(_localctx, 3);
				{
				setState(36);
				save();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LoadContext extends ParserRuleContext {
		public TerminalNode LOAD() { return getToken(XQLParser.LOAD, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode TO() { return getToken(XQLParser.TO, 0); }
		public TerminalNode ID() { return getToken(XQLParser.ID, 0); }
		public LoadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_load; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQLParserListener ) ((XQLParserListener)listener).enterLoad(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQLParserListener ) ((XQLParserListener)listener).exitLoad(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQLParserVisitor ) return ((XQLParserVisitor<? extends T>)visitor).visitLoad(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoadContext load() throws RecognitionException {
		LoadContext _localctx = new LoadContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_load);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			match(LOAD);
			setState(40);
			expr();
			setState(41);
			match(TO);
			setState(42);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(XQLParser.ID, 0); }
		public TerminalNode EQUALS() { return getToken(XQLParser.EQUALS, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQLParserListener ) ((XQLParserListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQLParserListener ) ((XQLParserListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQLParserVisitor ) return ((XQLParserVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			match(ID);
			setState(45);
			match(EQUALS);
			setState(46);
			expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SaveContext extends ParserRuleContext {
		public TerminalNode SAVE() { return getToken(XQLParser.SAVE, 0); }
		public TerminalNode ID() { return getToken(XQLParser.ID, 0); }
		public TerminalNode TO() { return getToken(XQLParser.TO, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public SaveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_save; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQLParserListener ) ((XQLParserListener)listener).enterSave(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQLParserListener ) ((XQLParserListener)listener).exitSave(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQLParserVisitor ) return ((XQLParserVisitor<? extends T>)visitor).visitSave(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SaveContext save() throws RecognitionException {
		SaveContext _localctx = new SaveContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_save);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			match(SAVE);
			setState(49);
			match(ID);
			setState(50);
			match(TO);
			setState(51);
			expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public PathContext path() {
			return getRuleContext(PathContext.class,0);
		}
		public CountExprContext countExpr() {
			return getRuleContext(CountExprContext.class,0);
		}
		public MapExprContext mapExpr() {
			return getRuleContext(MapExprContext.class,0);
		}
		public AggregateExprContext aggregateExpr() {
			return getRuleContext(AggregateExprContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public XmlTemplateContext xmlTemplate() {
			return getRuleContext(XmlTemplateContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQLParserListener ) ((XQLParserListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQLParserListener ) ((XQLParserListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQLParserVisitor ) return ((XQLParserVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_expr);
		try {
			setState(59);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(53);
				path();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(54);
				countExpr();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(55);
				mapExpr();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(56);
				aggregateExpr();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(57);
				literal();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(58);
				xmlTemplate();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PathContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(XQLParser.ID, 0); }
		public List<PathStepContext> pathStep() {
			return getRuleContexts(PathStepContext.class);
		}
		public PathStepContext pathStep(int i) {
			return getRuleContext(PathStepContext.class,i);
		}
		public PathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_path; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQLParserListener ) ((XQLParserListener)listener).enterPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQLParserListener ) ((XQLParserListener)listener).exitPath(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQLParserVisitor ) return ((XQLParserVisitor<? extends T>)visitor).visitPath(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PathContext path() throws RecognitionException {
		PathContext _localctx = new PathContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_path);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			match(ID);
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 352L) != 0)) {
				{
				{
				setState(62);
				pathStep();
				}
				}
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PathStepContext extends ParserRuleContext {
		public TerminalNode DOT() { return getToken(XQLParser.DOT, 0); }
		public TerminalNode ID() { return getToken(XQLParser.ID, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(XQLParser.LEFT_BRACKET, 0); }
		public TerminalNode NUMBER() { return getToken(XQLParser.NUMBER, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(XQLParser.RIGHT_BRACKET, 0); }
		public TerminalNode AT() { return getToken(XQLParser.AT, 0); }
		public PathStepContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pathStep; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQLParserListener ) ((XQLParserListener)listener).enterPathStep(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQLParserListener ) ((XQLParserListener)listener).exitPathStep(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQLParserVisitor ) return ((XQLParserVisitor<? extends T>)visitor).visitPathStep(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PathStepContext pathStep() throws RecognitionException {
		PathStepContext _localctx = new PathStepContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_pathStep);
		try {
			setState(75);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOT:
				enterOuterAlt(_localctx, 1);
				{
				setState(68);
				match(DOT);
				setState(69);
				match(ID);
				}
				break;
			case LEFT_BRACKET:
				enterOuterAlt(_localctx, 2);
				{
				setState(70);
				match(LEFT_BRACKET);
				setState(71);
				match(NUMBER);
				setState(72);
				match(RIGHT_BRACKET);
				}
				break;
			case AT:
				enterOuterAlt(_localctx, 3);
				{
				setState(73);
				match(AT);
				setState(74);
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CountExprContext extends ParserRuleContext {
		public PathContext path() {
			return getRuleContext(PathContext.class,0);
		}
		public TerminalNode HASH() { return getToken(XQLParser.HASH, 0); }
		public CountExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_countExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQLParserListener ) ((XQLParserListener)listener).enterCountExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQLParserListener ) ((XQLParserListener)listener).exitCountExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQLParserVisitor ) return ((XQLParserVisitor<? extends T>)visitor).visitCountExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CountExprContext countExpr() throws RecognitionException {
		CountExprContext _localctx = new CountExprContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_countExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			path();
			setState(78);
			match(HASH);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MapExprContext extends ParserRuleContext {
		public PathContext path() {
			return getRuleContext(PathContext.class,0);
		}
		public TerminalNode ARROW() { return getToken(XQLParser.ARROW, 0); }
		public TerminalNode ID() { return getToken(XQLParser.ID, 0); }
		public MapExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mapExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQLParserListener ) ((XQLParserListener)listener).enterMapExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQLParserListener ) ((XQLParserListener)listener).exitMapExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQLParserVisitor ) return ((XQLParserVisitor<? extends T>)visitor).visitMapExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MapExprContext mapExpr() throws RecognitionException {
		MapExprContext _localctx = new MapExprContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_mapExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			path();
			setState(81);
			match(ARROW);
			setState(82);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AggregateExprContext extends ParserRuleContext {
		public PathContext path() {
			return getRuleContext(PathContext.class,0);
		}
		public TerminalNode ARROW() { return getToken(XQLParser.ARROW, 0); }
		public TerminalNode ID() { return getToken(XQLParser.ID, 0); }
		public TerminalNode PLUSPLUS() { return getToken(XQLParser.PLUSPLUS, 0); }
		public AggregateExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aggregateExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQLParserListener ) ((XQLParserListener)listener).enterAggregateExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQLParserListener ) ((XQLParserListener)listener).exitAggregateExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQLParserVisitor ) return ((XQLParserVisitor<? extends T>)visitor).visitAggregateExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AggregateExprContext aggregateExpr() throws RecognitionException {
		AggregateExprContext _localctx = new AggregateExprContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_aggregateExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			path();
			setState(85);
			match(ARROW);
			setState(86);
			match(ID);
			setState(87);
			match(PLUSPLUS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(XQLParser.STRING, 0); }
		public TerminalNode NUMBER() { return getToken(XQLParser.NUMBER, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQLParserListener ) ((XQLParserListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQLParserListener ) ((XQLParserListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQLParserVisitor ) return ((XQLParserVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			_la = _input.LA(1);
			if ( !(_la==STRING || _la==NUMBER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class XmlTemplateContext extends ParserRuleContext {
		public TerminalNode XML_TEMPLATE() { return getToken(XQLParser.XML_TEMPLATE, 0); }
		public XmlTemplateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xmlTemplate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQLParserListener ) ((XQLParserListener)listener).enterXmlTemplate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQLParserListener ) ((XQLParserListener)listener).exitXmlTemplate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQLParserVisitor ) return ((XQLParserVisitor<? extends T>)visitor).visitXmlTemplate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final XmlTemplateContext xmlTemplate() throws RecognitionException {
		XmlTemplateContext _localctx = new XmlTemplateContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_xmlTemplate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			match(XML_TEMPLATE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0010^\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0001\u0000\u0005\u0000\u001c\b\u0000\n\u0000\f\u0000\u001f"+
		"\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0003"+
		"\u0001&\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005<\b\u0005\u0001"+
		"\u0006\u0001\u0006\u0005\u0006@\b\u0006\n\u0006\f\u0006C\t\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0003\u0007L\b\u0007\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b"+
		"\u0001\f\u0001\f\u0001\f\u0000\u0000\r\u0000\u0002\u0004\u0006\b\n\f\u000e"+
		"\u0010\u0012\u0014\u0016\u0018\u0000\u0001\u0001\u0000\f\r[\u0000\u001d"+
		"\u0001\u0000\u0000\u0000\u0002%\u0001\u0000\u0000\u0000\u0004\'\u0001"+
		"\u0000\u0000\u0000\u0006,\u0001\u0000\u0000\u0000\b0\u0001\u0000\u0000"+
		"\u0000\n;\u0001\u0000\u0000\u0000\f=\u0001\u0000\u0000\u0000\u000eK\u0001"+
		"\u0000\u0000\u0000\u0010M\u0001\u0000\u0000\u0000\u0012P\u0001\u0000\u0000"+
		"\u0000\u0014T\u0001\u0000\u0000\u0000\u0016Y\u0001\u0000\u0000\u0000\u0018"+
		"[\u0001\u0000\u0000\u0000\u001a\u001c\u0003\u0002\u0001\u0000\u001b\u001a"+
		"\u0001\u0000\u0000\u0000\u001c\u001f\u0001\u0000\u0000\u0000\u001d\u001b"+
		"\u0001\u0000\u0000\u0000\u001d\u001e\u0001\u0000\u0000\u0000\u001e \u0001"+
		"\u0000\u0000\u0000\u001f\u001d\u0001\u0000\u0000\u0000 !\u0005\u0000\u0000"+
		"\u0001!\u0001\u0001\u0000\u0000\u0000\"&\u0003\u0004\u0002\u0000#&\u0003"+
		"\u0006\u0003\u0000$&\u0003\b\u0004\u0000%\"\u0001\u0000\u0000\u0000%#"+
		"\u0001\u0000\u0000\u0000%$\u0001\u0000\u0000\u0000&\u0003\u0001\u0000"+
		"\u0000\u0000\'(\u0005\u0001\u0000\u0000()\u0003\n\u0005\u0000)*\u0005"+
		"\u0002\u0000\u0000*+\u0005\u000e\u0000\u0000+\u0005\u0001\u0000\u0000"+
		"\u0000,-\u0005\u000e\u0000\u0000-.\u0005\u0004\u0000\u0000./\u0003\n\u0005"+
		"\u0000/\u0007\u0001\u0000\u0000\u000001\u0005\u0003\u0000\u000012\u0005"+
		"\u000e\u0000\u000023\u0005\u0002\u0000\u000034\u0003\n\u0005\u00004\t"+
		"\u0001\u0000\u0000\u00005<\u0003\f\u0006\u00006<\u0003\u0010\b\u00007"+
		"<\u0003\u0012\t\u00008<\u0003\u0014\n\u00009<\u0003\u0016\u000b\u0000"+
		":<\u0003\u0018\f\u0000;5\u0001\u0000\u0000\u0000;6\u0001\u0000\u0000\u0000"+
		";7\u0001\u0000\u0000\u0000;8\u0001\u0000\u0000\u0000;9\u0001\u0000\u0000"+
		"\u0000;:\u0001\u0000\u0000\u0000<\u000b\u0001\u0000\u0000\u0000=A\u0005"+
		"\u000e\u0000\u0000>@\u0003\u000e\u0007\u0000?>\u0001\u0000\u0000\u0000"+
		"@C\u0001\u0000\u0000\u0000A?\u0001\u0000\u0000\u0000AB\u0001\u0000\u0000"+
		"\u0000B\r\u0001\u0000\u0000\u0000CA\u0001\u0000\u0000\u0000DE\u0005\u0005"+
		"\u0000\u0000EL\u0005\u000e\u0000\u0000FG\u0005\u0006\u0000\u0000GH\u0005"+
		"\r\u0000\u0000HL\u0005\u0007\u0000\u0000IJ\u0005\b\u0000\u0000JL\u0005"+
		"\u000e\u0000\u0000KD\u0001\u0000\u0000\u0000KF\u0001\u0000\u0000\u0000"+
		"KI\u0001\u0000\u0000\u0000L\u000f\u0001\u0000\u0000\u0000MN\u0003\f\u0006"+
		"\u0000NO\u0005\t\u0000\u0000O\u0011\u0001\u0000\u0000\u0000PQ\u0003\f"+
		"\u0006\u0000QR\u0005\n\u0000\u0000RS\u0005\u000e\u0000\u0000S\u0013\u0001"+
		"\u0000\u0000\u0000TU\u0003\f\u0006\u0000UV\u0005\n\u0000\u0000VW\u0005"+
		"\u000e\u0000\u0000WX\u0005\u000b\u0000\u0000X\u0015\u0001\u0000\u0000"+
		"\u0000YZ\u0007\u0000\u0000\u0000Z\u0017\u0001\u0000\u0000\u0000[\\\u0005"+
		"\u000f\u0000\u0000\\\u0019\u0001\u0000\u0000\u0000\u0005\u001d%;AK";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}