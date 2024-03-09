package lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingByStringLength {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "orange", "grape");

        // Group words by length using lambda expression
        Map<Integer, List<String>> groupedByLength = words.stream()
            .collect(Collectors.groupingBy(String::length));

        // Print words grouped by length
        groupedByLength.forEach((length, wordList) -> System.out.println("Words with length " + length + ": " + wordList));
    }

}
