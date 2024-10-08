//Tamar Michelson 323805861

/**
 * The HitNotifier interface indicate that objects that implement it send notifications when they are being hit.
 */
 public interface HitNotifier {

    /**
     * Add hl as a listener to hit events.
     * @param hl
     */
    void addHitListener(HitListener hl);

    /**
     * Remove hl from the list of listeners to hit events.
     * @param hl
     */
    void removeHitListener(HitListener hl);
}