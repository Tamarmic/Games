import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * Gmar over screen.
 */
public class GameOver extends KeyPressStoppableAnimation implements Animation {
    private boolean stop;

    private GameLevel gameLevel;
    private final GameFlow gameFlow;

    /**
     * constactor.
     * @param k
     * @param gameFlow
     */
    public GameOver(KeyboardSensor k, GameFlow gameFlow) {
        super(k, KeyboardSensor.SPACE_KEY, new BasicAnimation());
        this.gameFlow = gameFlow;
        //this.keyboard = k;
        // this.stop = false;
        // this.scoreC = scoreC;
    }

    /**
     * do one frame.
     * @param d
     */
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "Game Over. Your score is " + gameFlow.getScore().getValue(), 32);
        d.fillRectangle(385, 160, 100, 100);
        d.setColor(Color.red);
        d.fillCircle(405, 180, 10);
        d.fillCircle(465, 180, 10);
        d.fillRectangle(390, 230, 90, 10);
        super.doOneFrame(d);
        this.stop = super.shouldStop();
        // if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) { this.stop = true; }
    }

    /**
     * if the game should stop.
     * @return true
     */
    public boolean shouldStop() {
        return this.stop;
    }
}
