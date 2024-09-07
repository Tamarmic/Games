//Tamar Michelson 323805861
/**
 *   Velocity specifies the change in position on the `x` and the `y` axes.
 */
public class Velocity {
    private double dx;
    private double dy;
    /**
     *   constructor.
     * @param dx Changing the position of the X-axis
     * @param dy Changing the position of the Y-axis
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }
    // Take a point with position (x,y) and return a new point
    // with position (x+dx, y+dy)

    /**
     * Changes one point to another with a given change.
     * @param p
     * @return New Location
     */
    public Point applyToPoint(Point p) {
        Point newPoint = new Point(p.getX() + this.dx, p.getY() + this.dy);
        return newPoint;
    }

    /**
     * Returns the change in place.
     * @return Returns the change in place on the X-axis
     */
    public double getDx() {
        return this.dx;
    }

    /**
     * Returns the change in place.
     * @return Returns the change in place on the Y-axis
     */
    public double getDy() {
        return this.dy;
    }

    /**
     * setDx.
     * @param dxNew after change
     */
    public void  setDx(double dxNew) {
        this.dx = dxNew;
}

    /**
     * setDx.
     * @param dyNew after change
     */
    public void  setDy(double dyNew) {
        this.dy = dyNew;
    }
    /**
     * Measuring speed by angle and velocity.
     * @param angle The angle at which the ball will move
     * @param speed The speed at which the ball will move
     * @return Returns the Velocity
     */
    public  Velocity fromAngleAndSpeed(double angle, double speed) {
        this.dx = speed * Math.cos(angle);
        this.dy = -Math.abs(speed * Math.sin(angle));
        return new Velocity(dx, dy);
    }
}
