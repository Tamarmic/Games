import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * level 1.
 */
public class DirectHit implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 1;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        Velocity v = new Velocity(0, -2.5);
        java.util.List<Velocity> velocities = new ArrayList();
        velocities.add(v);
        return velocities;
    }

    @Override
    public int paddleSpeed() {
        return 7;
    }

    @Override
    public int paddleWidth() {
        return 70;
    }

    @Override
    public String levelName() {
        return "Direct Hit";
    }

    @Override
    public Sprite getBackground() {
       /* Block block = new Block(new Rectangle(new Point(0,0),800,600), Color.BLACK);

        return block;*/
        DirectHitBG directHitBG = new DirectHitBG();
        return directHitBG;
    }

    @Override
    public List<Block> blocks() {
        Block block = new Block(new Rectangle(new Point(385, 150), 30, 30), Color.red);
        java.util.List<Block> blocks = new ArrayList();
        blocks.add(block);
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 1;
    }
}
