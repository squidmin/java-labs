package practice.collectionsclass;

import java.util.Collections;
import java.util.List;

public class FindMaximumElementInCollection {

    public static void main(String[] args) {
        List<Integer> list = List.of(2, 34, 12, 9, 76, 29, 75);
        System.out.println("The minimum element in the list is: " + Collections.max(list));
    }

}
