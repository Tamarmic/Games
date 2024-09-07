/**
 * .
 */
public class Ass3Game {
    /**
     * .
     * @param args
     */
    public static void main(String[] args) {
        SpriteCollection collection = new SpriteCollection();
        GameEnvironment environment = new GameEnvironment();
        Game game = new Game(collection, environment);
        game.initialize();
        game.run();
    }
}
