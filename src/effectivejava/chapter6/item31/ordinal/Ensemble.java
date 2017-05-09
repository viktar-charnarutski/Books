package effectivejava.chapter6.item31.ordinal;

/**
 * Use instance fields instead of ordinals.
 */
public enum Ensemble {
    SOLO(1), DUET(2), TRIO(3), QUARTET(4), QUINTET(5), SIXTET(6), SEPTET(7), OCTET(8), DOUBLE_QUARTET(8),
    NONET(9), DECTET(10), TRIPLE_QUARTET(12);

    private final int numberOfMusicians;

    Ensemble(int numberOfMusicians) {
        this.numberOfMusicians = numberOfMusicians;
    }

    public int numberOfMusicians() {
        return numberOfMusicians;
    }

    // WRONG! Never derive a value associated with an enum from its ordinal.
    public int getNumberOfMusicians() {
        return ordinal() + 1;
    }
}
