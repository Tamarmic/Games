import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * A blog that can be moved by the keyboard.
 */
public class Paddle implements Sprite, Collidable {
    private final KeyboardSensor keyboard;
    private final int speed;
    private final Rectangle paddle;
    private biuoop.GUI gui;

    /**
     * One new Syrian by Mother Two.
     *
     * @param upperleft upperleft
     * @param width     width
     * @param height    height
     * @param gui       gui
     * @param speed
     */
    public Paddle(Point upperleft, int width, int height, biuoop.GUI gui, int speed) {
        paddle = new Rectangle(upperleft, width, height);
        this.gui = gui;
        this.keyboard = gui.getKeyboardSensor();
        this.speed = speed;

    }

    //set the keyboard-realy neccery?No!
    private void setKeyboard() {
        gui = new biuoop.GUI("title", 800, 600);
        biuoop.KeyboardSensor keyboard = gui.getKeyboardSensor();
    }

    /**
     * Move left.
     */
    public void moveLeft() {
        if (paddle.getUpperLeft().getX() >= 30) {
            paddle.setPlace(-speed);
        }
    }

    /**
     * Move right.
     */
    public void moveRight() {
        if (paddle.getUpright().getX() <= 770) {
            paddle.setPlace(speed);
        }
    }

    /**
     * Calls sliding left or sliding right.
     */
    private void moveTHePaddle() {
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            moveLeft();
            //   System.out.println("the left key is pressed");
        }
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            moveRight();
            //  System.out.println("the right key is pressed");
        }
    }
    // Sprite

    /**
     * Call move the peddle.
     */
    public void timePassed() {
        moveTHePaddle();
    }

    /**
     * drawOn DrawSurface d.
     *
     * @param d the surface.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(Color.orange);
        d.fillRectangle((int) paddle.getUpperLeft().getX(),
                (int) paddle.getUpperLeft().getY(), (int) paddle.getWidth(), (int) paddle.getHeight());
        d.setColor(new Color(177, 70, 80));
        d.drawRectangle((int) getCollisionRectangle().getUpperLeft().getX(),
                (int) getCollisionRectangle().getUpperLeft().getY(),
                (int) getCollisionRectangle().getWidth(), (int) getCollisionRectangle().getHeight());
    }

    // Collidable

    /**
     * get the Collision Rectangle.
     *
     * @return rectangle
     */
    public Rectangle getCollisionRectangle() {
        return paddle;
    }

    /**
     * If the ball hits it we will change the speed depending on the place.
     *
     * @param collisionPoint  collisionPoint
     * @param currentVelocity currentVelocity
     * @param abc
     * @return new velocity
     */
    @SuppressWarnings("checkstyle:EmptyBlock")
    public Velocity hit(Ball abc, Point collisionPoint, Velocity currentVelocity) {
        Velocity temp;
      /*  if (collisionPoint.getX() > paddle.getUpperLeft().getX()
                && collisionPoint.getX() < paddle.getUpright().getX()
                && collisionPoint.getY() > paddle.getUpperLeft().getY()
                && collisionPoint.getY() < paddle.getDownLeft().getX()) {
            return  new Velocity(currentVelocity.getDx(), -3);
        }*/
        if (Math.abs(collisionPoint.getX() - paddle.getUpperLeft().getX()) < 0.001
                || Math.abs(collisionPoint.getX() - paddle.getUpright().getX()) < 0.001) {
            return new Velocity(-currentVelocity.getDx(),
                    -currentVelocity.getDy());
        }
        // if (collisionPoint.getY() - paddle.getUpperLeft().getY() < 0.001) {
        double speed = Math.sqrt(Math.pow(currentVelocity.getDx(), 2) + Math.pow(currentVelocity.getDy(), 2));
        double placeOfPaddle = paddle.getUpperLeft().getX();
        double xOfColl = collisionPoint.getX();
        double peddlePart = paddle.getWidth() / 5;
        if (xOfColl <= peddlePart * 1 + placeOfPaddle) {
            temp = currentVelocity.fromAngleAndSpeed(300, speed);
        } else if (xOfColl <= peddlePart * 2 + placeOfPaddle) {
            temp = currentVelocity.fromAngleAndSpeed(330, speed);
        } else if (xOfColl <= peddlePart * 3 + placeOfPaddle) {
            temp = new Velocity(currentVelocity.getDx(),
                    -currentVelocity.getDy());
        } else if (xOfColl <= peddlePart * 4 + placeOfPaddle * 4) {
            temp = currentVelocity.fromAngleAndSpeed(30, speed);
        } else if (xOfColl <= peddlePart * 5 + placeOfPaddle * 5) {
            temp = currentVelocity.fromAngleAndSpeed(60, speed);
        } else {
            temp = new Velocity(2, 2);
        }
        //  } else {
        //      temp = currentVelocity;
        //  }
        if (temp.getDy() >= 0) {
            temp.setDy(-temp.getDy() - 0.5);
        }
        return temp;
    }
    // Add this paddle to the game.

    /**
     * addToGame.
     *
     * @param g the game
     */
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }

    /**
     * getter.
     * @return UpperLeft
     */
    public Point getUpperLeft() {
        return paddle.getUpperLeft();
    }
    /*
    public double getWidth() {
        return paddle.getWidth();
    }*/
}