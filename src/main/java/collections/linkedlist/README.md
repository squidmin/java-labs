# Linked list

## Basics

The following topics are covered:

- Internal implementation of `LinkedList`
- Time complexities for `LinkedList` operations
- Adding an element
- Removing an element
- Searching an element
  - Creating a `LinkedList`
- Using the no-arg constructor
- Using existing Collection
  - Inserting an element into a `LinkedList`
- Inserting a single element at the end
- Inserting a single element at the beginning
- Inserting an element at a particular index
- Inserting multiple elements from another Collection
- Inserting multiple elements from another Collection at a particular index

The `LinkedList` class in Java implements the `List` and the `Deque` interface.
A few of the main features of a `LinkedList` are:

1. The elements are inserted in the order of insertion.
2. It supports duplicate elements.
3. Any number of `null` elements can be added.

<img src="img/01.png" />

<details>
<summary>Internal implementation of LinkedList</summary>

## Internal implementation of `LinkedList`

The `LinkedList` class has a static inner class called `Node`.
This class contains three fields:

- `item`: This contains the value of the current element.
- `next`: This contains the pointer to the next element.
- `prev`: This contains the pointer to the previous element.

Below is the code for the `Node` class:

```java
private static class Node<E> {
    E item;
    Node<E> next;
    Node<E> prev;
    
    Node(Node<E> prev, E element, Node<E> next) {
        this.item = element;
        this.next = next;
        this.prev = prev;
    }
}
```

When an element is added to the `LinkedList`, a new `Node` instance is created.
Depending on where the new node is being added, the `prev` and `next` fields are set.

When a node at index `i` is removed, the `next` field of the node at index `i - 1` is set to the node at `index + 1`.
Similarly, the `prev` field of the node at index `i + 1` is set to node `i - 1`.

<img src="img/02.png" />

</details>


<details>
<summary>LinkedList operations and time complexities</summary>

## Time complexities for `LinkedList` operations

Let's see what the time complexities are for different operations in a `LinkedList`.

### Adding an element

**O(1)**. If we need to search for the position where the `Node` needs to be inserted, the time complexity is **O(n)**, but the element is usually inserted at the beginning or end, which makes it **O(1)**.

The biggest benefit of `LinkedList`, in comparison to an array, is that when new elements are added, the other elements are not re-arranged.

### Removing an element

Removing an element is also an O(1) operation if we are aware of the position of the element that needs to be removed.
If we need to search and remove an element, it is a **O(1)** operation.

### Searching an element

Search an element is a O(n) operation, as the entire `LinkedList` is iterated to search the element in the worst case.

### Creating a `LinkedList`

There are two ways to create a `LinkedList`:

#### Using the no-arg constructor

Creates a linked list of size zero.

```
List<Integer> list = new LinkedList<>();
```

#### Using existing Collection

A linked list can also be created using an existing Collection.
The newly-created `LinkedList` will contain all the elements in the same order as the original Collection.

```
List<Integer> list = new LinkedList<>(existingList);
```

### Inserting an element into a `LinkedList`

#### Inserting a single element at the end

```
LinkedList<Integer> list = new LinkedList<>();
list.add(3);
list.add(1);
list.addLast(5);
```

#### Inserting a single element at the beginning

```
LinkedList<Integer> list = new LinkedList<>();
list.add(3);
list.add(1);
list.addFirst(0);
```

#### Inserting an element at a particular index

```
LinkedList<Integer> list = new LinkedList<>();
list.add(int index, E element)
```

The index should be greater than zero and less than the size of the LinkedList; otherwise, `IndexOutOfBoundsException` is thrown.

#### Inserting multiple elements from another Collection

```
LinkedList<Integer> list = new LinkedList<>();
list.addAll(existingCollection);
```

#### Inserting multiple elements from another Collection at a particular index

```
addAll(int index, Collection c)
```

e.g.,

```
LinkedList<Integer> list = new LinkedList<>();
list.addAll(index, existingCollection);
```

### `ElementInsertionDemo.java`

```java
package collections.linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ElementInsertionDemo {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(3);
        linkedList.add(1);
        linkedList.addLast(5);
        System.out.println(linkedList);

        System.out.println("-".repeat(30));

        linkedList.addFirst(0);
        System.out.println(linkedList);

        System.out.println("-".repeat(30));

        linkedList.add(2, 20);
        System.out.println(linkedList);

        System.out.println("-".repeat(30));

        List<Integer> list = new ArrayList<>();
        list.add(101);
        list.add(102);
        list.add(103);

        linkedList.addAll(3, list);
        System.out.println(linkedList);
    }

}
```

</details>


## Fetching and Removing

**Topics**:

- Fetching an element from a LinkedList
  - Fetching the first element
  - Fetching the last element
  - Fetching an element at a particular index
- Removing an element from a LinkedList
  - Removing the first element
  - Removing the last element
  - Removing an element at a particular index
  - Removing a particular element
- Sorting a linked list

<details>
<summary>Fetching an element from a LinkedList</summary>

#### Fetching the first element

Use the `getFirst()` method to fetch the first element in the list.
If the `LinkedList` is empty, then `NoSuchElementException` is thrown.

#### Fetching the last element

Use the `getLast()` method to fetch the last element in the list.
If the `LinkedList` is empty, then `NoSuchElementException` is thrown.

#### Fetching an element at a particular index

Fetch an element at a particular index using the `getIndex()` method.

The index should be more than zero and less than the size of the `LinkedList`; otherwise, `IndexOutOfBoundsException` is thrown.

### `LinkedListFetchDemo.java`

```java
package collections.linkedlist;

import java.util.LinkedList;

public class LinkedListFetchDemo {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);

        System.out.println(linkedList.getFirst());  // 1
        System.out.println(linkedList.getLast());  // 5
        System.out.println(linkedList.get(2));  // 3
    }

}
```

**Output**

```
1
5
3
```

</details>


<details>
<summary>Removing an element from a LinkedList</summary>

#### Removing the first element

Use the `removeFirst()` method to remove the first element in the list.
If the `LinkedList` is empty, then `NoSuchElementException` is thrown.

#### Removing the last element

Use the `removeLast()` method to remove the last element in the list.
If the `LinkedList` is empty, then `NoSuchElementException` is thrown.

#### Removing an element at a particular index

Remove an element at a particular index by using the `remove(int index)` method.

The index should be more than zero and less than the size of the `LinkedList`; otherwise, `IndexOutOfBoundsException` is thrown.

#### Removing a particular element

Use the `remove(Object o)` method to remove a particular element from the `LinkedList`.
If there is more than one occurrence of a particular element, then the first occurrence is removed.

To remove the last occurrence of an element, use the `removeLastOccurrence()` method.

### `LinkedListRemoveDemo.java`

```java
package collections.linkedlist;

import java.util.LinkedList;

public class LinkedListRemoveDemo {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
    
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(2);
        linkedList.add(4);
        linkedList.add(5);
    
        System.out.println("LinkedList before removing any element: " + linkedList);
    
        linkedList.remove();  // Remove the first element.
        System.out.println("LinkedList after removing the first element: " + linkedList);
    
        linkedList.removeLast();  // Remove the last element.
        System.out.println("LinkedList after removing the last element: " + linkedList);
    
        linkedList.remove(Integer.valueOf(2));  // Remove the first occurrence of 2.
        System.out.println("LinkedList after removing the first occurrence of 2: " + linkedList);
    
        linkedList.removeLastOccurrence(4);
        System.out.println("LinkedList after removing the last occurrence of 4: " + linkedList);
    }

}
```

**Output**

```
LinkedList before removing any element: [1, 2, 3, 4, 2, 4, 5]
LinkedList after removing the first element: [2, 3, 4, 2, 4, 5]
LinkedList after removing the last element: [2, 3, 4, 2, 4]
LinkedList after removing the first occurrence of 2: [3, 4, 2, 4]
LinkedList after removing the last occurrence of 4: [3, 4, 2]
```

</details>


<details>
<summary>Sorting a linked list</summary>

To sort a `LinkedList`, use the `sort()` method of the `Collections` class as shown in the example below.

### `LinkedListSortDemo.java`

```java
package collections.linkedlist;

import java.util.Collections;
import java.util.LinkedList;

public class LinkedListDemo {

	public static void main(String[] args) {
		LinkedList<Integer> linkedList = new LinkedList<>();
		
		linkedList.add(20);
		linkedList.add(2);
		linkedList.add(12);
		linkedList.add(40);
		linkedList.add(76);
		linkedList.add(41);
		linkedList.add(53);
		
		Collections.sort(linkedList);  // Sort the list.
		
		System.out.println(linkedList);
	}
    
}
```

**Output**

```
List before sorting:
[20, 2, 12, 40, 76, 41, 53]

List after sorting:
[2, 12, 20, 40, 41, 53, 76]
```

</details>
