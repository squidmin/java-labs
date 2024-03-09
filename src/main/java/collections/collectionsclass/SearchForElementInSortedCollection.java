package collections.collectionsclass;

import java.util.ArrayList;
import java.util.Collections;

public class SearchForElementInSortedCollection {

    public static void main(String[] args) {
        // Create a sorted list
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);
        numbers.add(50);

        // Search for an element
        int index = Collections.binarySearch(numbers, 30);

        // Print the index of the element
        System.out.println("Index of element 30: " + index);
    }

}
