//Tamar Michelson 323805861
import biuoop.GUI;
import biuoop.DrawSurface;
import biuoop.Sleeper;

/**
 *
 */
public class BouncingBall {
    /**
     * A black ball bouncing inside the boundaries.
     * @param start The point where he starts to jump.
     * @param dx The speed
     * @param dy The speed
     */
    private static void drawAnimation(Point start, double dx, double dy) {
        GUI gui = new GUI("title", 200, 200);
        Sleeper sleeper = new Sleeper();
        Ball ball = new Ball((int) start.getX(), (int) start.getY(), 30, java.awt.Color.BLACK);
        ball.setVelocity(dx, dy);
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
     * A central function calls the second function and sends it start and speed data.
     * @param args
     */
    public static void main(String[] args) {
        Point ddd = new Point(70, 70);
        drawAnimation(ddd, 3, 4);
    }
}
