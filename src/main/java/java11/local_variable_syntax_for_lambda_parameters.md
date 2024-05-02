# Local Variable Syntax for Lambda Parameters (JEP 323)

This feature allows you to use the `var` keyword to declare the parameters of a lambda expression, providing consistency with the local variable syntax.

## Exercise Description

**Objective**: Create a lambda expression using the `var` keyword to sort a list of `Person` objects based on their age, and then print out each `Person`.

**Requirements**:
1. Define a `Person` class with at least two fields: `name` (String) and `age` (int).
2. Create a list of `Person` objects.
3. Use a lambda expression with `var` to sort the list by age.
4. Print the sorted list.

This exercise helps you practice using the `var` keyword in lambda expressions and also reinforces your understanding of lambda expressions and Java Collections.

## Sample Solution

```java
public class Main {
    public static void main(String[] args) {
        // Define the Person class
        class Person {
            String name;
            int age;
            
            Person(String name, int age) {
                this.name = name;
                this.age = age;
            }
            
            @Override
            public String toString() {
                return name + " (" + age + " years old)";
            }
        }
        
        // Create a list of Person objects
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 28));
        people.add(new Person("Bob", 24));
        people.add(new Person("Charlie", 33));
        
        // Sort the list by age using a lambda expression with 'var'
        people.sort((var p1, var p2) -> Integer.compare(p1.age, p2.age));
        
        // Print the sorted list
        people.forEach(person -> System.out.println(person));
    }
}
```

Okay, but wouldn't the type keyword usually be excluded completely from the lambda parameters?
How does adding the `var` keyword improve the code in this case?

Generally, the introduction of `var` in lambda parameters (as allowed in Java 11) serves consistency and readability in certain scenarios, rather than being a necessity for simplification.

### Where `var` makes a difference:

1. **Consistency**: Prior to Java 11, you couldn't mix implicitly typed and explicitly typed parameters in lambda expressions.
   Every parameter had to be either explicitly typed or not typed at all.
   With `var`, you can uniformly apply a style where each parameter's type is either evident or annotated, which helps in maintaining consistency throughout your codebase.
2. **Annotations**: One of the more practical benefits of using `var` in lambda parameters is the ability to use annotations on those parameters.
   Without `var`, you can't annotate the type of a lambda parameter directly because there is no place to attach the annotation.
   This can be useful in scenarios where you need to provide metadata for the parameters (e.g., for serialization, validation, or inter-operation with frameworks that rely on annotations).
3. **Complex Generic Types**: In cases where lambda parameters have complex generic types, using `var` can make the lambda expression more readable.
   Instead of having a complex type clutter the lambda expression, var simplifies the visual clutter, allowing the reader to focus on the logic of the lambda rather than its parameter types.

## Example with Annotations and Complex Types:

Here's a more detailed example that illustrates where `var` can be particularly useful.

```java
import java.util.function.BiFunction;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        BiFunction<List<@NonNull String>, List<@NonNull String>, Integer> compareSize =
            (var list1, var list2) -> Integer.compare(list1.size(), list2.size());

        List<String> list1 = new ArrayList<>(List.of("apple", "banana"));
        List<String> list2 = new ArrayList<>(List.of("cherry", "date", "elderberry"));

        System.out.println(compareSize.apply(list1, list2)); // Output: -1
    }
}
```
