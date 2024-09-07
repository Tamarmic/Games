import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * level 2.
 */
public class WideEasy implements LevelInformation {

    @Override
    public int numberOfBalls() {
        return 10;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        Velocity va = new Velocity(-2.5, -3);
        Velocity vb = new Velocity(-2.5, -3.2);
        Velocity vc = new Velocity(-2.5, -3.4);
        Velocity vd = new Velocity(-2, -3.6);
        Velocity ve = new Velocity(-2, -3.8);
        Velocity vf = new Velocity(2, -3.8);
        Velocity vg = new Velocity(2, -3.6);
        Velocity vh = new Velocity(2, -3.4);
        Velocity vi = new Velocity(2, -3.2);
        Velocity vj = new Velocity(2, -3);

        java.util.List<Velocity> velocities = new ArrayList();
        velocities.add(va);
        velocities.add(vb);
        velocities.add(vc);
        velocities.add(vd);
        velocities.add(ve);
        velocities.add(vf);
        velocities.add(vg);
        velocities.add(vh);
        velocities.add(vi);
        velocities.add(vj);

        return velocities;
    }

    @Override
    public int paddleSpeed() {
        return 7;
    }

    @Override
    public int paddleWidth() {
        return 400;
    }

    @Override
    public String levelName() {
        return "Wide Easy";
    }

    @Override
    public Sprite getBackground() {
        // Ball ball = new Ball(new Point(100,100),25,Color.yellow);
      /*  Block block = new Block(new Rectangle(new Point(0,0),0,00), Color.white);
        return block;*/
        WideEasyBG wideEasyBG = new WideEasyBG();
        return wideEasyBG;
    }

    @Override
    public List<Block> blocks() {
        // Block block = new Block(new Rectangle(new Point(390,100),60,60), Color.red);
        java.util.List<Block> blocks = new ArrayList();
        // blocks.add(block);
        initBlock(blocks, 220, Color.cyan, 1);
        initBlock(blocks, 220, Color.cyan, 2);
        initBlock(blocks, 220, Color.pink, 3);
        initBlock(blocks, 220, Color.pink, 4);
        initBlock(blocks, 220, Color.blue, 5);
        initBlock(blocks, 220, Color.blue, 6);
        initBlock(blocks, 220, Color.green, 7);
        initBlock(blocks, 220, Color.green, 8);
        initBlock(blocks, 220, Color.green, 9);
        initBlock(blocks, 220, Color.yellow, 10);
        initBlock(blocks, 220, Color.yellow, 11);
        initBlock(blocks, 220, Color.orange, 12);
        initBlock(blocks, 220, Color.orange, 13);
        initBlock(blocks, 220, Color.red, 14);
        initBlock(blocks, 220, Color.red, 15);
        return blocks;

    }

    /**
     * initBlock.
     * @param blocks
     * @param y
     * @param color
     * @param number
     */
    public void initBlock(java.util.List<Block> blocks, double y, Color color, int number) {

        Block next = new Block(new Rectangle(new Point(770 - 49.43 * number, y), 49, 20), color);
        blocks.add(next);
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
        return 15;
    }
}
