import biuoop.GUI;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import biuoop.Sleeper;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.util.Random;


public class Game {
    private List<GameObject> gameObjects = new ArrayList<>();
    private List<GameObject> gameObjects2 = new ArrayList<>();
    private KeyboardSensor sensor;
    private final Sleeper sleeper = new Sleeper();
    private biuoop.GUI gui = new GUI("Snake", 400, 400);
    private Snake snake;
    private int sizeOfSquare = 20;
    private int sizeOfBoard = 400;
    Random random = new Random();

    public void init() {
        this.sensor = gui.getKeyboardSensor();
        addBoard();
        addSnake();
        addFruit();

    }



    public void start() {
        int i = 0;
        while (i<10000) {
            long startTime = System.currentTimeMillis();
            DrawSurface d = gui.getDrawSurface();
            gameObjects2 = new ArrayList<>(gameObjects);
            for (GameObject gameObject : gameObjects) {
                gameObject.drawOn(d);
                if (i%1==0) {
                    gameObject.timePass();
                }
            }
            int add = 0;
            if (gameObjects.size()!=gameObjects2.size()){
                System.out.println("game.start");
                add = 1;
            }
            gameObjects = gameObjects2;
             if(add==1){
               addFruit();
              }
            gui.show(d);
            i++;
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = 60 - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
        gui.close();
    }


    public void addBoard() {
        gameObjects.add(new Board(sizeOfSquare, sizeOfBoard, Color.LIGHT_GRAY, Color.PINK));
    }
    public void addSnake(){
        snake = new Snake( Color.cyan, sizeOfSquare,new Point(110,110),sensor,this);
        gameObjects.add(snake);
    }
    public void addFruit() {
        int i = random.nextInt(sizeOfBoard/sizeOfSquare) + 1;
        int j = random.nextInt(sizeOfBoard/sizeOfSquare) + 1;
        gameObjects.add(gameObjects.size(),new SimpleFruit(new Point(i * sizeOfSquare % sizeOfBoard+sizeOfSquare/2, j * sizeOfSquare % sizeOfBoard+sizeOfSquare/2),sizeOfSquare/2-2, Color.green,this));
        //gameObjects.add(gameObjects.size(),new SimpleFruit(new Point(135, 335), 10, Color.green,this));
        // gameObjects.add(new SimpleFruit(new Point(205, 205), 10, Color.orange,this));
    }
    public GUI getGui(){
        return gui;
    }
    public Snake getSnake(){
        return this.snake;
    }
    /**
     * main
     *
     * @param args
     */
    public static void main(String[] args) {
        Game game = new Game();
        game.init();
        game.start();
    }

    public void removeFruit(SimpleFruit simpleFruit) {
        gameObjects2.remove(simpleFruit);
    }

    public int getSizeOfBoard() {
        return sizeOfBoard;
    }
}
