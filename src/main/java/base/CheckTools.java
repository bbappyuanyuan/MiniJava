package base;

import org.antlr.v4.runtime.Token;

public class CheckTools {

    public static void error(Token t, String msg) {
        System.err.printf("line %d:%d %s\n", t.getLine(), t.getCharPositionInLine(),
                msg);
    }
}
