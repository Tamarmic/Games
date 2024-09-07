/**
 * As of 7.4.21 (Hebrew writing) it is built like a structure that very simply gets a point-of-collision point.
 * Gets a Collidable and brings them back together.
 */

public class CollisionInfo {
    private Collidable collidable;
    private Point point;

    /**
     * CollisionInfo.
     * @param collidable collidable
     * @param point point
     */
    public CollisionInfo(Collidable collidable, Point point) {
        this.collidable = collidable;
        this.point = point;
    }
    // the point at which the collision occurs.

    /**
     * the point at which the collision occurs.
     * @return this point
     */
    public Point collisionPoint() {
             return this.point;
    }

    // the collidable object involved in the collision.

    /**
     * the collidable object involved in the collision.
     * @return this collidable
     */
    public Collidable collisionObject() {
            return this.collidable;
    }
}
