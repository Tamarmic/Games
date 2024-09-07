import biuoop.DrawSurface;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class Board implements GameObject {
    private List<Square> squares = new ArrayList<>();
    private Color color1;
    private Color color2;
    private int sizeOfSquare;
    private int sizeOfBoard;
    private int numOfSquars;

    public Board(int sizeOfSquare, int sizeOfBoard, Color c1, Color c2) {
        this.sizeOfBoard = sizeOfBoard ;
        this.sizeOfSquare = sizeOfSquare;
        this.numOfSquars = sizeOfBoard / sizeOfSquare;
        this.color1 = c1;
        this.color2 = c2;
        fillSquareList();
    }

    public void fillSquareList() {

        for (int i = 0; i < numOfSquars; i++) {
            for (int j = 0; j < numOfSquars; j++) {
                System.out.println(i * sizeOfSquare % sizeOfBoard +" "+j * sizeOfSquare % sizeOfBoard+" "+ sizeOfBoard);
                if ((i%2+j)%2==0) {
                    squares.add(new Square(new Point(i * sizeOfSquare % sizeOfBoard, j * sizeOfSquare % sizeOfBoard), sizeOfSquare, color1));
                }
                else if ((i%2+j)%2==1) {
                    squares.add(new Square(new Point(i * sizeOfSquare % sizeOfBoard, j * sizeOfSquare % sizeOfBoard), sizeOfSquare, color2));
                }
            }
        }
    }
    @Override
    public void drawOn(DrawSurface d) {
        drawLimits(d);
        for (int i = 0; i < squares.size(); i++) {
                squares.get(i).drawOn(d);
        }
    }

    @Override
    public void timePass() {

    }

    public void drawLimits(DrawSurface d) {
       // d.fillRectangle(0, 0, 30, sizeOfBoard);
     //   d.fillRectangle(0, 0, sizeOfBoard, 30);
        //todo 2 more limits
    }
}
