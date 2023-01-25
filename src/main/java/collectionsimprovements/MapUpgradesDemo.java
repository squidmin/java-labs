package collectionsimprovements;

import java.util.HashMap;
import java.util.Map;

public class MapUpgradesDemo {

    private static void withoutGetOrDefault() {
        Map<String, Integer> fruits = new HashMap<>();
        fruits.put("apple", 20);

        // We need to add 20 bananas in map.
        // Below line will throw NullPointerException if banana
        // is already not present in the map.

        // fruits.put("banana", fruits.get("banana") + 20);

        // This is the correct way to update map value fefore Java 8
        if (fruits.containsKey("banana")) fruits.put("banana", fruits.get("banana") + 20);
        else fruits.put("banana", 20);

        System.out.println(fruits);
    }

    private static void withGetOrDefault() {
        Map<String, Integer> fruits = new HashMap<>();
        fruits.put("apple", 20);
        fruits.put("banana", fruits.getOrDefault("banana", 0) + 20);
        System.out.println(fruits);
    }

    private static void putIfAbsent() {
        Map<String , Integer> fruits = new HashMap<>();
        fruits.put("apple", 20);
        System.out.println(fruits.get("apple"));
        fruits.putIfAbsent("apple", 30);
        System.out.println(fruits.get("apple"));
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
