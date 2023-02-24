package collections.map;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {

    public static Map<String, Integer> withoutGetOrDefault() {
        Map<String, Integer> items = new HashMap<>();
        items.put("perfume", 20);

        /*
         * Add 20 items to the map.
         * Below line will throw NullPointerException if key doesn't exist in the map.
         */
        // items.put("genius", items.get("genius") + 20);

        // This is the correct way to update a map value *before Java 8*.
        if (items.containsKey("genius")) { items.put("genius", items.get("genius") + 20); }
        else { items.put("genius", 20); }

        System.out.println(items);

        return items;
    }

    public static Map<String, Integer> withGetOrDefault() {
        Map<String, Integer> items = new HashMap<>();
        items.put("perfume", 20);
        items.put("genius", items.getOrDefault("genius", 0) + 20);
        System.out.println(items);
        return items;
    }

    public static Map<String, Integer> putIfAbsent() {
        Map<String , Integer> items = new HashMap<>();
        items.put("perfume", 20);
        System.out.println(items.get("perfume"));
        items.putIfAbsent("perfume", 30);
        System.out.println(items.get("perfume"));
        return items;
    }

    public static void main(String[] args) {
        System.out.println("getOrDefault() demo");
        withoutGetOrDefault();
        withGetOrDefault();
        System.out.println();

        System.out.println("putIfAbsent() demo");
        putIfAbsent();
        System.out.println();
    }

}
