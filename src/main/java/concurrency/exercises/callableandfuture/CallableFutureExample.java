package concurrency.exercises.callableandfuture;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableFutureExample {

    public static void main(String[] args) {
        int start = 1;
        int end = 100;

        ExecutorService executor = Executors.newSingleThreadExecutor();
        PrimeSumCalculator task = new PrimeSumCalculator(start, end);
        Future<Integer> result = executor.submit(task);

        try {
            System.out.println("The sum of all prime numbers between " + start + " and " + end + " is: " + result.get());
        } catch (Exception e) {
            System.err.println("Failed to calculate the sum of primes: " + e.getMessage());
        }

        executor.shutdown();
    }

}
