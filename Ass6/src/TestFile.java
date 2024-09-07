import java.util.Random;
import biuoop.GUI;
import biuoop.DrawSurface;

/**
 * This class is responsible for the gui and the art side of the program.
 */
public class TestFile {
    /**
     * The function calls functions to generate random lines and draw them.
     * @param args Arguments from the command line
     */
    public static void main(String[] args) {
        GUI gui = new GUI("Random lines", 600, 600);
        DrawSurface d = gui.getDrawSurface();
        Line[] lines = new Line[10];
        generateRandomLines(lines);
        drawLines(lines, d);
        markCenters(lines, d);
        markIntersections(lines, d);
        gui.show(d);
    }

    /**
     * The function generates 10 random lines.
     * @param lines An array of type Line
     */
    private static void generateRandomLines(Line[] lines) {
        Random rand = new Random();
        lines[0] = new Line(0, 0, 0, 400);
        lines[1] = new Line(100, 100, 0, 100);
        lines[2] = new Line(100, 100, 100, 0);
        lines[3] = new Line(100, 400, 100, 500);
        lines[4] = new Line(400, 0, 400, 500);
        lines[5] = new Line(200, 100, 400, 500);
        lines[6] = new Line(100, 500, 100, 0);
        lines[7] = new Line(0, 500, 600, 500);
        lines[8] = new Line(0, 200, 600, 200);
        lines[9] = new Line(200, 100, 175, 50);
    }

    /**
     * The function draws each line on an array of lines.
     * @param lines An array of type Line
     * @param drawSurface A drawing surface for the lines
     */
    private static void drawLines(Line[] lines, DrawSurface drawSurface) {
        for (Line line : lines) {
            Point point1 = line.start();
            Point point2 = line.end();
            drawSurface.drawLine((int) point1.getX(), (int) point1.getY(), (int) point2.getX(), (int) point2.getY());
        }
    }

    /**
     * The function marks the center of each line with a blue circle.
     * @param lines An array of type Line
     * @param drawSurface A drawing surface for the circles
     */
    private static void markCenters(Line[] lines, DrawSurface drawSurface) {
        drawSurface.setColor(java.awt.Color.BLUE);
        for (Line line : lines) {
            Point center = line.middle();
            drawSurface.fillCircle((int) center.getX(), (int) center.getY(), 3);
        }
    }

    /**
     * The function looks for all intersections between lines and marks them with a red circle.
     * @param lines An array of type Line
     * @param drawSurface A drawing surface for the circles
     */
    private static void markIntersections(Line[] lines, DrawSurface drawSurface) {
        drawSurface.setColor(java.awt.Color.RED);
        for (int i = 0; i < lines.length; i++) {
            for (int j = i; j < lines.length; j++) {
                Point intersection = lines[i].intersectionWith(lines[j]);
                if (intersection != null) {
                    drawSurface.fillCircle((int) intersection.getX(), (int) intersection.getY(), 3);
                }
            }
        }
    }
}