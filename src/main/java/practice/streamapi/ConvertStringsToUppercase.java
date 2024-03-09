package practice.streamapi;

import java.util.List;
import java.util.stream.Collectors;

public class ConvertStringsToUppercase {

    public static List<String> convertToUppercase(List<String> strings) {
        return null;
    }

    public static void main(String[] args) {
        List<String> strings = List.of("apple", "banana", "orange", "pineapple", "grape");
        List<String> uppercaseStrings = convertToUppercase(strings);
        System.out.println("Uppercase strings: " + uppercaseStrings);
    }

}
