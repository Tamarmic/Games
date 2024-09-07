//Tamar Michelson 323805861

/**
 * Defines a line by annual points, start point and end point.
 */
public class Line {
    private double x1;
    private double x2;
    private double y1;
    private double y2;
    private Point start;
    private Point end;
    // constructors

    /**
     *Defines what the starting point is and what the end point is.
     * @param start Starting point
     * @param end End point
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
        this.x1 = start.getX();
        this.x2 = end.getX();
        this.y1  = start.getY();
        this.y2 = end.getY();
    }

    /**
     * Defines the two points by X and Y of start and end points.
     * @param x1 Starting points X-axis
     * @param y1 Starting points Y-axis
     * @param x2 End points of the X-axis
     * @param y2 End points of the Y-axis
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }
    // Return the length of the line

    /**
     * Calculate the length of a line using the distance between the start point and the end point.
     * @return The length
     */
    public double length() {
        //   double a= ((this.x1-this.x2)*(this.x1-this.x2)+(this.y1-this.y2)*(this.y1-this.y2));
        //   double distance=Math.sqrt(a);
        double length1 = this.start.distance(this.end);
        return length1;

    }

    // Returns the middle point of the line

    /**
     * Calculate the midpoint of the segment by calculating the difference of two parts plus the small dot.
     * @return Returns a Point that is a midpoint
     */
    public Point middle() {
        double x = (this.x1 + this.x2) / 2;
        double y = (this.y1 + this.y2) / 2;
        Point mid = new Point(x, y);
        return mid;
    }

    // Returns the start point of the line

    /**
     * Returns the starting point of the line.
     * @return Returns the starting point of the line
     */
    public Point start() {
        Point start = new Point(this.x1, this.y1);
        return start;
    }

    // Returns the end point of the line

    /**
     * Returns the end point of the line.
     * @return Returns the end point of the line
     */
    public Point end() {
        Point end = new Point(this.x2, this.y2);
        return end;
    }

    // Returns true if the lines intersect, false otherwise

    /**
     * Checks whether two lines meet.
     * Calculates the slope of each of them and the point of intersection with the axis and compares them
     * There is a special case with the slope perpendicular to the X-axis and a special case if they have the same slope
     * @param other Checks whether two lines meet.
     * Calculates the slope of each of them and the point of intersection with the axis and compares them
     * There is a special case with the slope perpendicular to the X-axis and a special case if they have the same slope
     * @return Returns true if they meet and FALSE if not
     */
    @SuppressWarnings("checkstyle:SimplifyBooleanExpression")
    public boolean onTheYaxis(Line other) {
        /// CASE 1, the x's are the same.
        if ((x1 == x2) && (other.x1 == other.x2)) {
            if (this.start.getX() != other.start.getX()) {
                return false;
            }
            // If the lines intersect on any of the y axis.
            if ((this.start.getY() <= other.start.getY()
                    && this.start.getY() <= other.end.getY()
                    && this.end.getY() <= other.start.getY()
                    && this.end.getY() <= other.end.getY())
                    ||
                    (this.start.getY() >= other.start.getY()
                    && this.start.getY() >= other.end.getY()
                    && this.end.getY() >= other.start.getY()
                    && this.end.getY() >= other.end.getY())
            ) {
                return false;
            }
            return true;
        }

        // CASE 2 (if the line is straight up
        double m1;
        double m2; // Slope of the other line
        // If the
        if ((x1 == x2)) {
            if (other.y1 == other.y2) {
                m2 = 0;
            } else {
                m2 = ((other.y1 - other.y2) / (other.x1 - other.x2));
            }
            // b2 is the point of contact of other line with y axis
            double b2 = (-m2 * other.x1 + other.y1);

          double yInter = m2 * x1 + b2;
          if ((yInter <= y1 && yInter >= y2
            || yInter <= y2 && yInter >= y1)
            && (other.x1 <= x1 && other.x2 >= x1
             || other.x1 >= x1 && other.x2 <= x1)) {
              return true;
          }
          return false;
        }
        if ((other.x1 == other.x2)) {
            if (y1 == y2) {
                m1 = 0;
            } else {
                m1 = ((y1 - y2) / (x1 - x2));
            }
            double b1 = (-m1 * x1 + y1);
            double yInter = m1 * other.x1 + b1;
            if ((yInter <= other.y1 && yInter >= other.y2
               || yInter <= other.y2 && yInter >= other.y1)
                    && (x1 <= other.x1 && x2 >= other.x1
                    || x1 >= other.x1 && x2 <= other.x1)) {
                return true;
            }
            return false;
        }
        return false;
    }

    /**
     * Checks whether two lines meet.
     * Calculates the slope of each of them and the point of intersection with the axis and compares them
     * There is a special case with the slope perpendicular to the X-axis and a special case if they have the same slope
     * @param other Checks whether two lines meet.
     * Calculates the slope of each of them and the point of intersection with the axis and compares them
     * There is a special case with the slope perpendicular to the X-axis and a special case if they have the same slope
     * @return Returns true if they meet and FALSE if not
     */
    public boolean isIntersecting(Line other) {
        double m1;
        double m2;
        //Calculation m
        //If it is perpendicular to the X-axis
        if ((x1 == x2) || (other.x1 == other.x2)) {
           return onTheYaxis(other);
        }
        if (this.y1 == this.y2) {
            m1 = 0;
        } else {
            m1 = ((this.y1 - this.y2) / (this.x1 - this.x2));
        }
        //If it is perpendicular to the X-axis
        if (other.y1 == other.y2) {
            m2 = 0;
        } else {
            m2 = ((other.y1 - other.y2) / (other.x1 - other.x2));
        }
        //Calculate a point of intersection with the Y-axis
        double b1 = (-m1 * this.x1 + this.y1);
        double b2 = (-m2 * other.x1 + other.y1);
        /**If the lines have the same slope*/
      //If the lines are parallel
        if (m1 == m2) {
            if (equals(other)) {
                return true;
            }
            //if the m is 0 and they dont share the same x-false
            if (m1 == 0) {
               if (this.y1 != other.y1) {
                   return false;
               } else if (
                        (this.start.getY() <= other.start.getY()
                        && this.start.getY() <= other.end.getY()
                        && this.end.getY() <= other.start.getY()
                        && this.end.getY() <= other.end.getY())
                        ||
                       (this.start.getY() >= other.start.getY()
                        && this.start.getY() >= other.end.getY()
                        && this.end.getY() >= other.start.getY()
                        && this.end.getY() >= other.end.getY())
               ) {
                    return false;
                }
                return true;
            }
            //If they are intersect at exactly one point
            if (this.start == other.start
                    || this.start == other.end
                    || this.end == other.start
                    || this.end == other.end) {
                return true;
            }
            if (b1 != b2) {
                return false;
            }
                if (b1 == b2) {
                if (this.start.getY() <= other.start.getY()
                        && this.start.getY() <= other.end.getY()
                        && this.end.getY() <= other.start.getY()
                        && this.end.getY() <= other.end.getY()
                        || this.start.getY() >= other.start.getY()
                        && this.start.getY() >= other.end.getY()
                        && this.end.getY() >= other.start.getY()
                        && this.end.getY() >= other.end.getY()) {
                    return false;
                }
                return true;
            }
          /*  if (this.start.getX() <= other.start.getX()
                    && this.start.getX() <= other.end.getX()
                    && this.end.getX() <= other.start.getX()
                    && this.end.getX() <= other.end.getX()
                    || this.start.getX() >= other.start.getX()
                    && this.start.getX() >= other.end.getX()
                    && this.end.getX() >= other.start.getX()
                    && this.end.getX() >= other.end.getX()) {
                return false;
            }
            return true;*/
        }
        //If the lines are not parallel
        double xInter = (b2 - b1) / (m1 - m2);
        if (((xInter <= this.x1 && xInter >= this.x2) && (xInter <= other.x1 && xInter >= other.x2))
                || ((xInter <= this.x2 && xInter >= this.x1) && (xInter <= other.x1 && xInter >= other.x2))
                || ((xInter <= this.x1 && xInter >= this.x2) &&  (xInter <= other.x2 && xInter >= other.x1))
                || ((xInter <= this.x2 && xInter >= this.x1) && (xInter <= other.x2 && xInter >= other.x1))) {
            return true;
        }
        return false;
    }

    // Returns the intersection point if the lines intersect,
    // and null otherwise.

    /**
     *Checks if the lines meet using the previous function and if so,
     *  if there is one meeting point returns it,
     *  another returns NULL.
     * @param other Checks if the lines meet using the previous function and if so,
     *             if there is one meeting point returns it, another returns NULL.
     * @return The meeting point and if not then NULL
     */
    @SuppressWarnings("checkstyle:LineLength")
    public Point intersectionWith(Line other) {
      //  System.out.println("preLineNull2");
        //if the is no interecsion- return null;
        if (!isIntersecting(other)) {
         //   System.out.println("LineNull1");
            return null;
        }
        // If either of the lines is horizontal
        if ((x1 == x2) || (other.x1 == other.x2)) {
            if (onTheYaxis(other)) {
                if ((x1 == x2) && (other.x1 == other.x2)) {
                    if (this.start == other.start
                            || this.start == other.end) {
                        return this.start;
                    } else if (this.end == other.start
                            || this.end == other.end) {
                        return this.end;
                    } else {
                   //     System.out.println("horizontal");
                        return null;
                    }
                }

                if (x1 == x2) {
                    double m2 = ((other.y1 - other.y2) / (other.x1 - other.x2));
                    // b2 is the point of contact of other line with y axis
                    double b2 = (-m2 * other.x1 + other.y1);
                    double yInter = m2 * x1 + b2;
                    return new Point(x1, yInter);
                }
                if (other.x1 == other.x2) {
                    double m1 = ((y1 - y2) / (x1 - x2));
                    double b1 = (-m1 * x1 + y1);
                    double yInter = m1 * other.x1 + b1;
                    return new Point(other.x1, yInter);
                }
            }
        }
        double m1;
        double m2;
            m1 = ((this.y1 - this.y2) / (this.x1 - this.x2));
            m2 = ((other.y1 - other.y2) / (other.x1 - other.x2));

        double b1 = (-m1 * this.x1 + this.y1);
        double b2 = (-m2 * other.x1 + other.y1);

        /**If the lines have the same slope*/
        if (m1 == m2) {
            if (m1 == 0) {
                if (this.x1 == other.x1) {
                    return null;
                }
            }
            if (this.start == other.start
                    || this.start == other.end) {
                return this.start;
            } else if (this.end == other.start
                    || this.end == other.end) {
                return this.end;
            } else {
               System.out.println("LineNull2");
                return null;
            }
        }
        double inter = (b2 - b1) / (m1 - m2);
        Point intersecting = new Point(inter, inter * m1 + b1);
        return intersecting;
    }

    // equals -- return true is the lines are equal, false otherwise

    /**
     * Checking if this line is equal to the line they gave us.
     * @param other The line we will compare to it
     * @return Returns truth if they are equal, if not returns false
     */
    public boolean equals(Line other) {
        if (this.start.equals(other.start) && this.end.equals(other.end)) {
            return true;
        } else if (this.start.equals(other.end) && this.end.equals(other.start)) {
            return true;
        }
        return false;

    }

    // If this line does not intersect with the rectangle, return null.
    // Otherwise, return the closest intersection point to the
    // start of the line.

    /**
     * Checks whether the point is on the line.
     * @param point Collision point
     * @return true or false
     */
    public boolean pointOnLineOnlyForRectLeftEndRight(Point point) {
        if ((y1 < point.getY() && y2 > point.getY())
          || (y1 > point.getY() && y2 < point.getY())) {
            return true;
        }
        return false;
    }

    /**
     * Checks whether the point is on the line.
     * @param point Collision point
     * @return true or false
     */
    public boolean pointOnLineOnlyForRectUpAndDown(Point point) {
        if ((x1 < point.getX() && x2 > point.getX())
                || (x1 > point.getX() && x2 < point.getX())) {
            return true;
        }
        return false;
    }
}

