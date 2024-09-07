import biuoop.DrawSurface;

/**
 * interface Animation.
 */
public interface Animation {
    /**
     * doOneFrame.
     * @param d
     */
    void doOneFrame(DrawSurface d);

    /**
     * should Stop.
     * @return bool
     */
    boolean shouldStop();
}