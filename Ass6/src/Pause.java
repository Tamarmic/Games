import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * pause screen.
 */
public class Pause extends KeyPressStoppableAnimation {

    private boolean stop;
    private final GameLevel gameLevel;

    /**
     * constactor.
     * @param k
     * @param gameLevel
     */
    public Pause(KeyboardSensor k, GameLevel gameLevel) {
        super(k, KeyboardSensor.SPACE_KEY, new BasicAnimation());
        this.gameLevel = gameLevel;
    }

    /**
     * doOneFrame.
     * @param d
     */
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 32);
        d.setColor(Color.white);
        d.fillRectangle(100, 100, 300, 100);
        d.setColor(Color.blue);
        d.fillRectangle(100, 115, 300, 10);
        d.fillRectangle(100, 180, 300, 10);
        d.drawLine(240, 140, 260, 140);
        d.drawLine(240, 160, 260, 160);
        d.drawLine(240, 140, 250, 170);
        d.drawLine(260, 140, 250, 170);
        d.drawLine(240, 160, 250, 130);
        d.drawLine(260, 160, 250, 130);

        super.doOneFrame(d);
        this.stop = super.shouldStop();
    }

    /**
     * should Stop.
     * @return bool
     */
    public boolean shouldStop() {
        return this.stop;
    }
}