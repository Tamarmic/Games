import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Basis for all expressions that get 1 expression.
 */
public abstract class UnaryExpression extends BaseExpression {
    private final Expression expression;

    /**
     * constructor.
     *
     * @param expression
     */
    public UnaryExpression(Expression expression) {
        this.expression = expression;
    }

    @Override
    public List<String> getVariables() {
        Set<String> stringSet = new HashSet();
        List<String> stringList = new ArrayList<String>();
        stringSet.addAll(expression.getVariables());
        stringList.addAll(stringSet);
        return stringList;
    }
}
