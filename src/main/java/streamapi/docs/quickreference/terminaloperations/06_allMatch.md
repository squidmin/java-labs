## Terminal Operations: `allMatch(Predicate<T> predicate)`

Returns `true` if all elements match the provided predicate.

### Example

```java
import java.util.Arrays;
import java.util.List;

public class AllMatchEvenNumber {
    
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        boolean allEven = numbers.stream().allMatch(n -> n % 2 == 0);
    }
    
}
```
