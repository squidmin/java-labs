### ArrayLists

<br />

#### Inserting and retrieving elements 

<details>
<summary>Inserting a single element at a given index</summary>

`list.add(int index, E element);`

</details>


<details>
<summary>Inserting multiple elements from another Collection</summary>

`list.addAll(Collection c);`

</details>


<details>
<summary>Inserting multiple elements from another Collection at a particular index</summary>

`list.addAll(int index, Collection c);`

</details>

<br />

#### Operations

<details>
<summary>Removing all the elements within a range</summary>

This method is not defined in the `List` class.
So, it can be used only when the reference type is also `ArrayList` and not `List`.

`list.removeRange(int fromIndex, int toIndex);`

</details>


<details>
<summary>Removing all the elements within a given Collection</summary>

`list.removeAll(Collection c);`

</details>


<details>
<summary>Removing all the elements from the ArrayList</summary>

`list.clear();`

<blockquote>
We saw that <code>remove(int index)</code> removes a method at the given index and <code>remove(Object o)</code> removes the given object from the <code>ArrayList</code>.
Suppose we have an <code>ArrayList</code> that contains five elements, i.e., <code>[13, 21, 43, 2, 9]</code>.
Now, if we do <code>list.remove(2)</code>, then which overloaded method will be called?
Will <code>remove(int index)</code> be called or <code>remove(Object o)</code> be called?
<code>remove(int index)</code> will be called because we are passing a primitive to the <code>remove</code> method.
If we want to delete element **2**, we should call <code>remove(Integer.valueOf(2))</code> because elements are stored in an <code>ArrayList</code> as objects and not primitives.
</blockquote>

</details>


<details>
<summary>Overview: ArrayList element removal</summary>

```java
import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        list.add(60);
        list.add(70);
        list.add(80);

        System.out.println(list);

        list.remove(1);  // This will remove the element at index 1 i.e 20.
        System.out.println(list);

        list.remove(Integer.valueOf(30)); // This will remove 30 from the list
        System.out.println(list);

        list.clear(); //This will remove all the elements from the list.
        System.out.println(list);
    }
}
```

</details>


<details>
<summary>Replacing all the elements of an ArrayList</summary>

```java
import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("apple");
		list.add("banana");

		list.replaceAll((element) -> element.toUpperCase());

		System.out.println(list);
	}
}
```

</details>


<details>
<summary>Updating an element in ArrayList</summary>

`list.set(int index, E e);`

</details>

<br />

#### Iteration

<details>
<summary>Using for loop</summary>

This section is omitted for now.

</details>


<details>
<summary>Using Iterator</summary>

The `iterator()` method in `ArrayList` returns an `Iterator` type object.
The `Iterator` interface declares the below methods that help with iterating an `ArrayList`.

1. `hasNext()` - This method returns true if there are more elements in the list; otherwise, it returns false.
2. `next()` - This method returns the next element in the list. Before calling `next()`, we should always call `hasNext()` to verify that there is an element; otherwise, `NoSuchElementException` will be thrown.
3. `remove()` - This method removes the last element returned by the iterator. It can be called only once per call to the `next()` method.
4. `forEachRemaining(Consumer<? super E> action)` - This method was introduced in Java 8. It performs the given action for each remaining element until all elements have been processed or the action throws an exception. This method's benefit is that we do not need to check if there is a next element every time.

**Example**: Iterating an `ArrayList` using `Iterator`

```java
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListDemo {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(10);

		Iterator<Integer> itr = list.iterator();

		while(itr.hasNext()) {
			System.out.println(itr.next());
		}

		// Iterating using forEachRemaining() method
		System.out.println("Iterating using forEachRemaining() method");
		Iterator<Integer> newItr = list.iterator();
		newItr.forEachRemaining(element -> System.out.println(element));
	}
}
```

If we try to directly remove an element while iterating an `ArrayList` using an iterator, then `ConcurrentModificationException` will also be thrown.
We should always use the `remove()` method in the iterator to remove an element from the `ArrayList`.

The below program will fail because we are trying to delete the element from the list directly.

```java
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListDemo {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(10);

		Iterator<Integer> itr = list.iterator();
		while (itr.hasNext()) {
			int next = itr.next();
			if (next == 30) { list.remove(Integer.valueOf(30)); }
		}
	}
}
```

The code shown below is the correct way to delete an element from the list.

```java
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListDemo {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(10);

		Iterator<Integer> itr = list.iterator();
		while (itr.hasNext()) {
			int next = itr.next();
			if (next == 30) { itr.remove(); }
		}
		System.out.println(list);
	}
}
```

`ConcurrentModificationException` will also be thrown if an element is added to the `ArrayList` after the iterator is created.

```java
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListDemo {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(34);
		list.add(45);

		Iterator<Integer> itr = list.iterator();
		list.add(54);
		while (itr.hasNext()) { System.out.println(itr.next()); }
	}
}
```

</details>


<details>
<summary>Iteration using ListIterator</summary>

The `Iterator` provides very limited capabilities as we can iterate only in the forward direction and we can't update or insert an element to the list while iterating.
To overcome these problems, we can use `ListIterator`.
The `listIterator()` method returns an object of type `ListIterator` which can then be used to iterate the `ArrayList`.

Below are the methods that are available in the `ListIterator` interface.

1. `hasNext()` - This method is used to check if there is a next element in the list when the list is iterated in the forward direction.
2. `next()` - This method returns the next element in the list and advances the cursor position.
3. `hasPrevious()` - This method is used to check if there is a next element in the list when the list is iterated in the backward direction.
4. `previous()` - This method returns the previous element in the list and moves the cursor position backward.
5. `nextIndex()` - This method returns the index of the element that would be returned by a subsequent call to `next()`. It returns the list size if the list iterator is at the end of the list.
6. `previousIndex()` - This method returns the index of the element that would be returned by a subsequent call to `previous()`. It returns **-1** if the list iterator is at the beginning of the list.
7. `remove()` - This method removes the last element that was returned by `next()` or `previous()` from the list. This call can only be made once per call to `next()` or `previous()`. It can be made only if `add()` has not been called after the last call to `next()` or `previous()`.
8. `set(E e)` - This method replaces the last element returned by `next()` or `previous()` with the specified element. This call can be made only if neither `remove()` nor `add()` have been called after the last call to `next()` or `previous()`.
9. `add(E e)` - This method inserts the specified element into the list. The element is inserted immediately before the element that would be returned by `next()`, if any, and after the element that would be returned by `previous()`, if any.

The below example shows `ListIterator` working.

```java
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ArrayListDemo {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);

		// Getting ListIterator
		ListIterator<Integer> listIterator = list.listIterator();

		// Traversing elements
		System.out.println("Forward Direction Iteration:");
		while (listIterator.hasNext()) {
			System.out.println("Next element is " + listIterator.next() + 
			" and next index is " + listIterator.nextIndex());
		}

		// Traversing elements, the iterator is at the end at this point
		System.out.println("Backward Direction Iteration:");
		while (listIterator.hasPrevious()) {
			System.out.println("Previous element is " + listIterator.previous() + 
			" and previous index is " + listIterator.previousIndex());
		}
	}
}
```

</details>


<details>
<summary>Why raw type Collection should be avoided</summary>

Whenever we create a `Collection`, we should provide the type of object it can hold.
This is called parameterized type `Collection`.
A raw type `Collection` does not have any type of safety, and an object of any type can be inserted into it.
In the below example, we have created a raw type `ArrayList`.
Elements of `Integer` and `String` type are added to it.
This code will compile but will fail at run-time with `ClassCastException`.
This would have been avoided if we had used parameterized type.

```java
import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo {
	public static void doSomeWork(List list) {
		list.add("India");
	}

	public static void main(String[] args) {
		List list = new ArrayList<>();
		list.add(10);
		list.add(20);
		doSomeWork(list);

		Integer i = (Integer) list.get(2);
	}
}
```

</details>

<br />

#### Sorting

<details>
<summary>Sorting in ascending order</summary>



</details>
