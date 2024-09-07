import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

/**
 * the main class.
 */
public class CreateHypernymDatabase {
    private final ArrayList<Rules> list;
    private final Map<String, Map<String, Integer>> dict = new HashMap<>();

    /**
     * CreateHypernymDatabase.
     */
    public CreateHypernymDatabase() {
        //using the method with all the rules.
        list = makeRules();
    }

    /**
     * the main method.
     *
     * @param args get the input and out put.
     * @throws IOException
     */
    public static void main(String[] args) {
        CreateHypernymDatabase createHypernymDatabase1 = new CreateHypernymDatabase();
        try {
            createHypernymDatabase1.createHyperymsFile(args[0], args[1]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Make lise of the rules.
     *
     * @return the list.
     */
    public static ArrayList<Rules> makeRules() {
        ArrayList<Rules> list = new ArrayList();
        list.add(new Rule1());
        list.add(new Rule2());
        list.add(new Rule3());
        list.add(new Rule4());
        list.add(new Rule5());

        return list;
    }

    /**
     * .
     * @param match
     * @return list of nps
     */
    public static List<String> findNps(String match) {
        List<String> nps = new ArrayList<>();
        String end = "</np>";
        String start = "<np>";
        while (match.contains(start)) {
            int endi = match.indexOf(end);
            int starti = match.indexOf(start) + start.length();
            String np = match.substring(starti, endi);
            nps.add(np);
            match = match.substring(endi + end.length());
        }
        return nps;
    }

    /**
     *  createHyperymsFile.
     * @param inputPath
     * @param outputPath
     * @throws IOException
     */
    public void createHyperymsFile(String inputPath, String outputPath) throws IOException {
        //use the file from the args
        File dir = new File(inputPath);
        //somthing that prints.
        PrintWriter lineWriter;
        //for loop, run throw all the files in the curpos.
        for (File file : dir.listFiles()) {
            LineNumberReader lr = new LineNumberReader(new FileReader(file));
            String newLine = lr.readLine().toLowerCase();
            //  lineWriter = new PrintWriter(new FileOutputStream(outputPath));
            while (newLine != null) {
                for (int i = 0; i <= 4; i++) {
                    list.get(i).check(dict, newLine);
                }

                newLine = lr.readLine();
                //because we change again the line.
                if (newLine != null) {
                    newLine.toLowerCase();
                }
            }

        }

        File output = new File(outputPath);
        if (!output.exists()) {
            output.createNewFile();
        }
        Writer write = new FileWriter(output);
        //todo מיון לפי מפתחות

        // Object[] strings = dict.keySet().toArray();
        //Arrays.sort(strings);
        for (String hyper : dict.keySet()) {
            Map<String, Integer> map = dict.get(hyper);
            int s = map.size();
            if (s < 3) {
                continue;
            }
            //todo מיון לפי ערכים
            String line = hyper + ": ";
            for (String hypo : map.keySet()) {
                line += hypo + " (" + map.get(hypo) + "), ";
            }
            line += "\n";
            write.write(line);

        }
    }

}
