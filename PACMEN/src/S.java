import biuoop.DrawSurface;

import java.awt.*;
import java.util.List;
import java.util.Random;


public class S implements Sprite{
    private Point place;;
    private Color color;
    private  Random random = new Random();
    private  int rand = random.nextInt(4)+1;
    private int x;
    private int y;
    private int toMove=0;
    private int where;
    private int speed=2;
    public S(Point place,Color color){
        this.place = place;
        this.color =color;
        this.x=place.getX();
        this.y=place.getY();
    }
    public void drawOn(DrawSurface drawSurface){
        Point point = new Point(x,y-5);
        drawSurface.setColor(color);
        drawSurface.fillCircle(point.getX(),point.getY(),10);
        drawSurface.fillRectangle(point.getX()-10, point.getY(), 20,20);
        //eyes
        drawSurface.setColor(Color.white);
        drawSurface.fillCircle(point.getX()-5, point.getY(), 3);
        drawSurface.fillCircle(point.getX()+5, point.getY(), 3);
        drawSurface.setColor(Color.black);
        drawSurface.fillCircle(point.getX()-5, point.getY(), 2);
        drawSurface.fillCircle(point.getX()+5, point.getY(), 2);
        drawSurface.drawLine(point.getX()+6, point.getY()-5,point.getX()+1, point.getY()-2);
        drawSurface.drawLine(point.getX()-6, point.getY()-5,point.getX()-1, point.getY()-2);
//waivs
        drawSurface.fillCircle(point.getX(), point.getY()+19,2);
        drawSurface.fillCircle(point.getX()+4,point.getY()+19,2);
        drawSurface.fillCircle(point.getX()+8, point.getY()+19,2);
        drawSurface.fillCircle(point.getX()-4,point.getY()+19,2);
        drawSurface.fillCircle(point.getX()-8,point.getY()+19,2);

    }

    @Override
    public void timePassed(Play play) {
        moveOneStep(play.getBlocks());
    }

    public void moveOneStep(List<Block>blocks){
        moveTHeS(blocks,rand);
        if (toMove!=0){
            move(where);
        }
        else  rand = random.nextInt(4)+1;
    }
    private void moveTHeS(java.util.List<Block> blocks,int r) {

        if (r==4) {
            toMove =4;
           where= moveLeft(blocks);
        }
        if (r==3) {
            toMove=3;
            where=moveRight(blocks);
        }
        if (r==2) {
            toMove =2;
           where= moveUp(blocks);
        }
        if (r==1) {
            toMove =1;
           where= moveDown(blocks);
        }
move(where);
        where = 0;
    }
    private int moveLeft(List<Block>blocks){
        for (int i =0;i<blocks.size();i++){
            if((x-18< blocks.get(i).getUpperLeft().getX()+blocks.get(i).getWidth()
                    && x+12 > blocks.get(i).getUpperLeft().getX()
                    && y-15<blocks.get(i).getUpperLeft().getY()+blocks.get(i).getHeight()
                    &&y+15>blocks.get(i).getUpperLeft().getY()) ){
                toMove = 0;

            }}
        if (toMove == 4) {

            return 4;
        }
        else {
            return 0;
        }}
    private int moveRight(List<Block>blocks){
        for (int i =0;i<blocks.size();i++){
            if((x+18> blocks.get(i).getUpperLeft().getX()
                    && x-12 < blocks.get(i).getUpperLeft().getX()
                    && y+15>blocks.get(i).getUpperLeft().getY()
                    &&y-15<blocks.get(i).getUpperLeft().getY()+blocks.get(i).getHeight()) ){
                toMove = 0;
            }}
        if (toMove == 3) {

            return 3;
        }else {
            return 0;
        }}
    private int moveUp(List<Block>blocks){
        for (int i =0;i<blocks.size();i++){
            if((x+15> blocks.get(i).getUpperLeft().getX()
                    && x-15 < blocks.get(i).getUpperLeft().getX()+blocks.get(i).getWidth()
                    && y-18<blocks.get(i).getUpperLeft().getY()+blocks.get(i).getHeight()
                    &&y+12>blocks.get(i).getUpperLeft().getY()) ){
                toMove = 0;

            }}
        if (toMove == 2){
            return 2;}
        else {
            return 0;
        }}
    private int moveDown(List<Block>blocks){
        for (int i =0;i<blocks.size();i++){
            if((x+15> blocks.get(i).getUpperLeft().getX()
                    && x-15 < blocks.get(i).getUpperLeft().getX()+blocks.get(i).getWidth()
                    && y-12<blocks.get(i).getUpperLeft().getY()+blocks.get(i).getHeight()
                    &&y+18>blocks.get(i).getUpperLeft().getY()) ){
                toMove = 0;

            }}
        if (toMove == 1) {
            return 1;
        }
        else {
            return 0;
        }
    }
    public void move(int where){
        if (where ==1){
            y = y + speed;
        }
        if (where ==2){
            y=y-speed;
        }
        if (where ==3){
            x = x + speed;
        }
        if (where ==4){
            x = x - speed;
        }

    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
}
