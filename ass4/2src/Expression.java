import java.util.List;
import java.util.Map;

/**
 * Binds all the phrases together.
 */
public interface Expression {
    // Evaluate the expression using the variable values provided
    // in the assignment, and return the result. If the expression
    // contains a variable which is not in the assignment, an exception
    // is thrown.
    /**
     * Checks the value of the expression for the values from the map.
     *
     * @param assignment map
     * @return Whether it is true or not
     * @throws Exception
     */
    Boolean evaluate(Map<String, Boolean> assignment) throws Exception;

    // A convenience method. Like the `evaluate(assignment)` method above,
    // but uses an empty assignment.
    /**
     * Checks the value of the expression for the values.
     *
     * @return Whether it is true or not
     * @throws Exception
     */
    Boolean evaluate() throws Exception;

    // Returns a list of the variables in the expression.

    /**
     * Passes on a string and returns only variables.
     * @return variables
     */
    List<String> getVariables();

    // Returns a nice string representation of the expression.

    /**
     * Transfer to a string according to the operator.
     * @return Transfer to a string according to the operator.
     */
    String toString();

    // Returns a new expression in which all occurrences of the variable
    // var are replaced with the provided expression (Does not modify the
    // current expression).

    /**
     * Replacement of a particular expression within the expression.
     * @param var The variable you want to replace
     * @param expression What you want to exchange for it
     * @return New expression
     */
    Expression assign(String var, Expression expression);

    // Returns the expression tree resulting from converting all the operations to the logical Nand operation.

    /**
     * Make the expression be only with A.
     * @return expression be only with A.
     */
    Expression nandify();
    // Returns the expression tree resulting from converting all the operations to the logical Nor operation.
    /**
     * Make the expression be only with V.
     * @return expression be only with V.
     */
   Expression norify();
    // Returned a simplified version of the current expression.

    /**
     * Makes expression simpler.
     * @return Abstract expression
     */
    Expression simplify();
}