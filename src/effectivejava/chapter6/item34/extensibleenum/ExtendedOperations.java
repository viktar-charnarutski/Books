package effectivejava.chapter6.item34.extensibleenum;

import java.util.HashMap;
import java.util.Map;

/**
 * Emulated extensible enum using an interface implementation.
 */
public enum ExtendedOperations implements Operations {
    EXP("^") {
        @Override
        public double apply(double x, double y) {
            return Math.pow(x, y);
        }
    },
    REMINDER("%") {
        @Override
        public double apply(double x, double y) {
            return x % y;
        }
    };

    private final String symbol;

    ExtendedOperations(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }

    // implementing fromString method on an enum type
    private static final Map<String, ExtendedOperations> STRING_TO_OPERATIONS = new HashMap<>();
    static {
        STRING_TO_OPERATIONS.put("+", EXP);
        STRING_TO_OPERATIONS.put("-", REMINDER);
    }
    public ExtendedOperations fromString(String operation) {
        return STRING_TO_OPERATIONS.get(operation);
    }
}
