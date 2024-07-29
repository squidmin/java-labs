# Exercises: Interfaces

## Exercise 1: Default methods

1. Create an interface `Vehicle` with a default method `void start()`.
   Implement this interface in classes `Car` and `Motorcycle`, providing custom implementations for the `start()` method in each class.
2. Define another interface `Convertible` with a default method `void openRoof()`.
   Have the `Car` class implement this interface and provide its implementation for the `openRoof()` method.

## Exercise 2: Static methods

1. Create an interface `MathUtils` with a static method `int max(int a, int b)` that returns the maximum of two integers.
2. Implement the `MathUtils` interface in a class `MathOperations` and provide the implementation for the `max()` method.
3. Test the `max()` method by calling it with different pairs of integers and printing the result.

## Exercise 3: Functional interfaces

1. Create a functional interface `Calculator` with a single abstract method `int calculate(int a, int b)`.
2. Implement the `Calculator` interface using lambda expressions to define addition, subtraction, multiplication, and division operations.
3. Test the calculator operations by passing lambda expressions to perform arithmetic calculations.

## Exercise 4: `@FunctionalInterface` Annotation

1. Define a functional interface `StringTransformer` with a single abstract method `String transform(String input)`.
2. Annotate the `StringTransformer` interface with `@FunctionalInterface`.
3. Implement the `StringTransformer` interface using lambda expressions to define different string transformation operations such as uppercase, lowercase, and reverse.
4. Test the string transformation operations by passing different strings to the lambda expressions.

## Exercise 5: Avoid Overloading Methods with Functional Interfaces

1. Define an interface `Processor` with two methods: `process(Callable<String> c)` and `process(Supplier<String> s)`.
2. Implement the `Processor` interface in a class `DataProcessor` and provide implementations for both methods.
3. Test the `DataProcessor` class by calling both `process()` methods with appropriate lambda expressions as arguments.
