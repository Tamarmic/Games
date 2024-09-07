public class Line {
    private Point start;
    private Point end;
    // constructors

    /**
     * Defines what the starting point is and what the end point is.
     *
     * @param start Starting point
     * @param end   End point
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * Defines the two points by X and Y of start and end points.
     *
     * @param x1 Starting points X-axis
     * @param y1 Starting points Y-axis
     * @param x2 End points of the X-axis
     * @param y2 End points of the Y-axis
     */
    public Line(int x1, int y1, int x2, int y2) {
        this.start = new Point( x1 , y1);
        this.end = new Point(x2, y2);
    }
    // Return the length of the line


    // Returns the start point of the line

    /**
     * Returns the starting point of the line.
     *
     * @return Returns the starting point of the line
     */
    public Point getStart() {
        return this.start;
    }

    // Returns the end point of the line

    /**
     * Returns the end point of the line.
     *
     * @return Returns the end point of the line
     */
    public Point getEnd() {
        return this.end;
    }

    /**
     * Checking if this line is equal to the line they gave us.
     *
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
