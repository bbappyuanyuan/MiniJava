package base;

import org.antlr.v4.runtime.Token;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ErrorCenter {

    static List<Info> errors = new ArrayList<Info>();

    public static void report(Token t, String msg) {
        errors.add(new Info(t.getLine(), t.getCharPositionInLine(), msg));
    }

    public static void print(String[] lines) {
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
        for (Info error : errors) {
            System.err.printf("line %d:%d\t%s\n", error.x, error.y, error.msg);
            System.err.println(lines[error.x - 1]);
            for (int i = 0; i < error.y; ++i)
                System.err.print(" ");
            System.err.println("^");
        }
    }

    public static void reportRedefinition(Token t, String type, String id) {
        report(t, type + " '" + id + "' is already defined before");
    }

    public static void reportUndefinition(Token t, String type, String id) {
        report(t, type + " '" + id + "' not found");
    }

    public static void reportWrongGenre(Token t, String exp, String cur, String id) {
        report(t, "'" + id + "' is not a " + exp + " but a " + cur);
    }

    public static void reportWrongParameterNum(Token t, int cnt, String id) {
        report(t, "method '" + id + "' requires " + cnt + " parameter(s)");
    }

    public static void reportWrongType(Token t, String exp, String cur, String id) {
        report(t, "'" + id + "' is supposed to be a(n) " + exp + " value but not a(n) " + cur + " value");
    }

    public static void reportReturnWrongType(Token t, String exp) {
        report(t, "return type should be " + exp);
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
