import biuoop.KeyboardSensor;

import java.util.ArrayList;
import java.util.List;

/**
 * run all the levels.
 */
public class GameFlow {
    private final KeyboardSensor keyboardSensor;
    private final AnimationRunner animationRunner;
    private Counter ballC;
    private Counter blocksC;
    private Counter scoreC = new Counter(0);
    private final SpriteCollection spriteCollection;
    private final GameEnvironment gameEnvironment;

    /**
     * constactor.
     * @param s
     * @param g
     * @param ar
     * @param ks
     */
    public GameFlow(SpriteCollection s, GameEnvironment g, AnimationRunner ar, KeyboardSensor ks) {
        this.animationRunner = ar;
        this.keyboardSensor = ks;
        this.spriteCollection = s;
        this.gameEnvironment = g;
    }

    /**
     * level Informations if the is no args.
     * @return list
     */
    public List<LevelInformation> levelInformations() {
        List<LevelInformation> levelInformations = new ArrayList<>();

        levelInformations.add(new DirectHit());
        levelInformations.add(new WideEasy());
        levelInformations.add(new Green3());
        levelInformations.add(new FinalFour());

        return levelInformations;
    }

    /**
     * level Informations if the is args.
     * @param numbers
     * @return list
     */
    public List<LevelInformation> levelInformations(List<Integer> numbers) {
        List<LevelInformation> levelInformations = new ArrayList<>();
        //levelInformations.add(new FinalFour());
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == 1) {
                levelInformations.add(new DirectHit());
            }
            if (numbers.get(i) == 2) {
                levelInformations.add(new WideEasy());
            }
            if (numbers.get(i) == 3) {
                levelInformations.add(new Green3());
            }
            if (numbers.get(i) == 4) {
                levelInformations.add(new FinalFour());
            }
        }

        return levelInformations;
    }

    /**
     * run the Levels.
     * @param levels
     */
    public void runLevels(List<LevelInformation> levels) {
        // ...
        for (LevelInformation levelInfo : levels) {

            GameLevel level = new GameLevel(new SpriteCollection(), new GameEnvironment(),
                    levelInfo, this.keyboardSensor, this.animationRunner, scoreC);
            level.initialize();
            blocksC = level.getBlockC();
            ballC = level.getBallC();
            while (blocksC.getValue() != 0 && ballC.getValue() != 0) {
                level.run();
                blocksC = level.getBlockC();
                ballC = level.getBallC();
            }
            this.scoreC = level.getScoreC();
            if (blocksC.getValue() == 0) {
                scoreC.increase(100);
            }
            if (ballC.getValue() == 0) {
                //  PauseScreen pauseScreen = new PauseScreen(this.keyboardSensor,scoreC);
                //  pauseScreen.why(2);
                //   this.animationRunner.run(pauseScreen);
                //      this.animationRunner.run(new PauseScreen(this.keyboardSensor,scoreC));
                this.animationRunner.run(new GameOver(this.keyboardSensor, this));
                animationRunner.getGui().close();
                break;
            }
        }
        //   PauseScreen pauseScreen = new PauseScreen(this.keyboardSensor,scoreC);
        //  pauseScreen.why(3);
        //   this.animationRunner.run(pauseScreen);
        //  this.animationRunner.run(new PauseScreen(this.keyboardSensor,scoreC));
        this.animationRunner.run(new YouWin(this.keyboardSensor, this));
        animationRunner.getGui().close();
    }

    /**
     * geter/.
     * @return score
     */
    public Counter getScore() {
        return this.scoreC;
    }
}