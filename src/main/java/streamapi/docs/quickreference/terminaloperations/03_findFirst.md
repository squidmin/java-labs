## Terminal Operations: `findFirst()`

Returns an `Optional` describing the first element of the stream, or an empty `Optional` if the stream is empty.

### Example

```java
import java.util.Arrays;
import java.util.List;

public class FindFirstString {
    
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("string_1", "string_2", "string_3");
        Optional<String> first = strings.stream().findFirst();
        first.ifPresent(System.out::println);
    }
    
}
```
