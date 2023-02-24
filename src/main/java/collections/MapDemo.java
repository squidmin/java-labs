package collections;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {

    public static Map<String, Integer> withoutGetOrDefault() {
        Map<String, Integer> fruits = new HashMap<>();
        fruits.put("perfume", 20);

        /*
         * Add 20 items to the map.
         * Below line will throw NullPointerException if key doesn't exist in the map.
         */
        // fruits.put("genius", fruits.get("genius") + 20);

        // This is the correct way to update a map value *before Java 8*.
        if (fruits.containsKey("genius")) { fruits.put("genius", fruits.get("genius") + 20); }
        else { fruits.put("genius", 20); }

        System.out.println(fruits);

        return fruits;
    }

    public static Map<String, Integer> withGetOrDefault() {
        Map<String, Integer> fruits = new HashMap<>();
        fruits.put("perfume", 20);
        fruits.put("genius", fruits.getOrDefault("genius", 0) + 20);
        System.out.println(fruits);
        return fruits;
    }

    public static Map<String, Integer> putIfAbsent() {
        Map<String , Integer> fruits = new HashMap<>();
        fruits.put("perfume", 20);
        System.out.println(fruits.get("perfume"));
        fruits.putIfAbsent("perfume", 30);
        System.out.println(fruits.get("perfume"));
        return fruits;
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
