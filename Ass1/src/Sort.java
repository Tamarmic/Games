import java.util.ArrayList;
import java.util.List;

// 323805861 Tamar Michelson

/**
 * .
 * Gets an array of strings from the commandline, in the first place a direction of rating (ascending or descending)
 * and in the other strings numbers and it sorts them according to the post
 */
public class Sort {
    /**
     * @param args Gets an array of strings
     */
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        //List<Integer> intList = stringsToInts(args);
        if (args[0].equals("asc")) {
            List<Integer> intList = stringsToInts(args);
            list = sortAsc(intList);
        } else if (args[0].equals("desc")) {
            List<Integer> intList = stringsToInts(args);
            list = sortDesc(intList);
        } else {
            System.out.println("error message");
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    /**
     * @param args the arg
     * @return Sorted array in ascending order
     */
    public static List<Integer> sortAsc(List<Integer> args) {
        int temp;
        for (int j = 0; j < args.size(); j++) {
            for (int i = 0; i < args.size() - 1; i++) {
                if (args.get(i) > args.get(i + 1)) {
                    temp = args.get(i);
                    args.set(i, args.get(i + 1));
                    args.set(i + 1, temp);
                }
            }
        }
        return args;
    }

    /**
     * @param args
     * @return Sorted array in descending order
     */
    public static List<Integer> sortDesc(List<Integer> args) {
        int temp;
        for (int j = 0; j < args.size(); j++) {
            for (int i = 0; i < args.size() - 1; i++) {
                if (args.get(i) < args.get(i + 1)) {
                    temp = args.get(i);
                    args.set(i, args.get(i + 1));
                    args.set(i + 1, temp);
                }
            }
        }
        return args;
    }

    /**
     * @param numbers  array of strings
     * @return list
     */
    public static List<Integer> stringsToInts(String[] numbers) {
        List<Integer> list = new ArrayList<Integer>();   //declaring array
        int length = numbers.length;
        for (int i = 1; i < length; i++) {
            list.add(Integer.parseInt(numbers[i]));
        }
        return list;
    }
}











