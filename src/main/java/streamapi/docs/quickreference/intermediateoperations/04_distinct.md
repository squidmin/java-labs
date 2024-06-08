# Intermediate Operations: `distinct()`

Returns a stream with unique elements (according to `equals()`).

```java
import java.util.List;
import java.util.Arrays;

public class DistinctElements {
    
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
        List<Integer> distinctNumbers = numbers.stream().distinct().toList();
    }
    
}
```
