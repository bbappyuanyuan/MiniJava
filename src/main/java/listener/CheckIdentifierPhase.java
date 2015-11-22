package listener;

import base.MiniJavaParser;
import base.Utilities;
import scope.Scope;

public class CheckIdentifierPhase extends Phase {

    private Scope currentScope; // define symbols in this scope

    public CheckIdentifierPhase() {
        currentScope = outerScope;
    }

    // class
    @Override
    public void enterClassDeclaration(MiniJavaParser.ClassDeclarationContext ctx) {
        currentScope = scopes.get(ctx);
    }

    @Override
    public void exitClassDeclaration(MiniJavaParser.ClassDeclarationContext ctx) {
        currentScope = currentScope.getParent();
    }

    // method
    @Override
    public void enterMainMethod(MiniJavaParser.MainMethodContext ctx) {
        currentScope = scopes.get(ctx);
    }

    @Override
    public void exitMainMethod(MiniJavaParser.MainMethodContext ctx) {
        currentScope = currentScope.getParent();
    }

    @Override
    public void enterMethod(MiniJavaParser.MethodContext ctx) {
        currentScope = scopes.get(ctx);
    }

    @Override
    public void exitMethod(MiniJavaParser.MethodContext ctx) {
        currentScope = currentScope.getParent();
    }

    // block
    @Override
    public void enterBlock(MiniJavaParser.BlockContext ctx) {
        currentScope = scopes.get(ctx);
    }

    @Override
    public void exitBlock(MiniJavaParser.BlockContext ctx) {
        currentScope = currentScope.getParent();
    }

    @Override
    public void enterPrimaryExpression(MiniJavaParser.PrimaryExpressionContext ctx) {
        if (ctx.IDENTIFIER() != null) {
            String identifierName = ctx.IDENTIFIER().getText();
            Scope scope = currentScope.resolve(identifierName);
            if (ctx.getChildCount() > 1) {
                if (scope == null)
                    Utilities.reportUndefinition(ctx.IDENTIFIER().getSymbol(), "method", identifierName);
                else if (!scope.getGenre().equals("method"))
                    Utilities.reportWrongType(ctx.IDENTIFIER().getSymbol(), "method", scope.getGenre(), identifierName);
            } else {
                if (scope == null)
                    Utilities.reportUndefinition(ctx.IDENTIFIER().getSymbol(), "variable", identifierName);
                else if (!scope.getGenre().equals("variable"))
                    Utilities.reportWrongType(ctx.IDENTIFIER().getSymbol(), "variable", scope.getGenre(), identifierName);
            }
        }
    }
}