import biuoop.DrawSurface;

import java.awt.Color;

/**
 * Green3 background.
 */
public class Green3BG implements Sprite {
    @Override
    public void drawOn(DrawSurface d) {
        Block block = new Block(new Rectangle(new Point(0, 0), 800, 600), Color.green.darker());
        block.drawOn(d);
        d.setColor(Color.gray);
        d.drawRectangle(120, 340, 10, 180);
        d.fillRectangle(120, 340, 10, 180);
        d.setColor(Color.yellow);
        d.drawCircle(125, 340, 10);
        d.fillCircle(125, 340, 10);
        d.setColor(Color.orange);
        d.drawCircle(125, 340, 8);
        d.fillCircle(125, 340, 8);
        d.setColor(Color.white);
        d.drawCircle(125, 340, 5);
        d.fillCircle(125, 340, 5);
        d.setColor(Color.darkGray);
        d.drawRectangle(110, 440, 30, 180);
        d.fillRectangle(110, 440, 30, 180);
        d.setColor(Color.black);
        d.drawRectangle(90, 460, 70, 140);
        d.fillRectangle(90, 460, 70, 140);
        d.setColor(Color.white);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                d.drawRectangle(100 + i * 11, 470 + j * 20, 5, 15);
                d.fillRectangle(100 + i * 11, 470 + j * 20, 5, 15);
            }
        }
    }

    @Override
    public void timePassed() {

    }
}
