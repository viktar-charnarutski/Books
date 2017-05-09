package effectivejava.chapter6.item32.enummap;

/**
 * Use EnumMap instead of ordinal indexing.
 */
public class Herb {
    enum Type {ANNUAL, PERENNIAL, BIENNINAL}

    private final String name;
    private final Type type;

    Herb(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    public Type type() {
        return type;
    }

    @Override
    public String toString() {
        return name;
    }
}
