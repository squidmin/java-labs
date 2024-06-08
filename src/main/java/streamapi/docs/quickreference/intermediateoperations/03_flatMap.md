## Intermediate Operations: `flatMap(Function<T, Streeam<R>> mapper)`

Transforms each element into a stream and then flattens the resulting streams into a single stream.

### Example

```java
import java.util.List;
import java.util.Arrays;

public class FlatMapStrings {
    
    public static void main(String[] args) {
        List<List<String>> strings = Arrays.asList(
            Arrays.asList("string_1", "string_2"),
            Arrays.asList("string_3", "string_4")
        );
        List<String> flatStrings = strings.stream().flatMap(List::stream).toList();
        flatStrings.forEach(System.out::println);
    }
    
}
```
