import biuoop.KeyboardSensor;

import java.util.ArrayList;
import java.util.List;

/**
 * .
 */
public class Ass6Game {
    /**
     * .
     *
     * @param args
     */
    public static void main(String[] args) {
        List levels = stringsToInts(args);
        SpriteCollection collection = new SpriteCollection();
        GameEnvironment environment = new GameEnvironment();
        AnimationRunner animationRunner = new AnimationRunner(60);
        KeyboardSensor ks = animationRunner.getGui().getKeyboardSensor();
        GameFlow gameFlow = new GameFlow(collection, environment, animationRunner, ks);
        if (levels.size() != 0) {
            gameFlow.runLevels(gameFlow.levelInformations(levels));
        } else {
            gameFlow.runLevels(gameFlow.levelInformations());
        }

        //  GameLevel game = new GameLevel(collection, environment,new WideEasy());
        //  game.initialize();
        //  game.run();
    }

    /**
     * stringsToInts and make a list only from one to four.
     * @param args
     * @return the list
     */
    public static List<Integer> stringsToInts(String[] args) {

        List<Integer> list = new ArrayList<Integer>();   //declaring array
        int length = args.length;
        for (int i = 0; i < length; i++) {
            if (args[i].equals("1") || args[i].equals("2") || args[i].equals("3") || args[i].equals("4")) {
                list.add(Integer.parseInt(args[i]));
            }
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i) + "  list");

        }
        return list;
    }
}
