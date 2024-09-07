import biuoop.DrawSurface;

import java.awt.*;

public class Square {
    private Point upperLeft;
    private int size;
    private Color color;

    // Create a new rectangle with location and width/height.
    public Square(Point upperLeft, int size, Color color){
this.size = size;
this.upperLeft = upperLeft;
this.color = color;
    }

    // Return the width and height of the rectangle
    public int getWidth(){
        return this.size;
    }
    public int getHeight(){
        return this.size;
    }

    // Returns the upper-left point of the rectangle.
    public Point getUpperLeft(){
        return this.upperLeft;
    }


    public void drawOn(DrawSurface d ){
        d.setColor(color);
        d.fillRectangle(upperLeft.getX(),upperLeft.getY(),size,size);
        d.setColor(Color.pink);
        d.drawRectangle(upperLeft.getX(),upperLeft.getY(),size,size);
    }

}
