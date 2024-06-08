## Terminal Operations: `reduce(BinaryOperator<T> accunulator)`

Combines the elements of the stream into a single result.

### Example

```java
import java.util.List;
import java.util.Arrays;

public class ReduceNumbers {
    
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> sum = numbers.stream().reduce((a, b) -> a + b);
        sum.ifPresent(System.out::println);
    }
    
}
```

### Example with an initial value

Here's another example where we provide an initial value for the reduction operation:

```java
import java.util.Arrays;
import java.util.List;

public class ReduceNumbers {
    
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum);
    }
    
}
```

In this example:
- We provide `0` as the initial value.
  This means that the reduction starts with `0` and then applies the lambda expression `(a, b) -> a + b` to combine the elements.
- The result is directly an `int` (not an `Optional`) since an initial value is provided.
