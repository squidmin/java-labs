## Terminal Operations: `toList()`

- Collects the elements of the stream into an immutable list.
- Introduced in Java 16.

### Example

```java
import java.util.Arrays;
import java.util.List;

public class ToListExample {
    
    public static void main(String[] args) {
        List<String> strings = List.of("string_1", "string_2", "string_3");
        List<String> collectedStrings = strings.stream().toList();
        collectedStrings.forEach(System.out::println);
    }
    
}
```
