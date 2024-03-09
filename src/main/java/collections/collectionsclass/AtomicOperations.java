package collections.collectionsclass;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicOperations {
    private final List<Integer> list = new ArrayList<>();
    private final AtomicInteger size = new AtomicInteger(0);

    // Method to add an element to the collection in a thread-safe manner
    public void add(int element) {
        list.add(element);
        size.incrementAndGet();
    }

    // Method to remove an element from the collection in a thread-safe manner
    public void remove(int element) {
        synchronized (list) {
            int index = list.indexOf(element);
            if (index != -1) {
                list.remove(index);
                size.decrementAndGet();
            }
        }
    }

    // Method to access an element from the collection in a thread-safe manner
    public int get(int index) {
        synchronized (list) {
            return list.get(index);
        }
    }

    // Method to get the size of the collection in a thread-safe manner
    public int size() {
        return size.get();
    }

    public static void main(String[] args) {
        final int THREAD_COUNT = 3;
        final int OPERATIONS_PER_THREAD = 1000000;

        long startTime, endTime, totalTime;

        // Using AtomicCollection
        AtomicOperations atomicCollection = new AtomicOperations();
        startTime = System.currentTimeMillis();

        List<Thread> atomicThreads = new ArrayList<>();
        for (int i = 0; i < THREAD_COUNT; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < OPERATIONS_PER_THREAD; j++) {
                    atomicCollection.add(j);
                    atomicCollection.remove(j);
                }
            });
            atomicThreads.add(thread);
            thread.start();
        }

        // Wait for all threads to finish
        for (Thread thread : atomicThreads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;
        System.out.println("Total time using AtomicCollection: " + totalTime + " ms");
    }
}


