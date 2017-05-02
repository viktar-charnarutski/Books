package effectivejava.chapter2.item1.adapter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Noninstantiable class for service registration and access.
 */
public class Services {
    private Services() {
        // Noninstantiable constructor
    }

    // maps service name to it's provider
    private static Map<String, Provider> providers = new ConcurrentHashMap<>();

    private static String DEFAULT_SERVICE_PROVIDER_NAME = "<def>";

    // Provider registration API
    public static void registerDefaultProvider(Provider p) {
        providers.put(DEFAULT_SERVICE_PROVIDER_NAME, p);
    }

    public static void registerProvider(String name, Provider p) {
        providers.put(name, p);
    }

    // Service access API
    public static Service newInstance() {
        return providers.get(DEFAULT_SERVICE_PROVIDER_NAME).newServise();
    }

    public static Service newInstance(String name) {
        Provider p = providers.get(name);
        if (p == null) {
            throw new IllegalArgumentException("No registered providers by name: " + name);
        }
        return p.newServise();
    }

}
