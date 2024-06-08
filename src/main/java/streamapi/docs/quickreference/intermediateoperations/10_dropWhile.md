## Intermediate Operations: `dropWhile(Predicate<T> predicate)`

- Drops elements from the stream while the provided predicate is true and starts returning elements as soon as the predicate is false.
- Introduced in Java 9.

### Example

```java
import java.util.Arrays;
import java.util.List;

public class DropWhileLessThanFour {
    
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 1, 2);
        List<Integer> droppedNumbers = numbers.stream().dropWhile(n -> n < 4).toList();
    }
    
}
```
