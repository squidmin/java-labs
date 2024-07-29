# `ThreadLocal`

The `ThreadLocal` class in Java is used to create variables that can only be read and written by the same thread.
Thus, each thread accessing such as variable has its own, independently initialized copy of the variable.

This is useful for maintaining thread confinement, avoiding synchronization, and improving performance in multithreaded environments.

## Key Purposes of `ThreadLocal`

### 1. Thread Confinement

- `ThreadLocal` ensures that the variable is confined to the thread that accesses it.
  This helps in preventing the variable from being shared between threads, which can eliminate issues related to thread interference and memory consistency errors.

### 2. Simplified Sharing

- It allows each thread to have its own instance of a variable.
  This can simplify sharing data across various methods and classes within the same thread without passing the variable explicitly.

### 3. Performance

- Since each thread has its own instance of the variable, there is no need for synchronization when accessing the variable.
   This can lead to improved performance as synchronization can be costly in terms of CPU time and complexity.

## Common Use Cases

### 1. Use Session Data

- In web applications, `ThreadLocal` can be used to store user session data that needs to be accessed throughout a thread's execution, such as user ID, locale, or other session-related information.

### 2. Database Connections

- It can be used to store database connection objects, ensuring that each thread has its own connection, which is essential for thread safety and resource management.

### 3. Formatting

- `ThreadLocal` is commonly used with instances of `SimpleDateFormat` or `DecimalFormat`, which are not thread-safe.
  By using `ThreadLocal`, each thread can have its own formatter instance, avoiding the need for synchronization.

## Example

Here's an example demonstrating the use of `ThreadLocal`:

```java
public class ThreadLocalExample {
    
    // Creating a ThreadLocal variable
    private static ThreadLocal<Integer> threadLocalValue = ThreadLcoal.withInitial(() -> 1);
    
    public static void main(String[] args) {
        // Starting two threads
        Thread thread1 = new Thread(() -> {
            threadLocalValue.set(100);
            System.out.println("Thread 1: " + threadLocalValue.get());
        });
        
        Thread thread2 = new Thread(() -> {
            threadLocalValue.set(200);
            System.out.println("Thread 2: " + threadLocalValue.get());
        });
        
        thread1.start();
        thread2.start();
    }
    
}
```

In this example:

- `threadLocalValue` is a `ThreadLocal` variable initialized with a value of `1`.
- Each thread sets its own value (`100` for `thread1` and `200` for `thread2`) and prints it.
- The output will show that each thread has its own independent value for `threadLocalValue`.

By using `ThreadLocal`, you can avoid shared state between threads, which can simplify the design and implementation of multithreaded applications while improving performance.
