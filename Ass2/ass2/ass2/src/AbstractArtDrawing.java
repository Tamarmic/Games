//TamarMichelson323805861
import biuoop.GUI;
import biuoop.DrawSurface;

import java.util.Random;
import java.awt.Color;

/**
 * Draws 10 random lines and marks their midpoint in blue and their meeting point in red.
 */
public class AbstractArtDrawing {

   private Line[] arrayOfLines = new Line[10];

    /**
     * This is the function that draws everything.
     * it draws 10 random lines in black,
     * it uses a function that will draw the midpoints,
     * and a function that will draw the intersection points (using a field that is an array of lines)
      */
   public void drawEveryThing() {
        Random rand = new Random(); // create a random-number generator
        // Create a window with the title "Random Lines"
        // which is 400 pixels wide and 300 pixels high.
        GUI gui = new GUI("Random Lines", 400, 300);
        DrawSurface d = gui.getDrawSurface();
       // Line arrayoflines= new
        for (int i = 0; i < 10; ++i) {
            int x1 = rand.nextInt(400) + 1; // get integer in range 1-400
            int y1 = rand.nextInt(300) + 1; // get integer in range 1-300
            int x2 = rand.nextInt(400) + 1; // get integer in range 1-400
            int y2 = rand.nextInt(300) + 1; // get integer in range 1-300
            d.setColor(Color.BLACK);
            d.drawLine(x1, y1, x2, y2);
            drawMiddlePoint(x1, y1, x2, y2, d);
            //addLineToArray(x1,y1,x2,y2,i);
            drawIntersectPoint(x1, y1, x2, y2, d, i);
        }
        gui.show(d);
    }

    /**
     * A function that draws the midpoint of the line in blue.
     * @param x1 A point on the X-axis of the starting point
     * @param y1 A point on the Y-axis of the starting point
     * @param x2 A point on the X-axis of the end point
     * @param y2 A point on the Y-axis of the end point
     * @param d The screen on which you print
     */
    public void drawMiddlePoint(double x1, double y1, double x2, double y2, DrawSurface d) {
       Line nowLine = new Line(x1, y1, x2, y2);
      //  nowLine.middle()
      Point middle = nowLine.middle();
     int xMiddle = (int) middle.getX();
     int yMiddle = (int) middle.getY();
        d.setColor(Color.BLUE);
        d.fillCircle(xMiddle, yMiddle, 3);
    }
    Line generateRandomLine(Line a) {
        Line arrOfLines = new Line(1, 2, 3, 4);
        return a;
    }
    // Recieves a line, the board and how many previous iterations to check.
    // Goes from 0 to timeVisitHere - 1 and checks if there is a intersection with this line.
    // If there is an intersection point then it marks it as red.
    // TODO change timeVisitHere to CurrentLineNumber

    /**
     The function gets a line, a surface on which to print and the time it enters it.
     Checks all the lines already drawn if she meets with them,
     and if so she prints red in this place
     * @param x1 A point on the X-axis of the starting point
     * @param y1 A point on the Y-axis of the starting point
     * @param x2 A point on the X-axis of the end point
     * @param y2 A point on the Y-axis of the end point
     * @param d The screen on which you print
     * @param timeVisitHere
     */
    public void drawIntersectPoint(double x1, double y1, double x2, double y2, DrawSurface d, int timeVisitHere) {
        //Takes the points and makes it into a line
        Line now = new Line(x1, y1, x2, y2);
        arrayOfLines[timeVisitHere] = now;
       // Iterate over all the previous lines
        for (int i = 0; i < timeVisitHere; i++) {
          if (now.isIntersecting(arrayOfLines[i])) {
              //colorIntersectPointRed(arrayOfLines[i],arrayOfLines[timeVisitHere]);
              d.setColor(Color.RED);
              d.fillCircle((int) now.intersectionWith(arrayOfLines[i]).getX(),
                      (int) now.intersectionWith(arrayOfLines[i]).getY(), 3);
          }
        }
    }
    //void drawLine(Line l, DrawSurface d)

    /**
     * The central function, calls the other functions.
     * @param args
     */
    public static void main(String[] args) {
        AbstractArtDrawing example = new AbstractArtDrawing();
        example.drawEveryThing();
    }
}
