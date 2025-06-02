// Generated from /home/katchow/Interpreter/XML_Interpreter/src/main/kotlin/grammar/XQLLexer.g4 by ANTLR 4.13.2
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
		SEA_WS=16, COMMENT=17;
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
			"SEA_WS", "COMMENT"
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
			"SEA_WS", "COMMENT"
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
		"\u0004\u0000\u0011\u008d\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001"+
		"\t\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0005\u000bG\b\u000b\n\u000b\f\u000bJ\t\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\f\u0004\fO\b\f\u000b\f\f\fP\u0001\f\u0001\f\u0004\fU\b\f\u000b"+
		"\f\f\fV\u0003\fY\b\f\u0001\r\u0001\r\u0005\r]\b\r\n\r\f\r`\t\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000eg\b\u000e"+
		"\n\u000e\f\u000ej\t\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0003\u000ft\b\u000f"+
		"\u0001\u000f\u0004\u000fw\b\u000f\u000b\u000f\f\u000fx\u0001\u000f\u0001"+
		"\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0005\u0010\u0083\b\u0010\n\u0010\f\u0010\u0086\t\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0002h\u0084"+
		"\u0000\u0011\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b"+
		"\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b"+
		"\u000e\u001d\u000f\u001f\u0010!\u0011\u0001\u0000\u0005\u0002\u0000\""+
		"\"\\\\\u0001\u000009\u0004\u0000$$AZ__az\u0004\u000009AZ__az\u0002\u0000"+
		"\t\t  \u0097\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000"+
		"\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000"+
		"\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000"+
		"\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000"+
		"\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000"+
		"\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000"+
		"\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000"+
		"\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000"+
		"\u0000!\u0001\u0000\u0000\u0000\u0001#\u0001\u0000\u0000\u0000\u0003("+
		"\u0001\u0000\u0000\u0000\u0005+\u0001\u0000\u0000\u0000\u00070\u0001\u0000"+
		"\u0000\u0000\t2\u0001\u0000\u0000\u0000\u000b4\u0001\u0000\u0000\u0000"+
		"\r6\u0001\u0000\u0000\u0000\u000f8\u0001\u0000\u0000\u0000\u0011:\u0001"+
		"\u0000\u0000\u0000\u0013<\u0001\u0000\u0000\u0000\u0015?\u0001\u0000\u0000"+
		"\u0000\u0017B\u0001\u0000\u0000\u0000\u0019N\u0001\u0000\u0000\u0000\u001b"+
		"Z\u0001\u0000\u0000\u0000\u001da\u0001\u0000\u0000\u0000\u001fv\u0001"+
		"\u0000\u0000\u0000!|\u0001\u0000\u0000\u0000#$\u0005l\u0000\u0000$%\u0005"+
		"o\u0000\u0000%&\u0005a\u0000\u0000&\'\u0005d\u0000\u0000\'\u0002\u0001"+
		"\u0000\u0000\u0000()\u0005t\u0000\u0000)*\u0005o\u0000\u0000*\u0004\u0001"+
		"\u0000\u0000\u0000+,\u0005s\u0000\u0000,-\u0005a\u0000\u0000-.\u0005v"+
		"\u0000\u0000./\u0005e\u0000\u0000/\u0006\u0001\u0000\u0000\u000001\u0005"+
		"=\u0000\u00001\b\u0001\u0000\u0000\u000023\u0005.\u0000\u00003\n\u0001"+
		"\u0000\u0000\u000045\u0005[\u0000\u00005\f\u0001\u0000\u0000\u000067\u0005"+
		"]\u0000\u00007\u000e\u0001\u0000\u0000\u000089\u0005@\u0000\u00009\u0010"+
		"\u0001\u0000\u0000\u0000:;\u0005#\u0000\u0000;\u0012\u0001\u0000\u0000"+
		"\u0000<=\u0005-\u0000\u0000=>\u0005>\u0000\u0000>\u0014\u0001\u0000\u0000"+
		"\u0000?@\u0005+\u0000\u0000@A\u0005+\u0000\u0000A\u0016\u0001\u0000\u0000"+
		"\u0000BH\u0005\"\u0000\u0000CG\b\u0000\u0000\u0000DE\u0005\\\u0000\u0000"+
		"EG\t\u0000\u0000\u0000FC\u0001\u0000\u0000\u0000FD\u0001\u0000\u0000\u0000"+
		"GJ\u0001\u0000\u0000\u0000HF\u0001\u0000\u0000\u0000HI\u0001\u0000\u0000"+
		"\u0000IK\u0001\u0000\u0000\u0000JH\u0001\u0000\u0000\u0000KL\u0005\"\u0000"+
		"\u0000L\u0018\u0001\u0000\u0000\u0000MO\u0007\u0001\u0000\u0000NM\u0001"+
		"\u0000\u0000\u0000OP\u0001\u0000\u0000\u0000PN\u0001\u0000\u0000\u0000"+
		"PQ\u0001\u0000\u0000\u0000QX\u0001\u0000\u0000\u0000RT\u0005.\u0000\u0000"+
		"SU\u0007\u0001\u0000\u0000TS\u0001\u0000\u0000\u0000UV\u0001\u0000\u0000"+
		"\u0000VT\u0001\u0000\u0000\u0000VW\u0001\u0000\u0000\u0000WY\u0001\u0000"+
		"\u0000\u0000XR\u0001\u0000\u0000\u0000XY\u0001\u0000\u0000\u0000Y\u001a"+
		"\u0001\u0000\u0000\u0000Z^\u0007\u0002\u0000\u0000[]\u0007\u0003\u0000"+
		"\u0000\\[\u0001\u0000\u0000\u0000]`\u0001\u0000\u0000\u0000^\\\u0001\u0000"+
		"\u0000\u0000^_\u0001\u0000\u0000\u0000_\u001c\u0001\u0000\u0000\u0000"+
		"`^\u0001\u0000\u0000\u0000ab\u0005*\u0000\u0000bc\u0005*\u0000\u0000c"+
		"d\u0005*\u0000\u0000dh\u0001\u0000\u0000\u0000eg\t\u0000\u0000\u0000f"+
		"e\u0001\u0000\u0000\u0000gj\u0001\u0000\u0000\u0000hi\u0001\u0000\u0000"+
		"\u0000hf\u0001\u0000\u0000\u0000ik\u0001\u0000\u0000\u0000jh\u0001\u0000"+
		"\u0000\u0000kl\u0005*\u0000\u0000lm\u0005*\u0000\u0000mn\u0005*\u0000"+
		"\u0000no\u0001\u0000\u0000\u0000op\u0006\u000e\u0000\u0000p\u001e\u0001"+
		"\u0000\u0000\u0000qw\u0007\u0004\u0000\u0000rt\u0005\r\u0000\u0000sr\u0001"+
		"\u0000\u0000\u0000st\u0001\u0000\u0000\u0000tu\u0001\u0000\u0000\u0000"+
		"uw\u0005\n\u0000\u0000vq\u0001\u0000\u0000\u0000vs\u0001\u0000\u0000\u0000"+
		"wx\u0001\u0000\u0000\u0000xv\u0001\u0000\u0000\u0000xy\u0001\u0000\u0000"+
		"\u0000yz\u0001\u0000\u0000\u0000z{\u0006\u000f\u0001\u0000{ \u0001\u0000"+
		"\u0000\u0000|}\u0005<\u0000\u0000}~\u0005!\u0000\u0000~\u007f\u0005-\u0000"+
		"\u0000\u007f\u0080\u0005-\u0000\u0000\u0080\u0084\u0001\u0000\u0000\u0000"+
		"\u0081\u0083\t\u0000\u0000\u0000\u0082\u0081\u0001\u0000\u0000\u0000\u0083"+
		"\u0086\u0001\u0000\u0000\u0000\u0084\u0085\u0001\u0000\u0000\u0000\u0084"+
		"\u0082\u0001\u0000\u0000\u0000\u0085\u0087\u0001\u0000\u0000\u0000\u0086"+
		"\u0084\u0001\u0000\u0000\u0000\u0087\u0088\u0005-\u0000\u0000\u0088\u0089"+
		"\u0005-\u0000\u0000\u0089\u008a\u0005>\u0000\u0000\u008a\u008b\u0001\u0000"+
		"\u0000\u0000\u008b\u008c\u0006\u0010\u0001\u0000\u008c\"\u0001\u0000\u0000"+
		"\u0000\f\u0000FHPVX^hsvx\u0084\u0002\u0002\u0000\u0000\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}