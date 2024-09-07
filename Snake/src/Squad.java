import biuoop.DrawSurface;

import java.awt.*;

public class Squad {
    private Point place;
    private Squad prevPoint;
    private Point nextPointPlace;


    /**
     * constuctor.
     * Will have a the following Squad;
     *
     * @param place
     */
    Squad(Point place, Squad prevPoint) {
        this.place = place;
        this.prevPoint = prevPoint;
    }

    public void drawOn(DrawSurface d, int size,Color color) {
        d.setColor(Color.black);
        d.fillCircle(place.getX(), place.getY(), size);
        d.setColor(color);
        d.fillCircle(place.getX(), place.getY(), size-2);
        d.setColor(Color.black);
        d.fillCircle(place.getX(), place.getY(), size-4);
    }

    public void setPlace(int direcsion, int size,Point nextPointPlace) {
        if (prevPoint != null) {
            this.place = nextPointPlace;
        } else {
            if (direcsion == 1) {
                this.place.setX(place.getX() + size/2);
            } else if (direcsion == 2) {
                this.place.setX(place.getX() - size/2);
            } else if (direcsion == 3) {
                this.place.setY(place.getY() + size/2);
            } else if (direcsion == 4) {
                this.place.setY(place.getY() - size/2);
            }
        }
    }
    public Point getPlace(){
        return place;
    }
}
