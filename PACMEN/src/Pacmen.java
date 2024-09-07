import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import javax.imageio.ImageIO;
import java.awt.*;
import java.util.List;

public class Pacmen implements Sprite {
    private final KeyboardSensor keyboard;
    private biuoop.GUI gui;
private Point place = new Point(56,300);
private int x =  place.getX();
private   int y =  place.getY();
private int smile =0;
private int slowSmile=0;
private int toMove =1;
private Color color=Color.yellow;
    /**
     *
     * @param sensor
     */
    public Pacmen(KeyboardSensor sensor,  biuoop.GUI gui){
        this.gui = gui;
        this.keyboard = gui.getKeyboardSensor();
}
    /**
     *
     * @param d
     */
   public void drawOn(DrawSurface d){
       d.setColor(color);
       d.fillCircle(x, y, 15);
       d.setColor(Color.black);
       d.fillCircle(x+6, y - 6, 3);

       d.drawRectangle(x,y,15,openSmile());
       d.fillRectangle(x,y,15,openSmile());
    }

    /**
     * move the pacmen on the bord
     */
   public void moveOneStep(List<Block> blocks){

       moveTHePacmen(blocks);
   }

    /**
     *
     * @return Hight of the smile
     */
   public int openSmile(){
       if ((slowSmile%80) == 0){
           slowSmile++;
           return (smile++)%7;
       }
       slowSmile++;
        return (smile%7);
   }

    private void moveTHePacmen(List<Block>blocks) {

        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            moveLeft(blocks);
        }
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            moveRight(blocks);
        }
        if (keyboard.isPressed(KeyboardSensor.UP_KEY)) {
            moveUp(blocks);
        }
        if (keyboard.isPressed(KeyboardSensor.DOWN_KEY)) {
            moveDown(blocks);
        }

    }
private void moveLeft(List<Block>blocks){
    for (int i =0;i<blocks.size();i++){
        if((x-18< blocks.get(i).getUpperLeft().getX()+blocks.get(i).getWidth()
                && x+12 > blocks.get(i).getUpperLeft().getX()
        && y-15<blocks.get(i).getUpperLeft().getY()+blocks.get(i).getHeight()
        &&y+15>blocks.get(i).getUpperLeft().getY()) ){
            toMove = 0;

}}
   if (toMove == 1) {
       x = x - 2;
   }
   else {
       toMove = 1;

   }}
    private void moveRight(List<Block>blocks){
        for (int i =0;i<blocks.size();i++){
        if((x+18> blocks.get(i).getUpperLeft().getX()
                && x-12 < blocks.get(i).getUpperLeft().getX()
                && y+15>blocks.get(i).getUpperLeft().getY()
                &&y-15<blocks.get(i).getUpperLeft().getY()+blocks.get(i).getHeight()) ){
            toMove = 0;
        }}
        if (toMove == 1) {
            x = x + 2;
        }else {
            toMove = 1;
        }}
    private void moveUp(List<Block>blocks){
        for (int i =0;i<blocks.size();i++){
            if((x+15> blocks.get(i).getUpperLeft().getX()
                    && x-15 < blocks.get(i).getUpperLeft().getX()+blocks.get(i).getWidth()
                    && y-18<blocks.get(i).getUpperLeft().getY()+blocks.get(i).getHeight()
                    &&y+12>blocks.get(i).getUpperLeft().getY()) ){
                toMove = 0;

            }}
        if (toMove == 1){
            y=y-2;}
        else {
            toMove = 1;
        }}
    private void moveDown(List<Block>blocks){
                for (int i =0;i<blocks.size();i++){
                    if((x+15> blocks.get(i).getUpperLeft().getX()
                            && x-15 < blocks.get(i).getUpperLeft().getX()+blocks.get(i).getWidth()
                            && y-12<blocks.get(i).getUpperLeft().getY()+blocks.get(i).getHeight()
                            &&y+18>blocks.get(i).getUpperLeft().getY()) ){
                        toMove = 0;

                    }}
        if (toMove == 1) {
            y = y + 2;
        }
        else {
            toMove = 1;
        }
    }
    public Point getPlace(){
       return new Point(x,y);
    }

    public void setPlace(int x, int y){
       this.x=x;
        this.y=y;
    }


    public void setColor(Color color) {
        this.color=color;
    }

    @Override
    public void timePassed(Play play) {
moveOneStep(play.getBlocks());
    }
}
