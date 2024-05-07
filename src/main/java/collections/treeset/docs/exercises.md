# `TreeSet` exercises

## Exercise 1: Understanding the Importance of Consistency with equals

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
