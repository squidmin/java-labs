package collections.collectionsclass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConcurrentModification {
    public static void main(String[] args) {
        // Creating a non-thread-safe ArrayList
        List<String> arrayList = new ArrayList<>();

        // Adding elements to the ArrayList (non-thread-safe)
        arrayList.add("Element 1");
        arrayList.add("Element 2");
        arrayList.add("Element 3");

        // Creating a thread that iterates over the ArrayList and modifies it
        Thread modifyingThread = new Thread(() -> {
            for (String element : arrayList) {
                System.out.println("Element: " + element);
                // Concurrent modification - adding an element while iterating
                arrayList.add("New Element");
            }
        });

        modifyingThread.start();

        // Waiting for the modifying thread to finish
        try {
            modifyingThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("After concurrent modification, ArrayList: " + arrayList);

        // Making the ArrayList thread-safe using synchronizedList()
        List<String> synchronizedArrayList = Collections.synchronizedList(arrayList);

        // Creating a thread that iterates over the synchronized ArrayList and modifies it
        Thread synchronizedModifyingThread = new Thread(() -> {
            synchronized (synchronizedArrayList) {
                for (String element : synchronizedArrayList) {
                    System.out.println("Synchronized Element: " + element);
                    // Modifying the synchronized ArrayList is safe due to synchronization
                    synchronizedArrayList.add("New Synchronized Element");
                }
            }
        });

        synchronizedModifyingThread.start();

        // Waiting for the synchronized modifying thread to finish
        try {
            synchronizedModifyingThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Printing the synchronized ArrayList after concurrent modification
        System.out.println("After concurrent modification, Synchronized ArrayList: " + synchronizedArrayList);
    }
}

