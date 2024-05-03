package concurrency.exercises;

public class Synchronization {

    private static class Counter {
        private int count = 0;

        // Synchronized method to prevent concurrent modification
        public synchronized void increment() {
            count++;
        }

        public int getCount() {
            return count;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final Counter counter = new Counter();
        Thread[] threads = new Thread[10]; // Create 10 threads

        // Create and start each thread
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    counter.increment();
                }
            });
            threads[i].start();
        }

        // Wait for all threads to finish
        for (Thread thread : threads) {
            thread.join();
        }

        // Output the final count
        System.out.println("Final count is: " + counter.getCount());
        // Expected output: Final count is: 1000
    }

}
