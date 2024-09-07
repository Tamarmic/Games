import java.util.Map;

/**
 * Gets two expressions and connects their sons with Operator #.
 */
public class Xnor extends BinaryExpression {
    private final Expression x;
    private final Expression y;

    /**
     * constructor.
     *
     * @param x Left expression
     * @param y Right expression
     */
    public Xnor(Expression x, Expression y) {
        super(x, y);
        this.x = x;
        this.y = y;
    }

    //It seems to me that an exception should be thrown here
    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        return x.evaluate(assignment) && y.evaluate(assignment)
                || !x.evaluate(assignment) && !y.evaluate(assignment);
    }


    @Override
    public String toString() {
        String s = "";
        s = "(" + this.x.toString() + " # " + this.y.toString() + ")";
        return s;
    }

    @Override
    public Expression assign(String var, Expression expression) {
        Xnor recursive = new Xnor(this.x.assign(var, expression), this.y.assign(var, expression));
        return recursive;
    }

    //Todo//
    @Override
    public Expression nandify() {
        return new Nand(new Nand(new Nand(x.nandify(), x.nandify()),
                new Nand(y.nandify(), y.nandify())), new Nand(x.nandify(), y.nandify()));
        // [ ( A NAND A ) NAND ( B NAND B ) ] NAND
        //( A NAND B )
    }

    @Override
    public Expression norify() {
        return new Nor(new Nor(x.norify(), new Nor(x.norify(), y.norify())),
                new Nor(y.norify(), new Nor(x.norify(), y.norify())));

        //[ A NOR ( A NOR B ) ] NOR
        //[ B NOR ( A NOR B ) ]
    }

    //Todo//
    @Override
    public Expression simplify() {
        if (x.simplify().toString().equals(y.simplify().toString())) {
            return new Val(true);
        } else {
            return new Xnor(x.simplify(), y.simplify());
        }
    }
}
