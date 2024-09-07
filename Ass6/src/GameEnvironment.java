import java.util.ArrayList;
import java.util.List;

/**
 * The  GameEnvironment.
 */
public class GameEnvironment {
    private List<Collidable> collidableList = new ArrayList();
    // add the given collidable to the environment.

    /**
     * add Collidable.
     * @param c list of collidable
     */
    public void addCollidable(Collidable c) {
        collidableList.add(c);
    }

    /**
     * remove the collidable.
     * @param c
     */
    public void removeCollidable(Collidable c) {
        collidableList.remove(c);
    }
    // Assume an object moving from line.start() to line.end().
    // If this object will not collide with any of the collidables
    // in this collection, return null. Else, return the information
    // about the closest collision that is going to occur.


    /**
     * here I will find the closest point to the start of the line- that will be the Closest Collision point.
     * It runs on the list of blocks and checks what is the smallest distance and then,
     * returns the block and the point of collision
     * */
    /**
     * getClosestCollision.
     * @param trajectory (way)
     * @return ClosestCollision
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        double distance = 10000;
        Point pointOfColl = null;
       // Point pointOfColl = new Point(0, 0);
        int counter = 0;
       // System.out.println("test 2222");
        for (int i = 0; i < collidableList.size(); i++) {
            if (collidableList.get(i).getCollisionRectangle().closestToStart(trajectory) != null) {
               // System.out.println("test 33333");
                if (collidableList.get(i).getCollisionRectangle()
                        .closestToStart(trajectory).distance(trajectory.start()) < distance) {
                    distance = collidableList.get(i).getCollisionRectangle()
                            .closestToStart(trajectory).distance(trajectory.start());
                    pointOfColl = collidableList.get(i).getCollisionRectangle().closestToStart(trajectory);
                    counter = i;
                }
            }
        }
        CollisionInfo collisionInfo = new CollisionInfo(collidableList.get(counter), pointOfColl);
        return collisionInfo;
    }
}
