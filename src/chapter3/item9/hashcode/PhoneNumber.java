package chapter3.item9.hashcode;

/**
 * Simple hashCode overriding with lazy initialization.
 *
 * Rules:
 * <ul>
 *     <li>
 *         Always override {@code hashCode} if you have {@code equals} overriden;
 *     </li>
 *     <li>
 *         Equal objects must have equal hash codes;
 *     </li>
 *     <li>
 *         Equal objects must have equal hash codes;
 *     </li>
 *     <li>
 *         Each significant field has to be part of hash code computation;
 *     </li>
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
            hashCode = new Integer(17);
            hashCode = 32 * areaCode + hashCode;
            hashCode = 32 * prefix + hashCode;
            hashCode = 32 * lineNumber + hashCode;
        }
        return hashCode;
    }
}
