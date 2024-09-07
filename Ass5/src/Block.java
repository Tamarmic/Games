import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

//import java.awt.Point;

/**
 * Block implements Collidable, Sprite.
 */
public class Block implements Collidable, Sprite, HitNotifier {
private Rectangle rect;
private java.awt.Color color;
private List<HitListener> hitListeners = new ArrayList<HitListener>();

    /**
     * constractor.
     * @param rec rectangle
     * @param color color
     */
    public Block(Rectangle rec, Color color) {
        this.rect = rec;
        this.color = color;
    }
    @Override
    public Rectangle getCollisionRectangle() {
        return rect;
    }

    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }

    }
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        this.notifyHit(hitter);
        //  Point up = rect1.up().
        //  ;
        //if its on the curner- change x and y;
      /*  if (((rect.getUpperLeft().equals(collisionPoint)
                ||rect.getUpright().equals(collisionPoint)))
                ||rect.getDownLeft().equals(collisionPoint)
           *//*     ||rect.getDownRight().equals(collisionPoint)){
            System.out.println(currentVelocity.getDx()+ "Velocity before change3 dx");
            System.out.println(currentVelocity.getDy()+ "Velocity before change3 dy");
            currentVelocity.setDx(-currentVelocity.getDx());
            currentVelocity.setDy(-currentVelocity.getDy());
            System.out.println(currentVelocity.getDx()+ "Velocity after change3 Dx");
            System.out.println(currentVelocity.getDy()+ "Velocity after change3 dy");
            return currentVelocity;
        }*/
        //if its left or right  change dx
        if (rect.left().pointOnLineOnlyForRectLeftEndRight(collisionPoint)
                || rect.right().pointOnLineOnlyForRectLeftEndRight(collisionPoint)) {
           // System.out.println(currentVelocity.getDx() + "Velocity before change2 dx");
            currentVelocity.setDx(currentVelocity.getDx() * (-1));
          //  System.out.println(currentVelocity.getDy() + "Velocity before change2 dx");
        } else if (rect.up().pointOnLineOnlyForRectUpAndDown(collisionPoint)
                || rect.down().pointOnLineOnlyForRectUpAndDown(collisionPoint)) {
          //  System.out.println(currentVelocity.getDy() + "Velocity before change1 dy");
            currentVelocity.setDy(currentVelocity.getDy() * (-1));
         //   System.out.println(currentVelocity.getDy() + "Velocity after change1 dy");
        }
        return currentVelocity;
    }

    /**
     * drawOn the DrawSurface.
     * @param surface surface
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(color);
        surface.fillRectangle((int) getCollisionRectangle().getUpperLeft().getX(),
                (int) getCollisionRectangle().getUpperLeft().getY(),
                (int) getCollisionRectangle().getWidth(),
                (int) getCollisionRectangle().getHeight());
        surface.setColor(Color.black);
        surface.drawRectangle((int) getCollisionRectangle().getUpperLeft().getX(),
                (int) getCollisionRectangle().getUpperLeft().getY(),
                (int) getCollisionRectangle().getWidth(),
                (int) getCollisionRectangle().getHeight());
    }

    @Override
    public void timePassed() {
       //latter
    }

    /**
     * add to the place.
     * @param game the game
     */
     public void addToGame(Game game) {
        game.addCollidable(this);
        game.addSprite(this);
    }

    /**
     * removeFromGame.
     * @param game
     */
    public void removeFromGame(Game game) {
        game.removeCollidable(this);
        game.removeSprite(this);
    }

    @Override
    public void addHitListener(HitListener hl) {
        hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        hitListeners.remove(hl);
    }
}
