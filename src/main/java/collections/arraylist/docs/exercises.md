# `ArrayList` exercises

## Exercise 1: Implement Comparable for Sorting Custom Objects

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

## Exercise 2: Custom Sorting with Multiple Conditions

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

## Exercise 3: Basic ArrayList Operations

**Objective**: Learn basic operations of the `ArrayList`, such as adding, removing, and accessing elements.

**Task**:

- Create an `ArrayList` of integers.
- Add several integers to the list.
- Remove specific integers from the list using index and object removal methods.
- Access various elements in the list and print them.

**Expected Output**: Demonstrate the current state of the list after each operation, showing successful addition, removal, and access of elements.

---

## Exercise 4: Implementing a Dynamic Array

**Objective**: Understand how to use `ArrayList` to simulate a dynamic array that can expand based on runtime decisions.

**Task**:

- Create an `ArrayList` to store strings.
- Simulate receiving an unknown number of string inputs from a user until "stop" is entered.
- Store each input in the `ArrayList` and then print the entire list once "stop" is entered.

**Expected Output**: Output all user inputs stored in the `ArrayList` after the user stops entering data.

---

## Exercise 5: Merging and Deduplicating ArrayLists

**Objective**: Learn to merge two `ArrayLists` and remove duplicate items effectively.

**Task**:

- Create two `ArrayLists` of strings, each initialized with some predefined values, including some duplicates across the lists.
- Merge the two lists into a new list that contains only unique elements, preserving the order.
- Use a `HashSet` or `LinkedHashSet` to help with deduplication if necessary.

**Expected Output**: A single merged `ArrayList` without duplicates, printed to the console.

---

## Exercise 6: `ArrayList` as a Stack

**Objective**: Emulate stack behavior using an `ArrayList` to understand how it can be adapted for different data structure behaviors.

**Task**:

- Use an `ArrayList` to implement a basic stack with operations: push, pop, and peek.
- Ensure your implementation handles underflow (popping from an empty stack) gracefully.
- Push a series of integers onto the stack, then pop several items, and peek at the top item, printing the results at each step.

**Expected Output**: Show the contents of the stack after each operation and the result of peeking or popping items.

---

## Exercise 7: Random Access vs. Iterative Access in `ArrayList`

**Objective**: Compare the performance of random access and sequential iterative access in an `ArrayList`.

**Task**:

- Fill an `ArrayList` with a large number of integers.
- Measure and compare the time taken to access all elements randomly versus accessing them sequentially.
- Use `System.nanoTime()` to measure elapsed time for each operation.

**Expected Output**: Print the time taken for random access and sequential access, highlighting the differences.
