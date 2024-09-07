import java.util.Map;

/**
 * Gets two expressions and connects their sons with Operator ||.
 */
public class Or extends BinaryExpression {
    private final Expression x;
    private final Expression y;

    /**
     * constructor.
     *
     * @param x Left expression
     * @param y Right expression
     */
    public Or(Expression x, Expression y) {
        super(x, y);
        this.x = x;
        this.y = y;
    }

    //It seems to me that an exception should be thrown here
    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        return x.evaluate(assignment) || y.evaluate(assignment);
    }


    @Override
    public String toString() {
        String s = "";
        s = "(" + this.x.toString() + " | " + this.y.toString() + ")";
        return s;
    }

    @Override
    public Expression assign(String var, Expression expression) {
        Or recursive = new Or(this.x.assign(var, expression), this.y.assign(var, expression));
        return recursive;
    }

    @Override
    public Expression nandify() {
        return new Nand(new Nand(x.nandify(), x.nandify()), new Nand(y.nandify(), y.nandify()));
        //( A NAND A ) NAND ( B NAND B )
    }

    @Override
    public Expression norify() {
        return new Nor(new Nor(x.norify(), y.norify()), new Nor(x.norify(), y.norify()));
    }

    @Override
    public Expression simplify() {
        if (x.simplify().toString().equals("T") || y.simplify().toString().equals("T")) {
            return new Val(true);
        }
        if (!x.simplify().toString().equals("F") && y.simplify().toString().equals("F")) {
            return x.simplify();
        }
        if (x.simplify().toString().equals("F") && !y.simplify().toString().equals("F")) {
            return y.simplify();
        }
        if (x.toString().equals(y.toString())) {
            return y.simplify();
        } else {
            return new Or(x.simplify(), y.simplify());
        }
    }
}
