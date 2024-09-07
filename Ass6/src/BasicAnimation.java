import biuoop.DrawSurface;

/**
 * BasicAnimation.
 */
public class BasicAnimation implements Animation {
    private final boolean stop;

    /**
     * Basic.
     */
    public BasicAnimation() {
        this.stop = false;
    }

    @Override
    public void doOneFrame(DrawSurface d) {

    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
