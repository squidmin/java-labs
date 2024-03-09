package collections.collectionsclass;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrencyTesting {

    private static final int THREAD_COUNT = 10;
    private static final int OPERATIONS_PER_THREAD = 1000;

    public static void main(String[] args) {
        ConcurrentHashMap<Integer, String> concurrentMap = new ConcurrentHashMap<>();

        // Create threads to perform operations on the concurrent map
        Thread[] threads = new Thread[THREAD_COUNT];
        for (int i = 0; i < THREAD_COUNT; i++) {
            threads[i] = new Thread(new ConcurrentOperation(concurrentMap));
            threads[i].start();
        }

        // Wait for all threads to finish
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Validate the state of the concurrent map
        assert concurrentMap.size() == THREAD_COUNT * OPERATIONS_PER_THREAD :
            "ConcurrentHashMap size is not as expected";

        System.out.println("Concurrency testing successful.");
    }

    static class ConcurrentOperation implements Runnable {
        private final ConcurrentHashMap<Integer, String> concurrentMap;

        public ConcurrentOperation(ConcurrentHashMap<Integer, String> concurrentMap) {
            this.concurrentMap = concurrentMap;
        }

        @Override
        public void run() {
            for (int i = 0; i < OPERATIONS_PER_THREAD; i++) {
                int key = (int) (Math.random() * 1000);
                String value = Thread.currentThread().getName() + "-" + i;
                concurrentMap.put(key, value);
                concurrentMap.remove(key);
                assert concurrentMap.get(key) == null : "Element should be removed";
            }
        }
    }

}

