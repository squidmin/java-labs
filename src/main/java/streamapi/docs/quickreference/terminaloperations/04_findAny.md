## Terminal Operations: `findAny()`

Returns an `Optional` describing some element of the stream, or an empty `Optional` if the stream is empty.

### Example

```java
import java.util.Arrays;
import java.util.List;

public class FindAnyString {
    
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("string_1", "string_2", "string_3");
        Optional<String> any = strings.stream().findAny();
        any.ifPresent(System.out::println);
    }
    
}
```
