import biuoop.DrawSurface;

import java.awt.*;

/**
 * blocks the bord.
 */
public class Block implements Sprite{
    private Point upperLeft;
    private int height;
    private int width;
    private Color color;

    /**
     * will be define by
     * @param upperLeft upper Left Point
     * @param height int height
     * @param width int width
     * @param color color
     */
    public Block(Point upperLeft, int height , int width,Color color){
        this.upperLeft= upperLeft;
        this.height = height;
        this.width=width;
        this.color = color;
    }

    /**
     * will draw a rectangle in the right size.
     * @param drawSurface the bord surface
     */
    public void drawOn(DrawSurface drawSurface){
drawSurface.setColor(color);
      drawSurface.fillRectangle(upperLeft.getX(),upperLeft.getY(),width,height );
    }

    @Override
    public void timePassed(Play play) {

    }

    /**
     *returns the height.
     * @return int
     */
    public int getHeight() {
        return height;
    }

    /**
     *returns the width.
     * @return int
     */
    public int getWidth() {
        return width;
    }

    /**
     * returns the upperleft point of this block.
     * @return point
     */
    public Point getUpperLeft() {
        return upperLeft;
    }
}
