import java.util.Map;

/**
 * Gets  expression and use with Operator !.
 */
public class Not extends UnaryExpression {
    private final Expression expression;

    /**
     * constructor.
     *
     * @param expression1 expression
     */
    public Not(Expression expression1) {
        super(expression1);
        this.expression = expression1;
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        return !expression.evaluate(assignment);
    }

    @Override
    public String toString() {


        String s = "";
        s = "~(" + this.expression.toString() + ")";
        return s;
    }

    @Override
    public Expression assign(String var, Expression expression) {
        Not recursive = new Not(this.expression.assign(var, expression));
        return recursive;

    }
    @Override
    public Expression nandify() {
        return new Nand(expression.nandify(), expression.nandify());
    }

    @Override
    public Expression norify() {
        return new Nor(expression.norify(), expression.norify());
    }

    @Override
    public Expression simplify() {
        return new Not(expression.simplify());
    }

}
