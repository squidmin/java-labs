package concurrencyapiimprovements;

import java.util.concurrent.*;

public class CompletableFutureDemo {

    private static void supplyAsyncDemo() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Hello World";
        });

        System.out.println("This will print immediately");

        try {
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("This will print after 5 seconds");
    }

    private static void supplyAsyncOverloadedDemo() {
        ExecutorService pool = Executors.newFixedThreadPool(5);

        /*
        Passing a Runnable and ExecutorService as parameters to runAsync() method.
        The static method call Executors.newFixedThreadPool(5) could also be passed as the Executor argument, but as a
        consequence the thread pool would not be able to `shutdown()` and the application would not terminate properly.
        */
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Hello World";
        }, pool);

        System.out.println("This will print immediately");

        try {
            System.out.println(future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("This will print after 5 seconds");
        pool.shutdown();
    }

    private static void runAsyncDemo() {
        // Passing a Runnable to runAsync() method.
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            System.out.println("Doing some processing " + Thread.currentThread().getName());
        });

        System.out.println("This will print immediately " + Thread.currentThread().getName());

        try {
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("This will print after 5 seconds " + Thread.currentThread().getName());
    }

    private static void runAsyncOverloadedDemo() {
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

    public static void main(String[] args) {
        System.out.println("--- runAsync() demo ---");
        runAsyncDemo();
        System.out.println();

        System.out.println("--- runAsync() with Executor demo ---");
        runAsyncOverloadedDemo();
        System.out.println();


        System.out.println("--- supplyAsync() demo ---");
        supplyAsyncDemo();
        System.out.println();
        System.out.println("--- supplyAsync() with Executor demo ---");
        supplyAsyncOverloadedDemo();
        System.out.println();
    }

}
