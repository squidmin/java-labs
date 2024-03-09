package lambdas;

import java.util.Arrays;
import java.util.List;

public class FilteringAndMappingObjects {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Alice", "Bob", "Emily");

        // Filter names starting with 'A' and map to uppercase using lambda expression
        List<String> filteredAndMapped = names.stream()
            .filter(name -> name.startsWith("A"))
            .map(String::toUpperCase)
            .toList();

        // Print filtered and mapped names
        System.out.println("Filtered and mapped names: " + filteredAndMapped);
    }

}
