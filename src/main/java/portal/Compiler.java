package portal;

import base.ErrorCenter;
import base.MiniJavaLexer;
import base.MiniJavaParser;
import listener.BuildPhase;
import listener.CheckPhase;
import listener.Phase;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Compiler {

    @Option(name = "-gui", usage = "show abstract syntax tree")
    private boolean gui = false;

    @Option(name = "-rule", usage = "start rule")
    private String rule = "translationUnit";

    @Argument(required = true, usage = "code sources")
    private List<String> inputFiles = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        new Compiler().process(args);
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
                System.out.println("============== Analyzing '" + inputFile + "' ......");
                compile(file.getAbsolutePath());
                if (gui) try {
                    showGui(file.getAbsolutePath());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("============== Done.");
            } else {
                System.err.println("file " + inputFile + " not found!");
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
        Method method = null;
        try {
            method = parser.getClass().getMethod(rule, null);
        } catch (NoSuchMethodException e) {
            System.err.println("rule '" + rule + "' not found!");
            return;
        }
        ParseTree tree = null;
        try {
            tree = (ParseTree) method.invoke(parser, null);
        } catch (IllegalAccessException e) {
        } catch (InvocationTargetException e) {
        }

        List<? super Phase> phases = new ArrayList<Phase>();
        phases.add(new BuildPhase());
        phases.add(new CheckPhase());
        ParseTreeWalker walker = new ParseTreeWalker();
        for (Object phase : phases)
            walker.walk((Phase) phase, tree);

        ErrorCenter.print(tokens.getText().split("\n"));
    }
}
