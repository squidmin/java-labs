# HashMap: Exercises

Solve some `HashMap` practice problems.

Topics:
- Problem 1: Find the highest stock price
- Problem 2: Find the average stock price
- Problem 3: Remove companies with stock prive below 50

We are given a `HashMap` which contains stock data.

### Problem 1: Find the highest stock price

Find the company with the highest stock price.

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
        stockPrice.put("Google", 421);
        stockPrice.put("Ford", 456);
        stockPrice.put("Novartis", 43);
        stockPrice.put("TCS", 23);
        
        int max = 0;
        String company = "";
        for (Entry<String, Integer> entry : stockPrice.entrySet()) {
            if (entry.getValue() > max) {
                company = entry.getKey();
                max = entry.getValue();
            }
        }

        System.out.println("Company with max stock price is: " + company);
    }
}
```

### Problem 2: Find the average stock price

Find the average stock price of all the companies.

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
        stockPrice.put("Google", 421);
        stockPrice.put("Ford", 456);
        stockPrice.put("Novartis", 43);
        stockPrice.put("TCS", 23);
        
        Collection<Integer> values = stockPrice.values();
        
        int sum = 0;
        
        for (int i : values) {
            sum += i;
        }
        // Sum of values using Java 8 features
        //int sum = values.stream().mapToInt(i -> i.intValue()).sum();
        System.out.println("The average stock price is " + sum / values.size());
    }
}
```

### Problem 3: Remove companies with stock price below 50

Remove all the companies that have a stock price of fewer than 50 dollars.

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
        stockPrice.put("Google", 421);
        stockPrice.put("Ford", 456);
        stockPrice.put("Novartis", 43);
        stockPrice.put("TCS", 23);
        
        Iterator<Entry<String, Integer>> itr = stockPrice.entrySet().iterator();
        
        while (itr.hasNext()) {
            Entry<String, Integer> entry = itr.next();
            if (entry.getValue() < 50) {
                itr.remove();
            }
        }

        System.out.println(stockPrice);
    }
}
```
