package concurrency.exercises;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerProblem {

    // Producer class
    static class Producer implements Runnable {
        private final BlockingQueue<Integer> queue;

        Producer(BlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Produced: " + i);
                    queue.put(i);  // Places numbers into the queue
                    Thread.sleep(100);  // Simulate time delay
                }
                queue.put(-1);  // Indicate end of production
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    // Consumer class
    static class Consumer implements Runnable {
        private final BlockingQueue<Integer> queue;

        Consumer(BlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    int value = queue.take();  // Takes numbers from the queue
                    if (value == -1) {
                        System.out.println("End of consumption");
                        break;  // End of consumption
                    }
                    System.out.println("Consumed: " + value);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();

        // Create producer and consumer using the same BlockingQueue
        Thread producerThread = new Thread(new Producer(queue), "ProducerThread");
        Thread consumerThread = new Thread(new Consumer(queue), "ConsumerThread");

        // Start both threads
        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
