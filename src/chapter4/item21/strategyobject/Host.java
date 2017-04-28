package chapter4.item21.strategyobject;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Class is exporting a concrete strategy - comparing strings by length.
 * <p>
 * Also known as Strategy pattern.
 */
public class Host {

    private static class StrLenCmp implements Comparator<String>, Serializable {
        @Override
        public int compare(String str1, String str2) {
            return str1.length() - str2.length();
        }

        // returned comparator is serializable
        public static Comparator<String> STRINGS_LENGTH_COMPARATOR = new StrLenCmp();
    }
}
