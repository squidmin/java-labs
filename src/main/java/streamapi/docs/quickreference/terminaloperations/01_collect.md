## Terminal Operations: `collect(Collector<T, A, R> collector)`

Converts the elements of the stream into a different form, such as a list, set, or map.

### Example

```java
import java.util.List;
import java.util.Arrays;

public class CollectStrings {
    
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("string_1", "string_2", "string_3");
        List<String> collectedStrings = names.stream().collect(Collectors.toList());
        collectedNames.forEach(System.out::println);
    }
    
}
```

## Terminal Operations: `collect(Collectors.groupingBy(Function<T, K> classifier))`

Groups the elements of the stream by a classifier function and returns `Map` where the keys are the classifier results and the values are lists of items.

### Example

```java
import java.util.Arrays;
import java.util.List;

public class CollectStrings {
    
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("a_1", "a_2", "b_3", "c_4", "b_4", "c_1");
        Map<Character, List<String>> groupedByFirstLetter = strings.stream().collect(Collectors.groupingBy(name -> name.charAt(0)));
        System.out.println(groupedByFirstLetter);
    }
    
}
```

## Terminal Operations: `collect(Collectors.partitioningBy(Predicate<T> predicate))`

Partitions the elements of the stream into two groups based on a predicate and returns a `Map` with `Boolean` keys.

### Example

```java
import java.util.Arrays;
import java.util.List;

public class CollectNumbers {
    
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Map<Boolean, List<Integer>> partitionedByEven = numbers.stream()
            .collect(Collectors.partitioningBy(n -> n % 2 == 0));
    }
    
}
```
