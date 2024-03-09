package collections.collectionsclass;

import java.util.ArrayList;
import java.util.List;

public class CustomThreadSafeCollection<T> {

    private final List<T> list = new ArrayList<>();

    // Method to add an element to the collection in a thread-safe manner
    public synchronized void add(T element) {
        list.add(element);
    }

    // Method to remove an element from the collection in a thread-safe manner
    public synchronized void remove(T element) {
        list.remove(element);
    }

    // Method to access an element from the collection in a thread-safe manner
    public synchronized T get(int index) {
        return list.get(index);
    }

    // Method to get the size of the collection in a thread-safe manner
    public synchronized int size() {
        return list.size();
    }

    // Test program to validate the thread safety of the custom collection
    public static void main(String[] args) {
        final int THREAD_COUNT = 3;
        final int OPERATIONS_PER_THREAD = 1000;

        CustomThreadSafeCollection<Integer> collection = new CustomThreadSafeCollection<>();

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < THREAD_COUNT; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < OPERATIONS_PER_THREAD; j++) {
                    collection.add(j);
                    collection.remove(j);
                }
            });
            threads.add(thread);
            thread.start();
        }

        // Wait for all threads to finish
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Validate the size of the collection after all operations
        System.out.println("Size of collection: " + collection.size());
    }

}
