import biuoop.DrawSurface;

import java.awt.Color;

/**
 * the background for Final Four.
 */
public class FinalFourBG implements Sprite {
    @Override
    public void drawOn(DrawSurface d) {
        Block block = new Block(new Rectangle(new Point(0, 0), 800, 600), Color.blue.brighter());
        block.drawOn(d);
        d.setColor(Color.white);
        for (int i = 0; i < 10; i++) {
            d.drawLine(100 + 10 * i, 400, 80 + 10 * i, 600);
        }
        d.setColor(Color.lightGray);
        d.drawCircle(110, 400, 20);
        d.fillCircle(110, 400, 20);
        d.setColor(Color.gray);
        d.drawCircle(130, 425, 20);
        d.fillCircle(130, 425, 20);
        d.setColor(Color.gray);
        d.drawCircle(160, 425, 25);
        d.fillCircle(160, 425, 25);
        d.setColor(Color.lightGray);
        d.drawCircle(180, 400, 30);
        d.fillCircle(180, 400, 30);
        d.setColor(Color.gray);
        d.drawCircle(140, 390, 20);
        d.fillCircle(140, 390, 20);

        d.setColor(Color.white);
        for (int i = 0; i < 10; i++) {
            d.drawLine(600 + 10 * i, 450, 570 + 10 * i, 600);
        }

        d.setColor(Color.lightGray);
        d.drawCircle(610, 450, 20);
        d.fillCircle(610, 450, 20);
        d.setColor(Color.gray);
        d.drawCircle(630, 475, 20);
        d.fillCircle(630, 475, 20);
        d.setColor(Color.gray);
        d.drawCircle(660, 475, 25);
        d.fillCircle(660, 475, 25);
        d.setColor(Color.lightGray);
        d.drawCircle(680, 450, 30);
        d.fillCircle(680, 450, 30);
        d.setColor(Color.gray);
        d.drawCircle(640, 440, 20);
        d.fillCircle(640, 440, 20);
    }

    @Override
    public void timePassed() {

    }
}
