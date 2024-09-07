import biuoop.DrawSurface;

import java.awt.Color;

/**
 * the background for direct hit.
 */
public class DirectHitBG implements Sprite {

    @Override
    public void drawOn(DrawSurface d) {
        Block block = new Block(new Rectangle(new Point(0, 0), 800, 600), Color.BLACK);
        block.drawOn(d);
        d.setColor(Color.blue);
        d.drawCircle(400, 160, 80);
        d.drawCircle(400, 160, 60);
        d.drawCircle(400, 160, 40);
        d.drawLine(300, 160, 380, 160);
        d.drawLine(420, 160, 500, 160);
        d.drawLine(400, 190, 400, 270);
        d.drawLine(400, 140, 400, 60);
    }

    @Override
    public void timePassed() {

    }
}
