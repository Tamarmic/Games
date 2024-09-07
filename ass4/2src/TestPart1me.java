import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TestPart1me {
    public static void main(String[] args) throws Exception {

        Expression e2 = new Not(
                new Xor(
                        new And(
                                new Val(true),
                                new Or(
                                        new Var("x"),
                                        new Var("y")
                                )
                        ),
                        new Var("x")
                )
        );
        Expression e = new Not(
                new And(
                        new And(
                                new Val(true),
                                new And(
                                        new Var("x"),
                                        new Var("y")
                                )
                        ),
                        new Var("x")
                )
        );

        Map<String, Boolean> assignment = new TreeMap<>();
        assignment.put("x", true);
        assignment.put("y", false);
        Boolean value = e.evaluate(assignment);
        System.out.println("The result is: " + value);

      /*  e.getVariables();
        List<String> vars = e.getVariables();
        for (String v : vars) {
            System.out.println(v);
        }*/

        String s=e.toString();
        System.out.println(s);

        Expression e1 = new Xor(new Var("x"), new Var("y"));
       System.out.println(e.nandify());
        System.out.println(e.norify());
        System.out.println("simplify: "+e.simplify());
// should print:
// ((x A (x A y)) A (y A (x A y)))
// (((x V x) V (y V y)) V (x V y))
    }
}
