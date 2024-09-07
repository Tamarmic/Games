import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Snake implements GameObject {
    private List<Squad> squads = new ArrayList<>();
    private Color color;
    private int Speed;
    private int squareSize;
    private  KeyboardSensor sensor;
    private int direcsion=1;
    private Game game;
    private Head head;
Snake(Color color, int squareSize, Point place, KeyboardSensor sensor,Game game){
    this.squareSize = (int) (squareSize);
    head = new Head(new Point(place.getX()-squareSize, place.getY()),null);
    this.squads.add(head);
    this.squads.add(new Squad(new Point(place.getX()-squareSize*2, place.getY()),squads.get(0)));
    this.squads.add(new Squad(new Point(place.getX()-squareSize*3, place.getY()),squads.get(1)));
    this.color = color;
    this.sensor= sensor;
    this.game = game;

}

    @Override
    public void drawOn(DrawSurface d) {
        int color=0;
        for (Squad i : squads) {
            i.drawOn(d,squareSize/2,new Color(0, color*250/squads.size(), 204));
            color++;
        }
    }

    @Override
    public void timePass() {
        disqualification();
    int direcsion =setDirecsion();
        head.setDirecsion(direcsion);
        Point toSetTheNext = new Point(squads.get(0).getPlace().getX(),squads.get(0).getPlace().getY());
        Point toSetTheNextTemp = toSetTheNext;
        for (int i = 0; i<squads.size();i++) {
            //todo direcsion;
            toSetTheNextTemp = new Point(squads.get(i).getPlace().getX(),squads.get(i).getPlace().getY());
            squads.get(i).setPlace(direcsion,squareSize, toSetTheNext);
            toSetTheNext = toSetTheNextTemp;
        }
    }

    private void disqualification() {
      int  disqualification =0;
    for (Squad squad : squads){
        if (squad == squads.get(0)){
            int v = 1;
        }
        else if (squad.getPlace().getX()==squads.get(0).getPlace().getX()&&
                squad.getPlace().getY()==squads.get(0).getPlace().getY()){
            System.out.println("snake.disqualification");
            disqualification = 1;
        }
    }
    if (squads.get(0).getPlace().getX()>=game.getSizeOfBoard()||squads.get(0).getPlace().getY()>=game.getSizeOfBoard()||squads.get(0).getPlace().getX()<=0||squads.get(0).getPlace().getY()<=0||disqualification==1){
        game.getGui().close();
    }
    }

    public int setDirecsion() {

        if (sensor.isPressed(KeyboardSensor.LEFT_KEY)) {
            if (direcsion != 1){
            direcsion = 2;
            }
        }
        if (sensor.isPressed(KeyboardSensor.RIGHT_KEY)) {
            if (direcsion != 2) {
                direcsion = 1;
            }
        }
        if (sensor.isPressed(KeyboardSensor.UP_KEY)) {
            if (direcsion != 3){
            direcsion = 4;
        }}
        if (sensor.isPressed(KeyboardSensor.DOWN_KEY)) {
            if (direcsion != 4){
            direcsion = 3;
        }}
        return direcsion;
    }
    public Point getPlace(){
    return this.squads.get(0).getPlace();
    }
    public int getSquareSize(){
    return this.squareSize;
    }

    public void addSquad() {
        this.squads.add(new Squad(new Point(squads.get(squads.size()-1).getPlace().getX(), squads.get(squads.size()-1).getPlace().getY()),squads.get(squads.size()-1)));
    }
}
