package effectivejava.chapter2.item4.noninstantiability;

/**
 * Noninstantiable utility class
 */
public class UtilityClass {
    // Suppress default constructor for noninstantiability
    private UtilityClass() {
        // provides insurance in case the constructor is accidentally invoked with the class
        throw new AssertionError();
    }
    // Remainder omitted
}
