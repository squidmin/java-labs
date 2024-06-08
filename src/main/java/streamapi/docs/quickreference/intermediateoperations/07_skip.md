## Intermediate Operations: `skip(long n)`

### Example

```java
import java.util.List;
import java.util.Arrays;

public class SkipElements {
    
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> skippedNumbers = numbers.stream().skip(2).toList();
        skippedNumbers.forEach(System.out::println);
    }
    
}
```
