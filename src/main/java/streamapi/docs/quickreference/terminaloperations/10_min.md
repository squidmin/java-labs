## Terminal Operations: `min(Comparator<T> comparator)`

Returns the minimum element according to the provided comparator.

### Example

```java
import java.util.Arrays;
import java.util.List;

public class MinString {
    
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("string_1", "string_2", "string_3");
        Optional<String> minString = strings.stream().min(String::compareTo);
        minString.ifPresent(System.out::println);
    }
    
}
```
