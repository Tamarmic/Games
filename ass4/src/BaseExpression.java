/**
 * Basis for all expressions.
 */
public abstract class BaseExpression implements Expression {

    @Override
    public Boolean evaluate() throws Exception {
        throw new Exception("No map or key was received "
                + " -> Didn't get the (Map<String, Boolean>)  ");
    }

}
