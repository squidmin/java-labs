package concurrency.exercises.callableandfuture;

import java.util.concurrent.Callable;

public class PrimeSumCalculator implements Callable<Integer> {

    private final int start;
    private final int end;

    public PrimeSumCalculator(int start, int end) {
        this.start = start;
        this.end = end;
    }

    // Helper method to check if a number is prime
    private boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Integer call() {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                sum += i;
            }
        }
        return sum;
    }

}
