import biuoop.DrawSurface;

import java.awt.*;

public class SimpleFruit implements GameObject{
    private Point place;
    private int size;
    private Color color;
    private Color color1=new Color(181, 101, 29);
private Game game;
    /**
     *
     */
    public SimpleFruit(Point place,int size,Color color,Game game){
        this.place=place;
        this.size=size;
        this.color=color;
        this.game = game;
    }
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(color1);
        d.fillRectangle(place.getX()-1, place.getY()-15, 2,10);
        d.setColor(color);
        d.fillCircle(place.getX(), place.getY(), size);

    }

    @Override
    public void timePass() {
        int snakeX = game.getSnake().getPlace().getX();
        int snakeY = game.getSnake().getPlace().getY();
        if (snakeX+game.getSnake().getSquareSize()/2 > this.place.getX() &&
            snakeX-game.getSnake().getSquareSize()/2 < this.place.getX()+this.size &&
            snakeY+game.getSnake().getSquareSize()/2 > this.place.getY() &&
            snakeY-game.getSnake().getSquareSize()/2 < this.place.getY()+this.size){
            game.getSnake().addSquad();
            game.removeFruit(this);
            System.out.println("simple fruit.time pass");
        }
//todo
    }
}
