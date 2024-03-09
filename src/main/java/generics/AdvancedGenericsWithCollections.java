package generics;

import java.util.List;

public class AdvancedGenericsWithCollections {

    public static <T extends Comparable<T>> T maxElement(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("List is empty");
        }

        T max = list.get(0);
        for (T item : list) {
            if (item.compareTo(max) > 0) {
                max = item;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(5, 10, 3, 8, 2);
        System.out.println("Maximum element: " + maxElement(numbers));

        List<String> strings = List.of("apple", "banana", "orange");
        System.out.println("Maximum element: " + maxElement(strings));
    }

}
