package collections.collectionsclass;

import java.util.ArrayList;
import java.util.Collections;

public class ShuffleArrayListElements {

    public static void main(String[] args) {
        // Create an ArrayList
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            numbers.add(i);
        }

        // Shuffle the ArrayList
        Collections.shuffle(numbers);

        // Print the shuffled ArrayList
        System.out.println("Shuffled ArrayList: " + numbers);
    }

}
