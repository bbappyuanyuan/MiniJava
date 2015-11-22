package scope;

public class ClassScope extends Scope {

    public ClassScope(String name, Scope parent) {
        super(name, parent);
        this.genre = "class";
    }
}
