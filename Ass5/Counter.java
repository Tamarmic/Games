/**
 * Counter.
 */
public class Counter {
    private int count;

    /**
     * counts.
     * @param count
     */
    public Counter(int count) {
        this.count = count;
    }
    // add number to current count.
    void increase(int number) {
        count = count + number;
    }
    // subtract number from current count.
    void decrease(int number) {
        count = count - number;
    }
    // get current count.
    int getValue() {
        return count;
    };
}