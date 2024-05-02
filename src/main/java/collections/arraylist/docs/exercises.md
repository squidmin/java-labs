# `ArrayList` exercises

## Java Exercise 1: Implement Comparable for Sorting Custom Objects

**Objective**: Learn how to use the `Comparable` interface to sort custom objects in Java.

**Background**: The `Comparable` interface is used to impose a natural ordering on the objects of each class that implements it.
This ordering is referred to as the class's natural ordering, and the class's `compareTo` method is referred to as its natural comparison method.

**Task**:

Create a class `Student` that implements the `Comparable` interface to sort a list of students based on their grade point average (GPA) in ascending order.
Each `Student` object has two properties:
- `String name`
- `double GPA`

- Implement the `compareTo` method in the `Student` class to compare students by GPA.
- In your `main` method, create a `List` of `Student` objects with varying names and GPAs.
- Use `Collections.sort()` to sort the list and then iterate over the sorted list to print out the name and GPA of each student, demonstrating the sorting order.

**Expected Output**: When running your `main` method, the students should be printed in ascending order based on their GPA.

---

## Java Exercise 2: Custom Sorting with Multiple Conditions

**Objective**: Expand your understanding of the `Comparable` interface by implementing custom sorting logic that uses multiple conditions.

**Task**:

Create a class `Book` that implements the `Comparable` interface.
A `Book` object has three properties:
- `String title`
- `String author`
- `int yearPublished`

Implement the `compareTo` method in the `Book` class to sort books primarily by `yearPublished` in ascending order.
If two books were published in the same year, secondary sorting should be based on the title in alphabetical order.

- In the `main` method, create a list of `Book` objects with varying titles, authors, and publication years.
- Sort the list using `Collections.sort()`, and then iterate over the sorted list to print out the details of each book, demonstrating the sorting order based on the defined criteria.

**Expected Output**: The list of books should be printed in ascending order based on their publication year, with books published in the same year sorted alphabetically by title.

---

## Java Exercise 3: Understanding the Importance of Consistency with equals

**Objective**: Understand the importance of consistency between the `compareTo` method of the `Comparable` interface and the `equals` method from the `Object` class.

**Background**: It is strongly recommended (though not strictly required) that `(x.compareTo(y)==0) == (x.equals(y))`.
Failure to adhere to this condition may cause unpredictable behavior when such objects are used in Java collections.

**Task**:

Create a class `Product` that implements the `Comparable` interface.
A `Product` object has two properties:
- `String productId`
- `double price`

The `compareTo` method should sort products based on their price in ascending order.

- Override the `equals` method in the `Product` class to ensure it is consistent with the `compareTo` method (i.e., two `Product` objects are equal if their `productId` is the same).
- In your `main` method, create a `TreeSet` of `Product` objects and attempt to add duplicate products based on the `productId` to understand how the `equals` method is used in collection operations.
- Iterate over the `TreeSet` and print out the details of each product to observe the effect of a consistent `equals` method.

> **Why `TreeSet` instead of `HashSet`?**
> 
> The `HashSet` does not maintain elements in sorted order; it's a collection designed for fast access and uniqueness checks without regard to the order of elements.
> The sorting behavior you're expecting (i.e., seeing `Product` instances in a particular order based on their `productId` or `price`) won't be achieved with a `HashSet`.
> 
> `TreeSet` is a sorted collection that uses the natural ordering of its elements (defined by the `Comparable` implementation) or a `Comparator` provided at set creation time.

**Expected Output**: The `TreeSet` should eliminate duplicate products based on the `productId`, demonstrating the importance of having a consistent `equals` method with `compareTo`.
