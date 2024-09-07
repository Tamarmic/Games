//Tamar Michelson 323805861

/**
 * This class defines a point according to two values that symbolize the place on the X-axis and the Y-axis.
 */
public class Point {
    private double x;
    private double y;
    // constructor

    /**
     * It is a constructor that accepts values and puts them into an object.
     * @param x Position on the X-axis
     * @param y Position on the Y-axis
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // distance -- return the distance of this point to the other point

    /**
     * Calculates the distance between 2 points.
     * @param other
     * @return Calculates the distance between 2 points
     */
    public double distance(Point other) {
        double a = ((this.x - other.x) * (this.x - other.x) + (this.y - other.y) * (this.y - other.y));
        double distance = Math.sqrt(a);
        return distance;
    }

    // equals -- return true is the points are equal, false otherwise

    /**
     * Check if another point is equal to that point.
     * @param other The other point
     * @return Whether it is the same or not
     */
    public boolean equals(Point other) {
        if ((this.x == other.x) && (this.y == other.y)) {
            return true;
        }
        return false;
    }

    // Return the x and y values of this point

    /**
     * Returns the X value of the point.
     * @return Returns the X value of the point
     */
    public double getX() {
        return this.x; }
    /** Returns the Y value of the point.
     * @return Returns the Y value of the point
     */
    public double getY() {
        return this.y; }

    /**
     * Inserts the X value to the point.
     * @param x The X value of the point
     */
    public void setX(double x) {
        this.x = x;
    }
    /**
     * Inserts the X value to the point.
     * @param y The X value of the point
     */
    public void setY(double y) {
        this.y = y;
    }
}