package base;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MiniJavaParser extends Parser {
    public static final int
            T__0 = 1, T__1 = 2, T__2 = 3, T__3 = 4, T__4 = 5, T__5 = 6, T__6 = 7, T__7 = 8, T__8 = 9,
            T__9 = 10, T__10 = 11, T__11 = 12, T__12 = 13, T__13 = 14, T__14 = 15, T__15 = 16, T__16 = 17,
            T__17 = 18, T__18 = 19, T__19 = 20, T__20 = 21, T__21 = 22, T__22 = 23, T__23 = 24,
            T__24 = 25, T__25 = 26, T__26 = 27, T__27 = 28, T__28 = 29, T__29 = 30, T__30 = 31,
            T__31 = 32, T__32 = 33, T__33 = 34, T__34 = 35, T__35 = 36, T__36 = 37, T__37 = 38,
            T__38 = 39, T__39 = 40, T__40 = 41, T__41 = 42, T__42 = 43, T__43 = 44, T__44 = 45,
            T__45 = 46, T__46 = 47, T__47 = 48, INTEGER = 49, IDENTIFIER = 50, LINE_COMMENT = 51,
            COMMENT = 52, WS = 53;
    public static final int
            RULE_translationUnit = 0, RULE_classDeclaration = 1, RULE_classMember = 2,
            RULE_field = 3, RULE_mainMethod = 4, RULE_method = 5, RULE_parameters = 6,
            RULE_parameter = 7, RULE_type = 8, RULE_statement = 9, RULE_block = 10,
            RULE_ifStatement = 11, RULE_whileStatement = 12, RULE_emptyStatement = 13,
            RULE_printStatement = 14, RULE_expressionStatement = 15, RULE_returnStatement = 16,
            RULE_blockStatement = 17, RULE_localVariableDeclarationStatement = 18,
            RULE_expression = 19, RULE_primaryExpression = 20, RULE_expressionList = 21;
    public static final String[] ruleNames = {
            "translationUnit", "classDeclaration", "classMember", "field", "mainMethod",
            "method", "parameters", "parameter", "type", "statement", "block", "ifStatement",
            "whileStatement", "emptyStatement", "printStatement", "expressionStatement",
            "returnStatement", "blockStatement", "localVariableDeclarationStatement",
            "expression", "primaryExpression", "expressionList"
    };
    /**
     * @deprecated Use {@link #VOCABULARY} instead.
     */
    @Deprecated
    public static final String[] tokenNames;
    public static final String _serializedATN =
            "\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\67\u0102\4\2\t\2" +
                    "\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13" +
                    "\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22" +
                    "\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\7\2\60\n\2\f\2" +
                    "\16\2\63\13\2\3\3\3\3\3\3\3\3\5\39\n\3\3\3\3\3\7\3=\n\3\f\3\16\3@\13\3" +
                    "\3\3\3\3\3\4\3\4\3\4\5\4G\n\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6" +
                    "\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\5\7_\n\7\3\7\3\7\3\7" +
                    "\3\b\3\b\3\b\7\bg\n\b\f\b\16\bj\13\b\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\13" +
                    "\3\13\3\13\3\13\3\13\5\13x\n\13\3\f\3\f\7\f|\n\f\f\f\16\f\177\13\f\3\f" +
                    "\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u008a\n\r\3\16\3\16\3\16\3\16\3\16" +
                    "\3\16\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21" +
                    "\3\21\3\21\3\22\3\22\5\22\u00a3\n\22\3\22\3\22\3\23\3\23\5\23\u00a9\n" +
                    "\23\3\24\3\24\3\24\3\24\5\24\u00af\n\24\3\24\3\24\3\25\3\25\3\25\3\25" +
                    "\3\25\3\25\3\25\3\25\5\25\u00bb\n\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25" +
                    "\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25" +
                    "\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u00dd\n\25" +
                    "\3\25\3\25\3\25\3\25\7\25\u00e3\n\25\f\25\16\25\u00e6\13\25\3\26\3\26" +
                    "\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u00f4\n\26\3\26" +
                    "\3\26\5\26\u00f8\n\26\3\27\3\27\3\27\7\27\u00fd\n\27\f\27\16\27\u0100" +
                    "\13\27\3\27\2\3(\30\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,\2\b" +
                    "\5\2\n\n\22\23\64\64\3\2\36\37\3\2 \"\3\2#$\3\2%(\3\2)*\u0114\2\61\3\2" +
                    "\2\2\4\64\3\2\2\2\6F\3\2\2\2\bH\3\2\2\2\nM\3\2\2\2\fY\3\2\2\2\16c\3\2" +
                    "\2\2\20k\3\2\2\2\22n\3\2\2\2\24w\3\2\2\2\26y\3\2\2\2\30\u0082\3\2\2\2" +
                    "\32\u008b\3\2\2\2\34\u0091\3\2\2\2\36\u0093\3\2\2\2 \u009d\3\2\2\2\"\u00a0" +
                    "\3\2\2\2$\u00a8\3\2\2\2&\u00aa\3\2\2\2(\u00ba\3\2\2\2*\u00f7\3\2\2\2," +
                    "\u00f9\3\2\2\2.\60\5\4\3\2/.\3\2\2\2\60\63\3\2\2\2\61/\3\2\2\2\61\62\3" +
                    "\2\2\2\62\3\3\2\2\2\63\61\3\2\2\2\64\65\7\3\2\2\658\7\64\2\2\66\67\7\4" +
                    "\2\2\679\7\64\2\28\66\3\2\2\289\3\2\2\29:\3\2\2\2:>\7\5\2\2;=\5\6\4\2" +
                    "<;\3\2\2\2=@\3\2\2\2><\3\2\2\2>?\3\2\2\2?A\3\2\2\2@>\3\2\2\2AB\7\6\2\2" +
                    "B\5\3\2\2\2CG\5\b\5\2DG\5\n\6\2EG\5\f\7\2FC\3\2\2\2FD\3\2\2\2FE\3\2\2" +
                    "\2G\7\3\2\2\2HI\7\7\2\2IJ\5\22\n\2JK\7\64\2\2KL\7\b\2\2L\t\3\2\2\2MN\7" +
                    "\7\2\2NO\7\t\2\2OP\7\n\2\2PQ\7\13\2\2QR\7\f\2\2RS\7\r\2\2ST\7\16\2\2T" +
                    "U\7\17\2\2UV\7\64\2\2VW\7\20\2\2WX\5\26\f\2X\13\3\2\2\2YZ\7\7\2\2Z[\5" +
                    "\22\n\2[\\\7\64\2\2\\^\7\f\2\2]_\5\16\b\2^]\3\2\2\2^_\3\2\2\2_`\3\2\2" +
                    "\2`a\7\20\2\2ab\5\26\f\2b\r\3\2\2\2ch\5\20\t\2de\7\21\2\2eg\5\20\t\2f" +
                    "d\3\2\2\2gj\3\2\2\2hf\3\2\2\2hi\3\2\2\2i\17\3\2\2\2jh\3\2\2\2kl\5\22\n" +
                    "\2lm\7\64\2\2m\21\3\2\2\2no\t\2\2\2o\23\3\2\2\2px\5\26\f\2qx\5\36\20\2" +
                    "rx\5\30\r\2sx\5\32\16\2tx\5\34\17\2ux\5 \21\2vx\5\"\22\2wp\3\2\2\2wq\3" +
                    "\2\2\2wr\3\2\2\2ws\3\2\2\2wt\3\2\2\2wu\3\2\2\2wv\3\2\2\2x\25\3\2\2\2y" +
                    "}\7\5\2\2z|\5$\23\2{z\3\2\2\2|\177\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\u0080" +
                    "\3\2\2\2\177}\3\2\2\2\u0080\u0081\7\6\2\2\u0081\27\3\2\2\2\u0082\u0083" +
                    "\7\24\2\2\u0083\u0084\7\f\2\2\u0084\u0085\5(\25\2\u0085\u0086\7\20\2\2" +
                    "\u0086\u0089\5\24\13\2\u0087\u0088\7\25\2\2\u0088\u008a\5\24\13\2\u0089" +
                    "\u0087\3\2\2\2\u0089\u008a\3\2\2\2\u008a\31\3\2\2\2\u008b\u008c\7\26\2" +
                    "\2\u008c\u008d\7\f\2\2\u008d\u008e\5(\25\2\u008e\u008f\7\20\2\2\u008f" +
                    "\u0090\5\24\13\2\u0090\33\3\2\2\2\u0091\u0092\7\b\2\2\u0092\35\3\2\2\2" +
                    "\u0093\u0094\7\27\2\2\u0094\u0095\7\30\2\2\u0095\u0096\7\31\2\2\u0096" +
                    "\u0097\7\30\2\2\u0097\u0098\7\32\2\2\u0098\u0099\7\f\2\2\u0099\u009a\5" +
                    "(\25\2\u009a\u009b\7\20\2\2\u009b\u009c\7\b\2\2\u009c\37\3\2\2\2\u009d" +
                    "\u009e\5(\25\2\u009e\u009f\7\b\2\2\u009f!\3\2\2\2\u00a0\u00a2\7\33\2\2" +
                    "\u00a1\u00a3\5(\25\2\u00a2\u00a1\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a4" +
                    "\3\2\2\2\u00a4\u00a5\7\b\2\2\u00a5#\3\2\2\2\u00a6\u00a9\5\24\13\2\u00a7" +
                    "\u00a9\5&\24\2\u00a8\u00a6\3\2\2\2\u00a8\u00a7\3\2\2\2\u00a9%\3\2\2\2" +
                    "\u00aa\u00ab\5\22\n\2\u00ab\u00ae\7\64\2\2\u00ac\u00ad\7\34\2\2\u00ad" +
                    "\u00af\5(\25\2\u00ae\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b0\3\2" +
                    "\2\2\u00b0\u00b1\7\b\2\2\u00b1\'\3\2\2\2\u00b2\u00b3\b\25\1\2\u00b3\u00b4" +
                    "\t\3\2\2\u00b4\u00bb\5(\25\f\u00b5\u00bb\5*\26\2\u00b6\u00b7\7\35\2\2" +
                    "\u00b7\u00b8\7\64\2\2\u00b8\u00b9\7\f\2\2\u00b9\u00bb\7\20\2\2\u00ba\u00b2" +
                    "\3\2\2\2\u00ba\u00b5\3\2\2\2\u00ba\u00b6\3\2\2\2\u00bb\u00e4\3\2\2\2\u00bc" +
                    "\u00bd\f\13\2\2\u00bd\u00be\t\4\2\2\u00be\u00e3\5(\25\f\u00bf\u00c0\f" +
                    "\n\2\2\u00c0\u00c1\t\5\2\2\u00c1\u00e3\5(\25\13\u00c2\u00c3\f\t\2\2\u00c3" +
                    "\u00c4\t\6\2\2\u00c4\u00e3\5(\25\n\u00c5\u00c6\f\b\2\2\u00c6\u00c7\t\7" +
                    "\2\2\u00c7\u00e3\5(\25\t\u00c8\u00c9\f\7\2\2\u00c9\u00ca\7+\2\2\u00ca" +
                    "\u00e3\5(\25\b\u00cb\u00cc\f\6\2\2\u00cc\u00cd\7,\2\2\u00cd\u00e3\5(\25" +
                    "\7\u00ce\u00cf\f\5\2\2\u00cf\u00d0\7-\2\2\u00d0\u00e3\5(\25\6\u00d1\u00d2" +
                    "\f\4\2\2\u00d2\u00d3\7.\2\2\u00d3\u00e3\5(\25\5\u00d4\u00d5\f\3\2\2\u00d5" +
                    "\u00d6\7\34\2\2\u00d6\u00e3\5(\25\4\u00d7\u00d8\f\17\2\2\u00d8\u00d9\7" +
                    "\30\2\2\u00d9\u00da\7\64\2\2\u00da\u00dc\7\f\2\2\u00db\u00dd\5,\27\2\u00dc" +
                    "\u00db\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00e3\7\20" +
                    "\2\2\u00df\u00e0\f\16\2\2\u00e0\u00e1\7\30\2\2\u00e1\u00e3\7\64\2\2\u00e2" +
                    "\u00bc\3\2\2\2\u00e2\u00bf\3\2\2\2\u00e2\u00c2\3\2\2\2\u00e2\u00c5\3\2" +
                    "\2\2\u00e2\u00c8\3\2\2\2\u00e2\u00cb\3\2\2\2\u00e2\u00ce\3\2\2\2\u00e2" +
                    "\u00d1\3\2\2\2\u00e2\u00d4\3\2\2\2\u00e2\u00d7\3\2\2\2\u00e2\u00df\3\2" +
                    "\2\2\u00e3\u00e6\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5" +
                    ")\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e7\u00e8\7\f\2\2\u00e8\u00e9\5(\25\2" +
                    "\u00e9\u00ea\7\20\2\2\u00ea\u00f8\3\2\2\2\u00eb\u00f8\7/\2\2\u00ec\u00f8" +
                    "\7\60\2\2\u00ed\u00f8\7\61\2\2\u00ee\u00f8\7\62\2\2\u00ef\u00f8\7\63\2" +
                    "\2\u00f0\u00f1\7\64\2\2\u00f1\u00f3\7\f\2\2\u00f2\u00f4\5,\27\2\u00f3" +
                    "\u00f2\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\u00f8\7\20" +
                    "\2\2\u00f6\u00f8\7\64\2\2\u00f7\u00e7\3\2\2\2\u00f7\u00eb\3\2\2\2\u00f7" +
                    "\u00ec\3\2\2\2\u00f7\u00ed\3\2\2\2\u00f7\u00ee\3\2\2\2\u00f7\u00ef\3\2" +
                    "\2\2\u00f7\u00f0\3\2\2\2\u00f7\u00f6\3\2\2\2\u00f8+\3\2\2\2\u00f9\u00fe" +
                    "\5(\25\2\u00fa\u00fb\7\21\2\2\u00fb\u00fd\5(\25\2\u00fc\u00fa\3\2\2\2" +
                    "\u00fd\u0100\3\2\2\2\u00fe\u00fc\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff-\3" +
                    "\2\2\2\u0100\u00fe\3\2\2\2\25\618>F^hw}\u0089\u00a2\u00a8\u00ae\u00ba" +
                    "\u00dc\u00e2\u00e4\u00f3\u00f7\u00fe";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());
    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    private static final String[] _LITERAL_NAMES = {
            null, "'class'", "'extends'", "'{'", "'}'", "'public'", "';'", "'static'",
            "'void'", "'main'", "'('", "'String'", "'['", "']'", "')'", "','", "'boolean'",
            "'int'", "'if'", "'else'", "'while'", "'System'", "'.'", "'out'", "'println'",
            "'return'", "'='", "'new'", "'~'", "'!'", "'*'", "'/'", "'%'", "'+'",
            "'-'", "'<='", "'>='", "'>'", "'<'", "'=='", "'!='", "'&'", "'|'", "'&&'",
            "'||'", "'this'", "'null'", "'false'", "'true'"
    };
    private static final String[] _SYMBOLIC_NAMES = {
            null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null,
            null, "INTEGER", "IDENTIFIER", "LINE_COMMENT", "COMMENT", "WS"
    };
    public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

    static {
        RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION);
    }

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

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }

    public MiniJavaParser(TokenStream input) {
        super(input);
        _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
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
    public String getGrammarFileName() {
        return "MiniJava.g4";
    }

    @Override
    public String[] getRuleNames() {
        return ruleNames;
    }

    @Override
    public String getSerializedATN() {
        return _serializedATN;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }

    public final TranslationUnitContext translationUnit() throws RecognitionException {
        TranslationUnitContext _localctx = new TranslationUnitContext(_ctx, getState());
        enterRule(_localctx, 0, RULE_translationUnit);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(47);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T__0) {
                    {
                        {
                            setState(44);
                            classDeclaration();
                        }
                    }
                    setState(49);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ClassDeclarationContext classDeclaration() throws RecognitionException {
        ClassDeclarationContext _localctx = new ClassDeclarationContext(_ctx, getState());
        enterRule(_localctx, 2, RULE_classDeclaration);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(50);
                match(T__0);
                setState(51);
                match(IDENTIFIER);
                setState(54);
                _la = _input.LA(1);
                if (_la == T__1) {
                    {
                        setState(52);
                        match(T__1);
                        setState(53);
                        match(IDENTIFIER);
                    }
                }

                setState(56);
                match(T__2);
                setState(60);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T__4) {
                    {
                        {
                            setState(57);
                            classMember();
                        }
                    }
                    setState(62);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(63);
                match(T__3);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ClassMemberContext classMember() throws RecognitionException {
        ClassMemberContext _localctx = new ClassMemberContext(_ctx, getState());
        enterRule(_localctx, 4, RULE_classMember);
        try {
            setState(68);
            switch (getInterpreter().adaptivePredict(_input, 3, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(65);
                    field();
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(66);
                    mainMethod();
                }
                break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(67);
                    method();
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final FieldContext field() throws RecognitionException {
        FieldContext _localctx = new FieldContext(_ctx, getState());
        enterRule(_localctx, 6, RULE_field);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(70);
                match(T__4);
                setState(71);
                type();
                setState(72);
                match(IDENTIFIER);
                setState(73);
                match(T__5);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final MainMethodContext mainMethod() throws RecognitionException {
        MainMethodContext _localctx = new MainMethodContext(_ctx, getState());
        enterRule(_localctx, 8, RULE_mainMethod);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(75);
                match(T__4);
                setState(76);
                match(T__6);
                setState(77);
                match(T__7);
                setState(78);
                match(T__8);
                setState(79);
                match(T__9);
                setState(80);
                match(T__10);
                setState(81);
                match(T__11);
                setState(82);
                match(T__12);
                setState(83);
                match(IDENTIFIER);
                setState(84);
                match(T__13);
                setState(85);
                block();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final MethodContext method() throws RecognitionException {
        MethodContext _localctx = new MethodContext(_ctx, getState());
        enterRule(_localctx, 10, RULE_method);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(87);
                match(T__4);
                setState(88);
                type();
                setState(89);
                match(IDENTIFIER);
                setState(90);
                match(T__9);
                setState(92);
                _la = _input.LA(1);
                if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__15) | (1L << T__16) | (1L << IDENTIFIER))) != 0)) {
                    {
                        setState(91);
                        parameters();
                    }
                }

                setState(94);
                match(T__13);
                setState(95);
                block();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ParametersContext parameters() throws RecognitionException {
        ParametersContext _localctx = new ParametersContext(_ctx, getState());
        enterRule(_localctx, 12, RULE_parameters);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(97);
                parameter();
                setState(102);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T__14) {
                    {
                        {
                            setState(98);
                            match(T__14);
                            setState(99);
                            parameter();
                        }
                    }
                    setState(104);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ParameterContext parameter() throws RecognitionException {
        ParameterContext _localctx = new ParameterContext(_ctx, getState());
        enterRule(_localctx, 14, RULE_parameter);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(105);
                type();
                setState(106);
                match(IDENTIFIER);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final TypeContext type() throws RecognitionException {
        TypeContext _localctx = new TypeContext(_ctx, getState());
        enterRule(_localctx, 16, RULE_type);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(108);
                _la = _input.LA(1);
                if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__15) | (1L << T__16) | (1L << IDENTIFIER))) != 0))) {
                    _errHandler.recoverInline(this);
                } else {
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final StatementContext statement() throws RecognitionException {
        StatementContext _localctx = new StatementContext(_ctx, getState());
        enterRule(_localctx, 18, RULE_statement);
        try {
            setState(117);
            switch (_input.LA(1)) {
                case T__2:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(110);
                    block();
                }
                break;
                case T__20:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(111);
                    printStatement();
                }
                break;
                case T__17:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(112);
                    ifStatement();
                }
                break;
                case T__19:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(113);
                    whileStatement();
                }
                break;
                case T__5:
                    enterOuterAlt(_localctx, 5);
                {
                    setState(114);
                    emptyStatement();
                }
                break;
                case T__9:
                case T__26:
                case T__27:
                case T__28:
                case T__44:
                case T__45:
                case T__46:
                case T__47:
                case INTEGER:
                case IDENTIFIER:
                    enterOuterAlt(_localctx, 6);
                {
                    setState(115);
                    expressionStatement();
                }
                break;
                case T__24:
                    enterOuterAlt(_localctx, 7);
                {
                    setState(116);
                    returnStatement();
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final BlockContext block() throws RecognitionException {
        BlockContext _localctx = new BlockContext(_ctx, getState());
        enterRule(_localctx, 20, RULE_block);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(119);
                match(T__2);
                setState(123);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__5) | (1L << T__7) | (1L << T__9) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__19) | (1L << T__20) | (1L << T__24) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << INTEGER) | (1L << IDENTIFIER))) != 0)) {
                    {
                        {
                            setState(120);
                            blockStatement();
                        }
                    }
                    setState(125);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(126);
                match(T__3);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final IfStatementContext ifStatement() throws RecognitionException {
        IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
        enterRule(_localctx, 22, RULE_ifStatement);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(128);
                match(T__17);
                setState(129);
                match(T__9);
                setState(130);
                expression(0);
                setState(131);
                match(T__13);
                setState(132);
                statement();
                setState(135);
                switch (getInterpreter().adaptivePredict(_input, 8, _ctx)) {
                    case 1: {
                        setState(133);
                        match(T__18);
                        setState(134);
                        statement();
                    }
                    break;
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final WhileStatementContext whileStatement() throws RecognitionException {
        WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
        enterRule(_localctx, 24, RULE_whileStatement);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(137);
                match(T__19);
                setState(138);
                match(T__9);
                setState(139);
                expression(0);
                setState(140);
                match(T__13);
                setState(141);
                statement();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final EmptyStatementContext emptyStatement() throws RecognitionException {
        EmptyStatementContext _localctx = new EmptyStatementContext(_ctx, getState());
        enterRule(_localctx, 26, RULE_emptyStatement);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(143);
                match(T__5);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final PrintStatementContext printStatement() throws RecognitionException {
        PrintStatementContext _localctx = new PrintStatementContext(_ctx, getState());
        enterRule(_localctx, 28, RULE_printStatement);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(145);
                match(T__20);
                setState(146);
                match(T__21);
                setState(147);
                match(T__22);
                setState(148);
                match(T__21);
                setState(149);
                match(T__23);
                setState(150);
                match(T__9);
                setState(151);
                expression(0);
                setState(152);
                match(T__13);
                setState(153);
                match(T__5);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ExpressionStatementContext expressionStatement() throws RecognitionException {
        ExpressionStatementContext _localctx = new ExpressionStatementContext(_ctx, getState());
        enterRule(_localctx, 30, RULE_expressionStatement);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(155);
                expression(0);
                setState(156);
                match(T__5);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ReturnStatementContext returnStatement() throws RecognitionException {
        ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
        enterRule(_localctx, 32, RULE_returnStatement);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(158);
                match(T__24);
                setState(160);
                _la = _input.LA(1);
                if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << INTEGER) | (1L << IDENTIFIER))) != 0)) {
                    {
                        setState(159);
                        expression(0);
                    }
                }

                setState(162);
                match(T__5);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final BlockStatementContext blockStatement() throws RecognitionException {
        BlockStatementContext _localctx = new BlockStatementContext(_ctx, getState());
        enterRule(_localctx, 34, RULE_blockStatement);
        try {
            setState(166);
            switch (getInterpreter().adaptivePredict(_input, 10, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(164);
                    statement();
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(165);
                    localVariableDeclarationStatement();
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final LocalVariableDeclarationStatementContext localVariableDeclarationStatement() throws RecognitionException {
        LocalVariableDeclarationStatementContext _localctx = new LocalVariableDeclarationStatementContext(_ctx, getState());
        enterRule(_localctx, 36, RULE_localVariableDeclarationStatement);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(168);
                type();
                setState(169);
                match(IDENTIFIER);
                setState(172);
                _la = _input.LA(1);
                if (_la == T__25) {
                    {
                        setState(170);
                        match(T__25);
                        setState(171);
                        expression(0);
                    }
                }

                setState(174);
                match(T__5);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ExpressionContext expression() throws RecognitionException {
        return expression(0);
    }

    private ExpressionContext expression(int _p) throws RecognitionException {
        ParserRuleContext _parentctx = _ctx;
        int _parentState = getState();
        ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
        ExpressionContext _prevctx = _localctx;
        int _startState = 38;
        enterRecursionRule(_localctx, 38, RULE_expression, _p);
        int _la;
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(184);
                switch (_input.LA(1)) {
                    case T__27:
                    case T__28: {
                        setState(177);
                        _la = _input.LA(1);
                        if (!(_la == T__27 || _la == T__28)) {
                            _errHandler.recoverInline(this);
                        } else {
                            consume();
                        }
                        setState(178);
                        expression(10);
                    }
                    break;
                    case T__9:
                    case T__44:
                    case T__45:
                    case T__46:
                    case T__47:
                    case INTEGER:
                    case IDENTIFIER: {
                        setState(179);
                        primaryExpression();
                    }
                    break;
                    case T__26: {
                        setState(180);
                        match(T__26);
                        setState(181);
                        match(IDENTIFIER);
                        setState(182);
                        match(T__9);
                        setState(183);
                        match(T__13);
                    }
                    break;
                    default:
                        throw new NoViableAltException(this);
                }
                _ctx.stop = _input.LT(-1);
                setState(226);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 15, _ctx);
                while (_alt != 2 && _alt != ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        if (_parseListeners != null) triggerExitRuleEvent();
                        _prevctx = _localctx;
                        {
                            setState(224);
                            switch (getInterpreter().adaptivePredict(_input, 14, _ctx)) {
                                case 1: {
                                    _localctx = new ExpressionContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(186);
                                    if (!(precpred(_ctx, 9)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 9)");
                                    setState(187);
                                    _la = _input.LA(1);
                                    if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__29) | (1L << T__30) | (1L << T__31))) != 0))) {
                                        _errHandler.recoverInline(this);
                                    } else {
                                        consume();
                                    }
                                    setState(188);
                                    expression(10);
                                }
                                break;
                                case 2: {
                                    _localctx = new ExpressionContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(189);
                                    if (!(precpred(_ctx, 8)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 8)");
                                    setState(190);
                                    _la = _input.LA(1);
                                    if (!(_la == T__32 || _la == T__33)) {
                                        _errHandler.recoverInline(this);
                                    } else {
                                        consume();
                                    }
                                    setState(191);
                                    expression(9);
                                }
                                break;
                                case 3: {
                                    _localctx = new ExpressionContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(192);
                                    if (!(precpred(_ctx, 7)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 7)");
                                    setState(193);
                                    _la = _input.LA(1);
                                    if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37))) != 0))) {
                                        _errHandler.recoverInline(this);
                                    } else {
                                        consume();
                                    }
                                    setState(194);
                                    expression(8);
                                }
                                break;
                                case 4: {
                                    _localctx = new ExpressionContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(195);
                                    if (!(precpred(_ctx, 6)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 6)");
                                    setState(196);
                                    _la = _input.LA(1);
                                    if (!(_la == T__38 || _la == T__39)) {
                                        _errHandler.recoverInline(this);
                                    } else {
                                        consume();
                                    }
                                    setState(197);
                                    expression(7);
                                }
                                break;
                                case 5: {
                                    _localctx = new ExpressionContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(198);
                                    if (!(precpred(_ctx, 5)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 5)");
                                    setState(199);
                                    match(T__40);
                                    setState(200);
                                    expression(6);
                                }
                                break;
                                case 6: {
                                    _localctx = new ExpressionContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(201);
                                    if (!(precpred(_ctx, 4)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 4)");
                                    setState(202);
                                    match(T__41);
                                    setState(203);
                                    expression(5);
                                }
                                break;
                                case 7: {
                                    _localctx = new ExpressionContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(204);
                                    if (!(precpred(_ctx, 3)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 3)");
                                    setState(205);
                                    match(T__42);
                                    setState(206);
                                    expression(4);
                                }
                                break;
                                case 8: {
                                    _localctx = new ExpressionContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(207);
                                    if (!(precpred(_ctx, 2)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 2)");
                                    setState(208);
                                    match(T__43);
                                    setState(209);
                                    expression(3);
                                }
                                break;
                                case 9: {
                                    _localctx = new ExpressionContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(210);
                                    if (!(precpred(_ctx, 1)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 1)");
                                    setState(211);
                                    match(T__25);
                                    setState(212);
                                    expression(2);
                                }
                                break;
                                case 10: {
                                    _localctx = new ExpressionContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(213);
                                    if (!(precpred(_ctx, 13)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 13)");
                                    setState(214);
                                    match(T__21);
                                    setState(215);
                                    match(IDENTIFIER);
                                    setState(216);
                                    match(T__9);
                                    setState(218);
                                    _la = _input.LA(1);
                                    if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << INTEGER) | (1L << IDENTIFIER))) != 0)) {
                                        {
                                            setState(217);
                                            expressionList();
                                        }
                                    }

                                    setState(220);
                                    match(T__13);
                                }
                                break;
                                case 11: {
                                    _localctx = new ExpressionContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(221);
                                    if (!(precpred(_ctx, 12)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 12)");
                                    setState(222);
                                    match(T__21);
                                    setState(223);
                                    match(IDENTIFIER);
                                }
                                break;
                            }
                        }
                    }
                    setState(228);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 15, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            unrollRecursionContexts(_parentctx);
        }
        return _localctx;
    }

    public final PrimaryExpressionContext primaryExpression() throws RecognitionException {
        PrimaryExpressionContext _localctx = new PrimaryExpressionContext(_ctx, getState());
        enterRule(_localctx, 40, RULE_primaryExpression);
        int _la;
        try {
            setState(245);
            switch (getInterpreter().adaptivePredict(_input, 17, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(229);
                    match(T__9);
                    setState(230);
                    expression(0);
                    setState(231);
                    match(T__13);
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(233);
                    match(T__44);
                }
                break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(234);
                    match(T__45);
                }
                break;
                case 4:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(235);
                    match(T__46);
                }
                break;
                case 5:
                    enterOuterAlt(_localctx, 5);
                {
                    setState(236);
                    match(T__47);
                }
                break;
                case 6:
                    enterOuterAlt(_localctx, 6);
                {
                    setState(237);
                    match(INTEGER);
                }
                break;
                case 7:
                    enterOuterAlt(_localctx, 7);
                {
                    setState(238);
                    match(IDENTIFIER);
                    setState(239);
                    match(T__9);
                    setState(241);
                    _la = _input.LA(1);
                    if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << INTEGER) | (1L << IDENTIFIER))) != 0)) {
                        {
                            setState(240);
                            expressionList();
                        }
                    }

                    setState(243);
                    match(T__13);
                }
                break;
                case 8:
                    enterOuterAlt(_localctx, 8);
                {
                    setState(244);
                    match(IDENTIFIER);
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ExpressionListContext expressionList() throws RecognitionException {
        ExpressionListContext _localctx = new ExpressionListContext(_ctx, getState());
        enterRule(_localctx, 42, RULE_expressionList);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(247);
                expression(0);
                setState(252);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T__14) {
                    {
                        {
                            setState(248);
                            match(T__14);
                            setState(249);
                            expression(0);
                        }
                    }
                    setState(254);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
        switch (ruleIndex) {
            case 19:
                return expression_sempred((ExpressionContext) _localctx, predIndex);
        }
        return true;
    }

    private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
        switch (predIndex) {
            case 0:
                return precpred(_ctx, 9);
            case 1:
                return precpred(_ctx, 8);
            case 2:
                return precpred(_ctx, 7);
            case 3:
                return precpred(_ctx, 6);
            case 4:
                return precpred(_ctx, 5);
            case 5:
                return precpred(_ctx, 4);
            case 6:
                return precpred(_ctx, 3);
            case 7:
                return precpred(_ctx, 2);
            case 8:
                return precpred(_ctx, 1);
            case 9:
                return precpred(_ctx, 13);
            case 10:
                return precpred(_ctx, 12);
        }
        return true;
    }

    public static class TranslationUnitContext extends ParserRuleContext {
        public TranslationUnitContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<ClassDeclarationContext> classDeclaration() {
            return getRuleContexts(ClassDeclarationContext.class);
        }

        public ClassDeclarationContext classDeclaration(int i) {
            return getRuleContext(ClassDeclarationContext.class, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_translationUnit;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MiniJavaListener) ((MiniJavaListener) listener).enterTranslationUnit(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MiniJavaListener) ((MiniJavaListener) listener).exitTranslationUnit(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof MiniJavaVisitor)
                return ((MiniJavaVisitor<? extends T>) visitor).visitTranslationUnit(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class ClassDeclarationContext extends ParserRuleContext {
        public ClassDeclarationContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<TerminalNode> IDENTIFIER() {
            return getTokens(MiniJavaParser.IDENTIFIER);
        }

        public TerminalNode IDENTIFIER(int i) {
            return getToken(MiniJavaParser.IDENTIFIER, i);
        }

        public List<ClassMemberContext> classMember() {
            return getRuleContexts(ClassMemberContext.class);
        }

        public ClassMemberContext classMember(int i) {
            return getRuleContext(ClassMemberContext.class, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_classDeclaration;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MiniJavaListener) ((MiniJavaListener) listener).enterClassDeclaration(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MiniJavaListener) ((MiniJavaListener) listener).exitClassDeclaration(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof MiniJavaVisitor)
                return ((MiniJavaVisitor<? extends T>) visitor).visitClassDeclaration(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class ClassMemberContext extends ParserRuleContext {
        public ClassMemberContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public FieldContext field() {
            return getRuleContext(FieldContext.class, 0);
        }

        public MainMethodContext mainMethod() {
            return getRuleContext(MainMethodContext.class, 0);
        }

        public MethodContext method() {
            return getRuleContext(MethodContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_classMember;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MiniJavaListener) ((MiniJavaListener) listener).enterClassMember(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MiniJavaListener) ((MiniJavaListener) listener).exitClassMember(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof MiniJavaVisitor)
                return ((MiniJavaVisitor<? extends T>) visitor).visitClassMember(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class FieldContext extends ParserRuleContext {
        public FieldContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TypeContext type() {
            return getRuleContext(TypeContext.class, 0);
        }

        public TerminalNode IDENTIFIER() {
            return getToken(MiniJavaParser.IDENTIFIER, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_field;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MiniJavaListener) ((MiniJavaListener) listener).enterField(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MiniJavaListener) ((MiniJavaListener) listener).exitField(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof MiniJavaVisitor) return ((MiniJavaVisitor<? extends T>) visitor).visitField(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class MainMethodContext extends ParserRuleContext {
        public MainMethodContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode IDENTIFIER() {
            return getToken(MiniJavaParser.IDENTIFIER, 0);
        }

        public BlockContext block() {
            return getRuleContext(BlockContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_mainMethod;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MiniJavaListener) ((MiniJavaListener) listener).enterMainMethod(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MiniJavaListener) ((MiniJavaListener) listener).exitMainMethod(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof MiniJavaVisitor)
                return ((MiniJavaVisitor<? extends T>) visitor).visitMainMethod(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class MethodContext extends ParserRuleContext {
        public MethodContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TypeContext type() {
            return getRuleContext(TypeContext.class, 0);
        }

        public TerminalNode IDENTIFIER() {
            return getToken(MiniJavaParser.IDENTIFIER, 0);
        }

        public BlockContext block() {
            return getRuleContext(BlockContext.class, 0);
        }

        public ParametersContext parameters() {
            return getRuleContext(ParametersContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_method;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MiniJavaListener) ((MiniJavaListener) listener).enterMethod(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MiniJavaListener) ((MiniJavaListener) listener).exitMethod(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof MiniJavaVisitor) return ((MiniJavaVisitor<? extends T>) visitor).visitMethod(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class ParametersContext extends ParserRuleContext {
        public ParametersContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<ParameterContext> parameter() {
            return getRuleContexts(ParameterContext.class);
        }

        public ParameterContext parameter(int i) {
            return getRuleContext(ParameterContext.class, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_parameters;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MiniJavaListener) ((MiniJavaListener) listener).enterParameters(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MiniJavaListener) ((MiniJavaListener) listener).exitParameters(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof MiniJavaVisitor)
                return ((MiniJavaVisitor<? extends T>) visitor).visitParameters(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class ParameterContext extends ParserRuleContext {
        public ParameterContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TypeContext type() {
            return getRuleContext(TypeContext.class, 0);
        }

        public TerminalNode IDENTIFIER() {
            return getToken(MiniJavaParser.IDENTIFIER, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_parameter;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MiniJavaListener) ((MiniJavaListener) listener).enterParameter(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MiniJavaListener) ((MiniJavaListener) listener).exitParameter(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof MiniJavaVisitor)
                return ((MiniJavaVisitor<? extends T>) visitor).visitParameter(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class TypeContext extends ParserRuleContext {
        public TypeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode IDENTIFIER() {
            return getToken(MiniJavaParser.IDENTIFIER, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_type;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MiniJavaListener) ((MiniJavaListener) listener).enterType(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MiniJavaListener) ((MiniJavaListener) listener).exitType(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof MiniJavaVisitor) return ((MiniJavaVisitor<? extends T>) visitor).visitType(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class StatementContext extends ParserRuleContext {
        public StatementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public BlockContext block() {
            return getRuleContext(BlockContext.class, 0);
        }

        public PrintStatementContext printStatement() {
            return getRuleContext(PrintStatementContext.class, 0);
        }

        public IfStatementContext ifStatement() {
            return getRuleContext(IfStatementContext.class, 0);
        }

        public WhileStatementContext whileStatement() {
            return getRuleContext(WhileStatementContext.class, 0);
        }

        public EmptyStatementContext emptyStatement() {
            return getRuleContext(EmptyStatementContext.class, 0);
        }

        public ExpressionStatementContext expressionStatement() {
            return getRuleContext(ExpressionStatementContext.class, 0);
        }

        public ReturnStatementContext returnStatement() {
            return getRuleContext(ReturnStatementContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_statement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MiniJavaListener) ((MiniJavaListener) listener).enterStatement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MiniJavaListener) ((MiniJavaListener) listener).exitStatement(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof MiniJavaVisitor)
                return ((MiniJavaVisitor<? extends T>) visitor).visitStatement(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class BlockContext extends ParserRuleContext {
        public BlockContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<BlockStatementContext> blockStatement() {
            return getRuleContexts(BlockStatementContext.class);
        }

        public BlockStatementContext blockStatement(int i) {
            return getRuleContext(BlockStatementContext.class, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_block;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MiniJavaListener) ((MiniJavaListener) listener).enterBlock(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MiniJavaListener) ((MiniJavaListener) listener).exitBlock(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof MiniJavaVisitor) return ((MiniJavaVisitor<? extends T>) visitor).visitBlock(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class IfStatementContext extends ParserRuleContext {
        public IfStatementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public List<StatementContext> statement() {
            return getRuleContexts(StatementContext.class);
        }

        public StatementContext statement(int i) {
            return getRuleContext(StatementContext.class, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_ifStatement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MiniJavaListener) ((MiniJavaListener) listener).enterIfStatement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MiniJavaListener) ((MiniJavaListener) listener).exitIfStatement(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof MiniJavaVisitor)
                return ((MiniJavaVisitor<? extends T>) visitor).visitIfStatement(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class WhileStatementContext extends ParserRuleContext {
        public WhileStatementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public StatementContext statement() {
            return getRuleContext(StatementContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_whileStatement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MiniJavaListener) ((MiniJavaListener) listener).enterWhileStatement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MiniJavaListener) ((MiniJavaListener) listener).exitWhileStatement(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof MiniJavaVisitor)
                return ((MiniJavaVisitor<? extends T>) visitor).visitWhileStatement(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class EmptyStatementContext extends ParserRuleContext {
        public EmptyStatementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_emptyStatement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MiniJavaListener) ((MiniJavaListener) listener).enterEmptyStatement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MiniJavaListener) ((MiniJavaListener) listener).exitEmptyStatement(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof MiniJavaVisitor)
                return ((MiniJavaVisitor<? extends T>) visitor).visitEmptyStatement(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class PrintStatementContext extends ParserRuleContext {
        public PrintStatementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_printStatement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MiniJavaListener) ((MiniJavaListener) listener).enterPrintStatement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MiniJavaListener) ((MiniJavaListener) listener).exitPrintStatement(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof MiniJavaVisitor)
                return ((MiniJavaVisitor<? extends T>) visitor).visitPrintStatement(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class ExpressionStatementContext extends ParserRuleContext {
        public ExpressionStatementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_expressionStatement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MiniJavaListener) ((MiniJavaListener) listener).enterExpressionStatement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MiniJavaListener) ((MiniJavaListener) listener).exitExpressionStatement(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof MiniJavaVisitor)
                return ((MiniJavaVisitor<? extends T>) visitor).visitExpressionStatement(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class ReturnStatementContext extends ParserRuleContext {
        public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_returnStatement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MiniJavaListener) ((MiniJavaListener) listener).enterReturnStatement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MiniJavaListener) ((MiniJavaListener) listener).exitReturnStatement(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof MiniJavaVisitor)
                return ((MiniJavaVisitor<? extends T>) visitor).visitReturnStatement(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class BlockStatementContext extends ParserRuleContext {
        public BlockStatementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public StatementContext statement() {
            return getRuleContext(StatementContext.class, 0);
        }

        public LocalVariableDeclarationStatementContext localVariableDeclarationStatement() {
            return getRuleContext(LocalVariableDeclarationStatementContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_blockStatement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MiniJavaListener) ((MiniJavaListener) listener).enterBlockStatement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MiniJavaListener) ((MiniJavaListener) listener).exitBlockStatement(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof MiniJavaVisitor)
                return ((MiniJavaVisitor<? extends T>) visitor).visitBlockStatement(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class LocalVariableDeclarationStatementContext extends ParserRuleContext {
        public LocalVariableDeclarationStatementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TypeContext type() {
            return getRuleContext(TypeContext.class, 0);
        }

        public TerminalNode IDENTIFIER() {
            return getToken(MiniJavaParser.IDENTIFIER, 0);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_localVariableDeclarationStatement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MiniJavaListener)
                ((MiniJavaListener) listener).enterLocalVariableDeclarationStatement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MiniJavaListener)
                ((MiniJavaListener) listener).exitLocalVariableDeclarationStatement(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof MiniJavaVisitor)
                return ((MiniJavaVisitor<? extends T>) visitor).visitLocalVariableDeclarationStatement(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class ExpressionContext extends ParserRuleContext {
        public ExpressionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<ExpressionContext> expression() {
            return getRuleContexts(ExpressionContext.class);
        }

        public ExpressionContext expression(int i) {
            return getRuleContext(ExpressionContext.class, i);
        }

        public PrimaryExpressionContext primaryExpression() {
            return getRuleContext(PrimaryExpressionContext.class, 0);
        }

        public TerminalNode IDENTIFIER() {
            return getToken(MiniJavaParser.IDENTIFIER, 0);
        }

        public ExpressionListContext expressionList() {
            return getRuleContext(ExpressionListContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_expression;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MiniJavaListener) ((MiniJavaListener) listener).enterExpression(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MiniJavaListener) ((MiniJavaListener) listener).exitExpression(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof MiniJavaVisitor)
                return ((MiniJavaVisitor<? extends T>) visitor).visitExpression(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class PrimaryExpressionContext extends ParserRuleContext {
        public PrimaryExpressionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public TerminalNode INTEGER() {
            return getToken(MiniJavaParser.INTEGER, 0);
        }

        public TerminalNode IDENTIFIER() {
            return getToken(MiniJavaParser.IDENTIFIER, 0);
        }

        public ExpressionListContext expressionList() {
            return getRuleContext(ExpressionListContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_primaryExpression;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MiniJavaListener) ((MiniJavaListener) listener).enterPrimaryExpression(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MiniJavaListener) ((MiniJavaListener) listener).exitPrimaryExpression(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof MiniJavaVisitor)
                return ((MiniJavaVisitor<? extends T>) visitor).visitPrimaryExpression(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class ExpressionListContext extends ParserRuleContext {
        public ExpressionListContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<ExpressionContext> expression() {
            return getRuleContexts(ExpressionContext.class);
        }

        public ExpressionContext expression(int i) {
            return getRuleContext(ExpressionContext.class, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_expressionList;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MiniJavaListener) ((MiniJavaListener) listener).enterExpressionList(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MiniJavaListener) ((MiniJavaListener) listener).exitExpressionList(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof MiniJavaVisitor)
                return ((MiniJavaVisitor<? extends T>) visitor).visitExpressionList(this);
            else return visitor.visitChildren(this);
        }
    }
}