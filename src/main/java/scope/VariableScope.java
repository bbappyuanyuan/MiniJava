package scope;

public class VariableScope extends Scope {

    private String type;

    public VariableScope(String type, String name, Scope parent) {
        super(name, parent);
        this.type = type;
        this.genre = "variable";
    }

    public String getType() {
        return type;
    }
}
