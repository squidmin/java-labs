# Arrays: Operations

Some operations that can be performed using the `Arrays` class.

**Topics**:

- Converting an `Array` to a `List`
- Checking if two arrays are equal
- Filling an array with default value

## Converting an `Array` to a `List`

We can convert an array into a list using the  `asList()` method.
If any changes are made to the resulting list, then changes are propagated to the original array.
The `asList()` method returns a fixed-size list, so it is not possible to add or remove elements from this list.

```java
import java.util.Arrays;
import java.util.List;

public class ArraysDemo {
    public static void main(String[] args) {
        Integer[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        List<Integer> list = Arrays.asList(numbers);
        System.out.println(list);
    }
}
```

---

## Checking if two arrays are equal

We can use the `equals()` method of the `Arrays` class to check if the two arrays are equal or not.
Two arrays are considered equal if both have the same number of elements and all corresponding pairs of elements in the two arrays are equal.

```java
import java.util.Arrays;

public class ArraysDemo {
    public static void main(String[] args) {
        Integer[] numbers1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        Integer[] numbers2 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        
        boolean isEqual = Arrays.equals(numbers1, numbers2);

        System.out.println("Checking if two arrays are equal: " + isEqual);
    }
}
```

---

## Filling an array with default value

Have you ever encountered a scenario where you need to initialize an array and then fill it with some default value?

If yes, then you might have iterated the array and filled each element with the default value.
This task can be made simple using the `fill()` method of the `Arrays` class.
This method takes an array and a default value as input.
It then assigns the default value to each element of the array.

```java
import java.util.Arrays;

public class ArraysDemo {
    public static void main(String[] args) {
        Integer[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        Arrays.fill(numbers, 20);
        
        for (int i : numbers) {
            System.out.println(i + " ");
        }
    }
}
```

---

## Questions

> **Q**: Which algorithm is used when an array is searched using the `Arrays` class?
> 
> **A**: Binary search

> **Q**: What is the time complexity of binary search?
> 
> **A**: O(log(n))

> **Q**: What will be the output of the following code snippet?
> 
> ```
> int[] numbers = { 1, 3, 5, 6, 7, 8, 9, 10, 11 };
> Arrays.binarySearch(numbers, 4);
> ```
> 
> **A**: `-insertion_point - 1 = -2 - 1 = -3`

> **Q**: What will be the output of the following code snippet?
> 
> ```
> int[] numbers = { 1, 5, 4, 6, 7, 8, 9, 10, 11 };
> Arrays.binarySearch(numbers, 4);
> ```
> 
> **A**: Undefined, since the array isn't sorted.

> **Q**: When we sort an object using the `sort()` method of the `Arrays` class, which of the following algorithms is used?
> 
> **A**: Merge sort

> **Q**: Which operations are not supported on a list created using the `asList()` method?
> 
> **A**: Adding and removing an element.

> **Q**: True or false: If we create the copy of an array using the `copyOf()` method, then any changes in the original array will reflect on the copied array.
> 
> **A**: False.
