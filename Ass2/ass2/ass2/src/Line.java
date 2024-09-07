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
     * Calculates the slope of each of them and the point of intersection with the axes and compares them
     * There is a special case with the slope perpendicular to the X-axis and a special case if they have the same slope
     * @param other Checks whether two lines meet.
     * Calculates the slope of each of them and the point of intersection with the axes and compares them
     * There is a special case with the slope perpendicular to the X-axis and a special case if they have the same slope
     * @return Returns true if they meet and FALSE if not
     */
        @SuppressWarnings("checkstyle:SimplifyBooleanExpression")
        public boolean isIntersecting(Line other) {
            double m1;
            double m2;
            if (this.x1 == this.x2) {
                m1 = 0;
            } else {
                m1 = ((this.y1 - this.y2) / (this.x1 - this.x2));
            }
            if (other.x1 == other.x2) {
                m2 = 0;
            } else {
                m2 = ((other.y1 - other.y2) / (other.x1 - other.x2));
            }
            double b1 = (-m1 * this.x1 + this.y1);
            double b2 = (-m2 * other.x1 + other.y1);
            /**If the lines have the same slope*/
            if (m1 == m2) {
                if (equals(other)) {
                    return true;
                }
                if (this.start == other.start
                        || this.start == other.end
                        || this.end == other.start
                        || this.end == other.end) {
                 return true;
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
                if (this.start.getX() <= other.start.getX()
                        && this.start.getX() <= other.end.getX()
                        && this.end.getX() <= other.start.getX()
                        && this.end.getX() <= other.end.getX()
                        || this.start.getX() >= other.start.getX()
                        && this.start.getX() >= other.end.getX()
                        && this.end.getX() >= other.start.getX()
                        && this.end.getX() >= other.end.getX()) {
                return false;
            }
                return true;
            }
            double inter = (b2 - b1) / (m1 - m2);
            if (((inter <= this.x1 && inter >= this.x2)
                    || (inter <= this.x2 && inter >= this.x1)) && ((inter <= other.x1 && inter >= other.x2)
                    || (inter <= other.x2 && inter >= other.x1))) {
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
         //if the is no interecsion- return null;
            if (!isIntersecting(other)) {
                return null;
            }
            double m1;
            double m2;
            if (this.x1 == this.x2) {
                m1 = 0;
            } else {
                m1 = ((this.y1 - this.y2) / (this.x1 - this.x2));
            }
            if (other.x1 == other.x2) {
                m2 = 0;
            } else {
                m2 = ((other.y1 - other.y2) / (other.x1 - other.x2));
            }
            double b1 = (-m1 * this.x1 + this.y1);
            double b2 = (-m2 * other.x1 + other.y1);
            /**If the lines have the same slope*/
            if (m1 == m2) {
                if (this.start == other.start
                        || this.start == other.end) {
                    return this.start;
                } else if (this.end == other.start
                        || this.end == other.end) {
                    return this.end;
                } else {
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

    }

