package collections.collectionsclass;

import java.util.Collections;
import java.util.List;

public class FindMinimumElementInACollection {

    public static void main(String[] args) {
        List<Integer> list = List.of(2, 34, 12, 9, 76, 29, 75);
        System.out.println("The minimum element in the list is: " + Collections.min(list));
    }

}
