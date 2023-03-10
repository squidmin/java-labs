package concurrency;

import java.util.concurrent.*;

public class CompletableFutureDemo {

    public static void supplyAsyncDemo() {
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

    public static void supplyAsyncExecutorDemo() {
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

    public static void runAsyncDemo() {
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

    public static void runAsyncExecutorDemo() {
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

    public static void thenApplyDemo() {
        // Create a future which returns an integer.
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return 50;
        });

        // Calling thenApply() which takes a Function as parameter.
        // It takes a number as input and returns double of the number.
        CompletableFuture<Integer> resultFuture = future.thenApply(num -> {
            System.out.println(Thread.currentThread().getName());
            return num * 2;
        });

        try {
            System.out.println(resultFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void thenApplyAsyncDemo() {
        // Create a future which returns an integer.
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return 50;
        });

        // Calling thenApplyAsync() which takes a Function as parameter.
        // It takes a number as input and returns double of the number.
        CompletableFuture<Integer> resultFuture = future.thenApplyAsync(num -> {
            System.out.println(Thread.currentThread().getName());
            return num * 2;
        });

        try {
            System.out.println(resultFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void thenApplyAsyncExecutorDemo() {
        ExecutorService pool = Executors.newFixedThreadPool(5);

        // Create a future which returns an integer.
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return 50;
        });

        // Calling thenApplyAsync() which takes a Function as parameter.
        // It takes a number as input and returns double of number.
        CompletableFuture<Integer> resultFuture = future.thenApplyAsync(num -> {
            System.out.println(Thread.currentThread().getName());
            return num * 2;
        }, pool);

        try {
            System.out.println(resultFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        pool.shutdown();
    }

    public static void thenAcceptDemo() {
        // Create a future which returns an integer.
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return 50;
        });

        // Calling thenAccept() which takes a Function as parameter.
        // It takes a number as input and returns double of number.
        future.thenAccept(num -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("The value is " +  num);
        });
    }

    public static void thenRunDemo() {
        // Create a future which returns an integer.
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return 50;
        });

        // Calling thenApply() which takes a Function as parameter.
        // It takes a number as input and returns double of number.
        future.thenRun(() -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("Hello");
        });
    }

    public static void thenCombineDemo() {
        // Create a future which returns an integer.
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return 50;
        });

        // Calling thenCombine() which takes a Function as parameter.
        // It takes a number (num1) as input and returns a CompletableFuture of the sum of num1 and num2.
        CompletableFuture<Integer> resultFuture = future.thenCombine(
            CompletableFuture.supplyAsync(() -> 20), (num1, num2) -> num1 + num2);  // 50 + 20 = 70

        try {
            System.out.println(resultFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        System.out.println("--- runAsyncDemo() ---");
        runAsyncDemo();
        System.out.println();

        System.out.println("--- runAsyncExecutorDemo() ---");
        runAsyncExecutorDemo();
        System.out.println();


        System.out.println("--- supplyAsyncDemo() ---");
        supplyAsyncDemo();
        System.out.println();
        System.out.println("--- supplyAsyncExecutorDemo() ---");
        supplyAsyncExecutorDemo();
        System.out.println();


        System.out.println("--- thenApplyDemo() ---");
        thenApplyDemo();
        System.out.println();

        System.out.println("--- thenApplyAsyncDemo() ---");
        thenApplyAsyncDemo();
        System.out.println();

        System.out.println("--- thenApplyAsyncExecutorDemo() ---");
        thenApplyAsyncExecutorDemo();
        System.out.println();


        System.out.println("--- thenAcceptDemo() ---");
        thenAcceptDemo();
        System.out.println();


        System.out.println("--- thenRunDemo() ---");
        thenRunDemo();
        System.out.println();


        System.out.println("--- thenCombineDemo() ---");
        thenCombineDemo();
        System.out.println();

    }

}
