## Intermediate Operations: `boxed()`

Converts a primitive stream to a stream of the corresponding wrapper objects (e.g., `IntStream`, to `Stream<Integer>`).

### Example

```java
import java.util.Arrays;
import java.util.List;

public class BoxedIntegers {
    
    public static void main(String[] args) {
        IntStream intStream = IntStream.of(1, 2, 3);
        Stream<Integer> boxedStream = intStream.boxed();
        System.out.println(boxedStream);
    }
    
}
```
