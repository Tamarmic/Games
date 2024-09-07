public class Square {
    private Point upperLeft;
    private int width;
    private int height;
    // Create a new rectangle with location and width/height.
    public Square(Point upperLeft, int width, int height){

    }

    // Return the width and height of the rectangle
    public int getWidth(){
        return this.width;
    }
    public int getHeight(){
        return this.height;
    }

    // Returns the upper-left point of the rectangle.
    public Point getUpperLeft(){
        return this.upperLeft;
    }
}
