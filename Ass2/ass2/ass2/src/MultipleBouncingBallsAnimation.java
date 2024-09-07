//Tamar Michelson 323805861
import biuoop.GUI;
import biuoop.DrawSurface;
import java.util.Random;
import java.awt.Color;
import biuoop.Sleeper;

/**
 * Prints a lot of bouncing balls.
 */
public class MultipleBouncingBallsAnimation {

    /**
     * A center function that receives variables from the command line the radii of the spheres we want to print.
     * @param args the radii of the spheres we want to print
     */
    public static void  main(String[] args) {
        int length = args.length;
        Ball[]arrOfBalls = new Ball[length];
        int[] arr = stringsToInts(args);
        drawEveryThing(arr, length, arrOfBalls);
        drawAnimation(arr, length, arrOfBalls);
    }
    /**
     * A function that prints all the balls on the board.
     * @param arr The radii of the ball
     * @param length How many bullets are there
     * @param arrOfBalls The ballers themselves
     */
    public static void drawEveryThing(int[]arr, int length, Ball[]arrOfBalls) {
        Random rand = new Random(); // create a random-number generator
        for (int i = 0; i < length; ++i) {
            int x1 = rand.nextInt(200 - 2 * arr[i]) + arr[i]; // get integer in range 30-170
            int y1 = rand.nextInt(200 - 2 * arr[i]) + arr[i]; // get integer in range 30-170
            Point middle = new Point(x1, y1);
            Color color = new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
            Ball addTOArr = new Ball(middle, arr[i], color);
            arrOfBalls[i] = addTOArr;
        }
    }

    /**
     * A function that is in the print pointer, will print all the balls on the board.
     * @param arr The radii of the ball
     * @param length How many bullets are there
     * @param arrOfBalls The ballers themselves
     */
    private static void drawAnimation(int[] arr, int length, Ball[]arrOfBalls) {
        GUI gui = new GUI("title", 200, 200);
        Sleeper sleeper = new Sleeper();
        for (int i = 0; i < length; i++) {
        Velocity v = Velocity.fromAngleAndSpeed(45, 100 / arr[i]);
            arrOfBalls[i].setVelocity(v);
        }
        while (true) {
            for (int j = 0; j < length; j++) {
                arrOfBalls[j].setLimit(200, 0);
                arrOfBalls[j].moveOneStep();
            }
            DrawSurface d = gui.getDrawSurface();
            for (int j = 0; j < length; j++) {
                arrOfBalls[j].drawOn(d);
            }
            gui.show(d);
            sleeper.sleepFor(50);  // wait for 50 milliseconds.

        }
    }

    /**
     * Turns Strings To Ints.
     * @param numbers
     * @return arr of strings
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
}
