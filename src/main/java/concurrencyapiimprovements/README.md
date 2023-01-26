<details>
<summary>CompletableFuture: Introduction</summary>

Discussion of the newly added `CompletableFuture` interface.

The following topics are covered:
- Introduction to the `CompletableFuture` interface
- Limitations of the `Future` interface
- Creating a `CompletableFuture`
- Asynchronous computation using `runAsync()`
- Asynchronous computation using `supplyAsync()`

### Introduction to `CompletableFuture` interface

A `CompletableFuture` is a class in Java that belongs to the `java.util.concurrent` package.

It is used for asynchronous computation. The code is executed as a non-blocking call in a separate thread, and the result is made available when it is ready.

By doing this, the main thread does not block/wait for the completion of the task, and it can execute other tasks in parallel.

The `CompletableFuture` class implements the `CompletionStage` and `Future` interface. The `CompletionStage` is a promise. It promises that the computation eventually will be done.

Before Java 8, the `Future` interface, which was added in Java 1.5, was available for asynchronous computation. The limitation of the `Future` interface is that it does not have any methods to combine these computations or handle errors. We will address more limitations of the `Future` interface in the next section.

`CompletableFuture` has lots of different methods for composing, combining, & executing asynchronous computation steps, & handling errors.

### Limitations of the `Future` interface

The `Future` interface provides an `isDone()` method to check if computation is done, the `get()` method to get the result of computation, and the `cancel()` method to cancel the computation.

However, there are some limitations of the `Future` interface, which we will discuss here:
1. We cannot perform further action on a `Future`'s result without blocking. We have a `get()` method, which blocks until the computation is complete.
2. `Future` chaining is not possible. If you want to execute one `Future` and then trigger another `Future` once the first one is complete, this is not possible.
3. We cannot combine multiple `Future`s together. If we want to run five different `Future`s in parallel and then combine their result then this is not possible.
4. `Future` does not have any exception handling mechanism.

Looking at all these limitations, Java 8 introduced the `CompletableFuture`.

### Creating a `CompletableFuture`

We can easily create a `CompletableFuture` using the no-arg constructor and provide it to some `Thread`. The problem is that if that `Thread` calls the `get()` method on our `CompletableFuture` object, it blocks until the computation is complete. We can complete the `CompletableFuture` using the `complete()` method.

Here is an example. In the below example, we have a method that returns a `CompletableFuture` of the square of a number.

```java
public Future<String> getSquareAsynchronously(int num) throws InterruptedException {
    CompletableFuture<Integer> completableFuture = new CompletableFuture<>();

    Executors.newCachedThreadPool().submit(() -> {
        Thread.sleep(500);
        // The complete() call will complete this CompetableFuture. 
        completableFuture.complete(num * num);
        return null;
    });

    return completableFuture;
}
```

If we are sure about the result of the computation, we can use the static `completedFuture()` method with an argument that represents a result of this computation.

The `get()` method of the `Future` will never block.

```java
import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo {
    public static void main(String[] args) {
        CompletableFuture<String> completableFuture = CompletableFuture.completedFuture("Hello World");
        try {
            System.out.println(completableFuture.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

#### Output

```
Hello World
```

### Asynchronous computation using `runAsync()`

The `runAsync()` is a static method that runs some background tasks asynchronously and returns a `CompletableFuture<Void>`. This method takes a `Runnable` as a parameter.

This method is particularly useful if we just need to run some code in parallel but do not want any result in return.

In the below example, we will run a task using `runAsync()`. This will start running the code in a parallel thread.

Then, we immediately print a statement.

After that, we will call the `get()` method on our `Future` object. This will block the main thread.

Once our parallel thread completes its execution, the main thread will continue.

```java
import java.util.concurrent.*;

public class CompletableFutureDemo {
    public static void main(String[] args) {
        // Passing a runnable to runAsync() method. 
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
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("This will print after 5 seconds " + Thread.currentThread().getName());
    }
}
```

#### Output

```
This will print immediately main
Doing some processing ForkJoinPool.commonPool-worker-1
This will print after 5 seconds main
```

In the previous example, we are providing only the `Runnable` object to the `runAsync()` method.

By default, asynchronous execution uses `ForkJoinPool.commonPool()`, which uses daemon threads to execute the `Runnable` task.

However, if we want, we can provide our own `Executor` to the `runAsync()` method as well. Here is the code for it.

```java
import java.util.concurrent.*;

public class CompletableFutureDemo {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(5);

        // Passing a runnable and executor as parameter to runAsync() method.
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
    }
}
```

#### Output

```
This will print immediately
Doing some processing
This will print after 5 seconds
```

### Asynchronous computation using `supplyAsync()`

If we need to get the result of the computation, we should use `supplyAsync()`. It takes a `Supplier<T>` as input and returns `CompletableFuture<T>` where `T` is the type of the value obtained by calling the given supplier.

```java
import java.util.concurrent.*;

public class CompletableFutureDemo {
    public static void main(String[] args) {
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
            System.out.println(future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("This will print after 5 seconds");
    }
}
```

#### Output

```
This will print immediately
Hello World
This will print after 5 seconds
```

There is an overloaded version of `supplyAsync()` method as well. It takes a `Supplier<T>` and an `Executor` as input.

Below is an example.

```java
import java.util.concurrent.*;

public class CompletableFutureDemo {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(5);

        /*
        Passing a Runnable and ExecutorService as parameters to runAsync() method.
        The static method call Executors.newFixedThreadPool(5) could also be passed as the Executor argument, but as a
        consequence the thread pool would not be able to `shutdown()` and the application would not terminate properly.
        */
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
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
```

#### Output

```
This will print immediately
Hello World
This will print after 5 seconds
```

</details>


<details>
<summary>CompletableFuture: Processing Results</summary>

Discussion of how to process the result of a `CompletableFuture`.

- Processing the result of a `CompletableFuture`
  - `thenApply()`
  - `thenApplyAsync(Function<T, R> function)`
  - `thenApplyAsync(Function<T, R> function, Executor executor)`
  - `thenAccept()`
  - `thenRun()`

In the previous section, we looked at `CompletableFuture`. We discussed how to create a `CompletableFuture` object and how to run tasks asynchronously.

In this section, we will look at how to process the result of a `CompletableFuture`.

### Processing the result of `CompletableFuture`

Suppose we have a `CompletableFuture` and we need to process the result of its execution. Now, the `get()` method of `CompletableFuture` is blocking. This means we need to wait until we get the result of the first task. After getting the result, we can modify the result.

For our system to be truly asynchronous we should be able to attach a callback to the `CompletableFuture`, which should be automatically executed when the `Future` completes. That way, we won't need to wait for the result, and we can write the logic that needs to be executed after the completion of the `Future` inside our callback function.

There are a few ways in which we can do this. We will look at each of them one by one.

### 1) `thenApply()`

The `thenApply()` method accepts a `Function<T, R>` instance as parameter. As we have discussed earlier, the `Function<T, R>` interface takes in a parameter of type `T` and returns a result of type `R`.

The `thenApply()` method uses the `Function<T, R>` instance to process the result and returns a `Future` that holds a value returned by the function, i.e., `CompletableFuture<R>`.

In the below example, we have a `CompletableFuture` that returns an `Integer`. Then, we call the `thenApply()` method to double the result of the `CompletableFuture` and return the final result.

```java
import java.util.concurrent.*;

public class CompletableFutureDemo {
    public static void main(String[] args) {
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
}
```

#### Output

```
ForkJoinPool.commonPool-worker-1
ForkJoinPool.commonPool-worker-1
100
```

### 2) `thenApplyAsync(Function<T, R> function)`

If you look at the output of the above example closely, you will observe that the same thread executes the code in `supplyAsync()` and `thenApply()`. Moreover, if `supplyAsync()` completes very fast then `thenApply()` executes in the main thread.

To achieve actual asynchronous behavior, all the operations should be executed by a different thread. We can achieve this by using the `thenApplyAsync()` method.

This method executes the code in a common thread created by `ForkJoinPool`.

Below is an example of this.

```java
import java.util.concurrent.*;

public class CompletableFutureDemo {
    public static void main(String[] args) {
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
        });
    
        try {
            System.out.println(resultFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
```

#### Output

```
ForkJoinPool.commonPool-worker-1
ForkJoinPool.commonPool-worker-1
100
```

### 3) `thenApplyAsync(Function<T, R> function, Executor executor)`

There is one overloaded version of `thenApplyAsync()` as well. It takes a `Function<T,R>` and an `Executor` as input. By using this method, we get full control over our asynchronous processing flow.

Below is the example for the same.

```java
import java.util.concurrent.*;

public class CompletableFutureDemo {
    public static void main(String[] args) {
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
}
```

#### Output

```
ForkJoinPool.commonPool-worker-1
pool-1-thread-1
100
```

### 4) `thenAccept()`

The `thenAccept()` method is used if we don't want to return anything from our callback function.

This method takes a `Consumer<T>` as a parameter and returns a `CompletableFuture<Void>`.

```java
import java.util.concurrent.*;

public class CompletableFutureDemo {
    public static void main(String[] args) {
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
}
```

#### Output

```

```

### 5) `thenRun()`

The `thenRun()` method is also used if we don't want to return anything from our callback function.

This method takes a `Runnable` as a parameter and returns a `CompletableFuture`.

The difference between `thenAccept()` and `thenRun()` is that the `thenAccept()` method has access to the result of the `CompletableFuture` on which it is attached. Whereas `thenRun()` doesn't even have access to the `Future`'s result.

```java
import java.util.concurrent.*;

public class CompletableFutureDemo {
    public static void main(String[] args) {
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
}
```

#### Output

```

```

---

The next section discusses how to chain `CompletableFuture`s.

</details>


