import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * all the rules.
 */
public abstract class Rules {

    /**
     * addToDic.
     * @param dic dictionery
     * @param line
     * @param matcher
     */
    public abstract void addToDic(Map<String, Map<String, Integer>> dic, String line, Matcher matcher);

    /**
     * check to add to the dicsionery.
     * @param dic
     * @param line
     */
    public void check(Map<String, Map<String, Integer>> dic, String line) {
        Pattern p = condition();
        Matcher matcher = p.matcher(line);
        if (matcher.find()) {
            addToDic(dic, line, matcher);
        }
    }

    /**
     * Pattern.
     * @return the pattern
     */
    public abstract Pattern condition();

    /**
     * helper To Add.
     * @param secounds
     * @param nps
     * @param dic
     * @param hypernym
     */
    public void helperToAdd(Map<String, Integer> secounds, List<String> nps,
                            Map<String, Map<String, Integer>> dic, String hypernym) {

        for (String second : nps) {
            int times;
            if (secounds.containsKey(second)) {
                times = secounds.get(second) + 1;
            } else {
                times = 1;
            }
            secounds.put(second, times);
        }
        dic.put(hypernym, secounds);
    }
}
