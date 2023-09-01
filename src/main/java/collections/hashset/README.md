# `HashSet`

<details>
<summary>HashSet: Creation and insertion</summary>

`HashSet` creation and insertion.

The following topics are covered:
- Creating a `HashSet`
  - Using the no-arg constructor
  - Using the constructor that takes initial capacity as a parameter
  - Using the constructor that takes initial capacity and load factor as parameters
  - Using the constructor that takes another `Set` as a parameter
- Inserting an element into a `HashSet`
- Fetching an element from a `HashSet`

`HashSet` is the class in the `java.util` package which implements the `Set` interface.
Some of the features of `HashSet` are:

1. `HashSet` does not allow duplicate elements
2. `HashSet` allows only one null element
3. The elements are inserted in random order in a `HashSet`
4. A `HashSet` is internally backed by a `HashMap`

### Creating a `HashSet`

There are four different constructors available to create a `HashSet` in Java:

### Using the no-arg constructor:

The simplest way to create a HashSet is by using a no-arg constructor.
This constructor creates a `HashSet` with an initial capacity of `16` and a load factor of `0.75`.

Below is the code syntax to create a `HashSet`.

```
Set<Integer> set = new HashSet<>();
```

> Load factor is a number that defines when a `Set` should be resized.
> If the load factor is 0.75, then the `Set` should be resized when it is 75% full.

#### Using the constructor that takes initial capacity

We can also provide the initial capacity while creating the `HashSet`.
If we are already aware that our `HashSet` will contain more than 16 elements, then it is better to provide some initial capacity as it reduces the number of resizes.
In this case, also, the default load factor (0.75) is used.

#### Using the constructor that takes initial capacity and load factor

We can also provide initial capacity along with the load factor while creating the `HashSet`.
If we don't want frequent resizing, we can set the load factor to a higher number.

#### Using the constructor that takes another `Set` as a parameter

We can also create a `HashSet` using another `Set` by passing it to the constructor.
The newly created `HashSet` will have the same size as that of the passed `Set`, whereas the load factor will default to 0.75.

#### Inserting an element into a `HashSet`

There is an `add(E e)` method available that inserts an element into the `HashSet`.
If the element is not already present, then this method puts the element and returns `true`.
If the element is already present, then it returns `false`.

```java
import java.util.HashSet;
import java.util.Set;

public class HashSetDemo {
    
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        
        set.add(23);
        set.add(34);
        set.add(56);

        System.out.println(set.contains(34));
    }
    
}
```

</details>


<details>
<summary>HashSet: Operations</summary>

Some operations that can be done on a `HashSet`.

Topics:
- Removing an element from a `HashSet`
  - Using the `remove(Object o)` method
  - Using the `clear()` method
  - Checking if the `HashSet` is empty

### Removing an element from a `HashSet`

Below are ways that an element can be removed from a `HashSet`.

#### Using the `remove(Object o)` method

We can use the `remove(Object o)` method to remove an element from a `HashSet`.
This method takes an object that needs to be removed as a parameter.
If the element is removed, then this method returns `true`.
If the element is not present, then it returns `false`.

#### Using the `clear()` method

We can use the `clear()` method to remove all the elements from a `HashSet`.

```java
import java.util.HashSet;
import java.util.Set;

public class HashSetDemo {

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();

        set.add(23);
        set.add(34);
        set.add(45);

        set.remove(23);

        System.out.println("HashSet after removing one element: " + set);
        set.clear();
        System.out.println("HashSet after removing all elements: " + set);
    }

}
```

#### Checking if the `HashSet` is empty

We can check if the `HashSet` is empty using the `isEmpty()` method.
This method returns

- `true` if the `Set` doesn't contain any elements; or
- `false` if the `Set` contains at least one element.

```java
import java.util.HashSet;
import java.util.Set;

public class HashSetDemo {
    
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        
        set.add(23);
        set.add(34);
        set.add(45);

        System.out.println(set.isEmpty());
    }
    
}
```

</details>


<details>
<summary>HashSet: Iteration and sorting</summary>

## Iterating a HashSet

Below are the different methods to iterate over a `HashSet`.

### Using `for` loop

A `HashSet` can be easily iterated using an enhanced `for` loop as shown below:

```java
import java.util.HashSet;
import java.util.Set;

public class HashSetDemo {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(23);
        set.add(34);
        set.add(56);
        for (int i : set) {
            System.out.println();
        }
    }
}
```

### Using `forEach()` method

We can use the `forEach(Consumer<? super T> action)` method defined in the `Iterable` class.
This method was introduced in Java 8.
It accepts an action that needs to be performed for each element as a parameter.

```java
import java.util.HashSet;
import java.util.Set;

public class HashSetDemo {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(23);
        set.add(34);
        set.add(56);
        set.forEach(System.out::println);
    }
}
```

### Sorting a `HashSet`

Since a `HashSet` stores the elements in random order, it is not possible to store the elements in a `HashSet` in sorted order.
If we want to sort the elements of a `HashSet`, then we should convert it into some other `Collection` such as a `List`, `TreeSet`, or `LinkedHashSet`.

Here we will see how we can convert a `HashSet` to an `ArrayList`, and then we can use the elements from the `List`.
We can create an `ArrayList` by sending another collection to its constructor.
We can sort this `ArrayList` using the `sort()` method of the `Collections` class.

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HashSetDemo {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(23);
        set.add(34);
        set.add(56);
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        list.forEach(System.out::println);
    }
}
```

</details>


<details>
<summary>HashSet: Exercise</summary>

**Problem**: Find the duplicate element

You are given an array in which all the elements are unique except one element.
You need to find the duplicate element.

For example, the array is: `[12, 34, 1, 56, 43, 34, 65]`

The output should be `34` since it is the only duplicate element.

The problem should be done in **O(_n_)** complexity, and the array is not sorted.

### Code

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HashSetExercise {
    public static void main(String[] args) {
        int[] data = { 12, 34, 1, 56, 43, 34, 65 };
        int duplicate;
        Set<Integer> dataSet = new HashSet<Integer>(data);
        
        System.out.println(duplicate);
    }
}
```

### Solution

We know that when we insert an element into a `HashSet` it returns false if the element is already present.
To solve this problem we will insert each element into the `HashSet`.
If, for a particular element, `false` is returned, then it means the element is a duplicate.

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HashSetExercise {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        int[] data = {12, 34, 1,  56, 43, 34, 65};
        int duplicate = 0;
        for (int i : data) {
            if (!set.add(i)) {
                duplicate = i;
                break;
            }
        }
        System.out.println(duplicate);
    }
}
```

</details>
