package collections.collectionsclass;

import java.util.ArrayList;
import java.util.Collections;

public class ReverseOrderOfElementInCollection {

    public static void main(String[] args) {
        // Create a list of integers
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            numbers.add(i);
        }

        // Reverse the order of elements
        Collections.reverse(numbers);

        // Print the reversed list
        System.out.println("Reversed list: " + numbers);
    }

}
