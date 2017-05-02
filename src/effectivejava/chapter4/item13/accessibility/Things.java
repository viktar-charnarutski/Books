package effectivejava.chapter4.item13.accessibility;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Private array and public immutable list.
 * <p>
 * It's wrong for a class to have a public static final array field, or an accessor that returns such a field.
 */
public class Things {

    private static final String[] PRIVATE_IP_ADDRESSES = {"127.0.0.1", "127.0.0.2", "127.0.0.3"};

    public static final List<String> IP_ADDRESSES = Collections.unmodifiableList(Arrays.asList(PRIVATE_IP_ADDRESSES));

}
