## Terminal Operations: `noneMatch(Predicate<T> predicate)`

Returns `true` if no elements match the provided predicate.

### Example

```java
import java.util.Arrays;
import java.util.List;

public class NoneMatchEvenNumber {
    
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 3, 5, 7);
        boolean noneEven = numbers.stream().noneMatch(n -> n % 2 == 0);
        System.out.println(noneEven);
    }
    
}
```
