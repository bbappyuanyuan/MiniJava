package base;

import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

/**
 * This class provides an empty implementation of {@link MiniJavaVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 *            operations with no return type.
 */
public class MiniJavaBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements MiniJavaVisitor<T> {
    /**
     * {@inheritDoc}
     * <p/>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitTranslationUnit(MiniJavaParser.TranslationUnitContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     * <p/>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitClassDeclaration(MiniJavaParser.ClassDeclarationContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     * <p/>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitClassMember(MiniJavaParser.ClassMemberContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     * <p/>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitField(MiniJavaParser.FieldContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     * <p/>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitMainMethod(MiniJavaParser.MainMethodContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     * <p/>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitMethod(MiniJavaParser.MethodContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     * <p/>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitParameters(MiniJavaParser.ParametersContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     * <p/>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitParameter(MiniJavaParser.ParameterContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     * <p/>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitType(MiniJavaParser.TypeContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     * <p/>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitStatement(MiniJavaParser.StatementContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     * <p/>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitBlock(MiniJavaParser.BlockContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     * <p/>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitIfStatement(MiniJavaParser.IfStatementContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     * <p/>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitWhileStatement(MiniJavaParser.WhileStatementContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     * <p/>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitEmptyStatement(MiniJavaParser.EmptyStatementContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     * <p/>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitPrintStatement(MiniJavaParser.PrintStatementContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     * <p/>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitExpressionStatement(MiniJavaParser.ExpressionStatementContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     * <p/>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitReturnStatement(MiniJavaParser.ReturnStatementContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     * <p/>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitBlockStatement(MiniJavaParser.BlockStatementContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     * <p/>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitLocalVariableDeclarationStatement(MiniJavaParser.LocalVariableDeclarationStatementContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     * <p/>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitExpression(MiniJavaParser.ExpressionContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     * <p/>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitPrimaryExpression(MiniJavaParser.PrimaryExpressionContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     * <p/>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitExpressionList(MiniJavaParser.ExpressionListContext ctx) {
        return visitChildren(ctx);
    }
}