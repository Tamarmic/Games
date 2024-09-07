import biuoop.DrawSurface;

/**
 * somthing ro be printed.
 */
public interface Sprite {
    // draw the sprite to the screen

    /**
     * drawOn the DrawSurface.
     * @param d Surfac
     */
    void drawOn(DrawSurface d);
    // notify the sprite that time has passed

    /**
     * Informs everyone that time has passed.
     */
    void timePassed();
}
