package listener;

import base.ErrorCenter;
import base.MiniJavaParser;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import scope.*;

import java.util.List;

public class BuildPhase extends Phase {

    private Scope currentScope;

    public BuildPhase() {
        currentScope = outerScope;
    }

    public ParseTreeProperty<Scope> getScopes() {
        return scopes;
    }

    public Scope getOuterScope() {
        return outerScope;
    }

    // class
    @Override
    public void enterClassDeclaration(MiniJavaParser.ClassDeclarationContext ctx) {
        String className = ctx.IDENTIFIER(0).getText();
        ClassScope classScope = new ClassScope(className, currentScope);
        if (currentScope.defined(className))
            ErrorCenter.reportRedefinition(ctx.IDENTIFIER(0).getSymbol(), "class", className);
        currentScope.define(classScope);
        scopes.put(ctx, classScope);
        currentScope = classScope;
    }

    @Override
    public void exitClassDeclaration(MiniJavaParser.ClassDeclarationContext ctx) {
        currentScope = currentScope.getParent();
    }

    // method
    @Override
    public void enterMainMethod(MiniJavaParser.MainMethodContext ctx) {
        String mainMethodName = "main";
        MethodScope methodScope = new MethodScope("void", mainMethodName, currentScope);
        methodScope.addParameterType("String[]");
        if (currentScope.defined(mainMethodName))
            ErrorCenter.reportRedefinition(ctx.IDENTIFIER().getSymbol(), "main method", mainMethodName);
        currentScope.define(methodScope);
        scopes.put(ctx, methodScope);
        currentScope = methodScope;

        String argName = ctx.IDENTIFIER().getText();
        currentScope.define(new VariableScope("String[]", argName, currentScope));
    }

    @Override
    public void exitMainMethod(MiniJavaParser.MainMethodContext ctx) {
        currentScope = currentScope.getParent();
    }

    @Override
    public void enterMethod(MiniJavaParser.MethodContext ctx) {
        String methodName = ctx.IDENTIFIER().getText();
        MethodScope methodScope = new MethodScope(ctx.type().getText(), methodName, currentScope);
        if (ctx.parameters() != null) {
            List<MiniJavaParser.ParameterContext> parameters = ctx.parameters().parameter();
            for (MiniJavaParser.ParameterContext parameter : parameters)
                methodScope.addParameterType(parameter.type().getText());
        }
        if (currentScope.defined(methodName))
            ErrorCenter.reportRedefinition(ctx.IDENTIFIER().getSymbol(), "method", methodName);
        currentScope.define(methodScope);
        scopes.put(ctx, methodScope);
        currentScope = methodScope;
    }

    @Override
    public void exitMethod(MiniJavaParser.MethodContext ctx) {
        currentScope = currentScope.getParent();
    }

    // block
    @Override
    public void enterBlock(MiniJavaParser.BlockContext ctx) {
        Scope blockScope = new BlockScope(currentScope);
        scopes.put(ctx, blockScope);
        currentScope = blockScope;
    }

    @Override
    public void exitBlock(MiniJavaParser.BlockContext ctx) {
        currentScope = currentScope.getParent();
    }

    // variable
    @Override
    public void enterField(MiniJavaParser.FieldContext ctx) {
        String fieldName = ctx.IDENTIFIER().getText();
        Scope variableScope = new VariableScope(ctx.type().getText(), fieldName, currentScope);
        if (currentScope.defined(fieldName))
            ErrorCenter.reportRedefinition(ctx.IDENTIFIER().getSymbol(), "field", fieldName);
        else {
            currentScope.define(variableScope);
            scopes.put(ctx, variableScope);
        }
    }

    @Override
    public void enterParameter(MiniJavaParser.ParameterContext ctx) {
        String parameterName = ctx.IDENTIFIER().getText();
        Scope variableScope = new VariableScope(ctx.type().getText(), parameterName, currentScope);
        if (currentScope.defined(parameterName))
            ErrorCenter.reportRedefinition(ctx.IDENTIFIER().getSymbol(), "parameter", parameterName);
        else {
            currentScope.define(variableScope);
            scopes.put(ctx, variableScope);
        }
    }

    @Override
    public void enterLocalVariableDeclarationStatement(MiniJavaParser.LocalVariableDeclarationStatementContext ctx) {
        String variableName = ctx.IDENTIFIER().getText();
        Scope variableScope = new VariableScope(ctx.type().getText(), variableName, currentScope);
        if (currentScope.defined(variableName))
            ErrorCenter.reportRedefinition(ctx.IDENTIFIER().getSymbol(), "variable", variableName);
        else {
            currentScope.define(variableScope);
            scopes.put(ctx, variableScope);
        }
    }
}
