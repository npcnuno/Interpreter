// Generated from /home/katchow/Projects/ISCTE/3ano/compiladores/semana3/XML_Interpreter/src/main/kotlin/grammar/XQLLexer.g4 by ANTLR 4.13.2
package grammar;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class XQLLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LOAD=1, TO=2, SAVE=3, EQUALS=4, DOT=5, LEFT_BRACKET=6, RIGHT_BRACKET=7, 
		AT=8, HASH=9, ARROW=10, PLUSPLUS=11, STRING=12, NUMBER=13, ID=14, XML_TEMPLATE=15, 
		WS=16;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"LOAD", "TO", "SAVE", "EQUALS", "DOT", "LEFT_BRACKET", "RIGHT_BRACKET", 
			"AT", "HASH", "ARROW", "PLUSPLUS", "STRING", "NUMBER", "ID", "XML_TEMPLATE", 
			"WS"
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


	public XQLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "XQLLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0010t\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000bE\b\u000b"+
		"\n\u000b\f\u000bH\t\u000b\u0001\u000b\u0001\u000b\u0001\f\u0004\fM\b\f"+
		"\u000b\f\f\fN\u0001\f\u0001\f\u0004\fS\b\f\u000b\f\f\fT\u0003\fW\b\f\u0001"+
		"\r\u0001\r\u0005\r[\b\r\n\r\f\r^\t\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0005\u000ee\b\u000e\n\u000e\f\u000eh\t\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0004\u000f"+
		"o\b\u000f\u000b\u000f\f\u000fp\u0001\u000f\u0001\u000f\u0001f\u0000\u0010"+
		"\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r"+
		"\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e"+
		"\u001d\u000f\u001f\u0010\u0001\u0000\u0005\u0002\u0000\"\"\\\\\u0001\u0000"+
		"09\u0003\u0000AZ__az\u0004\u000009AZ__az\u0003\u0000\t\n\r\r  {\u0000"+
		"\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000"+
		"\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000"+
		"\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r"+
		"\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011"+
		"\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015"+
		"\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019"+
		"\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d"+
		"\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0001!\u0001"+
		"\u0000\u0000\u0000\u0003&\u0001\u0000\u0000\u0000\u0005)\u0001\u0000\u0000"+
		"\u0000\u0007.\u0001\u0000\u0000\u0000\t0\u0001\u0000\u0000\u0000\u000b"+
		"2\u0001\u0000\u0000\u0000\r4\u0001\u0000\u0000\u0000\u000f6\u0001\u0000"+
		"\u0000\u0000\u00118\u0001\u0000\u0000\u0000\u0013:\u0001\u0000\u0000\u0000"+
		"\u0015=\u0001\u0000\u0000\u0000\u0017@\u0001\u0000\u0000\u0000\u0019L"+
		"\u0001\u0000\u0000\u0000\u001bX\u0001\u0000\u0000\u0000\u001d_\u0001\u0000"+
		"\u0000\u0000\u001fn\u0001\u0000\u0000\u0000!\"\u0005l\u0000\u0000\"#\u0005"+
		"o\u0000\u0000#$\u0005a\u0000\u0000$%\u0005d\u0000\u0000%\u0002\u0001\u0000"+
		"\u0000\u0000&\'\u0005t\u0000\u0000\'(\u0005o\u0000\u0000(\u0004\u0001"+
		"\u0000\u0000\u0000)*\u0005s\u0000\u0000*+\u0005a\u0000\u0000+,\u0005v"+
		"\u0000\u0000,-\u0005e\u0000\u0000-\u0006\u0001\u0000\u0000\u0000./\u0005"+
		"=\u0000\u0000/\b\u0001\u0000\u0000\u000001\u0005.\u0000\u00001\n\u0001"+
		"\u0000\u0000\u000023\u0005[\u0000\u00003\f\u0001\u0000\u0000\u000045\u0005"+
		"]\u0000\u00005\u000e\u0001\u0000\u0000\u000067\u0005@\u0000\u00007\u0010"+
		"\u0001\u0000\u0000\u000089\u0005#\u0000\u00009\u0012\u0001\u0000\u0000"+
		"\u0000:;\u0005-\u0000\u0000;<\u0005>\u0000\u0000<\u0014\u0001\u0000\u0000"+
		"\u0000=>\u0005+\u0000\u0000>?\u0005+\u0000\u0000?\u0016\u0001\u0000\u0000"+
		"\u0000@F\u0005\"\u0000\u0000AE\b\u0000\u0000\u0000BC\u0005\\\u0000\u0000"+
		"CE\t\u0000\u0000\u0000DA\u0001\u0000\u0000\u0000DB\u0001\u0000\u0000\u0000"+
		"EH\u0001\u0000\u0000\u0000FD\u0001\u0000\u0000\u0000FG\u0001\u0000\u0000"+
		"\u0000GI\u0001\u0000\u0000\u0000HF\u0001\u0000\u0000\u0000IJ\u0005\"\u0000"+
		"\u0000J\u0018\u0001\u0000\u0000\u0000KM\u0007\u0001\u0000\u0000LK\u0001"+
		"\u0000\u0000\u0000MN\u0001\u0000\u0000\u0000NL\u0001\u0000\u0000\u0000"+
		"NO\u0001\u0000\u0000\u0000OV\u0001\u0000\u0000\u0000PR\u0005.\u0000\u0000"+
		"QS\u0007\u0001\u0000\u0000RQ\u0001\u0000\u0000\u0000ST\u0001\u0000\u0000"+
		"\u0000TR\u0001\u0000\u0000\u0000TU\u0001\u0000\u0000\u0000UW\u0001\u0000"+
		"\u0000\u0000VP\u0001\u0000\u0000\u0000VW\u0001\u0000\u0000\u0000W\u001a"+
		"\u0001\u0000\u0000\u0000X\\\u0007\u0002\u0000\u0000Y[\u0007\u0003\u0000"+
		"\u0000ZY\u0001\u0000\u0000\u0000[^\u0001\u0000\u0000\u0000\\Z\u0001\u0000"+
		"\u0000\u0000\\]\u0001\u0000\u0000\u0000]\u001c\u0001\u0000\u0000\u0000"+
		"^\\\u0001\u0000\u0000\u0000_`\u0005*\u0000\u0000`a\u0005*\u0000\u0000"+
		"ab\u0005*\u0000\u0000bf\u0001\u0000\u0000\u0000ce\t\u0000\u0000\u0000"+
		"dc\u0001\u0000\u0000\u0000eh\u0001\u0000\u0000\u0000fg\u0001\u0000\u0000"+
		"\u0000fd\u0001\u0000\u0000\u0000gi\u0001\u0000\u0000\u0000hf\u0001\u0000"+
		"\u0000\u0000ij\u0005*\u0000\u0000jk\u0005*\u0000\u0000kl\u0005*\u0000"+
		"\u0000l\u001e\u0001\u0000\u0000\u0000mo\u0007\u0004\u0000\u0000nm\u0001"+
		"\u0000\u0000\u0000op\u0001\u0000\u0000\u0000pn\u0001\u0000\u0000\u0000"+
		"pq\u0001\u0000\u0000\u0000qr\u0001\u0000\u0000\u0000rs\u0006\u000f\u0000"+
		"\u0000s \u0001\u0000\u0000\u0000\t\u0000DFNTV\\fp\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}