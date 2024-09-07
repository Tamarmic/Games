import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * level 2.
 */
public class FinalFour implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 3;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        Velocity v1 = new Velocity(2, 4);
        Velocity v2 = new Velocity(3, 4);
        Velocity v3 = new Velocity(4, 3);
        java.util.List<Velocity> velocities = new ArrayList();
        velocities.add(v1);
        velocities.add(v2);
        velocities.add(v3);
        return velocities;
    }

    @Override
    public int paddleSpeed() {
        return 10;
    }

    @Override
    public int paddleWidth() {
        return 80;
    }

    @Override
    public String levelName() {
        return "Final Four";
    }

    @Override
    public Sprite getBackground() {
        //  Block block = new Block(new Rectangle(new Point(0,0),800,600), Color.blue.brighter());
        //return block;
        FinalFourBG bg = new FinalFourBG();
        return bg;
    }

    @Override
    public List<Block> blocks() {
        java.util.List<Block> blocks = new ArrayList();
        //first line of blocks
        addLineOfBlocks(blocks, 130, 15, Color.gray);
        addLineOfBlocks(blocks, 150, 15, Color.red);
        addLineOfBlocks(blocks, 170, 15, Color.yellow);
        addLineOfBlocks(blocks, 190, 15, Color.green);
        addLineOfBlocks(blocks, 210, 15, Color.white);
        addLineOfBlocks(blocks, 230, 15, Color.pink);
        addLineOfBlocks(blocks, 250, 15, Color.cyan);
        return blocks;
    }

    java.util.List<Block> addLineOfBlocks(java.util.List<Block> blocks, double y, int numOfBlocks, Color color) {
        for (int i = 0; i < numOfBlocks; i++) {
            Block nextInList = new Block(new Rectangle(new Point(31.8 + 49 * i, y), 50, 20), color);
            blocks.add(nextInList);
        }
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 105;
    }
}
