import java.util.Comparator;
import java.util.Map;
    public class ValueThenKeyComparator<String extends Comparable<? super String>,
            Integer extends Comparable<? super Integer>>
            implements Comparator<Map.Entry<String, Integer>> {

        public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
            int cmp1 = b.getValue().compareTo(a.getValue());
            if (cmp1 != 0) {
                return cmp1;
            } else {
                return a.getKey().compareTo(b.getKey());
            }
        }

    }

