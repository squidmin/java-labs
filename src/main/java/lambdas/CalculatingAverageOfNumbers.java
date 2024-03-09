package lambdas;

import java.util.Arrays;
import java.util.List;

public class CalculatingAverageOfNumbers {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Calculate average of numbers using lambda expression
        double average = numbers.stream()
            .mapToInt(Integer::intValue)
            .average()
            .orElse(0);

        // Print average
        System.out.println("Average: " + average);
    }

}
