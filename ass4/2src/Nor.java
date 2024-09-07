import java.util.Map;

/**
 * Gets two expressions and connects their sons with Operator ! | =v.
 */
public class Nor extends BinaryExpression {
    private final Expression x;
    private final Expression y;

    /**
     * constructor.
     *
     * @param x Left expression
     * @param y Right expression
     */
    public Nor(Expression x, Expression y) {
        super(x, y);
        this.x = x;
        this.y = y;
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        return !(x.evaluate(assignment) || y.evaluate(assignment));
    }

    @Override
    public Expression assign(String var, Expression expression) {
        Nor recursive = new Nor(this.x.assign(var, expression), this.y.assign(var, expression));
        return recursive;
    }

    @Override
    public Expression nandify() {
        return new Nor(new Nor(new Nor(x.nandify(), x.nandify()), new Nor(y.nandify(),
                y.nandify())), new Nor(new Nor(x.nandify(), x.nandify()), new Nor(y.nandify(), y.nandify())));
    }

    @Override
    public Expression norify() {
        return new Nor(x.simplify(), y.simplify());
    }

    @Override
    public Expression simplify() {
        if (x.simplify().toString().equals("T") || y.simplify().toString().equals("T")) {
            return new Val(false);
        }
        if (y.simplify().toString().equals("F")) {
            return new Not(x);
        }
        if (x.simplify().toString().equals("F")) {
            return new Not(y);
        }
        if (x.simplify().toString().equals(y.toString())) {
            return new Not(x.simplify());
        } else {
            return new Nor(x.simplify(), y.simplify());
        }
    }

    @Override
    public String toString() {
        String s = "";
        s = "(" + this.x.toString() + " V " + this.y.toString() + ")";
        return s;
    }
}
