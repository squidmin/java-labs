package concurrency.exercises.parallelstream;

import java.util.List;

public class ParallelStreamExample {

    public static void main(String[] args) {
        List<Transaction> transactions = Transaction.generateRandomTransactions(1_000_000);

        long startTime = System.currentTimeMillis();

        // Calculate total amount of SALE transactions using parallel stream
        double totalSaleAmount = transactions.parallelStream()
            .filter(transaction -> transaction.getType().equals("SALE"))
            .mapToDouble(Transaction::getAmount)
            .sum();

        long endTime = System.currentTimeMillis();

        System.out.println("Total amount for SALE transactions: $" + totalSaleAmount);
        System.out.println("Time taken: " + (endTime - startTime) + " ms");
    }

}
