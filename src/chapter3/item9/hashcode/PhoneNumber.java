package chapter3.item9.hashcode;

/**
 * Simple hashCode overriding with lazy initialization.
 * <p>
 * Rules for hashCode overriding:
 * <ul>
 * <li>Always override {@code hashCode} if you have {@code equals} overridden;</li>
 * <li>Equal objects must have equal hash codes;</li>
 * <li>Equal objects must have equal hash codes;</li>
 * <li>Each significant field has to be part of hash code computation;</li>
 * </ul>
 * <p>
 * Rules for toString overriding:
 * <ul>
 * <li>Always override {@code toString};</li>
 * <li>{@code toString} should return all of the interesting information contained in the object to provide
 * an ability to reconstruct the object from the output;</li>
 * <li>It should be properly documented.</li>
 * </ul>
 */
public final class PhoneNumber {
    private final short areaCode;
    private final short prefix;
    private final short lineNumber;

    // lazy initialized, cached hash code
    private volatile Integer hashCode;

    public PhoneNumber(int areaCode, int prefix, int lineNumber) {
        rangeCheck(areaCode, 999, "area code");
        rangeCheck(prefix, 999, "prefix");
        rangeCheck(lineNumber, 9999, "line number");
        this.areaCode = (short) areaCode;
        this.prefix = (short) prefix;
        this.lineNumber = (short) lineNumber;
    }

    private static void rangeCheck(int num, int max, String type) {
        if (num < 0 || num > max) {
            throw new IllegalArgumentException("Illegal value provided for " + type);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof PhoneNumber)) return false;

        PhoneNumber pn = (PhoneNumber) obj;
        return pn.areaCode == this.areaCode
                && pn.prefix == this.prefix
                && pn.lineNumber == this.lineNumber;
    }

    @Override
    public int hashCode() {
        if (hashCode == null) {
            hashCode = 17;
            hashCode = 32 * areaCode + hashCode;
            hashCode = 32 * prefix + hashCode;
            hashCode = 32 * lineNumber + hashCode;
        }
        return hashCode;
    }

    /**
     * Returns the string representation of this phone number.
     * The string consists of fourteen characters whose format is "(XXX) YYY-ZZZZ",
     * where XXX is the area code, YYY is the prefix, and ZZZZ is the line number.
     * (Each of the capital letters represents a single decimal digit.)
     * <p>
     * If any of the tree parts of this phone number is too small to fill up it's fields,
     * the field is padded with leading zeros. For example, if the value of the line number
     * is 123, the last four characters of the string representation will be "0123".
     * <p>
     * Note that there is a single space separating the closing parenthesis after the area
     * code after the area code from the first digit of the prefix.
     */
    @Override
    public String toString() {
        return String.format("(%03d) %03d-%04d", areaCode, prefix, lineNumber);
    }

    @Override
    protected PhoneNumber clone() {
        try {
            return (PhoneNumber) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); // can't happen
        }
    }
}
