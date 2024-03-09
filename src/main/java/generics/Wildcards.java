package generics;

import java.util.List;

public class Wildcards {

    public static void printList(List<?> list) {
        for (Object item : list) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<Integer> integerList = List.of(1, 2, 3, 4, 5);
        System.out.print("Integer List: ");
        printList(integerList);

        List<String> stringList = List.of("apple", "banana", "orange");
        System.out.print("String List: ");
        printList(stringList);
    }

}
