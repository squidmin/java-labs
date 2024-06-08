## Intermediate Operations: `peek(Consumer<T> action)`

- Performs the provided action on each element as they are encountered and returns a new stream.
- Useful for debugging.

### Example

```java
import java.util.Arrays;
import java.util.List;

public class PeekStrings {
    
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("string_1", "string_2", "string_3");
        List<String> processedStrings = strings.stream()
            .peek(str -> System.out.println("Processing: " + str))
            .map(String::toUpperCase)
            .toList();
    }
    
}
```
