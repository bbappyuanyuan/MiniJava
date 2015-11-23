package base;

import org.antlr.v4.runtime.Token;

public class Utilities {

    public static void reportError(Token t, String msg) {
        System.err.printf("line %d:%d %s\n", t.getLine(), t.getCharPositionInLine(),
                msg);
    }

    public static void reportRedefinition(Token t, String type, String id) {
        reportError(t, type + " name '" + id + "' was defined before");
    }

    public static void reportUndefinition(Token t, String type, String id) {
        reportError(t, type + " '" + id + "' is never defined");
    }

    public static void reportWrongType(Token t, String exp, String cur, String id) {
        reportError(t, "'" + id + "' is not a " + exp + " but a " + cur);
    }

    public static void reportWrongParameterNum(Token t, int cnt, String id) {
        reportError(t, "method '" + id + "' should have " + cnt + " parameters");
    }
}
