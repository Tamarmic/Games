import java.util.Map;
import java.util.TreeMap;

/**
 * test.
 */
public class ExpressionsTest {
    /**
     * Main.
     *
     * @param args not used.
     * @throws Exception Exception
     */
    public static void main(String[] args) throws Exception {

        Expression e = new Not(
                new Xor(
                        new And(
                                new Val(true),
                                new Or(
                                        new Var("x"),
                                        new Var("y")
                                )
                        ),
                        new Var("z")
                )
        );


        Map<String, Boolean> assignment = new TreeMap<>();
        assignment.put("x", true);
        assignment.put("y", false);
        assignment.put("z", true);

        String s = e.toString();
        System.out.println(s);

        Boolean value = e.evaluate(assignment);
        System.out.println(value);
        System.out.println(e.nandify());
        System.out.println(e.norify());
        System.out.println(e.simplify());
    }
}
