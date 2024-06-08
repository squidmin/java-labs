package streamapi;

import java.util.Arrays;
import java.util.List;

public class FilterStrings {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("string_1", "string_2", "string_3");
        List<String> filteredStrings = strings.stream().filter(str -> str.contains("1")).toList();
        filteredStrings.forEach(System.out::println);
    }

}
