import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * YouWin screen.
 */
public class YouWin extends KeyPressStoppableAnimation implements Animation {
    //private KeyboardSensor keyboard;
    private boolean stop;
    // private int why;
    //  private Counter scoreC;
    private GameLevel gameLevel;
    private final GameFlow gameFlow;

    /**
     * constructor.
     * @param k
     * @param gameFlow
     */
    public YouWin(KeyboardSensor k, GameFlow gameFlow) {
        super(k, KeyboardSensor.SPACE_KEY, new BasicAnimation());
        this.gameFlow = gameFlow;
        // this.keyboard = k;
        // this.stop = false;
        //  this.scoreC = scoreC;
    }

    /**
     * do One Frame.
     * @param d
     */
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "You Win! Your score is " + gameFlow.getScore().getValue(), 32);
        d.setColor(Color.green);
        for (int i = 0; i < 10; i++) {
            d.drawLine(400 + i, 200 + i * (-1), 430 + i, 220 + i);
            d.drawLine(430 + i, 220 + i, 480 + i, 130 + i);
        }
        super.doOneFrame(d);
        this.stop = super.shouldStop();
        //  if (super.shouldStop()) { this.stop = true; }
        // if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) { this.stop = true; }
    }

    /**
     * should Stop.
     * @return bool
     */
    public boolean shouldStop() {
        return this.stop;
    }
}