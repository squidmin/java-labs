package collections.collectionsclass;

import java.util.ArrayList;
import java.util.Collections;

public class SortingStrings {

    public static void main(String[] args) {
        // Create a list of strings
        ArrayList<String> strings = new ArrayList<>();
        strings.add("Orange");
        strings.add("Banana");
        strings.add("Apple");

        // Sort the list
        Collections.sort(strings);

        // Print the sorted list
        System.out.println("Sorted list of strings: " + strings);
    }

}
