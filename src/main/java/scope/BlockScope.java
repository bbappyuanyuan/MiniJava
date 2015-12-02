package scope;

public class BlockScope extends Scope {

    public BlockScope(Scope parent) {
        super(null, parent);
        this.genre = "block";
    }
}
