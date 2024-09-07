/**
 * define point on exel.
 */
public class Point {
    private int x;
    private int y;

    /**
     * constructor.
     * @param x
     * @param y
     */
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * get x form different classes;
     * @return x
     */
    public int getX(){
        return this.x;
    }
    /**
     * get y form different classes;
     * @return  y
     */
    public int getY(){
        return this.y;
    }
    /**
     * set x and y form different classes;
     */
    public void setX(int x){
        this.x=x;
    }
    public void setY(int y){
        this.y=y;
    }
}
