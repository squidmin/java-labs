package practice.streamapi;

import java.util.List;

public class FilterEvenNumbers {

    public static List<Integer> filterEvenNumbers(List<Integer> numbers) {
        return null;
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenNumbers = filterEvenNumbers(numbers);
        System.out.println("Even numbers: " + evenNumbers);
    }

}
