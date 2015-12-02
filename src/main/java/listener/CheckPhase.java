package listener;

import base.ErrorCenter;
import base.MiniJavaParser;
import org.antlr.v4.runtime.tree.TerminalNode;
import scope.ExpressionScope;
import scope.MethodScope;
import scope.Scope;
import scope.VariableScope;

public class CheckPhase extends Phase {

    private final String INVALID = "__INVALID";
    private final String UNCERTAIN = "__UNCERTAIN";
    private Scope currentScope; // define symbols in this scope

    public CheckPhase() {
        currentScope = outerScope;
    }

    // class
    @Override
    public void enterClassDeclaration(MiniJavaParser.ClassDeclarationContext ctx) {
        if (ctx.IDENTIFIER().size() > 1) {
            String identifierName = ctx.IDENTIFIER(1).getText();
            Scope scope = currentScope.resolve(identifierName);
            if (scope == null || identifierName.equals(ctx.IDENTIFIER(0).getText()))
                ErrorCenter.reportUndefinition(ctx.IDENTIFIER(1).getSymbol(), "class", identifierName);
            else if (!scope.getGenre().equals("class")) {
                ErrorCenter.reportWrongGenre(ctx.IDENTIFIER(1).getSymbol(), "class", scope.getGenre(), identifierName);
            }
        }
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
                    ErrorCenter.reportUndefinition(ctx.IDENTIFIER().getSymbol(), "method", identifierName);
                else if (!scope.getGenre().equals("method"))
                    ErrorCenter.reportWrongGenre(ctx.IDENTIFIER().getSymbol(), "method", scope.getGenre(), identifierName);
            } else {
                if (scope == null)
                    ErrorCenter.reportUndefinition(ctx.IDENTIFIER().getSymbol(), "variable", identifierName);
                else if (!scope.getGenre().equals("variable"))
                    ErrorCenter.reportWrongGenre(ctx.IDENTIFIER().getSymbol(), "variable", scope.getGenre(), identifierName);
            }
        }
    }

    @Override
    public void exitExpression(MiniJavaParser.ExpressionContext ctx) {
        for (MiniJavaParser.ExpressionContext expressionContext : ctx.expression()) {
            ExpressionScope expressionScope = (ExpressionScope) scopes.get(expressionContext);
            if (expressionScope.getType().equals(INVALID)) {
                scopes.put(ctx, new ExpressionScope(INVALID, ctx.getText()));
                return;
            }
        }
        for (MiniJavaParser.ExpressionContext expressionContext : ctx.expression()) {
            ExpressionScope expressionScope = (ExpressionScope) scopes.get(expressionContext);
            if (expressionScope.getType().equals(UNCERTAIN)) {
                scopes.put(ctx, new ExpressionScope(UNCERTAIN, ctx.getText()));
                return;
            }
        }

        String type = UNCERTAIN;
        if (ctx.primaryExpression() != null) { // primaryExpression
            type = ((ExpressionScope) scopes.get(ctx.primaryExpression())).getType();
        } else if (ctx.getChild(0).getText().equals("new")) { // 'new' IDENTIFIER '(' ')'
            Scope scope = currentScope.resolve(ctx.IDENTIFIER().getText());
            if (scope.getGenre().equals("class"))
                type = scope.getName();
        } else if (ctx.getChild(0).getText().equals("-") || ctx.getChild(0).getText().equals("!")) { // ('-'|'!') expression
            ExpressionScope expressionScope = (ExpressionScope) scopes.get(ctx.expression(0));
            if (ctx.getChild(0).getText().equals("-")) {
                if (expressionScope.getType().equals("int")) {
                    type = "int";
                } else {
                    type = INVALID;
                    ErrorCenter.reportWrongType(ctx.expression(0).getStart(), "int", expressionScope.getType(), expressionScope.getName());
                }
            } else {
                if (expressionScope.getType().equals("boolean")) {
                    type = "boolean";
                } else {
                    type = INVALID;
                    ErrorCenter.reportWrongType(ctx.expression(0).getStart(), "boolean", expressionScope.getType(), expressionScope.getName());
                }
            }
        } else if (ctx.getChildCount() == 3 && ctx.expression().size() == 2) {
            ExpressionScope expressionScope0 = (ExpressionScope) scopes.get(ctx.expression(0));
            ExpressionScope expressionScope1 = (ExpressionScope) scopes.get(ctx.expression(1));
            if (ctx.getChild(1).getText().length() == 1) {
                switch (ctx.getChild(1).getText().charAt(0)) {
                    case '*':
                    case '/':
                    case '%': // expression ('*' | '/' | '%') expression
                    case '+':
                    case '-': // expression ('+' | '-') expression
                    case '&': // expression '&' expression
                    case '|': // expression '|' expression
                        if (expressionScope0.getType().equals("int") && expressionScope1.getType().equals("int"))
                            type = "int";
                        else {
                            type = INVALID;
                            if (!expressionScope0.getType().equals("int"))
                                ErrorCenter.reportWrongType(ctx.expression(0).getStart(), "int", expressionScope0.getType(), expressionScope0.getName());
                            if (!expressionScope1.getType().equals("int"))
                                ErrorCenter.reportWrongType(ctx.expression(1).getStart(), "int", expressionScope1.getType(), expressionScope1.getName());
                        }
                        break;
                    case '=': // expression '='<assoc=right> expression
                        if (matchType(expressionScope0.getType(), expressionScope1.getType()))
                            type = expressionScope0.getType();
                        else {
                            type = INVALID;
                            ErrorCenter.reportWrongType(ctx.expression(1).getStart(), expressionScope0.getType(), expressionScope1.getType(), expressionScope1.getName());
                        }
                        break;
                }
            } else { // expression ('<=' | '>=' | '==' | '!=' | '&&' | '||') expression
                String sign = ctx.getChild(1).getText();
                if (sign.equals("<=") || sign.equals(">=")) {
                    if (expressionScope0.getType().equals("int") && expressionScope1.getType().equals("int"))
                        type = "boolean";
                    else {
                        type = INVALID;
                        if (!expressionScope0.getType().equals("int"))
                            ErrorCenter.reportWrongType(ctx.expression(0).getStart(), "int", expressionScope0.getType(), expressionScope0.getName());
                        if (!expressionScope1.getType().equals("int"))
                            ErrorCenter.reportWrongType(ctx.expression(1).getStart(), "int", expressionScope1.getType(), expressionScope1.getName());
                    }
                } else if (sign.equals("==") || sign.equals("!=")) {
                    if (expressionScope0.getType().equals(expressionScope1.getType()))
                        type = "boolean";
                    else {
                        type = INVALID;
                        ErrorCenter.reportWrongType(ctx.expression(1).getStart(), expressionScope0.getType(), expressionScope1.getType(), expressionScope1.getName());
                    }
                } else {
                    if (expressionScope0.getType().equals("boolean") && expressionScope1.getType().equals("boolean"))
                        type = "boolean";
                    else {
                        type = INVALID;
                        if (!expressionScope0.getType().equals("boolean"))
                            ErrorCenter.reportWrongType(ctx.expression(0).getStart(), "boolean", expressionScope0.getType(), expressionScope0.getName());
                        if (!expressionScope1.getType().equals("boolean"))
                            ErrorCenter.reportWrongType(ctx.expression(1).getStart(), "boolean", expressionScope1.getType(), expressionScope1.getName());
                    }
                }
            }
        }
        scopes.put(ctx, new ExpressionScope(type, ctx.getText()));
    }

    @Override
    public void exitPrimaryExpression(MiniJavaParser.PrimaryExpressionContext ctx) {
        String type = UNCERTAIN;
        if (ctx.getChildCount() == 3 && ctx.expression() != null) { // '(' expression ')'
            type = ((ExpressionScope) scopes.get(ctx.expression())).getType();
        } else if (ctx.getChildCount() == 1) {
            String typeStr = ctx.getChild(0).getText();
            if (typeStr.equals("this")) { // 'this'
                type = currentScope.getParent("class").getName();
            } else if (typeStr.equals("null")) // 'null'
                type = "null";
            else if (typeStr.equals("true") || typeStr.equals("false")) // 'true' | 'false'
                type = "boolean";
            else if (((TerminalNode) ctx.getChild(0)).getSymbol().getType() == MiniJavaParser.INTEGER) // INTEGER
                type = "int";
            else { // IDENTIFIER
                Scope scope = currentScope.resolve(ctx.IDENTIFIER().getText());
                if (scope != null && scope.getGenre().equals("variable"))
                    type = ((VariableScope) scope).getType();
            }
        } else { // IDENTIFIER '(' expressionList? ')'
            Scope scope = currentScope.resolve(ctx.IDENTIFIER().getText());
            if (scope != null && scope.getGenre().equals("method")) {
                MethodScope methodScope = (MethodScope) scope;
                type = methodScope.getType();
                int parameterNum = 0;
                if (ctx.expressionList() != null)
                    parameterNum = ctx.expressionList().expression().size();
                if (parameterNum != methodScope.getParameterNum())
                    ErrorCenter.reportWrongParameterNum(ctx.IDENTIFIER().getSymbol(), methodScope.getParameterNum(), methodScope.getName());
                else {
                    for (int i = 0; i < parameterNum; ++i)
                        if (!matchType(methodScope.getParameterType(i), ((ExpressionScope) scopes.get(ctx.expressionList().expression(i))).getType()))
                            ErrorCenter.reportWrongType(ctx.expressionList().expression(i).getStart(), methodScope.getParameterType(i), ((ExpressionScope) scopes.get(ctx.expressionList().expression(i))).getType(), ctx.expressionList().expression(i).getText());
                }
            }
        }
        scopes.put(ctx, new ExpressionScope(type, ctx.getText()));
    }

    @Override
    public void exitLocalVariableDeclarationStatement(MiniJavaParser.LocalVariableDeclarationStatementContext ctx) {
        if (ctx.expression() != null) {
            String type = ((ExpressionScope) scopes.get(ctx.expression())).getType();
            if (!type.equals(INVALID) && !type.equals(UNCERTAIN)) {
                if (!matchType(ctx.type().getText(), type))
                    ErrorCenter.reportWrongType(ctx.expression().getStart(), ctx.type().getText(), type, ctx.expression().getText());
            }
        }
    }

    @Override
    public void exitReturnStatement(MiniJavaParser.ReturnStatementContext ctx) {
        if (ctx.expression() != null) {
            String type = ((ExpressionScope) scopes.get(ctx.expression())).getType();
            if (!type.equals(INVALID) && !type.equals(UNCERTAIN)) {
                String def = ((MethodScope) currentScope.getParent("method")).getType();
                if (!matchType(def, type))
                    ErrorCenter.reportReturnWrongType(ctx.expression().getStart(), def);
            }
        }
    }

    private boolean isIdentifier(String id) {
        return !id.equals("this") && !id.equals("null") && !id.equals("true") && !id.equals("false") && !id.equals("int");
    }

    private boolean matchType(String def, String type) {
        return def.equals(type) || isIdentifier(def) && type.equals("null") || def.equals("void") && type.equals("null");
    }
}
