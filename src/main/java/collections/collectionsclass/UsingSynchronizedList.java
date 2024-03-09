package collections.collectionsclass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UsingSynchronizedList {

    public static void main(String[] args) {
        // Creating a non-thread-safe ArrayList
        List<String> arrayList = new ArrayList<>();

        // Adding elements to the ArrayList (non-thread-safe)
        arrayList.add("Element 1");
        arrayList.add("Element 2");
        arrayList.add("Element 3");

        // Making the ArrayList thread-safe using synchronizedList()
        List<String> synchronizedArrayList = Collections.synchronizedList(arrayList);

        // Creating and starting two threads to modify the synchronized ArrayList concurrently
        Thread thread1 = new Thread(() -> {
            synchronized (synchronizedArrayList) {
                synchronizedArrayList.add("Thread 1 added");
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (synchronizedArrayList) {
                synchronizedArrayList.add("Thread 2 added");
            }
        });

        thread1.start();
        thread2.start();

        // Waiting for both threads to finish
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Printing the synchronized ArrayList
        System.out.println("Synchronized ArrayList: " + synchronizedArrayList);
    }

}
