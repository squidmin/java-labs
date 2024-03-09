package interfaces;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

interface Processor {
    String process(Callable<String> c) throws Exception;
    String process(Supplier<String> s);
}

class DataProcessor implements Processor {
    @Override
    public String process(Callable<String> c) throws Exception {
        return c.call();
    }

    @Override
    public String process(Supplier<String> s) {
        return s.get();
    }
}

public class AvoidOverloadingMethodsWithFunctionalInterfaces {

    public static void main(String[] args) {
        // Using lambda expressions for Callable and Supplier
        DataProcessor dataProcessor = new DataProcessor();

        // Lambda expression for Callable
        try {
            String result1 = dataProcessor.process((Callable<String>) () -> "Result from Callable");
            System.out.println("Result from Callable: " + result1);
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }

        // Lambda expression for Supplier
        String result2 = dataProcessor.process((Supplier<String>) () -> "Result from Supplier");
        System.out.println("Result from Supplier: " + result2);
    }

}
