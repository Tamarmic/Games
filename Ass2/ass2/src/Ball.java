//Tamar Michelson 323805861
import biuoop.DrawSurface;
//import java.awt.Point;

/**
 * Defines a sphere by a midpoint and a radius.
 */
public class Ball {
    private Point center;
    private int r;
    private java.awt.Color color;
    private int xCenter;
    private int yCenter;

    //stap to the 3.2 part
    private double dx;
    private double dy;
    private Velocity velocity;

    // constructors
    //this constructor recive point radios and color and the other one recive x,y insted of point;

    /**
     * Builder of the class.
     * @param center  Midpoint
     * @param r radius
     * @param color Color
     */
    public Ball(Point center, int r, java.awt.Color color) {
        this.center = center;
        this.r = r;
        this.color = color;
    }

    /**
     * A more detailed definition.
     * @param xCenter X of the center point
     * @param yCenter Y of the center point
     * @param r radius
     * @param color Color
     */
    public Ball(int xCenter, int yCenter, int r, java.awt.Color color) {
        this.xCenter = xCenter;
        this.yCenter = yCenter;
        Point center = new Point(xCenter, yCenter);
        this.center = center;
        this.r = r;
        this.color = color;
    }

    // accessors

    /**
     * Returns the X of the midpoint.
     * @return X
     */
    public int getX() {
     return (int) center.getX();
    }

    /**
     * Returns the Y of the midpoint.
     * @return Y
     */
    public int getY() {
        return (int) center.getY();
    }

    /**
     * Returns the radius of the ball.
     * @return radius
     */
    public int getSize() {
        return r;
    }

    /**
     * Returns the color of the ball.
     * @return Color
     */
    public java.awt.Color getColor() {
        return color;
    }

    // draw the ball on the given DrawSurface

    /**
     * Prints the circle.
     * @param surface Printing surface
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(getColor());
        surface.fillCircle(getX(), getY(), r);
    }
//add Velocity to this class for mission3.2;

    /**
     * Determines the speed and angle.
     * @param v The speed and angle.
     */
    public void setVelocity(Velocity v) {
        this.velocity = v;
    }

    /**
     * Sets the speed by movement on the axles.
     * @param dx Speed on the X-axis
     * @param dy Speed on the Y-axis
     */
    public void setVelocity(double dx, double dy) {
        Velocity set = new Velocity(dx, dy);
        this.velocity = set;
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * A function that brings the speed.
     * @return speed
     */
    public Velocity getVelocity() {
        return velocity;
    }

    /**
     * A function that returns the radius.
     * @return radius
     */
    public int getR() {
        return this.r;
    }
    private int limit1;
    private int limit2;
         void setLimit(int limit1, int limit2) {
            this.limit1 = limit1;
            this.limit2 = limit2;
        }

    /**
     * A function that moves the ball one step by speed.
     */
    public void moveOneStep() {
        // System.out.println("MoveOneStep");
       this.center = this.getVelocity().applyToPoint(this.center);

        if (this.center.getX() + this.r >= limit1 || this.center.getX() - this.r <= limit2) {
            setVelocity(-getVelocity().getDx(), getVelocity().getDy());
            // setVelocity(-dx, dy);
        }
        if (this.center.getY() + this.r >= limit1 || this.center.getY() - this.r <= limit2) {
            // this.dy = -dy;
            setVelocity(getVelocity().getDx(), -getVelocity().getDy());
           // setVelocity(dx, -dy);
        }
        if (this.center.getX() + this.r >= limit1) {
            this.center.setX(limit1 - getSize());
        }
        if (this.center.getX() - this.r <= limit2) {
            this.center.setX(limit2 + getSize());
        }
        if (this.center.getY() + this.r >= limit1) {
            this.center.setY(limit1 - getSize());
        }
        if (this.center.getY() - this.r <= limit2) {
            this.center.setY(limit2 + this.r);
        }
    }

    }
