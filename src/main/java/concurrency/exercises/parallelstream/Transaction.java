package concurrency.exercises.parallelstream;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Transaction {

    private final String type;
    private final double amount;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    // Generate a large list of random transactions for demonstration
    public static List<Transaction> generateRandomTransactions(int num) {
        List<Transaction> transactions = new ArrayList<>();
        Random random = new Random();
        String[] types = {"SALE", "REFUND", "REBATE"};

        for (int i = 0; i < num; i++) {
            String type = types[random.nextInt(types.length)];
            double amount = random.nextDouble() * 100;  // random amount up to $100
            transactions.add(new Transaction(type, amount));
        }

        return transactions;
    }

}
