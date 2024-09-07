import biuoop.DrawSurface;

import java.awt.Color;

/**
 * WideEasy back graund.
 */
public class WideEasyBG implements Sprite {
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.decode("#efefa9"));
        for (int i = 30; i < 700; i = i + 8) {
            d.drawLine(120, 120, i, 220);
        }
        d.setColor(Color.decode("#efefa9"));
        d.drawCircle(120, 120, 60);
        d.fillCircle(120, 120, 60);
        d.setColor(Color.decode("#f9f900"));
        d.drawCircle(120, 120, 50);
        d.fillCircle(120, 120, 50);
        d.setColor(Color.decode("#fefe4e"));
        d.drawCircle(120, 120, 40);
        d.fillCircle(120, 120, 40);

    }

    @Override
    public void timePassed() {

    }
}
