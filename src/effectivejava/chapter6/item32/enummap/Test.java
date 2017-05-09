package effectivejava.chapter6.item32.enummap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Using an EnumMap to associate data with enum.
 */
public class Test {
    public static void main(String[] args) {
        Herb rose = new Herb("rose", Herb.Type.ANNUAL);
        Herb peon = new Herb("peon", Herb.Type.BIENNINAL);
        Herb magnolia = new Herb("magnolia", Herb.Type.PERENNIAL);
        Herb sunflower = new Herb("sunflower", Herb.Type.ANNUAL);
        Herb[] garden = new Herb[]{rose, peon, magnolia, sunflower};

        Map<Herb.Type, Set <Herb>> herbsByType = new HashMap<>();

        for(Herb.Type type : Herb.Type.values()) {
            herbsByType.put(type, new HashSet<Herb>());
        }

        // fill out enum map
        for (Herb herb : garden) {
            herbsByType.get(herb.type()).add(herb);
        }

        System.out.println(herbsByType);
    }
}
