import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * Pause Screen.
 */
public class PauseScreen implements Animation {
    private final KeyboardSensor keyboard;
    private boolean stop;
    private int why;
    private final Counter scoreC;

    /**
     * constructor.
     * @param k
     * @param scoreC
     */
    public PauseScreen(KeyboardSensor k, Counter scoreC) {
        this.keyboard = k;
        this.stop = false;
        this.scoreC = scoreC;
    }

    /**
     * reason.
     * @param why
     */
    public void why(int why) {
        this.why = why;
    }

    /**
     * do One Frame.
     * @param d
     */
    public void doOneFrame(DrawSurface d) {
        switch (why) {
            case 1:
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

                break;
            case 2:
                d.drawText(10, d.getHeight() / 2, "Game Over. Your score is " + scoreC.getValue(), 32);
                d.fillRectangle(385, 160, 100, 100);
                d.setColor(Color.red);
                d.fillCircle(405, 180, 10);
                d.fillCircle(465, 180, 10);
                d.fillRectangle(390, 230, 90, 10);
                break;
            case 3:
                d.drawText(10, d.getHeight() / 2, "You Win! Your score is " + scoreC.getValue(), 32);
                d.setColor(Color.green);
                for (int i = 0; i < 10; i++) {
                    d.drawLine(400 + i, 200 + i * (-1), 430 + i, 220 + i);
                    d.drawLine(430 + i, 220 + i, 480 + i, 130 + i);
                }
                break;
            default:
                break;
        }
        if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
            this.stop = true;
        }
    }

    /**
     * shouldStop.
     * @return bool
     */
    public boolean shouldStop() {
        return this.stop;
    }
}