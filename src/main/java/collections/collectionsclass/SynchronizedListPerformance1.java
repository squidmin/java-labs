package collections.collectionsclass;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class SynchronizedListPerformance1 {

    public static void main(String[] args) {
        final int N = 100000; // Number of operations

        // Using synchronizedList
        List<Integer> synchronizedArrayList = Collections.synchronizedList(new ArrayList<>());

        long startTime = System.currentTimeMillis();

        // Performing write operations
        for (int i = 0; i < N; i++) {
            synchronized (synchronizedArrayList) {
                synchronizedArrayList.add(i);
            }
        }

        // Performing read operations
        for (int i = 0; i < N; i++) {
            synchronized (synchronizedArrayList) {
                synchronizedArrayList.get(i);
            }
        }

        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Total time using synchronizedList(): " + totalTime + " ms");
    }

}
