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


<details>
<summary>CompletableFuture: Chaining</summary>

Discussion of how to chain `CompletableFuture`s.

The following topics are covered:
- `thenCompose()`
- `thenCombine()`

Until now, we have looked at how to create a `CompletableFuture` and how to add callbacks.

One more interesting thing that we can do is combine `CompletableFuture` instances in a chain of computation steps. Suppose we want to get some data from a service and save it to the database. We can write two `CompletableFuture` instances and chain them together. The first instance will complete and share its result to the second instance.

There are two methods which help us achieve this. The first one is `thenCompose()`, and the second one is `thenCombine()`. We will look at each one of them below.

### 1) `thenCompose()`

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
    
        // Calling thenCompose() which takes a Function as parameter. 
        // It takes a number as input and returns a CompletableFuture of double of number.
        CompletableFuture<Integer> resultFuture = future.thenCompose(
            num -> CompletableFuture.supplyAsync(() -> num * 2)
        );
    
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
100
```

### 2) `thenCombine()`

In the previous example, we used `thenCompose()` which takes the output of a `Supplier` as a parameter. However, if we want to execute two independent `Futures` and do something with their results, we can use the `thenCombine()` method.

It accepts a `Future` and a `BiFunction` to process both results.

We will look at the same example that we looked at for `thenCompose()` but this time, we will use `thenCombine()`.

The callback function passed to `thenCombine()` will be called when both the futures are executed.

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
}
```

#### Output

```
70
```

---

The next section discusses how to combine the results of an arbitrary number of futures together.

</details>


<details>
<summary>Completable Future: Combining the Results of Futures</summary>

Discussion of how we can combine the results of an arbitrary number of futures together.

The following topics are covered:
- `allOf()`
- `join()`
- `anyOf()`

In the previous lesson, we used the `thenCombine()` and `thenCompose()` methods to combine the result of two futures.

If we need to run multiple futures in parallel and combine their result then we can use the `allOf()` and `anyOf()` methods.

### 1) `allOf()`

Here are a few important points regarding `allOf()` method:
1. It returns a new `CompletableFuture` that is completed when all of the given `CompletableFutures` are completed.
2. If any of the given `CompletableFutures` complete exceptionally, the returned `CompletableFuture` also completes, with a `CompletionException` holding this exception as its cause.
3. The results, if any, of the given `CompletableFuture`s are not reflected in the returned `CompletableFuture`, but they may be obtained by inspecting them individually.
4. If no `CompletableFutures` are provided, the `allOf()` method returns a `CompletableFuture` completed with the value null.

```java
import java.util.concurrent.*;

public class CompletableFutureDemo {
    public static void main(String[] args) {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> 50);
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> 40);
        CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(() -> 30);

        CompletableFuture<Void> finalFuture = CompletableFuture.allOf(future1, future2, future3);

        try {
            finalFuture.get();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Code that should be executed after all the futures complete.");
    }
}
```

#### Output

```
Code that should be executed after all the futures complete.
```

### 2) `join()`

Since the `allOf()` method returns a `CompletableFuture<Void>`, we can't combine the result of all the futures. We need to manually get the result of all the futures.

We can use the `join()` method to combine the result of all futures. The join method returns the result value when complete, or it throws an (unchecked) exception if completed exceptionally.

```java
import java.util.Optional;
import java.util.concurrent.*;
import java.util.stream.Stream;

public class CompletableFutureDemo {
    public static void main(String[] args) {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> 50);
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> 40);
        CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(() -> 30);

        Optional<Integer> maxElement = Stream.of(future1, future2, future3)
            .map(CompletableFuture::join) // This will return the stream of results of all futures.
            .max(Integer::compareTo);
        
        System.out.println("The max element is " + maxElement);
    }
}
```

#### Output

```
The max element is Optional[50]
```

### 3) `anyOf()`

Here are a few important points regarding the `anyOf()` method:
1. It returns a new `CompletableFuture` that is completed when any of the given `CompletableFuture`s complete with the same result.
2. If it is completed exceptionally, the returned CompletableFuture also does so, with a `CompletionException` holding this exception as its cause.
3. If no `CompletableFuture`s are provided, it returns an incomplete `CompletableFuture`.

```java
import java.util.concurrent.*;

public class CompletableFutureDemo {
    public static void main(String[] args) {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> 50);
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> 40);
        CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(() -> 30);

        // The first completed future will be returned.
        CompletableFuture<Object> firstCompletedFuture = CompletableFuture.anyOf(future1, future2, future3);

        try {
            System.out.println("The first completed future value is " + firstCompletedFuture.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("This should be printed after any of the futures complete.");
    }
}
```

#### Output

```
The first completed future value is 50
This should be printed after any of the futures complete.
```

---

The next section discusses a new (as of Java 8) kind of `Lock` class called the `StampedLock`.

</details>


<details>
<summary>StampedLock</summary>

Discussion of a new kind of Lock class introduced in Java 8.

The following topics are covered:
- The `ReentrantReadWriteLock` and its drawbacks
- The improvements provided by `StampedLock`
- Non-blocking lock methods
- Optimized reading
- Converting lock modes
  - `tryConvertToWriteLock(long stamp)`
  - `tryConvertToReadLock(long stamp)`
  - `tryConvertToOptimisticReading(long stamp)`

### The `ReentrantReadWriteLock` and its drawbacks

Before Java 8 we had a `ReentrantReadWriteLock` class that was used for reading and writing data in a thread-safe manner.

Here are a few of the important points about `ReentrantReadWriteLock`:
1. Multiple threads can acquire a read lock simultaneously.
2. Only one thread can acquire a write lock.
3. If a thread wants to acquire a write lock and there are some threads that have read lock, the thread will wait until all the threads release the read lock.

There are a few problems with using the `ReentrantReadWriteLock` class:
1. It can lead to starvation.
2. Sometimes it can be significantly slower than other synchronizers.

### The improvements provided by `StampedLock`

To overcome these disadvantages, `StampedLock` is added. Apart from providing separate read and write locks, `StampedLock` also has a feature for **optimistic** locking for reading operations.

`StampedLock` also provides a method to upgrade read lock to write lock, which is not in `ReentrantReadWriteLock` in Java.

The `StampedLock` class provides three locking modes:
1. Read
2. Write
3. Optimistic read

Let's look at a basic example of `StampedLock`. In the below example we have used a few operations that are available in the `StampedLock` class.

**a)** `readLock()` - This method is used to acquire the read lock. This method returns a stamp that should be used while releasing the lock.
**b)** `unlockRead(long stamp)` - This method is used to release the read lock. This method takes a stamp as an input. If the stamp provided does not match, `IllegalStateException` is thrown.
**c)** `writeLock()` - This method is used to acquire the write lock. This method returns a stamp that should be used while releasing the lock.
**d)** `unlockWrite(long stamp)` - This method is used to release the write lock. This method takes a stamp as an input. If the stamp provided does not match then `IllegalStateException` is thrown.

```java
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.StampedLock;

public class StampedLockDemo {
    static Map<String, Integer> data = new HashMap<>();
    static StampedLock lock = new StampedLock();

    // Method to read data from the Map.
    public static Integer readDataFromMap(String key) {
        long stamp = lock.readLock();
        try {
            return data.get(key);
        } finally {
            lock.unlockRead(stamp);
        }
    }

    // Method to write data to the Map.
    public static void writeDataToMap(String key, Integer value) {
        long stamp = lock.writeLock();
        try {
            data.put(key, value);
        } finally {
            lock.unlockWrite(stamp);
        }
    }

    public static void main(String[] args) {
        writeDataToMap("ray", 123);
        Integer val = readDataFromMap("ray");
        System.out.println(val);
    }
}
```

#### Output

```
123
```

### Non-blocking lock methods

The `readLock()` and `writeLock()` methods discussed above are blocking methods. This means that if a thread `t1` tries to acquire a read lock and some other thread, like `t2` has already acquired a write lock, the thread `t1` will block.

If we want, our thread should not block. We can use one of the following methods:

1. `tryReadLock()` - Acquire the lock if it is immediately available otherwise don’t block.
2. `tryWriteLock()` - Acquire the lock if it is immediately available otherwise don’t block.
3. `tryReadLock(long time, TimeUnit unit)` - Try to acquire the lock till the provided time limit.
4. `tryWriteLock(long time, TimeUnit unit)` - Try to acquire the lock until the provided time limit.

Let's look at an example of this.

```java
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.StampedLock;

public class StampedLockDemo {
    static Map<String, Integer> data = new HashMap<>();
    static StampedLock lock = new StampedLock();

    // Method to read data from the Map. Since we are using tryReadLock(), the thread will not block. 
    public static Integer readDataFromMap(String key) {
        long stamp = lock.tryReadLock();
        int result = 0;
        if (stamp != 0L) {
            try {
                result = data.get(key);
            } finally {
                lock.unlockRead(stamp);
            }
        }
        return result;
    }

    // Method to write data to the Map. Since we are using tryWriteLock(), the thread will not block.
    public static void writeDataToMap(String key, Integer value) {
        long stamp = lock.tryWriteLock();
        if (stamp != 0L) {
            try {
                data.put(key, value);
            } finally {
                lock.unlockWrite(stamp);
            }
        }
    }

    public static void main(String[] args) {
        writeDataToMap("ray", 123);
        Integer val = readDataFromMap("ray");
        System.out.println(val);
    }
}
```

#### Output

```
123
```

### Optimized reading

Acquiring and releasing a lock is a costly process and can lead to starvation.

Suppose we have a use case where data is read frequently but rarely updated. In this case, it is not advisable to get a read lock every time we are reading.

In such situations, we can use `tryOptimisticRead()` for our reading operations. Here is how `tryOptimisticRead()` works.

Suppose thread `t1` tries to get an optimistic lock.
1. If some other thread has already acquired a write lock, thread t1 returns. It is not able to acquire the lock.
2. If some other thread has already acquired a read lock then `tryOptimisticRead()` returns an **observation stamp**.

<blockquote>Please note that we have not acquired a lock. We have just received an observation stamp.</blockquote>

3. Now, thread `t1` completes the reading, and then it calls the `validate(long stamp)` method. This method tells if a write operation was generated after the **observation stamp**.
4. If the validation is successful, it means we have the most recent data, and we are good.
5. If the validation is not successful, it means that we may not have the most recent data, and we need to do something else.

So, this is the whole concept of optimistic locking. The benefit of optimizing locking is that we are not actually acquiring the lock, so it is a cheap operation.

```java
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.StampedLock;

public class StampedLockDemo {
    static Map<String, Integer> data = new HashMap<>();
    static StampedLock lock = new StampedLock();

    public static Integer readDataFromMap(String key) {
        int result = 0;
        long stamp = lock.tryOptimisticRead();

        if (stamp != 0L) {
            result = data.get(key);
        }

        if (!lock.validate(stamp)) {
        // This means that the data was modified after we called optimistic read.
        // Do extra work here to get the latest data.
        }
        return result;
    }

    public static void writeDataToMap(String key, Integer value) {
        long stamp = lock.tryWriteLock();
        if (stamp != 0L) {
            try {
                data.put(key, value);
            } finally {
                lock.unlockWrite(stamp);
            }
        }
    }

    public static void main(String[] args) {
        writeDataToMap("ray", 123);
        Integer val = readDataFromMap("ray");
        System.out.println(val);
    }
}
```

#### Output

```
123
```

### Converting lock modes

In the `StampedLock` class, it is possible to convert one lock mode to another, i.e., we can convert a read lock to a write lock and vice versa.

We can convert the locks' modes using the following methods:

### 1. `tryConvertToWriteLock(long stamp)`

- If the lock we are trying to convert is already a write lock, then return the lock.
- If the lock we are trying to convert is a read lock and a write lock is available then return the write lock and release the read lock.
- If the lock we are trying to convert is an optimistic read lock, then return the write lock if available.
- Return zero.

### 2. `tryConvertToReadLock(long stamp)`

- If the lock we are trying to convert is already a read lock then return the lock.
- If the lock we are trying to convert is a write lock then return the read lock and release write lock.
- If the lock we are trying to convert is an optimistic read lock, then return the read lock if it is available.
- Return zero.

### 3. `tryConvertToOptimisticRead(long stamp)`

- If the stamp represents an optimistic read lock, then return it (if it is validated).
- If the stamp represents a lock then release the lock and return an observation stamp.
- Return zero.

---

The next section discusses the `Time` API.

</details>