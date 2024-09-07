// 323805861 Tamar Michelson

/**
 *This class takes a list of commandandlin numbers in the form of a string,
 *  passes them to the int with the help of a function, then sends to three more functions that return the minimum
 *  , maximum and average to the main function and from there prints it.
 */
public class DescribeNumbers {
    /**
     * @param args List of numbers in the form of a string.
     */
    public static void main(String[] args) {
        //  int min=Integer.parseInt(args[0]);

        int[] intArray = stringsToInts(args);
        System.out.println("min: " + min(intArray));
        System.out.println("max: " + max(intArray));
        System.out.println("avg: " + avg(intArray));
    }

    /**
     * .
     * Function that passes an array of strings to an array of int
     *
     * @param numbers Receives an array of strings and passes them to an array of int
     * @return array of int
     */
    public static int[] stringsToInts(String[] numbers) {
        int[] intArray;    //declaring array
        int length = numbers.length;
        intArray = new int[length];
        for (int i = 0; i < length; i++) {
            intArray[i] = Integer.parseInt(numbers[i]);
        }
        return intArray;
    }

    /**
     * .
     * A function that goes through the array and calculates its minimum
     *
     * @param numbers array of int
     * @return The int with the minimum value
     */
    public static int min(int[] numbers) {
        int length = numbers.length;
        int min = numbers[0];
        for (int i = 1; i < length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        return min;
    }

    /**
     * .
     * A function that goes through the array and calculates its maximum
     *
     * @param numbers array of int
     * @return The int with the maximum value
     */
    public static int max(int[] numbers) {
        int length = numbers.length;
        int max = numbers[0];
        for (int i = 1; i < length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max;
    }

    /**
     * Makes the sum of the numbers and divides by the length of the array.
     *
     * @param numbers array of int
     * @return float Which is the average of the array
     *                A function that calculates the averege of the array
     */
    public static float avg(int[] numbers) {
        int length = numbers.length;
        float avg = numbers[0];
        for (int i = 1; i < length; i++) {
            avg = avg + numbers[i];
        }
        avg = avg / length;
        return avg;
    }
}
