## Terminal Operations: `summaryStatistics`

Returns a summary of statistics, such as count, sum, min, average, and max, for a stream of numbers.

### Example

```java
import java.util.Arrays;
import java.util.List;

public class SummaryStatisticsExample {
    
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        IntSummaryStatistics stats = numbers.stream()
            .mapToInt(Integer::intValue)
            .summaryStatistics();
        System.out.println(stats);
    }
    
}
```
