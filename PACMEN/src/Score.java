import biuoop.DrawSurface;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

public class Score implements Sprite {
private int livesCounter;
private int score;
private Play play;
public Score(int livesCounter,int score,Play play) {
    this.play=play;
    this.livesCounter = livesCounter;
    this.score = score;
}
    @Override
    public void drawOn(DrawSurface d) {
            d.setColor(Color.LIGHT_GRAY);
            d.fillRectangle(0,0,660,15);
            d.setColor(Color.BLACK);
            d.drawText(280, 12,
                    "Score: "
                            + this.score + "                       Lives: " + livesCounter, 15);

        }

    @Override
    public void timePassed(Play play) {
        this.livesCounter =play.getLives();
        this.score =424- play.sizeOfPoints()*2;
    }



}
