import biuoop.DrawSurface;
import biuoop.GUI;

import java.awt.*;

public class GamePoint implements Sprite {
    private Point place;
    private Play play;
    private Point placeOfPacmen;

    /**
     *
     * @param point
     * @param play
     */
    public GamePoint(Point point,Play play) {
        this.place = point;
        this.play = play;
    }

    public void drawOn(DrawSurface drawSurface){
        drawSurface.setColor(Color.white);
        drawSurface.fillCircle(place.getX(), place.getY(), 5);
    }

    @Override
    public void timePassed(Play play) {
        setPlaceOfPacmen(play.getPacman().getPlace());
        gotEat();
    }

    public void setPlaceOfPacmen(Point newPlaceOfPacmen) {
        this.placeOfPacmen = newPlaceOfPacmen;
    }

    /**
     * if the pacman on the point both in Y excel and on X excel, remove the point from the game.
     */
    public void gotEat(){
        if(((
                ((place.getX()-placeOfPacmen.getX()<=18)&&(place.getX()-placeOfPacmen.getX()>=-18))
            ||((placeOfPacmen.getX()-place.getX()<=18)&&(placeOfPacmen.getX()-place.getX()>=-18)))
            &&
                ((place.getY()-placeOfPacmen.getY()<=18)&&(place.getY()-placeOfPacmen.getY()>=-18)
                ||(placeOfPacmen.getY()-place.getY()<=18)&&(placeOfPacmen.getY()-place.getY()>=-18)))){
    play.removeGamePoint(this);
        }

    }
}
