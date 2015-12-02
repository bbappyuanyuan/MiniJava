package scope;

public class ExpressionScope extends Scope {

    private String type;

    public ExpressionScope(String type, String name) {
        super(name, null);
        this.type = type;
        this.genre = "expression";
    }

    public String getType() {
        return type;
    }
}
