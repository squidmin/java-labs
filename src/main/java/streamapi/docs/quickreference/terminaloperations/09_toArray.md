## Terminal Operations: `toArray`

Returns an array containing the elements of the stream.

### Example

```java
import java.util.Arrays;
import java.util.List;

public class ToArrayStrings {
    
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("string_1", "string_2", "string_3");
        String[] stringsArray = strings.stream().toArray(String[]::new);
    }
    
}
```
