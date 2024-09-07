/**
 * Something that can be collided with, in the shape of a rectangle.
 */
public interface Collidable {
        // Return the "collision shape" of the object.

        /**
         * get Collision Rectangle.
          * @return rectangle
         */
        Rectangle getCollisionRectangle();

        // Notify the object that we collided with it at collisionPoint with
        // a given velocity.
        // The return is the new velocity expected after the hit (based on
        // the force the object inflicted on us).

        /**
         * change the velocity of the ball while hit.
         * @param collisionPoint collisionPoint
         * @param currentVelocity currentVelocity
         * @return new Velocity
         */
        Velocity hit(Point collisionPoint, Velocity currentVelocity);

}
