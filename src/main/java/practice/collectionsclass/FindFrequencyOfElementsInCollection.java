package practice.collectionsclass;

import java.util.Collections;
import java.util.List;

public class FindFrequencyOfElementsInCollection {

    public static void main(String[] args) {
        List<Integer> list = List.of(34, 12, 9, 76, 29, 75, 9);
        System.out.println("Total number of times 9 is present in the list: " + Collections.frequency(list, 9));
    }

}
