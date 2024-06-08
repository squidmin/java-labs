## Intermediate Operations: `takeWhile(Predicate<T> predicate)`

- Takes elements from the stream while the provided predicate is true and stops as sson as the predicate is false.
- Introduced in Java 9.

### Example

```java
import java.util.Arrays;
import java.util.List;

public class TakeWhileLessThanFour {
    
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 1, 2);
        List<Integer> takenNumbers = numbers.stream().takeWhile(n -> n < 4).toList();
        takenNumbers.forEach(System.out::println);
    }
    
}
```
