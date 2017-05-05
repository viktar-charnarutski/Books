package effectivejava.chapter5.item28.boundedwildcards;

import java.util.HashSet;
import java.util.Set;

/**
 * Use bounded wildcards to increase API flexibility.
 */
public class SetHelper {
    public static <E> Set<E> union(Set<? extends E> set1, Set<? extends E> set2) {
        Set<E> result = new HashSet<>(set1);
        result.addAll(set2);
        return result;
    }
}
