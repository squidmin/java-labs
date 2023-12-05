# TreeSet

## TreeSet: Creation and Insertion

**Topics**:

- Difference between a `HashSet` and a `TreeSet`
- Creating a `TreeSet`
  - Using the no-arg constructor
  - Using a constructor with `Comparator` as an argument
  - Using a constructor with a `Collection` type argument
  - Using a constructor with the argument type `SortedSet`
- Inserting an element into a `TreeSet`
  - Inserting a single element
  - Inserting multiple elements

Java **TreeSet** class implements the **Set** interface that uses a tree for storage.
It inherits the **AbstractSet** class and implements the **NavigableSet** interface.

Some of the features of **TreeSet** are:
1. **TreeSet** does not allow duplicate elements.
2. **TreeSet** class doesn't allow null elements.
3. Since elements are stored in a tree, the access and retrieval times are quite fast in a **TreeSet**.
4. The elements are stored in ascending order in a **TreeSet**.

### Difference between a `HashSet` and a `TreeSet`

1. The `HashSet` allows one `null` element, whereas a `TreeSet` does not allow a `null` element.
2. The elements are stored in random order in a `HashSet`, whereas they are stored in sorted order in a `TreeSet`.
3. `HashSet` is faster than `TreeSet` for operations like add, remove, contains, size, etc.

### Creating a `TreeSet`

Before we look at the different methods to create a `TreeSet`, we'll discuss one very important prerequisite to store the elements in a `TreeSet`.
Since all the elements are stored in sorted order in a `TreeSet`, storing elements should either implement the `Comparable` interface or a custom `Comparator` while creating the `TreeSet`.

Let's discuss the different methods to create a `TreeSet`.

#### Using the no-arg constructor

A `TreeSet` internally uses a `TreeMap`. When an instance of `TreeSet` is created using the no-arg constructor it internally creates an empty instance of `TreeMap`.

Below is the code syntax to create a `TreeSet`.

```
Set<Integer> set = new TreeSet<>();
```

#### Using a constructor with `Comparator` as an argument

If the objects that we are storing in a `TreeSet` do not implement the `Comparable` interface or if we need to store the elements in descending order, then we can provide a custom `Comparator` while creating the `TreeSet`.
Now when the elements are stored in the `TreeSet`, they are sorted as per the logic provided by the `Comparator`.

#### Using a constructor with `Collection` type argument

A `TreeSet` can be created from another `Collection` as well. The elements are stored in ascending order irrespective of the order in which the elements are stored in the `Collection`.

#### Using a constructor with the argument of type `SortedSet`

This constructor behaves as a copy constructor and creates a new sorted set with the same elements and the same ordering of the provided sorted set.

```java
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class TreeSetDemo {
    
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(21);
        list.add(32);
        list.add(44);
        list.add(11);
        list.add(54);
        
        TreeSet<Integer> set = new TreeSet<>(list);
        System.out.println("TreeSet elements in ascending order: " + set);
    }
    
}
```

### Inserting an element into a `TreeSet`

There are two methods to insert an element in a `TreeSet`:

#### Inserting a single element

To insert a single element, we can use the `add(E e)` method.
This method returns `true` if the element is inserted, and it returns `false` if the element is already present.

#### Inserting multiple elements

We can insert multiple elements in a `TreeSet` using the `addAll(Collection<> c)` method.

```java
import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetDemo {
    
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(21);
        set.add(32);
        set.add(44);
        set.add(11);
        set.add(54);
        System.out.println("TreeSet elements in ascending order: " + set);
        
        // This TreeSet will store the elements in reverse order.
        TreeSet<Integer> reverseSet = new TreeSet<>(Comparator.reverseOrder());
        reverseSet.add(21);
        reverseSet.add(32);
        reverseSet.add(44);
        reverseSet.add(11);
        reverseSet.add(54);
        System.out.println("TreeSet elements in descending order: " + reverseSet);
    }
    
}
```

---

## TreeSet: Fetching and Removal

Fetching and removal operations in `TreeSet`.

**Topics**:

- Fetching an element from a TreeSet
  - Fetching the first element
  - Fetching the last element
  - Fetching a subset of elements
  - Fetching elements that are smaller than the given element
  - Fetching elements that are greater than the given element
- Removing an element from a TreeSet
- Additional operations on a TreeSet

### Fetching an element from a TreeSet

The following methods can be used to fetch elements from a `TreeSet`.

#### Fetching the first element

We can fetch the first element in the `TreeSet` using the `first()` method.
If the `TreeSet` is empty, then `NoSuchElementException` is thrown.

#### Fetching the last element

We can fetch the last element in the `TreeSet` using the `last()` method.
If the `TreeSet` is empty, then `NoSuchElementException` is thrown.

#### Fetching a subset of elements

We can use the `subset(E fromElement, E toElement)` method to fetch a subset of `TreeSet` within a given range.
This method will return the elements ranging from `fromElement` to `toElement`.
Note that `fromElement` is inclusive and `toElement` is exclusive.

#### Fetching elements that are smaller than the given element

The `headSet(E toElement)` method returns all the elements that are smaller than the provided element.
The `toElement` is not inclusive.

#### Fetching elements that are greater than the given element

The `tailSet(E fromElement)` method returns all the elements which are greater than the provided element.
The `fromElement` is not inclusive.

```java
import java.util.TreeSet;

public class TreeSetDemo {
    
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(21);
        set.add(32);
        set.add(44);
        set.add(11);
        set.add(54);
        set.add(3);
        set.add(9);
        set.add(41);

        System.out.println("Fetching the first element in TreeSet: " + set.first());
        System.out.println("Fetching the last element in TreeSet: " + set.last());
        System.out.println("Fetching all the elements less than 40: " + set.headSet(40));
        System.out.println("Fetching all the elements greater than 40: " + set.tailSet(40));
    }
    
}
```

#### Removing an element from a TreeSet

To remove an element from a `TreeSet`, the `remove(Object o)` method can be used.
This method returns `true` if the element is removed and returns `false` if the element is not present in the `TreeSet`.

```java
import java.util.TreeSet;

public class TreeSetDemo {

    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(21);
        set.add(32);
        set.add(44);
        set.add(11);
        set.add(54);
        set.add(3);
        set.add(9);
        set.add(41);

        System.out.println("Removing 44 from TreeSet: " + set.remove(44));
        System.out.println("Removing 100 from TreeSet: " + set.remove(100));
    }

}
```

#### Additional operations on a TreeSet

1. The `isEmpty()` method can be used to check if the `TreeSet` is empty or contains some elements.
2. The `size()` method can be used to get the size of the `TreeSet`.
3. The `contains(Object o)` method is used to check if a particular element is present in the `TreeSet` or not.

```java
import java.util.TreeSet;

public class TreeSetDemo {
    
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        System.out.println("Checking if TreeSet is empty: " + set.isEmpty());
        System.out.println("Checking the TreeSet size: " + set.size());
        System.out.println("Checking if TreeSet contains 44: " + set.contains(44));
        
        set.add(21);
        set.add(32);
        set.add(44);
        set.add(11);
        
        System.out.println("Checking if TreeSet is empty: " + set.isEmpty());
        System.out.println("Checking the TreeSet size: " + set.size());
        System.out.println("Checking if TreeSet contains 44: " + set.contains(44));
    }
    
}
```

---

## Exercises

### Problem 1: Numbers greater than 50

```java
import java.util.TreeSet;

public class TreeSetExercise {
    
    public static void main(String[] args) {
        int[] numbers = { 1, 4, 5, 2, 34, 66, 5, 4, 33, 45, 6, 8, 56, 76, 78, 98, 34, 37, 12, 12, 23, 43, 54, 56 };
        TreeSet<Integer> set = new TreeSet<>();
        Arrays.stream(numbers).forEach(set::add);
        System.out.println("Fetching all the elements greater than 50: " + set.tailSet(50));
    }
    
}
```

### Problem 2: Smallest and largest number in array

```java
import java.util.Comparator;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class TreeSetExercise {

    public static void main(String[] args) {
        int[] numbers = {1, 4, 5, 2, 34, 66, 5, 4, 33, 45, 6, 8, 56, 76, 78, 98, 34, 37, 12, 12, 23, 43, 54, 56};
        TreeSet<Integer> set = new TreeSet<>();
        Arrays.stream(numbers).forEach(set::add);
        System.out.println("Largest number in the array: " + set.stream().sorted(Comparator.reverseOrder()).toList().get(0));
        System.out.println("Smallest number in the array: " + set.stream().sorted().toList().get(0));
    }

}
```
