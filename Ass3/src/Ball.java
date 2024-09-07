//Tamar Michelson 323805861
import biuoop.DrawSurface;
//import java.awt.Point;

/**
 * Defines a sphere by a midpoint and a radius.
 */
public class Ball implements Sprite {
    private Point center;
    private int r;
    private java.awt.Color color;


    //stap to the 3.2 part
    private double dx;
    private double dy;
    private Velocity velocity;
    private GameEnvironment gameEnvironment;
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
    @Override
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
     * A function that brings the gameEnvironment.
     * @return The gameEnvironment
     */
    public GameEnvironment gameEnvironment9() {
        return gameEnvironment;
}

    /**
     * set the environment.
     * @param environment
     */
    public void setGameEnvironment(GameEnvironment environment) {
        this.gameEnvironment = environment;
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

    @Override

    /**
     *Updates the position of the ball.
     */
   public void timePassed() {
        moveOneStep();
    }



    /**
     * A function that moves the ball one step by speed.
     */
    public void moveOneStep() {
        //Saving the starting point
        Point start = new Point(this.center.getX(), this.center.getY());
        //Sliding the dot one step
        this.center = this.getVelocity().applyToPoint(this.center);
        //Check if there is a collision point between the previous step and this.
        //We will define a line between the reserved point and the new one.
         Line way = new Line(start, this.center);
        /////////////////////////////////////////////////////////////////

      if (gameEnvironment.getClosestCollision(way).collisionPoint() != null) {
             //almost????
        //  System.out.println(" if(gameEnvironment.getClosestCollision(way).collisionPoint()!=null) ");
          Point collisionPoint = gameEnvironment.getClosestCollision(way).collisionPoint();
        /*  if (a.getX()!=start.getX() || a.getY()!=start.getY()){
              this.center = a;
          }*/
          //this.center =new Point((collisionPoint.getX() +center.getX())/2,(collisionPoint.getY() +center.getY())/2);

          this.center = new Point(start.getX() + 0.001, start.getY() + 0.001);
         // System.out.println(collisionPoint.getX() + " " + collisionPoint.getY() + "collisionPoint ");
         // System.out.println(center.getX() + " " + center.getY() + "center after change place");
           setVelocity(gameEnvironment.getClosestCollision(way).collisionObject().hit(collisionPoint, this.velocity));
          //  System.out.println(velocity.getDx() + "  " + velocity.getDy() + " EVERY Veloscity after change in Ball");
         }
      //$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
     if (this.center.getY() >= 570) {
          this.center.setY(567);
      }
        if (Math.abs(this.velocity.getDx()) < 1) {
            this.velocity.setDx(this.velocity.getDx() * 3);
            if ((Math.abs(this.velocity.getDy()) > 12)) {
                this.velocity.setDy(this.velocity.getDy() * 0.8);

            }
        }
        if (Math.abs(this.velocity.getDy()) < 1) {
            this.velocity.setDy(this.velocity.getDy() * 3);
            if ((Math.abs(this.velocity.getDx()) > 12)) {
                this.velocity.setDx(this.velocity.getDx() * 0.8);

            }
        }
        //If the point reaches at least one of the limits change the speed to the other side.
     /*   if (this.center.getX() + this.r >= limit1 || this.center.getX() - this.r <= limit2) {
            setVelocity(-getVelocity().getDx(), getVelocity().getDy());

        }
        if (this.center.getY() + this.r >= limit1 || this.center.getY() - this.r <= limit2) {

            setVelocity(getVelocity().getDx(), -getVelocity().getDy());

        }
       //If the current point is off the board, return it.
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
        }*/
    }

    /**
     * addToGame.
     * @param game the game
     */
    public void addToGame(Game game) {
        game.addSprite(this);
    }
}
