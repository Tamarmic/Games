import biuoop.DrawSurface;
import biuoop.GUI;

import java.awt.Color;

// The CountdownAnimation will display the given gameScreen,
// for numOfSeconds seconds, and on top of them it will show
// a countdown from countFrom back to 1, where each number will
// appear on the screen for (numOfSeconds / countFrom) seconds, before
// it is replaced with the next one.

/**
 * CountdownAnimation before the level starts.
 */
public class CountdownAnimation implements Animation {
    private final double numOfSeconds;
    private final int countFrom;
    private final SpriteCollection gameScreen;
    private int countNow;
    private boolean stop = false; ////////////////////////////
    private long usedTime;
    private long startTime;

    /**
     * constactor.
     * @param numOfSeconds
     * @param countFrom
     * @param gameScreen
     * @param gui
     */
    public CountdownAnimation(double numOfSeconds, int countFrom,
                              SpriteCollection gameScreen, GUI gui) {
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.countNow = countFrom;
        this.gameScreen = gameScreen;
    }

    /**
     * do only One Frame.
     * @param d
     */
    public void doOneFrame(DrawSurface d) {
        if (countNow == 0) {
            this.stop = true;
        }
        this.gameScreen.drawAllOn(d);
        d.setColor(Color.magenta);
        if (countNow == 0) {
            d.drawText(400, 300, "GO", 50);
        } else {
            d.drawText(400, 300, Integer.toString(this.countNow), 50);
        }
        if (System.currentTimeMillis() - this.startTime
                > this.usedTime / this.countFrom) {
            this.startTime = System.currentTimeMillis();
            this.countNow = countNow - 1;
        }
        //   numOfSeconds = numOfSeconds - 1;

    }

    /**
     * if it should Stop.
     * @return true
     */
    public boolean shouldStop() {
        return this.stop;
    }
}