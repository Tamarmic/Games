import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Holds true or false value.
 */
public class Val implements Expression {
    private Boolean aBoolean;
    /**
     * constructor.
     * @param b A boolean
     */
    public Val(boolean b) {
        this.aBoolean = b;
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        return aBoolean;
    }

    @Override
    public Boolean evaluate() throws Exception {
        return aBoolean;
    }
    //Todo empty list
    @Override
    public List<String> getVariables() {
        List<String> empty = new ArrayList<String>();
        return empty;
    }

    @Override
    public String toString() {
        String s;
        if (aBoolean) {
            s = "T";
        } else {
            s = "F";
        }
        return s;
    }

    @Override
    public Expression assign(String var, Expression expression) {
        return this;
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
