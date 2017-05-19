package effectivejava.chapter10.item71.lazyinit;

/**
 * Double-check idiom for lazy initialization of instance fields.
 * Helps to avoid a cost of locking if the field has been already initialized.
 */
public class LazyDoubleCheck {
    private volatile FieldType field;

    FieldType getField() {
        // to ensure that field is read only once it's already initialized
        FieldType result = field;
        if (result == null) { // first check without locking
            synchronized (this) {
                if (field == null) { // second check with locking
                    result = field = calculateFieldValue();
                }
            }
        }
        return result;
    }

    private FieldType calculateFieldValue() {
        return new FieldType();
    }
}
