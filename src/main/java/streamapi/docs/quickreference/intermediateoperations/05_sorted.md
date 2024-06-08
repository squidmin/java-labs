## Intermediate Operations: `sorted()`

Returns a stream with elements sorted in natural order.

### Example

```java
import java.util.List;
import java.util.Arrays;

public class SortedElements {
    
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("string_1", "string_2", "string_3");
        List<String> sortedStrings = strings.stream().sorted().toList();
        sortedStrings.forEach(System.out::println);
    }
    
}
```

## Intermediate Operations: `sorted(Comparator<T> comparator)`

Returns a stream with elements sorted according to the provided comparator.

### Example

```java
import java.util.List;
import java.util.Arrays;

public class SortedElements {
    
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("string_1", "string_2", "string_3");
        List<String> sortedStrings = strings.stream().sorted(Comparator.reverseOrder()).toList();
        sortedStrings.forEach(System.out::println);
    }
    
}
```
