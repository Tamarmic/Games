import java.util.ArrayList;
import java.util.List;

/**
 * That of a rectangle.
 */
public class Rectangle {
 private Point upperLeft;
 private double width;
 private double height;
    private  Point downRight;
    private Point downLeft;
    private Point upright;
 //private do
        // Create a new rectangle with location and width/height.

    /**
     * Setting the rectangle by variables.
     * @param upperLeft1 Top left point
     * @param width width
     * @param height height
     */
        public Rectangle(Point upperLeft1, double width, double height) {
            this.upperLeft = upperLeft1;
            this.width = width;
            this.height = height;
             downRight = new Point(upperLeft.getX() + width, upperLeft.getY() + height);
             downLeft = new Point(upperLeft.getX(), upperLeft.getY() + height);
             upright = new Point(upperLeft.getX() + width, upperLeft.getY());
        }
        //mainly for paddle

    /**
     * Changing the position of the rectangle (for pedal).
     * @param step How much to move.
     */
        public void setPlace(double step) {
            this.upperLeft = new Point(upperLeft.getX() + step, upperLeft.getY());
            downRight = new Point(upperLeft.getX() + width, upperLeft.getY() + height);
            downLeft = new Point(upperLeft.getX(), upperLeft.getY() + height);
            upright = new Point(upperLeft.getX() + width, upperLeft.getY());
        }
        // Return a (possibly empty) List of intersection points
        // with the specified line.

    /**
     * List of all intersection points with all rectangles in the way.
     * @param line the way
     * @return the list
     */
    public java.util.List<Point> intersectionPoints(Line line) {
            List listOfPoints = new ArrayList();
            Line[] arrOfLines =  arrOfLine();

            for (int i = 0; i < 4; i++) {
                //if there is an intersection point with this line
                if (arrOfLines[i].intersectionWith(line) != null) {
               //if there is only one intersection point
                    if (listOfPoints.size() == 1) {
                      //if this is a new intersection point that I never see before-add to the list
                        if (arrOfLines[i].intersectionWith(line) != listOfPoints.get(0)
                                && arrOfLines[i].intersectionWith(line) != listOfPoints.get(0)) {
                            listOfPoints.add(arrOfLines[i].intersectionWith(line));
                        }
                    } else if (listOfPoints.size() == 0) {
                        //if the list is empty, imidietly add to the list
                        listOfPoints.add(arrOfLines[i].intersectionWith(line));

                    }
                }
            }
        //there is no more then to intersicion point in one rect?/?????
            return listOfPoints;
        }
        /**goes on the list of interacsion points and return the cloosest to the start*/
    /**
     * Search within the list of all intersection points for the point closest to the beginning of the route.
     * @param line
     * @return the point closest to the beginning
     */
    public Point closestToStart(Line line) {
            if (intersectionPoints(line).size() == 0) {
                return null;
            }
            if (intersectionPoints(line).size() == 1) {
            //    System.out.println("test rect 2");
                return intersectionPoints(line).get(0);
            }
         if (intersectionPoints(line).get(0).distance(line.start())
                 < intersectionPoints(line).get(1).distance(line.start())) {
           //  System.out.println("test rect 3");
             return intersectionPoints(line).get(0);
         }
         //   System.out.println("test rect 4");
         return intersectionPoints(line).get(1);
        }
/**geters*/
    /**
     * getWidth.
     * @return The width of the rectangle
     */
            // Return the width and height of the rectangle
            public double getWidth() {
                return this.width;
            }

    /**
     * The length of the rectangle.
     * @return The length of the rectangle.
     */
    public double getHeight() {
                return this.height;
            }
            /**lines to array*/
    /**
     * A function that returns an array of all the lines of the rectangle up and down and left and right.
     * @return Returns line arrays
     */
    public Line[] arrOfLine() {
              //  System.out.println("arrOfLines");
                Line[] arrOfLines = new Line[4];
                arrOfLines[0] = left();
                arrOfLines[1] = down();
                arrOfLines[2] = right();
                arrOfLines[3] = up();
                return arrOfLines;
    }
            // Returns the upper-left point of the rectangle.

    /**
     * Returns the top left point.
     * @return UpperLeft
     */
            public Point getUpperLeft() {
                return this.upperLeft;
            }

    /**
     * Returns the bottom left point.
     * @return downLeft
     */
    public Point getDownLeft() {
        return this.downLeft;
    }

    /**
     * Returns the right point at the bottom.
     * @return Returns the right point at the bottom
     */
            public Point getDownRight() {
        return this.downRight;
    }

    /**
     * We return the right dot to the top.
     * @return We return the right dot to the top
     */
            public Point getUpright() {
        return this.upright;
    }
            /**determine all the lines of the rictangle.*/
    /**
     * up line.
     * @return line
     */
    public Line up() {
                Line up1 = new Line(upperLeft, upright);
               // System.out.println(up1.start().getX()+" bbbb"+up1.start().getY());
                return up1;
            }

    /**
     * down line.
     * @return line
     */
    public Line down() {
                Line down1 = new Line(downLeft, downRight);
            //   System.out.println(down1.start().getX()+"bbbb "+down1.start().getY());
                return down1;
            }

    /**
     * left line.
     * @return line
     */
    public Line left() {
                Line left1 = new Line(downLeft, upperLeft);
              //  System.out.println(left1.start().getX()+"bbbbbb "+left1.start().getY());
                return left1;
            }

    /**
     * line right.
     * @return line
     */
    public Line right() {
                Line right1 = new Line(downRight, upperLeft);
              //  System.out.println(upperLeft.getX()+"upperleft" + upperLeft.getY());
              //  System.out.println(downRight.getX()+"downright"+downRight.getY());
             //   System.out.println(right1.start().getX()+"bbbb"+right1.start().getY());
                return right1;
            }
        }