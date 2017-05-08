package effectivejava.chapter6.item30.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Enum type with constant-specific class bodies and data.
 */
public enum Operations {
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

    Operations(String symbol) {
        this.symbol = symbol;
    }

    public abstract double apply(double x, double y);

    @Override
    public String toString() {
        return symbol;
    }

    // implementing fromString method on an enum type
    private static final Map<String, Operations> STRING_TO_OPERATIONS = new HashMap<>();
    static {
        STRING_TO_OPERATIONS.put("+", PLUS);
        STRING_TO_OPERATIONS.put("-", MINUS);
        STRING_TO_OPERATIONS.put("*", MULTIPLY);
        STRING_TO_OPERATIONS.put("/", DIVIDE);
    }
    public Operations fromString(String operation) {
        return STRING_TO_OPERATIONS.get(operation);
    }
}
