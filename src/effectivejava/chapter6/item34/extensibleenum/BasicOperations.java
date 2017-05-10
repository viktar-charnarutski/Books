package effectivejava.chapter6.item34.extensibleenum;

import java.util.HashMap;
import java.util.Map;

/**
 * Emulated extensible enum using an interface implementation.
 */
public enum BasicOperations implements Operations {
    PLUS("+") {
        @Override
        public double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS("-") {
        @Override
        public double apply(double x, double y) {
            return x - y;
        }
    },
    MULTIPLY("*") {
        @Override
        public double apply(double x, double y) {
            return x * y;
        }
    },
    DIVIDE("/") {
        @Override
        public double apply(double x, double y) {
            return x / y;
        }
    };

    private final String symbol;

    BasicOperations(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }

    // implementing fromString method on an enum type
    private static final Map<String, BasicOperations> STRING_TO_OPERATIONS = new HashMap<>();
    static {
        STRING_TO_OPERATIONS.put("+", PLUS);
        STRING_TO_OPERATIONS.put("-", MINUS);
        STRING_TO_OPERATIONS.put("*", MULTIPLY);
        STRING_TO_OPERATIONS.put("/", DIVIDE);
    }
    public BasicOperations fromString(String operation) {
        return STRING_TO_OPERATIONS.get(operation);
    }
}
