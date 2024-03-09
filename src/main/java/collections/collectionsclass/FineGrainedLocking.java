package collections.collectionsclass;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class FineGrainedLocking<T> {

    private final List<T> list = new ArrayList<>();
    private final ReentrantLock[] locks;

    public FineGrainedLocking(int capacity) {
        for (int i = 0; i < capacity; i++) {
            list.add(null); // Initialize the list with null elements
        }
        locks = new ReentrantLock[capacity];
        for (int i = 0; i < capacity; i++) {
            locks[i] = new ReentrantLock();
        }
    }

    // Method to add an element to the collection in a thread-safe manner
    public void add(int index, T element) {
        locks[index].lock();
        try {
            list.set(index, element);
        } finally {
            locks[index].unlock();
        }
    }

    // Method to remove an element from the collection in a thread-safe manner
    public void remove(int index) {
        locks[index].lock();
        try {
            list.set(index, null);
        } finally {
            locks[index].unlock();
        }
    }

    // Method to access an element from the collection in a thread-safe manner
    public T get(int index) {
        locks[index].lock();
        try {
            return list.get(index);
        } finally {
            locks[index].unlock();
        }
    }

    // Test program to validate the thread safety of the custom collection
    public static void main(String[] args) {
        final int THREAD_COUNT = 3;
        final int OPERATIONS_PER_THREAD = 1000;
        final int CAPACITY = 100;

        FineGrainedLocking<Integer> collection = new FineGrainedLocking<>(CAPACITY);

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < THREAD_COUNT; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < OPERATIONS_PER_THREAD; j++) {
                    int index = (int) (Math.random() * CAPACITY);
                    collection.add(index, j);
                    collection.remove(index);
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

        // Validate the contents of the collection after all operations
        for (int i = 0; i < CAPACITY; i++) {
            System.out.println("Element at index " + i + ": " + collection.get(i));
        }
    }

}
