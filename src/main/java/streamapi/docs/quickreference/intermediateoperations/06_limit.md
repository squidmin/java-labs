## Intermediate Operations: `limit(long maxSize)`

Returns a stream that is truncated to be no longer than the given size.

### Example

```java
import java.util.List;
import java.util.Arrays;

public class LimitStreamSize {
    
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> limitedNumbers = numbers.stream().limit(3).toList();
        limitedNumbers.forEach(System.out::println);
    }
    
}
```
