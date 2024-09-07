import java.awt.Color;
import biuoop.DrawSurface;

/**
 * score.
 */
public class ScoreIndicator implements Sprite {
    private Counter score;
    private Rectangle rectangle = new Rectangle(new Point(0, 0), 800, 20);

    /**
     * constructor.
     * @param score
     */
    public ScoreIndicator(Counter score) {
        this.score = score;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.LIGHT_GRAY);
        d.fillRectangle((int) this.rectangle.getUpperLeft().getX(),
                (int) this.rectangle.getUpperLeft().getY(),
                (int) this.rectangle.getWidth(),
                (int) this.rectangle.getHeight());
        d.setColor(Color.BLACK);
        d.drawText((int) (this.rectangle.getUpperLeft().getX()
                        + this.rectangle.getWidth() / 2 - 30),
                (int) (this.rectangle.getUpperLeft().getY()
                        + this.rectangle.getHeight() / 2 + 3),
                "Score: "
                        + Integer.toString(this.score.getValue()), 13);

    }

    @Override
    public void timePassed() {

    }

    /**
     * add to game.
     * @param game
     */
    public void addToGame(Game game) {
        game.addSprite(this);
    }
}
