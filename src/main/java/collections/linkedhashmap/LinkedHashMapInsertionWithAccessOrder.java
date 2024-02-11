package collections.linkedhashmap;

import java.util.LinkedHashMap;
import java.util.HashMap;

public class LinkedHashMapInsertionWithAccessOrder {
    public static void main(String[] args) {
        // Specify access order in constructor
        HashMap<String, Integer> stocks = new LinkedHashMap<>(16, 0.75f, true);
        stocks.put("Apple", 123);
        stocks.put("BMW", 54);
        stocks.put("Google", 87);
        stocks.put("Microsoft", 232);
        stocks.put("Oracle", 76);

        System.out.println(stocks);
        stocks.get("Google");
        stocks.get("BMW");

        System.out.println(stocks);
    }
}
