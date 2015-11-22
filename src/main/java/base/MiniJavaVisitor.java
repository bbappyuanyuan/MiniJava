package base;// Generated from /Users/Yuanzi/Documents/project/MiniJava/src/main/resources/MiniJava.g4 by ANTLR 4.5.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MiniJavaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MiniJavaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#translationUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTranslationUnit(MiniJavaParser.TranslationUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#classDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclaration(MiniJavaParser.ClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#classMember}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassMember(MiniJavaParser.ClassMemberContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitField(MiniJavaParser.FieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#mainMethod}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMainMethod(MiniJavaParser.MainMethodContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#method}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod(MiniJavaParser.MethodContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(MiniJavaParser.ParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(MiniJavaParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(MiniJavaParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(MiniJavaParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(MiniJavaParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(MiniJavaParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(MiniJavaParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#emptyStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyStatement(MiniJavaParser.EmptyStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#printStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStatement(MiniJavaParser.PrintStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#expressionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionStatement(MiniJavaParser.ExpressionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(MiniJavaParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#blockStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStatement(MiniJavaParser.BlockStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#localVariableDeclarationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVariableDeclarationStatement(MiniJavaParser.LocalVariableDeclarationStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(MiniJavaParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#primaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryExpression(MiniJavaParser.PrimaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionList(MiniJavaParser.ExpressionListContext ctx);
}