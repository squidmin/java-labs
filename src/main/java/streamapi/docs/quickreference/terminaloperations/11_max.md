## Terminal Operations: `max(Comparator<T> comparator)`

Returns the maximum element according to the provided comparator.

### Example

```java
import java.util.Arrays;
import java.util.List;

public class MaxString {
    
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("string_1", "string_2", "string_3");
        Optional<String> maxString = strings.stream().max(String::compareTo);
        maxString.ifPresent(System.out::println);
    }
    
}
```
