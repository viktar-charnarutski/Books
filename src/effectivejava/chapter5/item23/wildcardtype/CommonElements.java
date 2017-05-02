package effectivejava.chapter5.item23.wildcardtype;

import java.util.Set;

/**
 * Don't use raw types.
 */
public class CommonElements {

    // RIGHT: wildcard type - typesafe and flexible
    public static int numberOfElementsInCommon(Set<?> firstSet, Set<?> secondSet) {
        int result = 0;
        for (Object o : firstSet) {
            if (secondSet.contains(o)) {
                result++;
            }
        }
        return result;
    }

    // WRONG: raw type for unknown element type
    public static int numberOfElementsInCommonRaw(Set firstSet, Set secondSet) {
        int result = 0;
        for (Object o : firstSet) {
            if (secondSet.contains(o)) {
                result++;
            }
        }
        return result;
    }

}
