import biuoop.DrawSurface;

import java.awt.*;

public class Head extends Squad {
    private int direcsion=0;

    /**
     * constuctor.
     * Will have a the following Squad;
     *
     * @param place
     * @param prevPoint
     */
    Head(Point place, Squad prevPoint) {
        super(place, prevPoint);
    }
    @Override
    public void drawOn(DrawSurface d, int size,Color color) {


        if (direcsion == 1){
            d.setColor(Color.white);
            drawTriangular(d,1,0);
        }
        if (direcsion == 2){
            d.setColor(Color.white);
            drawTriangular(d,-1,0);
        }
        if (direcsion == 3){
            d.setColor(Color.white);
            drawTriangular(d,0,1);
        }
        if (direcsion == 4){
            d.setColor(Color.white);
            drawTriangular(d,0,-1);
        }
        d.setColor(Color.black);
        d.fillCircle(super.getPlace().getX(), super.getPlace().getY(), size);
        d.setColor(color);
        d.fillCircle(super.getPlace().getX(), super.getPlace().getY(), size - 2);
        d.setColor(Color.black);
        d.fillCircle(super.getPlace().getX(), super.getPlace().getY(), size - 4);
    }

    private void drawTriangular(DrawSurface d, int a,int b) {
        for (int i = -3; i <= 3; i=i+1) {
            d.setColor(Color.red);
            d.drawLine(super.getPlace().getX(), super.getPlace().getY(), super.getPlace().getX() +20*a  +i*b , super.getPlace().getY() + 20*b  +i*a);

        }
    }
    public void setDirecsion(int direcsion) {
        this.direcsion = direcsion;
    }

}
