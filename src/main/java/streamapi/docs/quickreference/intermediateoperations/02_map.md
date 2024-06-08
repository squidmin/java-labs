## Intermediate Operations: `map(Function<T, R> mapper)`

Transforms each element of the stream by applying the given function.

### Example

```java
import java.util.List;
import java.util.Arrays;

public class MapStrings {
    
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("string_1", "string_2", "string3");
        List<Integer>  stringLengths = strings.stream().map(String::length).toList();
    }
    
}
```
