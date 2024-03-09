# Making Collections thread-safe

How collections can be made thread-safe.

**Topics**:

- Making an `ArrayList` thread-safe

Most of the collections such as `ArrayList`, `LinkedList`, `HashSet`, `HashMap`, etc., are not thread-safe.
If two parallel threads modify any of these collections in parallel, the user can get stale data or `ConcurrentModificationException`.

We can use thread-safe alternatives such as `CopyOnWriteArrayList`, `ConcurrentHashMap`, etc., but what if we don't want to use these alternatives?
What if we have already created an `ArrayList`, and now we want to make it thread-safe?

The `Collections` class provides us with the following methods that can be used to make our existing collection thread-safe.

1. `synchronizeCollection(Collection<T> c)`
2. `synchronizedList(List<T> list)`
3. `synchronizedMap(Map<K, V> m)`
4. `synchronizedSet(Set<T> s)`
5. `synchronizedSortedMap(SortedMap<K, V> m)`
6. `synchronizedSortedSet(SortedSet<T> s)`

## Making an `ArrayList` thread-safe

To make an `ArrayList` thread-safe we can use the `synchronizedList()` method.
Let's see how this method works internally.
The `Collections` class contains a static inner class called `SynchronizedList`.
The `synchronizedList()` method is called when the object of this class is returned.
If you look at the implementation of this class below, then you can see that all the methods have been synchronized.

Since all the methods are synchronized, this makes it very slow.
So, we should always try to use the thread-safe implementations instead of making a collection thread-safe using this method.

```java
static class SynchronizedList<E> extends SynchornizedCollection<E> implements List<E> {
    
    private static final long serialVersionUID = -7754090372962971524L;
    
    final List<E> list;
    
    SynchronizedList(List<E> list) {
        super(list);
        this.list = list;
    }
    SynchronizedList(List<E> list, Object, mutex) {
        super(list, mutex);
        this.list = list;
    }
    
    public boolean equals(Object o) {
        if (this == o) { return true; }
        synchronized (mutex) { return list.equals(o); }
    }
    
    public int hashCode() {
        synchronized (mutex) { return list.hashCode(); }
    }
    
    public E get(int index) {
        synchronized (mutex) { return list.get(index); }
    }
    public E set(int index, E element) {
        synchronized (mutex) { return list.add(index, element); }
    }
    public void add(int index, E element) {
        synchronized (mutex) { return list.add(index, element); }
    }
    public E remove(int index) {
        synchronized (mutex) { return list.remove(index); }
    }
    
    // ...
    
}
```

---

## Exercises

Here are some exercises ranging from simple to advanced based on the provided information about making collections thread-safe:

### Simple Exercises:

1. **Understanding Collections**:
    - What are some examples of collections in Java that are not thread-safe?
    - Why might it be problematic to use non-thread-safe collections in a multi-threaded environment?

2. **Basic Synchronization**:
    - Explain what the term "thread-safe" means in the context of Java collections.
    - Describe one potential issue that can arise when multiple threads concurrently modify a non-thread-safe collection.

3. **Using `synchronizedList()`**: Write a Java program that demonstrates how to make an ArrayList thread-safe using `synchronizedList()`.

4. **Concurrent modification**: Create a Java program that simulates concurrent modification exceptions in a non-thread-safe collection like `ArrayList`.
   Then modify the program to use `synchronizedList()` to make the collection thread-safe and prevent the exceptions.

### Intermediate Exercises:

5. **Method Usage**:
    - Choose one method from the `Collections` class provided for making collections thread-safe. Describe its purpose and how it achieves thread safety.
    - Compare and contrast the usage of `synchronizedList()` with `CopyOnWriteArrayList`. When might you choose one over the other?

6. **Implementation Analysis**:
    - Analyze the provided `SynchronizedList` class. What does the `mutex` object represent, and why is it necessary?
    - Identify and explain at least two methods from the `SynchronizedList` class that have been synchronized to ensure thread safety.

7. **Comparing performance**:
   Write two Java programs that perform a significant number of read and write operations on `ArrayList`.
   One program should use `synchronizedList()`, and the other should use `CopyOnWriteArrayList`.
   Measure the execution time of both programs and compare their performance.

8. **Custom thread-safe collection**:
   Ensure that the class provides methods for adding, removing, and accessing elements safely from multiple threads.
   Write a test program to validate the thread safety of your custom collection.

### Advanced Exercises:

9. **Performance Considerations**:
    - Discuss the performance implications of using `synchronizedList()` compared to a non-thread-safe `ArrayList` or a thread-safe alternative like `CopyOnWriteArrayList`.
    - Propose alternative strategies for ensuring thread safety in collections that might offer better performance in specific scenarios.

10. **Custom Thread Safety**:
    - Suppose you need to create a custom collection class that guarantees thread safety. Design a strategy for achieving this without relying on the provided methods in the `Collections` class.
    - Implement your custom thread-safe collection class in Java, ensuring that concurrent modifications are handled safely and efficiently.

11. **Concurrency Testing**:
    - Develop a multi-threaded test scenario to evaluate the thread safety of a collection class. Include multiple threads performing concurrent read and write operations.
    - Utilize techniques such as synchronization, locks, or atomic operations to coordinate access to the collection and identify any potential race conditions or synchronization issues.

12. **Fine-grained locking**:
    - Modify the **custom thread-safe collection** class from the related exercise to use fine-grained locking mechanisms instead of synchronizing the entire collection.
      Implement strategies like lock striping or per-element locking to achieve better concurrency and performance.

13. **Concurrency testing**:
    - Write a Java program that performs stress testing on a thread-safe collection class (e.g., `ConcurrentHashMap`).
      Create multiple threads that concurrently add, remove, and access elements from the collection.
      Use assertions or other validation techniques to ensure that the collection remains in a consistent state under concurrent access.

14. **Atomic operations**:
    Implement a Java program that uses atomic operations (e.g., `AtomicInteger`) to ensure thread safety in a custom collection class.
    Compare the performance of this approach with traditional synchronization techniques.

These exercises involve writing Java code to implement, test, and analyze various aspects of making collections thread-safe.
They cover basic usage, performance considerations, advanced techniques, and concurrency testing.