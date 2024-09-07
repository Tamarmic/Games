import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

import java.awt.Color;
import java.util.ArrayList;

/**
 * all  the game.
 */
public class Game {
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private  GUI gui;
  private   Sleeper sleeper;
 private Ball ball;
  /**constructor*/
    /**
     * constructor.
     * @param s SpriteCollection
     * @param g GameEnvironment
     */
 public Game(SpriteCollection s, GameEnvironment g) {
     this.sprites = s;
     this.environment = g;
 }

    /**
     * addCollidable.
     * @param c the Collidable
     */
    public void addCollidable(Collidable c) {
     environment.addCollidable(c);
    }

    /**
     * addSprite.
     * @param s the Sprite
     */
    public void addSprite(Sprite s) {
        sprites.addSprite(s);
    }

    // Initialize a new game: create the Blocks and Ball (and Paddle)
    // and add them to the game.

    /**
     * initialize all the game.
     */
    public void initialize() {
        this.gui = new GUI("title", 800, 600);
        this.sleeper = new Sleeper();
//init peddle
        Paddle pedd = new Paddle(new Point(250, 555), 60, 15, gui);
        environment.addCollidable(pedd);
        pedd.addToGame(this);
        //init ball number1
        Point center1 = new Point(400, 250);
        this.ball = new Ball(center1, 10, Color.red);
        this.ball.setGameEnvironment(environment);
        ball.setVelocity(-3, -4.5);
        ball.addToGame(this);
        // init ball number 2
        Point center2 = new Point(400, 499);
        this.ball = new Ball(center2, 10, Color.red);
        this.ball.setGameEnvironment(environment);
        ball.setVelocity(-2.5, -4);
        ball.addToGame(this);
//up
        Point p0 = new Point(0, 0);
        Rectangle rectangle = new Rectangle(p0, 800, 30);
        Block block11 = new Block(rectangle, Color.gray);
        environment.addCollidable(block11);
        block11.addToGame(this);
//right
        Point p1 = new Point(770, 0);
        Rectangle rectangle1 = new Rectangle(p1, 30, 600);
        Block block1 = new Block(rectangle1, Color.gray);
        environment.addCollidable(block1);
        block1.addToGame(this);
//left
        Point p2 = new Point(0, 570);
        Rectangle rectangle2 = new Rectangle(p2, 800, 30);
        Block block2 = new Block(rectangle2, Color.gray);
        environment.addCollidable(block2);
        block2.addToGame(this);
//right
        Point p3 = new Point(0, 0);
        Rectangle rectangle3 = new Rectangle(p3, 30, 600);
        Block block3 = new Block(rectangle3, Color.gray);
        environment.addCollidable(block3);
        block3.addToGame(this);
        //add the blocks to the Games
        java.util.List<Block> blocks = new ArrayList();
        //first line of blocks
        addLineOfBlocks(blocks, 130, 12, Color.gray);
        addLineOfBlocks(blocks, 150, 11, Color.red);
        addLineOfBlocks(blocks, 170, 10, Color.yellow);
        addLineOfBlocks(blocks, 190, 9, Color.blue);
        addLineOfBlocks(blocks, 210, 8, Color.pink);
        addLineOfBlocks(blocks, 230, 7, Color.green);

        for (int j = 0; j < blocks.size(); j++) {
            Block block = blocks.get(j);
            block.addToGame(this);
        }


        // }
    }
    java.util.List<Block> addLineOfBlocks(java.util.List<Block> blocks, double y, int numOfBlocks, Color color) {
        for (int i = 0; i < numOfBlocks; i++) {
            Block nextInList = new Block(new Rectangle(new Point(725 - 45 * i, y), 45, 20), color);
            blocks.add(nextInList);
        } return blocks;
    }

    // Run the game -- start the animation loop.

    /**
     * run the game.
     */
    public void run() {
        //...
        int framesPerSecond = 60;
        int millisecondsPerFrame = 1000 / framesPerSecond;
        while (true) {
            long startTime = System.currentTimeMillis(); // timing
            //  ball.setLimit(1000,0);
            DrawSurface d = gui.getDrawSurface();
            this.sprites.drawAllOn(d);
            gui.show(d);
            this.sprites.notifyAllTimePassed();

            // timing
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
    /**
     * .
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Anopther Block was hit.");
        SpriteCollection collection = new SpriteCollection();
        GameEnvironment environment = new GameEnvironment();
        Game game = new Game(collection, environment);
        game.initialize();
        game.run();
    }
}
