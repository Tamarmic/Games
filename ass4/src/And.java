import java.util.Map;

/**
 * Gets two expressions and connects their sons with Operator &.
 */
public class And extends BinaryExpression implements Expression {
    private final Expression x;
    private final Expression y;

    /**
     * constructor.
     *
     * @param x Left expression
     * @param y Right expression
     */
    public And(Expression x, Expression y) {
        super(x, y);
        this.x = x;
        this.y = y;
    }

    /**
     * Checks the value of the expression for the values from the map.
     *
     * @param assignment map
     * @return Whether it is true or not
     * @throws Exception
     */
    //It seems to me that an exception should be thrown here
    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        return x.evaluate(assignment) && y.evaluate(assignment);
    }

    @Override
    public String toString() {
        String s = "";
        s = "(" + this.x.toString() + " & " + this.y.toString() + ")";
        return s;
    }

    @Override
    public Expression assign(String var, Expression expression) {
        And recursive = new And(this.x.assign(var, expression), this.y.assign(var, expression));
        return recursive;
    }

    @Override
    public Expression nandify() {
        return new Nand(new Nand(x.nandify(), y.nandify()), new Nand(x.nandify(), y.nandify()));
    }

    //( A NAND B ) NAND ( A NAND B )
    @Override
    public Expression norify() {
        return new Nor(new Nor(x.norify(), x.norify()), new Nor(y.norify(), y.norify()));
    }

    @Override
    public Expression simplify() {
        if (x.simplify().toString().equals("T")) {
            return y.simplify();
        }
        if (y.simplify().toString().equals("T")) {
            return x.simplify();
        }
        if (x.simplify().toString().equals("F") || y.simplify().toString().equals("F")) {
            return new Val(false);
        }
        if (x.toString().equals(y.toString())) {
            return y.simplify();
        } else {
            return new And(x.simplify(), y.simplify());
        }
    }
}
