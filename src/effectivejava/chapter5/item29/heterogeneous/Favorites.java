package effectivejava.chapter5.item29.heterogeneous;

import java.util.HashMap;
import java.util.Map;

/**
 * Typesafe heterogeneous container pattern.
 */
public class Favorites {
    private Map<Class<?>, Object> favorites = new HashMap<>();

    public <T> void putFavorite(Class<T> type, T obj) {
        if (type == null) {
            throw new NullPointerException("Type is null!");
        }
        favorites.put(type, obj);
    }
    
    public <T> T getFavorite(Class<T> type) {
        return type.cast(favorites.get(type));
    }
}
