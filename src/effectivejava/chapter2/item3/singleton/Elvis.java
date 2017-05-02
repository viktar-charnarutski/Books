package effectivejava.chapter2.item3.singleton;

/**
 * Single-element enum type is the best way to implement a singleton.
 * <p>
 * Pros:
 * <ul>
 * <li>serialization machinery</li>
 * <li>ironclad guarantee against multiple instantiations (reflection attack)</li>
 * </ul>
 * </p>
 */
public enum Elvis {

    INSTANCE;

    public void leaveTheBuilding() {

    }
}
