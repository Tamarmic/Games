import biuoop.GUI;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import biuoop.Sleeper;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;

/**the main class.
 */
public class Play {
private Pacmen pacmen;
private List<Sprite> gameObject=new ArrayList<>();
private List<GamePoint>gamePoints = new ArrayList<>();
private List<Block>blocks = new ArrayList<>();
private List<S>monsters = new ArrayList<>();
private KeyboardSensor sensor;
private final Sleeper sleeper=new Sleeper();
private LevelOne levelOne = new LevelOne(620,0,620,0,this);
private biuoop.GUI gui = new GUI("Pacman", 620, 620);
private int live = 3;
private Score score = new Score(live,0,this);

    /**
     * start all the game.
     */
    public void start() {
        init();
        float i=0;
        int millisecondsPerFrame = 1000 / 170;
        while (gamePoints.size()>0&&live>0) {
                long startTime = System.currentTimeMillis(); // timing
                DrawSurface d = gui.getDrawSurface();
                d.setColor(Color.black);
                d.fillRectangle(0, 0, 800, 650);
            for (int c =0; c <gameObject.size();c++){
                gameObject.get(c).drawOn(d);
                if (i % 2 == 0)
                gameObject.get(c).timePassed(this);
            }
            i++;
            gui.show(d);
                long usedTime = System.currentTimeMillis() - startTime;
                long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
                if (milliSecondLeftToSleep > 0) {
                    this.sleeper.sleepFor(milliSecondLeftToSleep);
                }
            pacmenGotEaten();
            pacmen.setColor(Color.yellow);
        }
        gui.close();
    }

    /**
     * add the gamePoint that the pacmen eats;
     * use the level info;
     */
    public void addGamePoints(){
    gamePoints = levelOne.levelPoints(this);
    for (GamePoint i :gamePoints) {
        gameObject.add(i);
    }
    }
    /**
     * add the blocks;
     * use the level info;
     */
public void addGameBlocks(){
    blocks= levelOne.levelBlock();
    for (Block i : blocks){
        gameObject.add(i);
    }
}
    /**
     * add the game monsters;
     * use the level info;
     */
public void addGameMonsters(){
    monsters= levelOne.levelMonsters();
    for (S i : monsters){
        gameObject.add(i);
    }
    }

    /**
     * not in use yet;
     * @param d surface;
     */
    void doOneFrame(DrawSurface d) {
        pacmen.moveOneStep( blocks);
    }

    /**
     * when the pacmen eats them;
     * @param gamePoint
     */
    public void removeGamePoint(GamePoint gamePoint){
        gamePoints.remove(gamePoint);
        gameObject.remove(gamePoint);
    }

    /**
     * start the level with all the info;
     */
    public void init(){
        this.sensor = gui.getKeyboardSensor();
        this.pacmen = new Pacmen(sensor,gui);
        addGamePoints();
        addGameBlocks();
        addPacman();
        addGameMonsters();
        addScore();
    }
public void  addPacman (){
        gameObject.add(pacmen);
}
    public void  addScore (){
        gameObject.add(score);
    }
    /**
     * when the monsters meet the pacman live goes down and pacman change place.
     */
    public void pacmenGotEaten(){
    int lose =0;
    for (int i = 0; i< monsters.size();i++){
        if ( monsters.get(i).getX()<pacmen.getPlace().getX()+25
         &&  monsters.get(i).getX()>pacmen.getPlace().getX()-25
         &&  monsters.get(i).getY()<pacmen.getPlace().getY()+25
         &&  monsters.get(i).getY()>pacmen.getPlace().getY()-25 ){
            lose = 1;
        }
    }
    if (lose==1){
       live--;
       loseAnimaision();
        pacmen.setPlace(170,260);
    }
    }

    private void loseAnimaision() {
        int millisecondsPerFrame = 1000 / 1;
        long startTime = System.currentTimeMillis(); // timing
        DrawSurface d = gui.getDrawSurface();
        d.setColor(Color.black);
        d.fillRectangle(0, 0, 800, 650);
        pacmen.setColor(Color.red);
        for (int c =0; c <gameObject.size();c++){
            gameObject.get(c).drawOn(d);
        }
        gui.show(d);
       long usedTime = System.currentTimeMillis() - startTime;
        long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
        if (milliSecondLeftToSleep > 0) {
            this.sleeper.sleepFor(milliSecondLeftToSleep);
        }
    }

    /**
     *the main func
     * @param args non
     */
    public static void main(String[] args) {
        Play play = new Play();
        play.start();
    }
    public int sizeOfPoints(){
        return this.gamePoints.size();
    }
    public int getLives(){
        return this.live;
    }
    public List<Block> getBlocks(){
        return this.blocks;
    }
    public Pacmen getPacman(){
        return this.pacmen;
    }
}