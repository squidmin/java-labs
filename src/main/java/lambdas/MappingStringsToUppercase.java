package lambdas;

import java.util.Arrays;
import java.util.List;

public class MappingStringsToUppercase {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "orange", "grape");

        // Map strings to uppercase using lambda expression
        List<String> uppercaseWords = words.stream()
            .map(String::toUpperCase)
            .toList();

        // Print uppercase words
        System.out.println("Uppercase words: " + uppercaseWords);
    }

}
