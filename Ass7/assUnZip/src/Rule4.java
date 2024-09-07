import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Rule4.
 */
public class Rule4 extends Rules {
    @Override
    public Pattern condition() {

        Pattern p4 = Pattern.compile("<np>[^>]+</np> ?,? ?especially ("
                + "<np>[^>]+</np> (, )?)+(( and| or)?<np>[^>]+</np>)?");
        return p4;
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
