package listener;

import base.MiniJavaBaseListener;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import scope.BlockScope;
import scope.Scope;

public abstract class Phase extends MiniJavaBaseListener {

    static ParseTreeProperty<Scope> scopes = new ParseTreeProperty<Scope>();
    static Scope outerScope = new BlockScope(null);
}
