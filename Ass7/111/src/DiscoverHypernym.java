import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * part 2.
 */
public class DiscoverHypernym {
    /**
     * the main class.
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<Rules> list = CreateHypernymDatabase.makeRules();
        Map<String, Map<String, Integer>> dict = new HashMap<>();
        File dir = new File(args[0]);
        int files = 0;
        PrintWriter lineWriter;
        for (File file : dir.listFiles()) {
            //  System.out.println(file.getName());
            LineNumberReader lineNumberReader = null;
            try {
                lineNumberReader = new LineNumberReader(new FileReader(file));
                String line = lineNumberReader.readLine();
                while (line != null) {
                    for (int i = 0; i < 4; i++) {
                        list.get(i).check(dict, line);
                    }
                    line = lineNumberReader.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            // lineWriter = new PrintWriter(new FileOutputStream(outputPath));
        }
        String lemma = args[1];

        Map<String, Integer> newdict = new HashMap<>();

        for (String hyper : dict.keySet()) {

            Map<String, Integer> map = dict.get(hyper);

            if (!map.containsKey(lemma)) {
                continue;
            }
            int times = map.get(lemma);

            newdict.put(hyper, times);
            //  System.out.println(hyper+ ": ("+String.valueOf(times)+")");

        }
        //start a new one
        if (newdict.isEmpty()) {
            //print somthing for the user.
            System.out.println("The lemma doesn't appear in the corpus.");
        } else {
            if (files != 0) {
                files++;
            }
            //todo
            //
            for (String hyper : newdict.keySet()) {
                int time = newdict.get(hyper);
//prints the hypers
                System.out.println(hyper + ": (" + time + ")");
            }
        }
    }
}
