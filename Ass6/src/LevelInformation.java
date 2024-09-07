import java.util.List;

/**
 * Information on each level.
 */
public interface LevelInformation {
    /**
     * numberOfBalls.
     * @return number
     */
    int numberOfBalls();
    // The initial velocity of each ball
    // Note that initialBallVelocities().size() == numberOfBalls()

    /**
     * initial Ball Velocities.
     * @return balls
     */
    List<Velocity> initialBallVelocities();

    /**
     * the speed of the paddle.
     * @return Speed
     */
    int paddleSpeed();

    /**
     * the width of the paddle.
     * @return  width
     */
    int paddleWidth();

    /**
     *  the level name will be displayed at the top of the screen.
     * @return name
     */
    // the level name will be displayed at the top of the screen.
    String levelName();
    // Returns a sprite with the background of the level

    /**
     * Returns a sprite with the background of the level.
     * @return a sprite with the background of the level
     */
    Sprite getBackground();
    // The Blocks that make up this level, each block contains
    // its size, color and location.

    /**
     * The Blocks that make up this level, each block contains.
     *  its size, color and location.
     * @return list of blocks.
     */
    List<Block> blocks();
    // Number of blocks that should be removed
    // before the level is considered to be "cleared".
    // This number should be <= blocks.size();

    /**
     *  number Of Blocks.
     * @return number
     */
    int numberOfBlocksToRemove();
}