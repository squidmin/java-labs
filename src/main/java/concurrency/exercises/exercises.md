# Exercises: Concurrency in Java

Here are a few code exercises that can help you understand and practice various aspects of Java's concurrency utilities, particularly in JAva 17.

## Exercise 1: Implementing Runnable vs. Extending Thread

**Objective**: Understand the differences between implementing `Runnable` and extending `Thread`, and practice creating threads using both methods.

**Task**: Create two threads, one by extending `Thread` and the other by implementing `Runnable`.
Each thread should print numbers from 1 to 10 with a 500 ms delay between numbers.

## Exercise 2: Synchronization

**Objective**: Learn to manage access to a shared resource using synchronized blocks to prevent race conditions.

**Task**: Create a shared class with a method to increment a counter.
Implement multiple threads that increment this counter 100 times each. Ensure that the final count is correct using synchronization techniques.

## Exercise 3: Producer-Consumer Problem

**Objective**: Implement the classic producer-consumer problem using Java's `BlockingQueue`.

**Task**: Create two classes, Producer and Consumer. The Producer should put numbers into a `BlockingQueue`, and the Consumer should take them out and print them.
Ensure that the Producer waits when the queue is full and the Consumer waits when the queue is empty.

## Exercise 4: Deadlock Creation and Resolution

**Objective**: Understand how deadlocks occur and practice resolving them.

**Task**: Create s simulated deadlock scenario using two resources and two threads.
Each thread should lock one resource and then try to lock the other.
Detect the deadlock and refactor the code to resolve it.

## Exercise 5: Callable and Future

**Objective**: Learn to use `Callable` and `Future` to obtain results from your threads.

**Task**: Create a callable task that returns the sum of all prime numbers within a given range.
Use `ExecutorService` to run the task and `Future` to get the result back.

## Exercise 6: Parallel Streams

**Objective**: Practice using parallel streams to perform operations on large datasets concurrently.

**Task**: Given a large list of customer transactions, use parallel streams to compute the total transaction amount for a particular type of transaction.

## Exercise 7: Atomic Variables

**Objective**: Learn to use atomic variables to ensure thread safety without using synchronization.

**Task**: Implement a thread-safe counter using `AtomicInteger`.
Multiple threads should increment the counter, and the final value should reflect the total increments correctly.

## Exercise 8: Sum Up

**Objective**: Optimize performance of summing up integers.

**Task**: Compute the sum of all the integers from 0 to `Integer.MAX_VALUE`.
  Use two threads to split the range into two parts and have one thread sum for each range.
  Afterwards, add the two half sums to get the combined sum.
  Measure the time taken to complete the computation and print it.
