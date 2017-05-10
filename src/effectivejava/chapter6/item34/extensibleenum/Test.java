package effectivejava.chapter6.item34.extensibleenum;

import java.util.Arrays;
import java.util.Collection;

/**
 * Testing extensible enums.
 */
public class Test {
    public static void main(String[] args) {
        double x = 15;
        double y = 5;
        // passing an entire extension enum type for using it's elements
        test(BasicOperations.class, x, y);
        test(ExtendedOperations.class, x, y);

        // passing a Collection which is a bounded wildcard type
        test(Arrays.asList(BasicOperations.values()), x, y);
        test(Arrays.asList(ExtendedOperations.values()), x, y);
    }

    private static <T extends Enum<T> & Operations> void test(Class<T> opSet, double x, double y) {
        for (Operations op : opSet.getEnumConstants()) {
            System.out.println(x + " " + op + " " + y + " = " + op.apply(x, y));
        }
    }
    private static void test(Collection<? extends Operations> opSet, double x, double y) {
        for (Operations op : opSet) {
            System.out.println(x + " " + op + " " + y + " = " + op.apply(x, y));
        }
    }
}
