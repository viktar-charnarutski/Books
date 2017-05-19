package effectivejava.chapter10.item71.lazyinit;

/**
 * Lazy initialization holder class idiom for static fields.
 */
public class LazyInitHolder {
    private static class FieldHolder {
        static final FieldType field = computeFieldValue();
    }

    static FieldType getField() {
        return FieldHolder.field;
    }

    private static FieldType computeFieldValue() {
        return new FieldType();
    }
}
