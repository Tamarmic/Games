import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Rule5.
 */
public class Rule5 extends Rules {

    @Override
    public Pattern condition() {

        Pattern p5 = Pattern.compile("<np>[^>]</np> ?,? ?which is ((an example|"
                + "a kind|a class) of( a | an )?)?<np>[^>]+</np>");
        return p5;

    }

    // todo cheK hyponym on the second place instead of first
    //chek;
    @Override
    public void addToDic(Map<String, Map<String, Integer>> dic, String line, Matcher matcher) {
        List<String> nps = CreateHypernymDatabase.findNps(matcher.group());
        String hypernym = nps.get(1);
        nps.remove(hypernym);
        //the np without the hyper
        Map<String, Integer> secounds;
        if (dic.containsKey(hypernym)) {
            secounds = dic.get(hypernym);
        } else {
            secounds = new HashMap<>();
        }
        helperToAdd(secounds, nps, dic, hypernym);
    }
}
