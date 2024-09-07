import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * level 3.
 */
public class Green3 implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 2;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        Velocity v1 = new Velocity(2.5, -4);
        Velocity v2 = new Velocity(3, -4);
        java.util.List<Velocity> velocities = new ArrayList();
        velocities.add(v1);
        velocities.add(v2);
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
        return "Green 3";
    }

    @Override
    public Sprite getBackground() {
        //Block block = new Block(new Rectangle(new Point(0,0),800,600), Color.green.darker());
        //return block;
        Green3BG green3BG = new Green3BG();
        return green3BG;
    }

    @Override
    public List<Block> blocks() {
        java.util.List<Block> blocks = new ArrayList();
        //first line of blocks
        addLineOfBlocks(blocks, 130, 10, Color.gray);
        addLineOfBlocks(blocks, 150, 9, Color.red);
        addLineOfBlocks(blocks, 170, 8, Color.yellow);
        addLineOfBlocks(blocks, 190, 7, Color.blue);
        addLineOfBlocks(blocks, 210, 6, Color.white);
        return blocks;
    }

    java.util.List<Block> addLineOfBlocks(java.util.List<Block> blocks, double y, int numOfBlocks, Color color) {
        for (int i = 0; i < numOfBlocks; i++) {
            Block nextInList = new Block(new Rectangle(new Point(725 - 45 * i, y), 45, 20), color);
            blocks.add(nextInList);
        }
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 40;
    }
}