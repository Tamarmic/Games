import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Holds a key value for a map that is sure to have true or false values.
 */
public class Var implements Expression {
    private final String variable;

    /**
     * constructor.
     *
     * @param string Expression
     */
    public Var(String string) {
        this.variable = string;
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        if (assignment.containsKey(this.variable)) {
            return assignment.get(this.variable);
        } else {
            throw new Exception("Expetion in evaluate var: "
                    + this.variable
                    + " - there is no assignment in the MAP");
        }
    }

    @Override
    public Boolean evaluate() throws Exception {
        throw new Exception("Expetion in evaluate var: "
                + this.variable
                + " - Didn't get the CORRECT (Map<String, Boolean>)  ");
    }

    @Override
    public List<String> getVariables() {
        List<String> vars = new ArrayList<String>();
        vars.add(this.variable);
        return vars;
    }

    @Override
    public String toString() {
        return variable;
    }

    @Override
    public Expression assign(String var, Expression expression) {
        if (this.variable.equals(var)) {
            return expression;
        } else {
            return this;
        }
    }

    @Override
    public Expression nandify() {
        return this;
    }

    @Override
    public Expression norify() {
        return this;
    }

    @Override
    public Expression simplify() {
        return this;
    }
}
