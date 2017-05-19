package effectivejava.chapter10.item71.lazyinit;

/**
 * Lazy initialization holder class idiom for static fields.
 */
public class LazyInitHolder {
    private static class FieldHolder {
        static final Integer field = computeFieldValue();
    }

    static Integer getField() {
        return FieldHolder.field;
    }

    private static Integer computeFieldValue() {
        return 42;
    }
}
