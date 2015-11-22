package base;

import org.antlr.v4.runtime.Token;

public class Utilities {

    public static void reportError(Token t, String msg) {
        System.err.printf("line %d:%d %s\n", t.getLine(), t.getCharPositionInLine(),
                msg);
    }

    public static void reportRedefinition(Token t, String type, String id) {
        System.err.printf("line %d:%d %s\n", t.getLine(), t.getCharPositionInLine(),
                type + " name '" + id + "' was defined before");
    }

    public static void reportUndefinition(Token t, String type, String id) {
        System.err.printf("line %d:%d %s\n", t.getLine(), t.getCharPositionInLine(),
                type + " '" + id + "' is never defined");
    }

    public static void reportWrongType(Token t, String x, String y, String id) {
        System.err.printf("line %d:%d %s\n", t.getLine(), t.getCharPositionInLine(),
                "'" + id + "' is not a(n) " + x + " but a(n) " + y);
    }
}
