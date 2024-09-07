import java.util.ArrayList;
import java.util.List;

import biuoop.DrawSurface;

/**
 * SpriteCollection.
 */
public class SpriteCollection {
    private List<Sprite> listOfSprite = new ArrayList<Sprite>();

    /**
     * addSprite.
     * @param s the new sprite
     */
    public void addSprite(Sprite s) {
        listOfSprite.add(s);
    }

    // call timePassed() on all sprites.

    /**
     * call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        for (Sprite sprite: listOfSprite) {
            sprite.timePassed();
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
