import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Rule2.
 */
public class Rule2 extends Rules {
    @Override
    public Pattern condition() {

        Pattern p2
                = Pattern.compile("such <np>[^>]+</np> ?,? ?as ("
                + "<np>[^>]+</np> (, )?)+(( and| or)?<np>[^>]*</np>)?");
        return p2;

    }

    @Override
    public void addToDic(Map<String, Map<String, Integer>> dic, String line, Matcher matcher) {
        List<String> nps = CreateHypernymDatabase.findNps(matcher.group());
        String hypernym = nps.get(0);
        nps.remove(hypernym);
        Map<String, Integer> secounds;
        if (dic.containsKey(hypernym)) {
            secounds = dic.get(hypernym);
        } else {
            secounds = new HashMap<>();
        }
        helperToAdd(secounds, nps, dic, hypernym);
    }

}
