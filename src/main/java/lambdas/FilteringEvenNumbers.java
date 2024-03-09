package lambdas;

import java.util.Arrays;
import java.util.List;

public class FilteringEvenNumbers {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Filter even numbers using lambda expression
        List<Integer> evenNumbers = numbers.stream()
            .filter(n -> n % 2 == 0)
            .toList();

        // Print even numbers
        System.out.println("Even numbers: " + evenNumbers);
    }

}
