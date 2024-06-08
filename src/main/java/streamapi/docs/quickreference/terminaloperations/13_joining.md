## Terminal Operations: `joining()`

Concatenates the elements of the stream into a single `String`.

### Example

```java
import java.util.Arrays;
import java.util.List;

public class JoiningStrings {
    
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("string_1", "string_2", "string_3");
        String concatenatedStrings = strings.stream()
            .collect(Collectors.joining(", "));
        System.out.println(concatenatedStrings);
    }
    
}
```
