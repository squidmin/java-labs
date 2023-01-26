package concurrencyapiimprovements;

import java.util.concurrent.*;

public class CompletableFutureDemo {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(5);

        /*
        Passing a Runnable and ExecutorService as parameters to runAsync() method.
        The static method call Executors.newFixedThreadPool(5) could also be passed as the Executor argument, but as a
        consequence the thread pool would not be able to `shutdown()` and the application would not terminate properly.
        */
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            System.out.println("Doing some processing");
        }, pool);

        System.out.println("This will print immediately");

        try {
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("This will print after 5 seconds");
        pool.shutdown();
    }
}