package base;

import listener.BuildPhase;
import listener.CheckIdentifierPhase;
import listener.Phase;
import org.antlr.v4.gui.Trees;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionMode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import javax.print.PrintException;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Analyzer {

    @Option(name = "-gui", usage = "show abstract syntax tree")
    private boolean gui = false;

    @Option(name = "-rule", usage = "start rule")
    private String rule = "translationUnit";

    @Argument(required = true)
    private List<String> inputFiles = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        new Analyzer().process(args);
    }

    private void process(String[] args) throws IOException {
        CmdLineParser parser = new CmdLineParser(this);
        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            System.err.println(e.getMessage());
            System.err.println("java -jar {jarFile} [options...] files...");
            parser.printUsage(System.err);
            System.err.println();
        }
        for (String inputFile : inputFiles) {
            File file = new File(inputFile);
            if (file.exists()) {
                System.out.println("============== Analyzing " + inputFile + " ......");
                compile(file.getAbsolutePath());
                if (gui) try {
                    showGui(file.getAbsolutePath());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("============== Done.");
            } else {
                System.out.println("file " + inputFile + " not found!");
            }
        }
    }

    private void showGui(String inputFile) throws Exception {
        new TestRig(new String[]{"MiniJava", rule, "-gui", inputFile}).process();
    }

    private void compile(String inputFile) throws IOException {
        InputStream is = new FileInputStream(inputFile);
        ANTLRInputStream input = new ANTLRInputStream(is);
        MiniJavaLexer lexer = new MiniJavaLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MiniJavaParser parser = new MiniJavaParser(tokens);
        ParseTree tree = parser.translationUnit();
//        System.out.println(tree.toStringTree(parser));

        List<? super Phase> phases = new ArrayList<Phase>();
        phases.add(new BuildPhase());
        phases.add(new CheckIdentifierPhase());
        ParseTreeWalker walker = new ParseTreeWalker();
        for (Object phase : phases)
            walker.walk((Phase) phase, tree);
    }

    public class TestRig {
        public static final String LEXER_START_RULE_NAME = "tokens";
        protected final List<String> inputFiles = new ArrayList();
        protected String grammarName;
        protected String startRuleName;
        protected boolean printTree = false;
        protected boolean gui = false;
        protected String psFile = null;
        protected boolean showTokens = false;
        protected boolean trace = false;
        protected boolean diagnostics = false;
        protected String encoding = null;
        protected boolean SLL = false;

        public TestRig(String[] args) throws Exception {
            if (args.length < 2) {
                System.err.println("java org.antlr.v4.runtime.misc.TestRig GrammarName startRuleName\n  [-tokens] [-tree] [-gui] [-ps file.ps] [-encoding encodingname]\n  [-trace] [-diagnostics] [-SLL]\n  [input-filename(s)]");
                System.err.println("Use startRuleName=\'tokens\' if GrammarName is a lexer grammar.");
                System.err.println("Omitting input-filename makes rig read from stdin.");
            } else {
                byte i = 0;
                this.grammarName = args[i];
                int var4 = i + 1;
                this.startRuleName = args[var4];
                ++var4;

                while (var4 < args.length) {
                    String arg = args[var4];
                    ++var4;
                    if (arg.charAt(0) != 45) {
                        this.inputFiles.add(arg);
                    } else {
                        if (arg.equals("-tree")) {
                            this.printTree = true;
                        }

                        if (arg.equals("-gui")) {
                            this.gui = true;
                        }

                        if (arg.equals("-tokens")) {
                            this.showTokens = true;
                        } else if (arg.equals("-trace")) {
                            this.trace = true;
                        } else if (arg.equals("-SLL")) {
                            this.SLL = true;
                        } else if (arg.equals("-diagnostics")) {
                            this.diagnostics = true;
                        } else if (arg.equals("-encoding")) {
                            if (var4 >= args.length) {
                                System.err.println("missing encoding on -encoding");
                                return;
                            }

                            this.encoding = args[var4];
                            ++var4;
                        } else if (arg.equals("-ps")) {
                            if (var4 >= args.length) {
                                System.err.println("missing filename on -ps");
                                return;
                            }

                            this.psFile = args[var4];
                            ++var4;
                        }
                    }
                }

            }
        }

        public void process() throws Exception {
            String lexerName = this.grammarName + "Lexer";
            Class lexerClass = MiniJavaLexer.class;
            Lexer lexer = new MiniJavaLexer(null);
            Class parserClass = MiniJavaParser.class;
            Parser parser = new MiniJavaParser(null);

            if (this.inputFiles.size() == 0) {
                InputStream is3 = System.in;
                InputStreamReader inputFile2;
                if (this.encoding != null) {
                    inputFile2 = new InputStreamReader(is3, this.encoding);
                } else {
                    inputFile2 = new InputStreamReader(is3);
                }

                this.process(lexer, parserClass, parser, is3, inputFile2);
            } else {
                Object is1;
                InputStreamReader r;
                for (Iterator is2 = this.inputFiles.iterator(); is2.hasNext(); this.process(lexer, parserClass, parser, (InputStream) is1, r)) {
                    String inputFile1 = (String) is2.next();
                    is1 = System.in;
                    if (inputFile1 != null) {
                        is1 = new FileInputStream(inputFile1);
                    }

                    if (this.encoding != null) {
                        r = new InputStreamReader((InputStream) is1, this.encoding);
                    } else {
                        r = new InputStreamReader((InputStream) is1);
                    }

                    if (this.inputFiles.size() > 1) {
                        System.err.println(inputFile1);
                    }
                }

            }
        }

        protected void process(Lexer lexer, Class<? extends Parser> parserClass, Parser parser, InputStream is, Reader r) throws IOException, IllegalAccessException, InvocationTargetException, PrintException {
            try {
                ANTLRInputStream input = new ANTLRInputStream(r);
                lexer.setInputStream(input);
                CommonTokenStream tokens = new CommonTokenStream(lexer);
                tokens.fill();
                if (this.showTokens) {
                    Iterator nsme = tokens.getTokens().iterator();

                    while (nsme.hasNext()) {
                        Object tree = nsme.next();
                        System.out.println(tree);
                    }
                }

                if (this.startRuleName.equals("tokens")) {
                    return;
                }

                if (this.diagnostics) {
                    parser.addErrorListener(new DiagnosticErrorListener());
                    ((ParserATNSimulator) parser.getInterpreter()).setPredictionMode(PredictionMode.LL_EXACT_AMBIG_DETECTION);
                }

                if (this.printTree || this.gui || this.psFile != null) {
                    parser.setBuildParseTree(true);
                }

                if (this.SLL) {
                    ((ParserATNSimulator) parser.getInterpreter()).setPredictionMode(PredictionMode.SLL);
                }

                parser.setTokenStream(tokens);
                parser.setTrace(this.trace);

                try {
                    Method nsme1 = parserClass.getMethod(this.startRuleName, new Class[0]);
                    ParserRuleContext tree1 = (ParserRuleContext) nsme1.invoke(parser, (Object[]) null);
                    if (this.printTree) {
                        System.out.println(tree1.toStringTree(parser));
                    }

                    if (this.gui) {
                        Trees.inspect(tree1, parser);
                    }

                    if (this.psFile != null) {
                        Trees.save(tree1, parser, this.psFile);
                    }
                } catch (NoSuchMethodException var13) {
                    System.err.println("No method for rule " + this.startRuleName + " or it has arguments");
                }
            } finally {
                if (r != null) {
                    r.close();
                }

                if (is != null) {
                    is.close();
                }

            }

        }
    }
}
