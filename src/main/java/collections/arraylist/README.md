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
<summary>Explanation</summary>

In Java 8, the `sort(Comparator<? super E> c)` method was added to the `List` interface.
If we look at the implementation of the `Collections.sort()` method, then we will find that it internally calls the `sort()` method of the `List` interface.
The code is shown below:

```
public static <T extends Comparable<? super T>> void sort(List<T> list) {
    list.sort(null);
}
```

Let's see how the `sort()` method if the `List` interface sorts a list.
When the `sort()` method is called, an array containing all elements in this list is created and sorted.
After sorting the array, the list is iterated and each element is reset from the corresponding position in the array.

The elements are first copied to an array and then sorted because it takes less time to sort a _linked list_ using this approach.

</details>


<details>
<summary>Sorting in ascending order</summary>

The `Collections` class contains a `sort(List<T> list)` method, which is used to sort an `ArrayList`.
This method takes an `ArrayList` as input and sorts it in ascending order.

In the `sort(List<T> list)` method, `T` represents the type of object that is stored in the `ArrayList`.
The `Collections.sort(List<T> list)` method takes an `ArrayList` of type `T` object as input.
`T` must implement the `Comparable` interface; otherwise, the code will not compile.

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListSortAscendingDemo {
    
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(36);
        list.add(15);
        list.add(11);
        list.add(83);
        list.add(37);
        list.add(97);
        
        Collections.sort(list);
        System.out.println("ArrayList is in ascending order: " + list);
    }
    
}
```

**Output**:

```
ArrayList is in ascending order: [11, 15, 36, 37, 83, 97]
```

There is another way to sort an `ArrayList` using **streams**, which is a feature added in Java 8.

Once a stream is created, then we can use the `sorted()` method of the **Stream** class, which returns the stream of objects in sorted order.

```java
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayListStreamSortAscendingDemo {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(36);
        list.add(15);
        list.add(11);
        list.add(83);
        list.add(37);
        list.add(97);

        List<Integer> sortedList = list.stream().sorted().collect(Collectors.toList());
        System.out.println("ArrayList is in ascending order: " + list);
    }

}
```

**Output**:

```
ArrayList is in ascending order: [11, 15, 36, 37, 83, 97]
```

</details>


<details>
<summary>Sorting in descending order</summary>

There is another overloaded version of the `sort()` method, i.e., `sort(List<T> list, Comparator<? super T> c)`, which takes a `List` and `Comparator` object as input.

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListSortDescendingDemo {
    
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(36);
        list.add(15);
        list.add(11);
        list.add(83);
        list.add(37);
        list.add(97);
        
        Collections.sort(list, Collections.reverseOrder());
        System.out.println("ArrayList is in descending order: " + list);
    }
    
}
```

**Output**:

```
ArrayList is in descending order: [97, 83, 37, 36, 15, 11]
```

The `ArrayList` can be sorted in reverse order using streams by passing `Comparator.reverseOrder()` to the `sorted()` method.

```java
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayListStreamSortDescendingDemo {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(36);
        list.add(15);
        list.add(11);
        list.add(83);
        list.add(37);
        list.add(97);

        list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println("ArrayList is in descending order: " + list);
    }

}
```

**Output**:

```
ArrayList is in descending order: [97, 83, 37, 36, 15, 11]
```

</details>

<br />

#### Understanding the `Comparable` interface

<details>
<summary>Introduction</summary>

The `Collections.sort()` method sorts the given `List` in ascending order.
How does the `sort()` method decide which element is smaller and which one is larger?

Each numeric wrapper class (`Integer`, `Double`, or `Long`), the `String` class, and the `Date` class implements an interface called `Comparable`.
This interface contains a `compareTo(T o)` method which is used by sorting methods to srot the `Collection`.
This method returns a negative integer, zero, or a positive integer if the `this` object is less than, equal to, or greater than the object passed as an argument.

<blockquote>
If we use the <code>Collections.sort(List<T> list)</code> method to sort an <code>ArrayList</code>, then the class whose objects are stored in the <code>ArrayList</code> must implement the <code>Comparable</code> interface.
If the <code>ArrayList</code> stores an <code>Integer</code>, a <code>Long</code>, or a <code>String</code>, then we don't need to worry as these classes already implement the <code>Comparable</code> interface.
But if the <code>ArrayList</code> stores a custom class object, then that class must implement the <code>Comparable</code> interface.
</blockquote>

In the below example, we have a custom class called `Employee`.
We have stored some `Employee` objects in an `ArrayList`, and we need to sort it.
The below example will not compile as the `Employee` class does not implement the `Comparable` interface.

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Employee {
    String name;
    int age;
    public Employee(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }
}

public class ArrayListComparableDemo {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Jane", 29));
        list.add(new Employee("Alex", 54));
        
        Collections.sort(list);
        System.out.println("ArrayList in ascending order: " + list);
    }
}
```

In the below example, the `Employee` class implements the `Comparable` interface.
The code will run successfully and will sort the `Employee` objects in ascending order of their age.

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Employee implements Comparable<Employee> {
    String name;
    int age;
    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public int compareTo(Employee employee) {
        /* 
         * Sort the employees based on age in ascending order.
         * Returns a negative integer, zero, or a positive integer according to whether the age of this Employee
         *   is less than, equal to, or greater than the specified object.
         */
        return this.age = employee.age;
    }
}

public class ArrayListComparableDemo {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Jane", 29));
        list.add(new Employee("Alex", 54));
        list.add(new Employee("Matt", 19));
        list.add(new Employee("Roy", 72));

        Collections.sort(list);
        for (Employee emp : list) {
            System.out.println("Employee Name: " + emp.name + ", Employee Age: " + emp.age);
        }
    }
}
```

**Output**

```
Employee Name: Jane, Employee Age: 29
Employee Name: Alex, Employee Age: 29
Employee Name: Matt, Employee Age: 29
Employee Name: Roy, Employee Age: 29
```

</details>


<details>
<summary>How to write an implementation of the compareTo() method</summary>

Let's say you have a custom class, and you need to write the implementation of the `compareTo()` method.

The first step will be to select the fields within that class where you need to sort the objects.
For example, if you have a `Vehicle` class, you might want to sort vehicles based on the year in which they were sold.

Once you have decided the field whre the sorting will be done, then the second step will be to write the implementation of the `compareTo()` method.
The `compareTo(T o)` method takes only one object as an input.
The comparison is made with the calling object.
Let's say we have two `Vehicle` class objects.

```
Vehicle v_1 = new Vehicle();
Vehicle v_2 = new Vehicle();
```

Then `v_1.compareTo(v2)` should return:

1. **-1** if the production year of `v_1` is less than the production year of `v_2`.
2. **1** if the production year of `v_1` is greater than the production year of `v_2`.
3. **0** if the production year of `v_1` is equal to the production year of `v_2`.

If we need to sort the `Vehicle` class on the basis of the year it was made, the logic will look as below:

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Vehicle implements Comparable<Vehicle> {
    String brand;
    Integer makeYear;
    public Vehicle(String brand, Integer makeYear) {
        this.brand = brand;
        this.makeYear = makeYear;
    }
    @Override
    public int compareTo(Vehicle o) {
        /*
         * The compareTo() method of the Integer class can also be used:
         *   return this.makeYear.compareTo(o.makeYear);
         */
        return this.makeYear - o.makeYear;
    }
}

public class ArrayListComparableDemo {
    public static void main(String[] args) {
        List<Vehicle> list = new ArrayList<>();
        list.add(new Vehicle("Volkswagen", 2010));
        list.add(new Vehicle("Audi", 2009));
        list.add(new Vehicle("Ford", 2001));
        list.add(new Vehicle("BMW", 2015));

        Collections.sort(list);
        for (Vehicle vehicle1 : list) {
            System.out.println("Vehicle Brand: " + vehicle1.brand + ", Vehicle Make: " + vehicle1.makeYear);
        }
    }
}
```

**Output**

```
Vehicle Brand: Ford, Vehicle Make: 2001
Vehicle Brand: Audi, Vehicle Make: 2009
Vehicle Brand: Volkswagen, Vehicle Make: 2010
Vehicle Brand: BMW, Vehicle Make: 2015
```

If we need to sort the `Vehicle` class on the basis of the brand name, the logic will be as below:

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Vehicle implements Comparable<Vehicle> {
    String brand;
    Integer makeYear;
    public Vehicle(String brand, Integer makeYear) {
        this.brand = brand;
        this.makeYear = makeYear;
    }
    @Override
    public int compareTo(Vehicle o) {
        /*
         * Using the compareTo() method of the String class.
         */
        return this.brand.compareTo(o.brand);
    }
}

public class ArrayListComparableDemo {
    public static void main(String[] args) {
        List<Vehicle> list = new ArrayList<>();
        list.add(new Vehicle("Volkswagen", 2010));
        list.add(new Vehicle("Audi", 2009));
        list.add(new Vehicle("Ford", 2001));
        list.add(new Vehicle("BMW", 2015));

        Collections.sort(list);
        for (Vehicle vehicle1 : list) {
            System.out.println("Vehicle Brand: " + vehicle1.brand + ", Vehicle Make: " + vehicle1.makeYear);
        }
    }
}
```

**Output**

```
Vehicle Brand: Audi, Vehicle Make: 2009
Vehicle Brand: BMW, Vehicle Make: 2015
Vehicle Brand: Ford, Vehicle Make: 2001
Vehicle Brand: Volkswagen, Vehicle Make: 2010
```

</details>

<br />

#### Understanding the `Comparator` interface

<details>
<summary>Main drawback of Comparator</summary>

One of the major drawbacks of using a `Comparable` interface is that the comparing logic becomes fixed.
For instance, if we have a `Vehicle` class, then it can be sorted either on the basis of the brand or the production year depending on the implementation of the `compareTo()` method.

</details>

<details>
<summary>Pros / cons of Comparator vs. Comparable</summary>

If we need some flexibility in sorting, we should use the `Comparator` interface instead of the `Comparable` interface.
The `Comparator` interface has a method

`compare(T o1, T o2)`

which takes two objects, `o1` and `o2` as parameters. It returns

- **-1** if `o1 < o2`
- **1** if `o1 > o2`
- **0** if `o1 == o2`

If we need to use the `Comparator` interface, then we can't use the `Collections.sort(List<T> t)` method as `T` should implement the `Comparable` interface.
There is another overloaded method

`sort(List<T> list, Comparator<? super T> c)`

that takes the list as well as a `Comparator` object as input.
It then sorts the list based on the logic provided in the `Comparator` implementation.

</details>

<details>
<summary>Creating a custom Comparator</summary>

The below code shows how to create a custom `Comparator`.
We will create two custom comparators: one for sorting by brand and one for sorting by year.

#### `BrandComparator.java`

```java
import java.util.Comparator;

class BrandComparator implements Comparator<Vehicle> {
    @Override
    public int compare(Vehicle o1, Vehicle o2) {
        return o1.brand.compareTo(o2.brand);
    }
}
```

#### `MakeYearComparator.java`

```java
import java.util.Comparator;

class MakeYearComparator implements Comparator<Vehicle> {
    @Override
    public int compare(Vehicle o1, Vehicle o2) {
        return o1.makeYear.compareTo(o2.makeYear);
    }
}
```

#### `Vehicle.java`

```java
class Vehicle {
    String brand;
    Integer makeYear;
    public Vehicle(String brand, Integer makeYear) {
        super();
        this.brand = brand;
        this.makeYear = makeYear;
    }
}
```

In the below example, we have used both the Comparators to sort on the basis of brand and production year.

#### `ArrayListComparatorDemo.java`

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListComparatorDemo1 {
	public static void main(String[] args) {
		List<Vehicle> list = new ArrayList<>();
		list.add(new Vehicle("Volkswagen", 2010));
		list.add(new Vehicle("Audi", 2009));
		list.add(new Vehicle("Ford", 2001));
		list.add(new Vehicle("BMW", 2015));

        System.out.println("Sorting by brand name.");
		Collections.sort(list, new BrandComparator());
		for (Vehicle vehicle : list) {
			System.out.println("Vehicle Brand: " + vehicle.brand + ", Vehicle Make: " + vehicle.makeYear);
		}
		
		System.out.println("Sorting by make year.");
		Collections.sort(list, new MakeYearComparator());
		for (Vehicle vehicle : list) {
			System.out.println("Vehicle Brand: " + vehicle.brand + ", Vehicle Make: " + vehicle.makeYear);
		}
	}
}
```

We can also use an anonymous class in the sort method instead of creating a separate class that implements Comparator. This is shown in the below example.

#### `Vehicle.java`

```java
class Vehicle {
    String brand;
    Integer makeYear;
    public Vehicle(String brand, Integer makeYear) {
        super();
        this.brand = brand;
        this.makeYear = makeYear;
    }
}
```

#### `ArrayListComparatorDemo2.java`

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ArrayListComparatorDemo2 {
    
    public static void main(String[] args) {
        List<Vehicle> list = new ArrayList<>();
        list.add(new Vehicle("Volkswagen", 2010));
        list.add(new Vehicle("Audi", 2009));
        list.add(new Vehicle("Ford", 2001));
        list.add(new Vehicle("BMW", 2015));
        System.out.println("Sorting by brand name");
        Collections.sort(list, new Comparator<Vehicle>() {
            
            @Override
            public int compare(Vehicle o1, Vehicle o2) {
                return o1.brand.compareTo(o2.brand);
            }
        });

        for (Vehicle vehicle : list) {
            System.out.println("Vehicle Brand: " + vehicle.brand + ", Vehicle Make: " + vehicle.makeYear);
        }

        System.out.println("Sorting by make year");
        Collections.sort(list, new Comparator<Vehicle>() {
            
            @Override
            public int compare(Vehicle o1, Vehicle o2) {
                return o1.makeYear.compareTo(o2.makeYear);
            }
        });
        
        for (Vehicle vehicle : list) {
            System.out.println("Vehicle Brand: " + vehicle.brand + ", Vehicle Make: " + vehicle.makeYear);
        }
    }
    
}
```

The above code can be further simplified if we use a lambda expression instead of anonymous classes.

#### `ArrayListComparatorDemo3.java`

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListComparatorDemo3 {
    
    public static void main(String[] args) {
        List<Vehicle> list = new ArrayList<>();
        list.add(new Vehicle("Volkswagen", 2010));
        list.add(new Vehicle("Audi", 2009));
        list.add(new Vehicle("Ford", 2001));
        list.add(new Vehicle("BMW", 2015));
        System.out.println("Sorting by brand name");
        Collections.sort(list, (o1, o2) -> o1.brand.compareTo(o2.brand));

        for (Vehicle vehicle : list) {
            System.out.println("Vehicle Brand: " + vehicle.brand + ", Vehicle Make: " + vehicle.makeYear);
        }
    }
    
}
```

</details>

<br />

#### ArrayList exercise

Solve the following exercises, given an `ArrayList` that contains `Employee` objects.

<details>
<summary>Problem 1: Find employees aged over 50</summary>

Print the names of all employees whose agw is more than 50.

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ArrayListExercise {

    class Employee implements Comparable<Employee> {
        String name;
        int age;
        String country;
        public Employee(String name, int age, String country) {
            this.name = name;
            this.age = age;
            this.country = country;
        }
        @Override
        public int compareTo(Employee employee) { return this.age = employee.age; }
    }
    
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Alex", 23, "USA"));
        list.add(new Employee("Dave", 34, "India"));
        list.add(new Employee("Carl", 21, "USA"));
        list.add(new Employee("Joe", 56, "Russia"));
        list.add(new Employee("Amit", 64, "China"));
        list.add(new Employee("Ryan", 19, "Brazil"));
        
        list.stream().filter(e -> e.age > 50).map(e -> e.name).forEach(System.out::println);
    }
    
}
```

</details>


<details>
<summary>Problem 2: Find employees from the USA</summary>

Remove all the Employees from the List who reside in the USA.

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ArrayListExercise {
    
    static class Employee implements Comparable<Employee> {
        String name;
        int age;
        String country;
        public Employee(String name, int age, String country) {
            this.name = name;
            this.age = age;
            this.country = country;
        }
        @Override
        public int compareTo(Employee employee) { return this.age = employee.age; }
    }
    
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Alex", 23, "USA"));
        list.add(new Employee("Dave", 34, "India"));
        list.add(new Employee("Carl", 21, "USA"));
        list.add(new Employee("Joe", 56, "Russia"));
        list.add(new Employee("Amit", 64, "China"));
        list.add(new Employee("Ryan", 19, "Brazil"));

        /* Remove all the Employees from the List who reside in the USA. */
        System.out.println("Remove all the Employees from the List who reside in the USA.");
        System.out.println("-".repeat(30));
        System.out.println("List before removal:");
        list.forEach(e -> System.out.println(e.name));
        list.removeIf(e -> e.country.equalsIgnoreCase("USA"));
        System.out.println("List after removal:");
        list.forEach(e -> System.out.println(e.name));
    }
    
}
```

</details>


<details>
<summary>Problem 3: Sort employees by country</summary>

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ArrayListExercise {
    
    static class Employee implements Comparable<Employee> {
        String name;
        int age;
        String country;
        public Employee(String name, int age, String country) {
            this.name = name;
            this.age = age;
            this.country = country;
        }
        @Override
        public int compareTo(Employee employee) { return this.age = employee.age; }
    }
    
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Alex", 23, "USA"));
        list.add(new Employee("Dave", 34, "India"));
        list.add(new Employee("Carl", 21, "USA"));
        list.add(new Employee("Joe", 56, "Russia"));
        list.add(new Employee("Amit", 64, "China"));
        list.add(new Employee("Ryan", 19, "Brazil"));

        /* Sort all the employees by country name. */
        System.out.println("Sort all the employees by country name.");
        System.out.println("-".repeat(30));
        System.out.println("List before sorting:");
        list.forEach(System.out::println);
        list.sort(Comparator.naturalOrder());
        System.out.println("List after sorting:");
        list.forEach(System.out::println);
    }
    
}
```

</details>
