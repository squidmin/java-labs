package streamapi;

import java.util.List;
import java.util.Optional;

public class FindMinimumAndMaximumNumbers {

    public static void findMinMax(List<Integer> numbers) {
        Optional<Integer> min = numbers.stream().min(Integer::compareTo);
        Optional<Integer> max = numbers.stream().max(Integer::compareTo);

        System.out.println("Minimum number: " + min.orElse(null));
        System.out.println("Maximum number: " + max.orElse(null));
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(3, 6, 2, 8, 4, 9, 1);
        findMinMax(numbers);
    }

}
