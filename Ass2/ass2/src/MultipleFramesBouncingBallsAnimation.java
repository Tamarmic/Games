//Tamar Michelson 323805861
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

import java.awt.Color;
import java.util.Random;

/**
 *Prints two different frames and inside each of them bouncing balls.
 */
public class MultipleFramesBouncingBallsAnimation {
    /**
     *The main function calls all the other functions.
     * @param args Gets the radii of the spheres from the command line
     */
    public static void  main(String[] args) {
        int[] arr = MultipleBouncingBallsAnimation.stringsToInts(args);
       int size = arr.length;
       Ball[]arrOfBalls = makeArrOffBalls(arr);
        printBoard(arrOfBalls);
    }

    /**
     *Prepares a list of balls from the radius array.
     * @param arr Gets an array of radii
     * @return Returns an array of balls
     */
    public static Ball[]makeArrOffBalls(int[]arr) {
        Random rand = new Random(); // create a random-number generator
        Ball[]arrOfBalls = new Ball[arr.length];
        int x1, y1;
        for (int i = 0; i < arr.length; ++i) {
            if (i < arr.length / 2) {
                 x1 = rand.nextInt(450 - 2 * arr[i]) + arr[i] + 50;
                 y1 = rand.nextInt(450 - 2 * arr[i]) + arr[i] + 50;
            } else {
                 x1 = rand.nextInt(150 - 2 * arr[i]) + arr[i] + 450;
                 y1 = rand.nextInt(150 - 2 * arr[i]) + arr[i] + 450;
            }
            Point middle = new Point(x1, y1);
            Color color = new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
            Ball addTOArr = new Ball(middle, arr[i], color);
            arrOfBalls[i] = addTOArr;
        }
        return arrOfBalls;
    }

    /**
     * Prints the entire board.
     * @param arrOfBalls Receives the array of bullets (originally from the command line)
     */
   static void printBoard(Ball[] arrOfBalls) {
        GUI gui = new GUI("title", 700, 700);
        Sleeper sleeper = new Sleeper();
       Velocity v;
        for (int i = 0; i < arrOfBalls.length; i++) {
            if (arrOfBalls[i].getR() >= 50) {
                v = Velocity.fromAngleAndSpeed(45, 1);
            } else {
                v = Velocity.fromAngleAndSpeed(45, 50 / arrOfBalls[i].getR());
            }
            arrOfBalls[i].setVelocity(v);
        }
        while (true) {
            DrawSurface d = gui.getDrawSurface();
            d.setColor(Color.GRAY);
            d.fillRectangle(50, 50, 450, 450);
            for (int j = 0; j < arrOfBalls.length / 2; j++) {
                arrOfBalls[j].setLimit(500, 50);
                arrOfBalls[j].moveOneStep();
                arrOfBalls[j].drawOn(d);
            }
            d.setColor(Color.YELLOW);
            d.fillRectangle(450, 450, 150, 150);
            for (int j = arrOfBalls.length / 2; j < arrOfBalls.length; j++) {
                arrOfBalls[j].setLimit(600, 450);
                arrOfBalls[j].moveOneStep();
                arrOfBalls[j].drawOn(d);
            }
            gui.show(d);
            sleeper.sleepFor(50);  // wait for 50 milliseconds.


    }
    }
}
