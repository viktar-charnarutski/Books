package effectivejava.chapter5.item27.genericmethods;

import java.util.HashSet;
import java.util.Set;

/**
 * Favor generic methods.
 */
public class SetHelper {
    public static <E> Set<E> union(Set<E> set1, Set<E> set2) {
        Set<E> result = new HashSet<>(set1);
        result.addAll(set2);
        return result;
    }
}
