import java.util.Map;

/**
 * Gets two expressions and connects their sons with Operator ! & = A.
 */
public class Nand extends BinaryExpression {
    private final Expression x;
    private final Expression y;

    /**
     * constructor.
     *
     * @param x Left expression
     * @param y Right expression
     */
    public Nand(Expression x, Expression y) {
        super(x, y);
        this.x = x;
        this.y = y;
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        return !(x.evaluate(assignment) && y.evaluate(assignment));
    }

    @Override
    public Expression assign(String var, Expression expression) {
        Nand recursive = new Nand(this.x.assign(var, expression), this.y.assign(var, expression));
        return recursive;
    }

    @Override
    public Expression nandify() {
        return new Nand(x.nandify(), y.nandify());
    }

    @Override
    public Expression norify() {
            return new Nor(new Nor(new Nor(x.norify(), x.norify()), new Nor(y.norify(),
                    y.norify())), new Nor(new Nor(x.norify(), x.norify()), new Nor(y.norify(), y.norify())));
        }

    @Override
    public Expression simplify() {
        if (x.simplify().toString().equals("T")) {
            return new Not(y.simplify());
        }
        if (y.simplify().toString().equals("T")) {
            return new Not(x.simplify());
        }
        if (y.simplify().toString().equals("F") || x.simplify().toString().equals("F")) {
            return new Val(true);
        }
        if (x.toString().equals(y.toString())) {
            return new Not(x.simplify());
        } else {
            return new Nand(x.simplify(), y.simplify());
        }
    }

    @Override
    public String toString() {
        String s = "";
        s = "(" + this.x.toString() + " A " + this.y.toString() + ")";
        return s;
    }
}
