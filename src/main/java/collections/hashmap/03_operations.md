# HashMap: Operations

Discussion of some HashMap operations.

Topics:
- Operations on `HashMap`
  - Checking if a key is present in the `HashMap`
  - Fetching all the keys from `HashMap`
  - Fetching all the values from `HashMap`
  - Checking if the `HashMap` is empty

## Operations on `HashMap`

### Checking if a key is present in the `HashMap`

We can use the `containsKey(Object key)` method to check if a given key is present in the `HashMap`.
This method returns `true` if the key is present and returns `false` if the key is not present.
Similarly, we have a `containsValue(Object value)` method that returns `true` if one or more keys are mapped to this value.

```java
import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
    public static void main(String[] args) {
        Map<String, Integer> stockPrice = new HashMap<>();
        stockPrice.put("Oracle", 56);
        stockPrice.put("Fiserv", 117);
        stockPrice.put("BMW", 73);
        stockPrice.put("Microsoft", 213);
        
        System.out.println(stockPrice.containsKey("Oracle"));
        System.out.println(stockPrice.containsValue(73));
    }
}
```

### Fetching all the keys from `HashMap`

If we need to fetch all the keys that are stored in a `HashMap`, then we can use the `keySet()` method.
This method returns a `Set` containing all the keys present in the `Map`.

### Fetching all the values from  `HashMap`

If we need to fetch all the values stored in a `HashMap`, we can use the `values()` method.
This method returns a `Collection` containing all the values present in the `Map`.

```java
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {
    public static void main(String[] args) {
        Map<String, Integer> stockPrice = new HashMap<>();
        stockPrice.put("Oracle", 56);
        stockPrice.put("Fiserv", 117);
        stockPrice.put("BMW", 73);
        stockPrice.put("Microsoft", 213);

        System.out.println("HashMap Keys");
        Set<String> keys = stockPrice.keySet();
        for (String key : keys) {
            System.out.println(key);
        }
        
        System.out.println("HashMap Values");
        Collection<Integer> values = stockPrice.values();
        for (Integer value : values) {
            System.out.println(value);
        }
    }
}
```

### Checking if the `HashMap` is empty

We can check if the `HashMap` is empty using the `isEmpty()` method.
This method returns `true` if the `Map` does not have any elements and returns `false` if the `Map` has some elements.

```java
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class HashMapDemo {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("abc", 23);
        map.put("def", 34);
        map.put("ghi", 56);
        System.out.println(map.isEmpty());
    }
}
```
