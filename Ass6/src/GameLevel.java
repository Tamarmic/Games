import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import biuoop.Sleeper;
import java.awt.Color;



/**
 * all  the game.
 */
public class GameLevel implements Animation {
    private final AnimationRunner runner;
    private boolean running;
    private final SpriteCollection sprites;
    private final GameEnvironment environment;
    //   private  GUI gui;
    private Sleeper sleeper;
    private Ball ball;
    private PrintingHitListener printingHitListener;
    private BlockRemover blockRemover;
    private BallRemover ballRemover;
    private ScoreIndicator score;
    private ScoreTrackingListener scoreTrackingListener = new ScoreTrackingListener(new Counter(0));
    private Counter blockC;
    private Counter ballC = new Counter(3);
    private final Counter scoreC;
    private KeyboardSensor keyboard;
    private final LevelInformation levelInformation;
    /**
     * constructor.
     * @param s
     * @param g
     * @param levelInformation
     * @param keyboard
     * @param animationRunner
     * @param scoreC
     */
    public GameLevel(SpriteCollection s, GameEnvironment g, LevelInformation levelInformation,
                     KeyboardSensor keyboard, AnimationRunner animationRunner, Counter scoreC) {
        this.sprites = s;
        this.environment = g;
        this.levelInformation = levelInformation;
        this.keyboard = keyboard;
        this.runner = animationRunner;
        this.scoreC = scoreC;
    }

    /**
     * .
     *
     * @param args
     */
    public static void main(String[] args) {
        SpriteCollection collection = new SpriteCollection();
        GameEnvironment environment = new GameEnvironment();
        //  GameLevel game = new GameLevel(collection, environment,new DirectHit());
        //   game.initialize();
        //   game.run();
    }

    /**
     * addCollidable.
     *
     * @param c the Collidable
     */
    public void addCollidable(Collidable c) {
        environment.addCollidable(c);
    }

    // Initialize a new game: create the Blocks and Ball (and Paddle)
    // and add them to the game.

    /**
     * addSprite.
     *
     * @param s the Sprite
     */
    public void addSprite(Sprite s) {
        sprites.addSprite(s);
    }

    /**
     * initialize all the game.
     */
    public void initialize() {
        //  this.gui = new GUI("Arcknoid", 800, 600);
        //  this.sleeper = new Sleeper();
        setKeyboard();
        printingHitListener = new PrintingHitListener();
        blockC = new Counter(levelInformation.numberOfBlocksToRemove());
        ballC = new Counter(levelInformation.numberOfBalls());
        blockRemover = new BlockRemover(this, blockC);
        ballRemover = new BallRemover(this, ballC);
        score = new ScoreIndicator(scoreC, levelInformation.levelName());
        //   scoreC = runner.get
        scoreTrackingListener = new ScoreTrackingListener(scoreC);
        this.addSprite(levelInformation.getBackground());
//init peddle
        Paddle pedd = new Paddle(new Point(365, 560), levelInformation.paddleWidth(),
                15, runner.getGui(), levelInformation.paddleSpeed());
        environment.addCollidable(pedd);
        pedd.addToGame(this);
        //init ball number1
        for (int i = 0; i < levelInformation.numberOfBalls(); i++) {
            initBall(new Point(400 + i * 30, 300), levelInformation.initialBallVelocities().get(i));
        }

      /*  initBall(new Point(400, 250),-2,-2.5);
        // init ball number 2
        initBall(new Point(400, 499),-2.5,-2);
        // init ball number 3
        initBall(new Point(450, 70),-2.5,-2);*/
//up
        Point p0 = new Point(0, 0);
        Rectangle rectangle = new Rectangle(p0, 800, 30);
        Block block11 = new Block(rectangle, Color.gray);
        environment.addCollidable(block11);
        // block11.addHitListener(printingHitListener);
        block11.addToGame(this);
        // block11.addHitListener(printingHitListener);
//right
        Point p1 = new Point(770, 0);
        Rectangle rectangle1 = new Rectangle(p1, 30, 600);
        Block block1 = new Block(rectangle1, Color.gray);
        environment.addCollidable(block1);
        //  block1.addHitListener(printingHitListener);
        block1.addToGame(this);
//right
        Point p3 = new Point(0, 0);
        Rectangle rectangle3 = new Rectangle(p3, 30, 600);
        Block block3 = new Block(rectangle3, Color.gray);
        environment.addCollidable(block3);
        //   block3.addHitListener(printingHitListener);
        block3.addToGame(this);
        //down-//to do ////////////////////////////////////////////////////
        Point p2 = new Point(0, 570);
        Rectangle rectangle2 = new Rectangle(p2, 800, 30);
        Block block2 = new Block(rectangle2, Color.gray);
        environment.addCollidable(block2);
        block2.addHitListener(ballRemover);
        block2.addToGame(this);
        /////////////////////////////////////////////////////////////////////////
        score.addToGame(this);
        //add the blocks to the Games
        java.util.List<Block> blocks = levelInformation.blocks();
        //first line of blocks
       /* addLineOfBlocks(blocks, 130, 12, Color.gray);
        addLineOfBlocks(blocks, 150, 11, Color.red);
        addLineOfBlocks(blocks, 170, 10, Color.yellow);
        addLineOfBlocks(blocks, 190, 9, Color.blue);
        addLineOfBlocks(blocks, 210, 8, Color.pink);
        addLineOfBlocks(blocks, 230, 7, Color.green);
*/
        for (int j = 0; j < blocks.size(); j++) {
            Block block = blocks.get(j);
            block.addToGame(this);
            block.addHitListener(printingHitListener);
            block.addHitListener(blockRemover);
            block.addHitListener(scoreTrackingListener);
        }


        // }
    }

    /**
     * add Line Of Blocks to the game.
     *
     * @param blocks      a list
     * @param y           where
     * @param numOfBlocks number of blocks to add
     * @param color       what color
     * @return list of blocks
     */
    java.util.List<Block> addLineOfBlocks(java.util.List<Block> blocks, double y, int numOfBlocks, Color color) {
        for (int i = 0; i < numOfBlocks; i++) {
            Block nextInList = new Block(new Rectangle(new Point(725 - 45 * i, y), 45, 20), color);
            nextInList.addHitListener(printingHitListener);
            nextInList.addHitListener(blockRemover);
            nextInList.addHitListener(scoreTrackingListener);
            blocks.add(nextInList);
            blockC.increase(1);
        }
        return blocks;
    }
    // Run the game -- start the animation loop.

    /**
     * init all the Balls.
     *
     * @param center   point
     * @param velocity v
     */
    public void initBall(Point center, Velocity velocity) {

        this.ball = new Ball(center, 6, Color.white);
        this.ball.setGameEnvironment(environment);
        ball.setVelocity(velocity.getDx(), velocity.getDy());
        ball.addToGame(this);
    }

    /**
     * run the game.
     */
    public void run() {
        //...
        this.runner.setFramesPerSecond(1);
        this.running = true;
        this.runner.run(new CountdownAnimation(2, 3, sprites, runner.getGui())); // countdown before turn starts.
        this.runner.setFramesPerSecond(60);
        this.runner.run(this);
        //gui.close();
    }

    /**
     * when the level should stop.
     *
     * @return true if it should stop
     */
    public boolean shouldStop() {
        if (this.ballC.getValue() == 0) {
            return true;
        }
        return this.blockC.getValue() == 0;
    }

    /**
     * do One Frame.
     *
     * @param d the surface
     */
    public void doOneFrame(DrawSurface d) {
        // game-specific logic
        if (this.keyboard.isPressed("p") || this.keyboard.isPressed("פ") || this.keyboard.isPressed("P")) {
            // PauseScreen pauseScreen = new PauseScreen(this.keyboard,scoreC);
            // pauseScreen.why(1);
            // this.runner.run(pauseScreen);
            this.runner.run(new Pause(this.keyboard, this));

        }
        // levelInformation.getBackground().drawOn(d);
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();
    }

    /**
     * should be removed from the  GameEnvironment.
     *
     * @param c collidable;
     */
    public void removeCollidable(Collidable c) {

        environment.removeCollidable(c);
    }

    /**
     * should be removed from the SpriteCollection.
     *
     * @param s collidable;
     */
    public void removeSprite(Sprite s) {
        sprites.removeSprite(s);
    }

    /**
     * set Key board.
     */
    private void setKeyboard() {
        this.keyboard = runner.getGui().getKeyboardSensor();
    }

    /**
     * get blocks.
     *
     * @return b
     */
    public Counter getBlockC() {
        return this.blockC;
    }

    /**
     * getBallC.
     *
     * @return c
     */
    public Counter getBallC() {
        return this.ballC;
    }

    /**
     * getScoreC.
     *
     * @return score
     */
    public Counter getScoreC() {
        return this.scoreC;
    }
}
