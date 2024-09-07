import java.util.ArrayList;
import java.util.List;

import biuoop.DrawSurface;

/**
 * SpriteCollection.
 */
public class SpriteCollection {
    private List<Sprite> listOfSprite = new ArrayList<Sprite>();
private Play play;
    /**
     * addSprite.
     * @param s the new sprite
     */
    public void addSprite(Sprite s) {
        listOfSprite.add(s);
    }

    /**
     * removeSprite.
     * @param s the sprite to de\\remove;
     */
    public void removeSprite(Sprite s) {
        listOfSprite.remove(s);
    }

    // call timePassed() on all sprites.

    /**
     * call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        List<Sprite> sprites1 = new ArrayList<>(this.listOfSprite);
        for (Sprite sprite: sprites1) {
            sprite.timePassed(play);
        }
    }

    // call drawOn(d) on all sprites.

    /**
     * call drawOn(d) on all sprites.
     * @param d surface
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite sprite: listOfSprite) {
            sprite.drawOn(d);
        }
    }

}
