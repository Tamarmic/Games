//Tamar Michelson 323805861
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

/**
 *  class prints a bouncing ball on the screen.
 */
public class BouncingBallAnimation {
    //constructor

    /**
     * A central function calls the second function and sends it start and speed data.
     * @param args The information from the command line.
     */
    public static void  main(String[]args) {
       Double[]arr = stringsToInts(args);
        BouncingBall bouncingBall = new BouncingBall();
        Point send = new Point(arr[0], arr[1]);
        drawAnimation(send, arr[2], arr[3]);
    }
    private static void drawAnimation(Point start, double dx, double dy) {
        GUI gui = new GUI("title", 200, 200);
        Sleeper sleeper = new Sleeper();
        Ball ball = new Ball((int) start.getX(), (int) start.getY(), 30, java.awt.Color.BLACK);
        Velocity v = Velocity.fromAngleAndSpeed(dx, dy);
        ball.setVelocity(v);
        while (true) {
            ball.setLimit(200, 0);
            ball.moveOneStep();
            DrawSurface d = gui.getDrawSurface();
            ball.drawOn(d);
            gui.show(d);
            sleeper.sleepFor(50);  // wait for 50 milliseconds.
        }
    }

    /**
     * Turns Strings To Ints.
     * @param numbers
     * @return arr of strings
     */
    public static Double[] stringsToInts(String[] numbers) {
        Double[] intArray;    //declaring array
        int length = numbers.length;
        intArray = new Double[length];
        for (int i = 0; i < length; i++) {
            intArray[i] = Double.parseDouble(numbers[i]);
        }
        return intArray;
    }
}
