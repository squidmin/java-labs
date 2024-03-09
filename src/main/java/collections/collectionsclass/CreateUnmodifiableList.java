package collections.collectionsclass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CreateUnmodifiableList {

    public static void main(String[] args) {
        // Create a list of strings
        ArrayList<String> strings = new ArrayList<>();
        strings.add("Java");
        strings.add("Python");
        strings.add("C++");

        // Create an unmodifiable list
        List<String> unmodifiableList = Collections.unmodifiableList(strings);

        // Try to modify the unmodifiable list (will throw UnsupportedOperationException)
        // unmodifiableList.add("JavaScript");

        // Print the unmodifiable list
        System.out.println("Unmodifiable list: " + unmodifiableList);
    }

}
