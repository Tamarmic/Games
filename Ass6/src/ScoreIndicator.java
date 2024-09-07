import biuoop.DrawSurface;

import java.awt.Color;

/**
 * score.
 */
public class ScoreIndicator implements Sprite {
    private final Counter score;
    private final Rectangle rectangle = new Rectangle(new Point(0, 0), 800, 10);
    private final String levelName;

    /**
     * ScoreIndicator.
     * @param score
     * @param levelName
     */
    public ScoreIndicator(Counter score, String levelName) {
        this.score = score;
        this.levelName = levelName;
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
                        + this.score.getValue() + "                       Level Name: " + levelName, 13);

    }

    @Override
    public void timePassed() {

    }

    /**
     * add to game.
     *
     * @param game
     */
    public void addToGame(GameLevel game) {
        game.addSprite(this);
    }
}
