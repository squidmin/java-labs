package collections.collectionsclass;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class SynchronizedListPerformance2 {

    public static void main(String[] args) {
        final int N = 100000; // Number of operations

        // Using CopyOnWriteArrayList
        List<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();

        long startTime = System.currentTimeMillis();

        // Performing write operations
        for (int i = 0; i < N; i++) {
            copyOnWriteArrayList.add(i);
        }

        // Performing read operations (just to simulate some processing)
        for (Integer element : copyOnWriteArrayList) {
            // Read the element, but we don't actually do anything with it
        }

        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Total time using CopyOnWriteArrayList: " + totalTime + " ms");
    }

}
