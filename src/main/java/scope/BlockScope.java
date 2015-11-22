package scope;

public class BlockScope extends Scope {

    public BlockScope(Scope parent) {
        super("anonym", parent);
        this.genre = "block";
    }
}
