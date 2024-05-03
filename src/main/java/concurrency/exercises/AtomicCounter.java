package concurrency.exercises;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {

    private AtomicInteger count = new AtomicInteger(0);

    public void increment() {
        count.getAndIncrement();  // Atomically increments by one
    }

    public int getCount() {
        return count.get();  // Retrieves the current value
    }

    public static void main(String[] args) throws InterruptedException {
        final AtomicCounter atomicCounter = new AtomicCounter();
        Thread[] threads = new Thread[10];  // Create 10 threads

        // Create and start each thread to perform increments
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    atomicCounter.increment();
                }
            });
            threads[i].start();
        }

        // Wait for all threads to finish
        for (Thread thread : threads) {
            thread.join();
        }

        // Output the final count
        System.out.println("Final count is: " + atomicCounter.getCount());
        // Expected output: Final count is: 1000
    }

}
