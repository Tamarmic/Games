import java.util.Map;

/**
 * Gets two expressions and connects their sons with Operator ^.
 */
public class Xor extends BinaryExpression {
    private final Expression x;
    private final Expression y;

    /**
     * constructor.
     *
     * @param x Left expression
     * @param y Right expression
     */
    public Xor(Expression x, Expression y) {
        super(x, y);
        this.x = x;
        this.y = y;
    }

    //It seems to me that an exception should be thrown here
    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        return (x.evaluate(assignment) && !y.evaluate(assignment))
                || (!x.evaluate(assignment) && y.evaluate(assignment));
    }


    @Override
    public String toString() {
        String s = "";
        s = "(" + this.x.toString() + " ^ " + this.y.toString() + ")";
        return s;
    }

    @Override
    public Expression assign(String var, Expression expression) {
        Xor recursive = new Xor(this.x.assign(var, expression), this.y.assign(var, expression));
        return recursive;
    }

    @Override
    public Expression nandify() {
        return new Nand(new Nand(x.nandify(), new Nand(x.nandify(),
                y.nandify())), new Nand(y.nandify(), new Nand(x.nandify(), y.nandify())));
        // [ A NAND ( A NAND B ) ] NAND
        //[ B NAND ( A NAND B ) ]
    }

    @Override
    public Expression norify() {
        return new Nor(new Nor(new Nor(x.norify(), x.norify()),
                new Nor(y.norify(), y.norify())), new Nor(x.norify(), y.norify()));
        // [ ( A NOR A ) NOR ( B NOR B ) ]        NOR      ( A NOR B )
    }

    @Override
    public Expression simplify() {
        if (x.simplify().toString().equals("T")) {
            return new Not(y.simplify());
        }
        if (y.simplify().toString().equals("T")) {
            return new Not(x.simplify());
        }
        if (y.simplify().toString().equals("F")) {
            return x.simplify();
        }
        if (x.simplify().toString().equals("F")) {
            return y.simplify();
        }
        if (x.toString().equals(y.toString())) {
            return new Val(false);
        } else {
            return new Xor(x.simplify(), y.simplify());
        }
    }
}
