import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

/**
 * runs the animaition.
 */
public class AnimationRunner {
    private final GUI gui;
    private final Sleeper sleeper;
    private int framesPerSecond;

    /**
     * constuctor.
     * @param framesPerSecond
     */
    public AnimationRunner(int framesPerSecond) {
        this.gui = new GUI("Arcknoid", 800, 600);
        this.sleeper = new Sleeper();
        this.framesPerSecond = framesPerSecond;
    }

    /**
     * setFramesPerSecond.
     * @param framesPerSecond
     */
    public void setFramesPerSecond(int framesPerSecond) {
        this.framesPerSecond = framesPerSecond;
    }

    /**
     * the point of this class.
     * @param animation
     */
    public void run(Animation animation) {
        int millisecondsPerFrame = 1000 / framesPerSecond;
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();

            animation.doOneFrame(d);

            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
        //  gui.close();
    }

    /**
     * geter.
     * @return the gui.
     */
    public GUI getGui() {
        return this.gui;
    }
}