import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Basis for all expressions that get 2 expressions.
 */
public abstract class BinaryExpression extends BaseExpression {
    private final Expression x;
    private final Expression y;

    /**
     * constructor.
     * @param x Left expression
     * @param y Right expression
     */
    public BinaryExpression(Expression x, Expression y) {
        this.x = x;
        this.y = y;
    }

    //I think it should return NULL
    //todo is it empty return var x y;
    @Override
    public List<String> getVariables() {
        Set<String> stringSet = new HashSet();
        List<String> stringList = new ArrayList<String>();
        stringSet.addAll(x.getVariables());
        stringSet.addAll(y.getVariables());
        stringList.addAll(stringSet);
        return stringList;
    }

}
