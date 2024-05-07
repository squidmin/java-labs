package collections.arraylist.exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomAccessVsIterativeAccess {

    public static void main(String[] args) {
        final int SIZE = 100000; // Number of integers to be added to the ArrayList
        List<Integer> numbers = new ArrayList<>(SIZE);
        Random random = new Random();

        // Filling the ArrayList with random integers
        for (int i = 0; i < SIZE; i++) {
            numbers.add(random.nextInt());
        }

        // Sequential access
        long startTimeSequential = System.nanoTime();
        for (int i = 0; i < SIZE; i++) {
            int num = numbers.get(i); // Sequential access
        }
        long endTimeSequential = System.nanoTime();
        long durationSequential = endTimeSequential - startTimeSequential;

        // Random access
        long startTimeRandom = System.nanoTime();
        for (int i = 0; i < SIZE; i++) {
            int index = random.nextInt(SIZE); // Generate a random index to access
            int num = numbers.get(index); // Random access
        }
        long endTimeRandom = System.nanoTime();
        long durationRandom = endTimeRandom - startTimeRandom;

        // Output the results
        System.out.println("Time taken for sequential access: " + durationSequential + " nanoseconds");
        System.out.println("Time taken for random access: " + durationRandom + " nanoseconds");

        // Highlighting the difference
        if (durationSequential < durationRandom) {
            System.out.println("Sequential access was faster by " + (durationRandom - durationSequential) + " nanoseconds.");
        } else {
            System.out.println("Random access was faster by " + (durationSequential - durationRandom) + " nanoseconds.");
        }
    }

}
