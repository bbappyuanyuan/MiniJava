package base;

import org.antlr.v4.runtime.Token;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ErrorCentre {

    static List<Info> errors = new ArrayList<Info>();

    public static void reportError(Token t, String msg) {
        errors.add(new Info(t.getLine(), t.getCharPositionInLine(), msg));
    }

    public static void errPrint() {
        errors.sort(new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                if (o1.x < o2.x) return -1;
                if (o1.x > o2.x) return 1;
                if (o1.y < o2.y) return -1;
                if (o1.y > o2.y) return 1;
                return 0;
            }
        });
        for (Info error : errors)
            System.err.printf("line %d:%d %s\n", error.x, error.y, error.msg);
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

    static class Info {

        public int x;
        public int y;
        String msg;

        public Info(int x, int y, String msg) {
            this.x = x;
            this.y = y;
            this.msg = msg;
        }
    }
}
