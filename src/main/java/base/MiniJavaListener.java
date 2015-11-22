package base;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MiniJavaParser}.
 */
public interface MiniJavaListener extends ParseTreeListener {
    /**
     * Enter a parse tree produced by {@link MiniJavaParser#translationUnit}.
     *
     * @param ctx the parse tree
     */
    void enterTranslationUnit(MiniJavaParser.TranslationUnitContext ctx);

    /**
     * Exit a parse tree produced by {@link MiniJavaParser#translationUnit}.
     *
     * @param ctx the parse tree
     */
    void exitTranslationUnit(MiniJavaParser.TranslationUnitContext ctx);

    /**
     * Enter a parse tree produced by {@link MiniJavaParser#classDeclaration}.
     *
     * @param ctx the parse tree
     */
    void enterClassDeclaration(MiniJavaParser.ClassDeclarationContext ctx);

    /**
     * Exit a parse tree produced by {@link MiniJavaParser#classDeclaration}.
     *
     * @param ctx the parse tree
     */
    void exitClassDeclaration(MiniJavaParser.ClassDeclarationContext ctx);

    /**
     * Enter a parse tree produced by {@link MiniJavaParser#classMember}.
     *
     * @param ctx the parse tree
     */
    void enterClassMember(MiniJavaParser.ClassMemberContext ctx);

    /**
     * Exit a parse tree produced by {@link MiniJavaParser#classMember}.
     *
     * @param ctx the parse tree
     */
    void exitClassMember(MiniJavaParser.ClassMemberContext ctx);

    /**
     * Enter a parse tree produced by {@link MiniJavaParser#field}.
     *
     * @param ctx the parse tree
     */
    void enterField(MiniJavaParser.FieldContext ctx);

    /**
     * Exit a parse tree produced by {@link MiniJavaParser#field}.
     *
     * @param ctx the parse tree
     */
    void exitField(MiniJavaParser.FieldContext ctx);

    /**
     * Enter a parse tree produced by {@link MiniJavaParser#mainMethod}.
     *
     * @param ctx the parse tree
     */
    void enterMainMethod(MiniJavaParser.MainMethodContext ctx);

    /**
     * Exit a parse tree produced by {@link MiniJavaParser#mainMethod}.
     *
     * @param ctx the parse tree
     */
    void exitMainMethod(MiniJavaParser.MainMethodContext ctx);

    /**
     * Enter a parse tree produced by {@link MiniJavaParser#method}.
     *
     * @param ctx the parse tree
     */
    void enterMethod(MiniJavaParser.MethodContext ctx);

    /**
     * Exit a parse tree produced by {@link MiniJavaParser#method}.
     *
     * @param ctx the parse tree
     */
    void exitMethod(MiniJavaParser.MethodContext ctx);

    /**
     * Enter a parse tree produced by {@link MiniJavaParser#parameters}.
     *
     * @param ctx the parse tree
     */
    void enterParameters(MiniJavaParser.ParametersContext ctx);

    /**
     * Exit a parse tree produced by {@link MiniJavaParser#parameters}.
     *
     * @param ctx the parse tree
     */
    void exitParameters(MiniJavaParser.ParametersContext ctx);

    /**
     * Enter a parse tree produced by {@link MiniJavaParser#parameter}.
     *
     * @param ctx the parse tree
     */
    void enterParameter(MiniJavaParser.ParameterContext ctx);

    /**
     * Exit a parse tree produced by {@link MiniJavaParser#parameter}.
     *
     * @param ctx the parse tree
     */
    void exitParameter(MiniJavaParser.ParameterContext ctx);

    /**
     * Enter a parse tree produced by {@link MiniJavaParser#type}.
     *
     * @param ctx the parse tree
     */
    void enterType(MiniJavaParser.TypeContext ctx);

    /**
     * Exit a parse tree produced by {@link MiniJavaParser#type}.
     *
     * @param ctx the parse tree
     */
    void exitType(MiniJavaParser.TypeContext ctx);

    /**
     * Enter a parse tree produced by {@link MiniJavaParser#statement}.
     *
     * @param ctx the parse tree
     */
    void enterStatement(MiniJavaParser.StatementContext ctx);

    /**
     * Exit a parse tree produced by {@link MiniJavaParser#statement}.
     *
     * @param ctx the parse tree
     */
    void exitStatement(MiniJavaParser.StatementContext ctx);

    /**
     * Enter a parse tree produced by {@link MiniJavaParser#block}.
     *
     * @param ctx the parse tree
     */
    void enterBlock(MiniJavaParser.BlockContext ctx);

    /**
     * Exit a parse tree produced by {@link MiniJavaParser#block}.
     *
     * @param ctx the parse tree
     */
    void exitBlock(MiniJavaParser.BlockContext ctx);

    /**
     * Enter a parse tree produced by {@link MiniJavaParser#ifStatement}.
     *
     * @param ctx the parse tree
     */
    void enterIfStatement(MiniJavaParser.IfStatementContext ctx);

    /**
     * Exit a parse tree produced by {@link MiniJavaParser#ifStatement}.
     *
     * @param ctx the parse tree
     */
    void exitIfStatement(MiniJavaParser.IfStatementContext ctx);

    /**
     * Enter a parse tree produced by {@link MiniJavaParser#whileStatement}.
     *
     * @param ctx the parse tree
     */
    void enterWhileStatement(MiniJavaParser.WhileStatementContext ctx);

    /**
     * Exit a parse tree produced by {@link MiniJavaParser#whileStatement}.
     *
     * @param ctx the parse tree
     */
    void exitWhileStatement(MiniJavaParser.WhileStatementContext ctx);

    /**
     * Enter a parse tree produced by {@link MiniJavaParser#emptyStatement}.
     *
     * @param ctx the parse tree
     */
    void enterEmptyStatement(MiniJavaParser.EmptyStatementContext ctx);

    /**
     * Exit a parse tree produced by {@link MiniJavaParser#emptyStatement}.
     *
     * @param ctx the parse tree
     */
    void exitEmptyStatement(MiniJavaParser.EmptyStatementContext ctx);

    /**
     * Enter a parse tree produced by {@link MiniJavaParser#printStatement}.
     *
     * @param ctx the parse tree
     */
    void enterPrintStatement(MiniJavaParser.PrintStatementContext ctx);

    /**
     * Exit a parse tree produced by {@link MiniJavaParser#printStatement}.
     *
     * @param ctx the parse tree
     */
    void exitPrintStatement(MiniJavaParser.PrintStatementContext ctx);

    /**
     * Enter a parse tree produced by {@link MiniJavaParser#expressionStatement}.
     *
     * @param ctx the parse tree
     */
    void enterExpressionStatement(MiniJavaParser.ExpressionStatementContext ctx);

    /**
     * Exit a parse tree produced by {@link MiniJavaParser#expressionStatement}.
     *
     * @param ctx the parse tree
     */
    void exitExpressionStatement(MiniJavaParser.ExpressionStatementContext ctx);

    /**
     * Enter a parse tree produced by {@link MiniJavaParser#returnStatement}.
     *
     * @param ctx the parse tree
     */
    void enterReturnStatement(MiniJavaParser.ReturnStatementContext ctx);

    /**
     * Exit a parse tree produced by {@link MiniJavaParser#returnStatement}.
     *
     * @param ctx the parse tree
     */
    void exitReturnStatement(MiniJavaParser.ReturnStatementContext ctx);

    /**
     * Enter a parse tree produced by {@link MiniJavaParser#blockStatement}.
     *
     * @param ctx the parse tree
     */
    void enterBlockStatement(MiniJavaParser.BlockStatementContext ctx);

    /**
     * Exit a parse tree produced by {@link MiniJavaParser#blockStatement}.
     *
     * @param ctx the parse tree
     */
    void exitBlockStatement(MiniJavaParser.BlockStatementContext ctx);

    /**
     * Enter a parse tree produced by {@link MiniJavaParser#localVariableDeclarationStatement}.
     *
     * @param ctx the parse tree
     */
    void enterLocalVariableDeclarationStatement(MiniJavaParser.LocalVariableDeclarationStatementContext ctx);

    /**
     * Exit a parse tree produced by {@link MiniJavaParser#localVariableDeclarationStatement}.
     *
     * @param ctx the parse tree
     */
    void exitLocalVariableDeclarationStatement(MiniJavaParser.LocalVariableDeclarationStatementContext ctx);

    /**
     * Enter a parse tree produced by {@link MiniJavaParser#expression}.
     *
     * @param ctx the parse tree
     */
    void enterExpression(MiniJavaParser.ExpressionContext ctx);

    /**
     * Exit a parse tree produced by {@link MiniJavaParser#expression}.
     *
     * @param ctx the parse tree
     */
    void exitExpression(MiniJavaParser.ExpressionContext ctx);

    /**
     * Enter a parse tree produced by {@link MiniJavaParser#primaryExpression}.
     *
     * @param ctx the parse tree
     */
    void enterPrimaryExpression(MiniJavaParser.PrimaryExpressionContext ctx);

    /**
     * Exit a parse tree produced by {@link MiniJavaParser#primaryExpression}.
     *
     * @param ctx the parse tree
     */
    void exitPrimaryExpression(MiniJavaParser.PrimaryExpressionContext ctx);

    /**
     * Enter a parse tree produced by {@link MiniJavaParser#expressionList}.
     *
     * @param ctx the parse tree
     */
    void enterExpressionList(MiniJavaParser.ExpressionListContext ctx);

    /**
     * Exit a parse tree produced by {@link MiniJavaParser#expressionList}.
     *
     * @param ctx the parse tree
     */
    void exitExpressionList(MiniJavaParser.ExpressionListContext ctx);
}