<details>
<summary>Lambda basics</summary>

The following topics are covered:
- Lambda expression definition
- How to write a lambda expression

### What is a lambda expression?

Java is an object-oriented language. By introducing lambdas in Java 8, the authors of Java tried to add elements of functional programming in Java.
What are the differences between _object-oriented programming_ and _functional programming_?

In _object-oriented programming_, objects and classes are the main entities.
If a function is created, then it should exist within a class.
A function has no meaning outside the scope of the object that invokes it.

In _functional programming_, functions can exist outside the scope of their owning object.
They can be assigned to a reference variable, and they can also be passed as parameters to other methods.

A _lambda expression_ is just an *anonymous function*, i.e., a function with **no name** and that is **not bound to an identifier**.
A lambda expression can be passed to other methods as a parameter, which is just one example of the power of functional programming in Java.

### How to write a lambda expression

The below example shows a functional interface called `AFunctionalInterface`.
There are two classes `ClassA` and `ClassB` that implement this interface.

### `AFunctionalInterface.java`

```java
@FunctionalInterface
public interface AFunctionalInterface {
    void execute();
}
```

### `ClassA.java`

```java
public class ClassA implements AFunctionalInterface {
    // Overriding the execute() method from AFunctionalInterface interface.
    @Override
    public void execute() {
        System.out.println("Namaste");
    }
}
```

### `ClassB.java`

```java
public class ClassB implements AFunctionalInterface {
    // Overriding the execute() method from AFunctionalInterface interface.
    @Override
    public void execute() {
        System.out.println("Hi");
    }
}
```

The below code example shows the implementation of another class called `ClassC`.
This class has a method called `wish(AFunctionalInterface functionalInterface)` which takes `AFunctionalInterface` as a parameter, and based on the type of object passed, prints the output of the `execute()` method.

### `ClassC.java`

```java
package lambdas;

public class ClassC {
    public static void wish(AFunctionalInterface functionalInterface) {
        functionalInterface.execute();
    }

    public static void main(String[] args) {
        AFunctionalInterface functionalInterface_1 = new ClassA();
        wish(functionalInterface_1);  // Passing an object of ClassA.

        AFunctionalInterface functionalInterface_2 = new ClassB();
        wish(functionalInterface_2);  // Passing an object of ClassB.
    }
}
```

**Output**

```
Namaste
Hi
```

This is a classic object-oriented programming example.
Now, what if requirements changed to have the `ClassC` class greet in all available languages?

Should a class be created for each concrete entity, e.g., `ClassD`, `ClassE`, `ClassF`, etc?

Isn't it possible to create no additional classes and just send a function to the `wish(AFunctionalInterface functionalInterface)` method?

The `wish(AFunctionalInterface functionalInterface)` method will directly execute the function that is provided to it and print the output.

This is possible through anonymous classes.
We'll quickly see how this can be done through an anonymous class, and then jump straight back into lambdas.

Note that the `@FunctionalInterface` annotation allows the Java compiler to trigger an error in response to any attempt to break the predefined structure of a functional interface.
It's also a handy tool to make an application architecture easier to understand for other developers.  

In the below example, the `ClassC` class is changed to use an anonymous class.

### `AFunctionalInterface.java`

```java
@FunctionalInterface
public interface AFunctionalInterface {
    void execute();
}
```

### `ClassC.java`

```java
public class ClassC {

    public static void wish(AFunctionalInterface functionalInterface) {
        functionalInterface.execute();
    }

    public static void main(String[] args) {
        // We are passing an anonymous class object to the wish method.
        wish(new AFunctionalInterface() {
            @Override
            public void execute() {
                System.out.println("Namaste");
            }
        });
    }

}
```

In the above example, a class doesn't need to be created for each language.
An anonymous class can be used, and suffices for our purposes in the example above.
But the code is still somewhat cumbersome.
Although the class is anonymous, a class is still being created.

To improve this code, all the unnecessary parts can be removed step-by-step to create a lambda expression.

**Step 1**: The compiler knows that the `wish(AFunctionalInterface functionalInterface)` method takes in a parameter of type `AFunctionalInterface`.
So, an anonymous class of type `AFunctionalInterface` doesn't need to be created explicitly.

### `ClassC.java`

```java
public class ClassC {

    public static void wish(AFunctionalInterface functionalInterface) {
        functionalInterface.execute();
    }

    public static void main(String[] args) {
        wish(
            public void execute() {
                System.out.println("Namaste");
            }
        );
    }
    
}
```

**Step 2**: It's understood that the `AFunctionalInterface` interface has only one method.
So, the method name doesn't need to be provided - just the method body.

### `ClassC.java`

```java
public class ClassC {

    public static void wish(AFunctionalInterface functionalInterface) {
        functionalInterface.execute();
    }

    public static void main(String[] args) {
        wish(
            public void () {
                System.out.println("Namaste");
            }
        );
    }
}
```

**Step 3**: The compiler can understand that the body does not return anything.
So, mentioning the return type is redundant.
The `public` declaration can also be removed.

### `ClassC.java`

```java
public class ClassC {

    public static void wish(AFunctionalInterface functionalInterface) {
        functionalInterface.execute();
    }

    public static void main(String[] args) {
        wish(
            () -> {
                System.out.println("Namaste");
            }
        );
    }
}
```

Note that a `->` is added between the empty brackets and the method body.
This is part of the syntax for declaring a lambda expression.

There still is one more improvement that can be made.
Since the method body contains only a single line, the curly braces are unnecessary.

#### `AFunctionalInterface.java`

```java
@FunctionalInterface
public interface AFunctionalInterface {
    void execute();
}
```

#### `ClassC.java`

```java
public class ClassC {
    public static void wish(AFunctionalInterface functionalInterface) {
        functionalInterface.execute();
    }

    // Passing a lambda expression to wish method.
    public static void main(String[] args) {
        wish( () -> System.out.println("Namaste") );
    }
}
```

This is how simple it is to write a lambda expression.

To recap, when writing a lambda expression, a function is passed as a method parameter, and it is directly executed.

### Don't treat lambda expressions as inner classes

Note that lambda expressions are not compiled to anonymous inner classes.
Instead, lambdas get wrapped inside new classes generated during runtime.

In earlier examples, an inner class was essentially substituted by a lambda expression, but the concepts of inner class and lambda expression are different in an important way: **scope**.

When an inner class is used, it creates a new scope.
Local variables can be hidden from the enclosing scope by instantiating new local variables with the same names.
The keyword `this` can also be utilized inside an inner class as a reference to its instance.

Lambda expressions, however, work with enclosing scope.
Variables can't be hidden from the enclosing scope inside the lambda's body.
In this case, the keyword `this` is a reference to an enclosing instance.

For example, in the class `ScopeExperiment`, we have an instance variable `value`:

```
private String value = "Enclosing scope value";
```

Then in some method of this class, place the following code and execute this method:

### `ScopeExperiment.java`

```java
public class ScopeExperiment {
    
    private String value = "Enclosing scope value";
    
    public String scopeExperiment() {
        Foo fooIC = new Foo() {
            String value = "Inner class value";
    
            @Override
            public String method(String string) {
              return this.value;
            }
        };
        String resultIC = fooIC.method("");
    
        Foo fooLambda = parameter -> {
            String value = "Lambda value";
            return this.value;
        };
        String resultLambda = fooLambda.method("");
    
        return "Results: resultIC = " + resultIC +
                ", resultLambda = " + resultLambda;
    }
    
    public static void main(String[] args) {
        scopeExperiment();
    }
    
}
```

#### Output

```
Results: resultIC = Inner class value, resultLambda = Enclosing scope value
```

By calling `this.value` in `fooIC`, we can access a local variable from its instance.
In the case of the lambda, the `this.value` call accesses the instance-level variable `value`, which is defined in the `ScopeExperiment` class, but not to the variable `value` defined inside the lambda's body.

### Keep lambda expressions short and self-explanatory

- Avoid blocks of code in a lambda's body
- Avoid specifying parameter types
- Avoid parentheses around a single parameter
- Avoid the `return` statement and braces
- Use method references

</details>


<details>
<summary>Java Comparator using Lambda</summary>

Use lambdas to write a concise comparator.

The following topics are covered:
- Comparator example using anonymous classes
- Comparator example using a lambda expression

If you've been working with Java for some time, then you've probably encountered a scenario where you need to sort the elements in a collection.

If your collection contains a *wrapper class object*, then the sorting is very easy.
Since all the wrapper classes implement the `Comparable` interface, you can directly use `Collections.sort()` to sort your collection.

However, if your collection contains a custom class object then you need to provide the logic to sort your object.
In this lesson, we will look at an example in which we will sort a list of `Person` class objects using a **comparator**.
Then, we will write a program to do the same task using **lambdas**.

### Comparator example using anonymous classes

First, we will create a `Person` class.

### `Person.java`

```java
public class Person {

    private String name;
    private int age;
    private String country;

    public Person(String name, int age, String country) {
        this.name = name;
        this.age = age;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCountry() {
        return country;
    }
}
```

Now, we have a `PersonService` class. It has a `getPersons(List<Person> persons)` method.
It takes a **list of person object** as input and returns a **list of person object** in sorted order.

In this method, we are creating an anonymous comparator, which sorts the `Person` objects on the basis of name.

### `PersonService.java`

```java
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PersonService {

    public static List<Person> getPersons(List<Person> persons){
        // Created an anonymous Comparator, which sorts the Person object on the basis of Person name.
        Collections.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.getName().compareTo(p2.getName());
            }
        });
        return persons;
    }
}
```

Finally, we have a `PersonMain` class that runs our logic.

### `PersonMain.java`

```java
import java.util.ArrayList;
import java.util.List;

public class PersonMain {

    public static void main(String[] args){
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("John" , 23 , "USA"));
        persons.add(new Person("Carl" , 23 , "Australia"));
        persons.add(new Person("Amit" , 23 , "India"));
        persons.add(new Person("Vikram" , 23 , "Bhutan"));
        persons.add(new Person("Kane" , 23 , "Brazil"));
        // Calling getPerson() method which will return the List of Person in sorted order.
        List<Person> sortedPersons = PersonService.getPersons(persons);

        System.out.println("Persons after sorting");
        // Printing the name of each person.
        for (Person person : sortedPersons){
            System.out.println("Person Name : " + person.getName());
        }
    }
}
```

If you look at the `Comparator` interface, you notice that it is a functional interface.
It has only one abstract method called `compare()`.
This makes it a perfect candidate to be used in lambdas.

### Comparator example using a lambda expression

Now, let's see how we can write the same logic using a lambda expression.
When writing lambdas, we only need to consider the input parameters and the method body.

Below is the signature of the `compare()` method.

`int compare(T o1, T o2)`

It takes two parameters as input and returns an `int`.

Let's start constructing the lambda expression:

The structure of lambda will be like:

`(p1, p2) -> {};`

Here, `p1` and `p2` are the two input parameters. We can name them anything.

Now, we will add the body.

`(p1, p2) -> p1.getName().compareTo(p2.getName());`

So, this is the lambda expression for sorting the `Person` objects based on name.

You can see how easy and concise it is to write code with lambdas instead of using anonymous classes.

### `Person.java`

```java
public class Person {

    private String name;
    private int age;
    private String country;

    public Person(String name, int age, String country) {
        this.name = name;
        this.age = age;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCountry() {
        return country;
    }
}
```

### `PersonService.java`

```java
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PersonService {

    public static List<Person> getPersons(List<Person> persons) {
        // Instead of creating an anonymous class, we have provided a lambda expression.
        Collections.sort(persons, (p1, p2) -> p1.getName().compareTo(p2.getName()));
        return persons;
    }
}
```

### `PersonMain.java`

```java
import java.util.ArrayList;
import java.util.List;

public class PersonMain {

    public static void main(String[] args){
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("John" , 23 , "USA"));
        persons.add(new Person("Carl" , 23 , "Australia"));
        persons.add(new Person("Amit" , 23 , "India"));
        persons.add(new Person("Vikram" , 23 , "Bhutan"));
        persons.add(new Person("Kane" , 23 , "Brazil"));
        // Calling getPerson() method which will return the List of Person in sorted order.
        List<Person> sortedPersons = PersonService.getPersons(persons);

        System.out.println("Persons after sorting");
        for(Person person : sortedPersons){
            System.out.println("Person Name : " + person.getName());
        }
    }
}
```

</details>


<details>
<summary>Predicate Functional Interface</summary>

Introduces the `Predicate` functional interface.
We will discuss where a `Predicate` interface can be used and how to use it.

The following topics are covered:
- Introduction to the `Predicate` interface
  - a) `and(Predicate other)`
  - b) `or(Predicate other)`
  - c) `negate()`
  - d) `isEqual(Object targetRef)`
- Introduction to the `BiPredicate` interface

### Introduction to the `Predicate` interface

Java 8 provides some in-built functional interfaces in the `java.util.function` package.
These interfaces are required so that, while writing lambda expressions, we don't need to worry about creating a functional interface.

There are 43 predefined interfaces in Java 8.
Remembering all of them is a bit difficult, so we will divide them into categories and look at each category.
The first category that we are looking at in this lesson is `Predicate`.

Below are the interfaces in this category:

| Interface name          | Description                                                                        | Abstract method              |
|-------------------------|------------------------------------------------------------------------------------|------------------------------|
| `Predicate<T>`          | Represents a predicate (boolean-value function) of one argument (reference type)   | `boolean test(T t)`          |
| `DoublePredicate`       | Accepts one double-value argument                                                  | `boolean test(double value)` |
| `IntPredicate`          | Accepts one int-value argument.                                                    | `boolean test(int value)`    |
| `LongPredicate`         | Accepts one long-value argument                                                    | `boolean test(long value)`   |
| `BiPredicate<T, U>`     | Accepts two arguments (reference types)                                            | `boolean test(T t, U u)`     |

The `Predicate<T>` interface has an abstract method `boolean test(T t)`.
Basically, a predicate is a function that evaluates the given input and returns `true` or `false`.

Below is the list of methods available in the `Predicate<T>` interface.

![img.png](img/01.png)

As we can see, there is only one abstract method and a few default and static methods.

Let's look at an example. We have a `PredicateDemo` class, which has a method `isPersonEligibleForVoting()`.
This method takes in a `Person` object and a `Predicate` as a parameter.
The `Predicate` is evaluated to check if the given `Person` is eligible for voting or not.

### `PredicateDemo.java`

```java
import java.util.function.Predicate;

public class PredicateDemo {
    static boolean isPersonEligibleForVoting(Person person, Predicate<Person> predicate){
        return predicate.test(person);
    }
  
    public static void main(String[] args) {
        Person person = new Person("Alex", 23);
        // Created a predicate. It returns true if age is greater than 18.
        Predicate<Person> predicate = p -> p.age > 18;
        boolean eligible = isPersonEligibleForVoting(person, predicate);
        System.out.println("Person is eligible for voting: " + eligible);
    }
}

class Person {
    String name;
    int age;
    Person(String name, int age){
        this.name = name;
        this.age = age;
    }
}
```

In the above example, we use a `Predicate<T>`. This interface has some other default and static methods that are used for the purpose of chaining.
We will discuss these methods and look at one example for each of them.

### a) `and(Predicate other)`

This method returns a composed predicate that represents a short-circuiting logical AND of this predicate and another.

In the below example, we need to check if a person is eligible for club membership.
The criteria is that the person's age should be more than 18 and less than 60.

We have created two predicates and then combined them into a single predicate using the `and()` method.

### `PredicateDemo.java`

```java
import java.util.function.Predicate;

public class PredicateDemo {
    static boolean isPersonEligibleForMembership(Person person, Predicate<Person> predicate){
        return predicate.test(person);
    }

    public static void main(String[] args) {
        Person person = new Person("Alex", 23);

        // Created a predicate. It returns true if age is greater than 18.
        Predicate<Person> greaterThanEighteen = (p) -> p.age > 18;
        // Created a predicate. It returns true if age is less than 60.
        Predicate<Person> lessThanSixty = (p) -> p.age < 60;
        
        Predicate<Person> predicate = greaterThanEighteen.and(lessThanSixty);

        boolean eligible = isPersonEligibleForMembership(person, predicate);
        System.out.println("Person is eligible for membership: " + eligible);
    }
}

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
```

#### Output

```
Person is eligible for membership: true
```

### b) `or(Predicate other)`

This method returns a composed predicate that represents a short-circuiting logical OR of this predicate and another.

In the below example we need to check if a person is eligible for retirement.
The criteria is that either the person’s age should be more than 60 or the year of service should be more than 30.

We will create two predicates and then combined them into a single predicate using the `or()` method.

### `PredicateDemo.java`

```java
import java.util.function.Predicate;

public class PredicateDemo {
    static boolean isPersonEligibleForRetirement(Person person, Predicate<Person> predicate){
        return predicate.test(person);
    }
    
    public static void main(String[] args) {
        Person person = new Person("Alex", 23, 10);
        // Created a predicate. It returns true if age is greater than 60.
        Predicate<Person> greaterThanSixty = (p) -> p.age > 60;
        // Created a predicate. It returns true if year of service is greater than 30.
        Predicate<Person> serviceMoreThanThirty = (p) -> p.yearsOfService > 30;
        Predicate<Person> predicate = greaterThanSixty.or(serviceMoreThanThirty);

        boolean eligible = isPersonEligibleForRetirement(person , predicate);
        System.out.println("Person is eligible for membership: " + eligible);
    }
}

class Person {
    String name;
    int age;
    int yearsOfService;

    Person(String name, int age, int yearsOfService) {
        this.name = name;
        this.age = age;
        this.yearsOfService = yearsOfService;
    }
}
```

#### Output

```
Person is eligible for membership: false
```

### c) `negate()`

This method returns a predicate that represents the logical negation of the predicate it is called on.

Suppose we have a Predicate defined, but in some areas, we need to negate that predicate.
In that case, we can use `negate()`.

In the below example, we have a predicate that checks if a number is greater than 10.
However, we need to check if a number is less than 10.
Now instead of writing a new predicate, we can negate the predicate we already have.

### `PredicateDemo.java`

```java
import java.util.function.Predicate;

public class PredicateDemo {
    static boolean isNumberLessThanTen(Predicate<Integer> predicate){
        return predicate.negate().test(14);
    }

    public static void main(String[] args) {
        Predicate<Integer> numberGreaterThanTen = p -> p > 10;
        boolean isLessThanTen = isNumberLessThanTen(numberGreaterThanTen);
        System.out.println("Is number less than ten: " + isLessThanTen);
    }
}
```

#### Output

```
Is number less than ten: false
```

### d) `isEqual(Object targetRef)`

This method returns a predicate that tests if two arguments are equal according to `Objects.equals(Object, Object)`.
This is not a chaining method.

```java
import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String[] args) {
        Predicate<String> predicate  = Predicate.isEqual("Hello");

        // The same thing can be achieved by below lambda.
        // Predicate<String> predicate  = p -> p.equals("Hello");
    
        System.out.println(predicate.test("Welcome"));
    }
}
```

#### Output

```
false
```

### Introduction to the `BiPredicate` interface

The `Predicate<T>` takes only one parameter and returns the result.
Now suppose we have a requirement where we need to send two parameters (i.e., `Person` object and min age to vote) and then return the result.
Here, we can use `BiPredicate<T, T>`.

The `BiPredicate<T, T>` has a functional method `test(Object, Object)`.
It takes in two parameters and returns a `boolean` value.
Below is the list of methods in the `BiPredicate<T, T>` interface.

![img.png](img/02.png)

If you notice in the above example, we are hard coding the voting age in our lambda, e.g., `p -> p.getAge() > 18`.
The voting age, i.e., 18, is hardcoded here.
If we want to take this age as input, we can use a `BiPredicate` instead of `Predicate`.

In the example shown below, `isPersonEligibleForVoting()` takes in three parameters.
`Person` object, `age`, and `BiPredicate`.

### `PredicateTest.java`

```java
import java.util.function.BiPredicate;

public class PredicateTest {
    static boolean isPersonEligibleForVoting(Person person, Integer minAge, BiPredicate<Person, Integer> predicate) {
        return predicate.test(person, minAge);
    }

    public static void main(String[] args) {
        Person person = new Person("Alex", 23);
        boolean eligible =
            isPersonEligibleForVoting(
                person,
                18,
                (p, minAge) -> {
                  return p.age > minAge;
                });
        System.out.println("Person is eligible for voting: " + eligible);
    }
}

class Person {
    String name;
    int age;
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
```

Similarly, we can use other predicates like `IntPredicate`, `LongPredicate`, and `DoublePredicate`.
The only difference is that these predicates take an input of a particular type, i.e., `int`, `double`, or `long`.

You should now have a clear understanding of using the `Predicate` functional interface in your lambdas.

</details>


<details>
<summary>Supplier Functional Interface</summary>

The following topics are covered:
- `Supplier<T>`
- `IntSupplier`
- `DoubleSupplier`

`Supplier` is an interface that does not take in any argument but produces a value when the `get()` function is invoked.
Suppliers are useful when we don't need to apply any value and obtain a result at the same time.

Below are some functional interfaces available, which can be categorized as a supplier.

| Interface name    | Description                                       | Abstract method          |
|-------------------|---------------------------------------------------|--------------------------|
| `Suppler<T>`      | Represents a supplier of results (reference type) | `T get()`                |
| `DoubleSupplier`  | A supplier of double-value results                | `double getAsDouble()`   |
| `IntSupplier`     | A supplier of int-value results                   | `int getAsInt()`         |
| `LongSupplier`    | A supplier of long-value results                  | `long getAsLong()`       |
| `BooleanSupplier` | A supplier of boolean-value results               | `boolean getAsBoolean()` |

### `Supplier<T>`

The `Supplier<T>` interface supplies a result of type `T`.
In the previous lesson, we were passing a person object and a predicate to our `isPersonEligibleForVoting()` method.

In this example, we will provide a `Supplier<Person>` instead of the Person object.
The `isPersonEligibleForVoting()` method will, itself, fetch the `Person` object from the supplier.
Here is the code for this.

### `SupplierTest.java`

```java
import java.util.function.Predicate;
import java.util.function.Supplier;

public class SupplierTest {
    static boolean isPersonEligibleForVoting(Supplier<Person> supplier, Predicate<Person> predicate) {
        return predicate.test(supplier.get());
    }

    public static void main(String[] args) {
        Supplier<Person> supplier = () -> new Person("Alex", 23);
        Predicate<Person> predicate = (p) -> p.age > 18;
        boolean eligible = isPersonEligibleForVoting(supplier, predicate);
        System.out.println("Person is eligible for voting: " + eligible);
    }
}

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
```

#### Output

```
Person is eligible for voting: true
```

The `Supplier<T>` interface does not contain any default or static methods.
Here are some of the primitive specializations of the supplier interface.

### `IntSupplier`

The `IntSupplier` interface has a method `getAsInt()`, which applies the given operation on its argument and returns an int value.
It is similar to using an object of type `Supplier<Integer>`.

### `SupplierDemo.java`

```java
import java.util.function.IntSupplier;

public class SupplierDemo {
      public static void main(String[] args) {
          IntSupplier supplier = () -> (int)(Math.random() * 10);
          System.out.println(supplier.getAsInt()); 
      }
}
```

#### Output

```
6
```

### `DoubleSupplier`

The `DoubleSupplier` interface has a method `getAsDouble()`, which applies the given operation on its argument and returns a `double` value.
It is similar to using an object of type `Supplier<Double>`.

### `SupplierDemo.java`

```java
import java.util.function.DoubleSupplier;

public class SupplierDemo {
    public static void main(String[] args) {
        DoubleSupplier supplier = () -> (int)(Math.random() * 10);
        System.out.println(supplier.getAsDouble());
    }
}
```

#### Output

```
6.0
```

</details>


<details>
<summary>Consumer Functional Interface</summary>

Basics of Consumer Functional Interfaces

The following topics are covered:
- `Consumer<T>`
- `BiConsumer<T, U>`

`Consumer`s are functional interfaces that take in a parameter and do not produce anything.

Below are some of the functional interfaces which can be categorized as `Consumer`s.

| Interface name         | Description                                                                                         | Abstract method                  |
|------------------------|-----------------------------------------------------------------------------------------------------|----------------------------------|
| `Consumer<T>`          | Represents an operation that accepts a single (reference type) input argument and returns no result | `void accept(T t)`               |
| `DoubleConsumer`       | Accepts a single double-value argument and returns no result                                        | `void accept(double value)`      |
| `IntConsumer`          | Accepts a single int-value argument and returns no result                                           | `void accept(int value)`         |
| `LongConsumer`         | Accepts a single long-value argument and returns no result                                          | `void accept(long value)`        |
| `BiConsumer<T, U>`     | Represents an operation that accepts two (reference type) input arguments and returns no result     | `void accept(T t, U u)`          |
| `ObjDoubleConsumer<T>` | Accepts an object-value and a double-value argument, and returns no result                          | `void accept(T t, double value)` |
| `ObjIntConsumer<T, U>` | Accepts an object-value and an int-value argument, and returns no result                            | `void accept(T t, int value)`    |
| `ObjLongConsumer<T>`   | Accepts an object-value and a long-value argument, and returns no result                            | `void accept(T t, long value)`   |

### `Consumer<T>`

This interface takes a parameter of type `T` and does not return anything.

A consumer can be used in all contexts where an object needs to be consumed; i.e., taken as input, and some operation is performed on the object without returning any result.

Below is the list of methods in the `Consumer` interface. `Consumer<T>` has an abstract method `accept()` and a default method called `andThen()`, which is used for chaining.

![img.png](img/03.png)

In the below example, we will create a `Consumer` which prints a value.

### `ConsumerDemo.java`

```java
import java.util.function.Consumer;

public class ConsumerDemo {
    public static void main(String[] args) {
        Consumer<String> stringConsumer = s -> System.out.println(s);
        stringConsumer.accept("Hello World.");
		
        Consumer<Integer> intConsumer = i -> System.out.println("Integer value = " + i);
        intConsumer.accept(5);
	}
}
```

#### Output

```
Hello World.
Integer value = 5
```

The `andThen()` method, which is a default method in the `Consumer` interface, is used for chaining.
Here is the syntax of this method:

```
Consumer<T> andThen(Consumer<? super T> after)
```

The `andThen()` method returns a composed `Consumer` that performs this operation followed by the `after` operation (see above parameter list).
In the below example, we will create two consumers, and we will chain them together using the `andThen()` method.

### `ConsumerDemo.java`

```java
import java.util.function.Consumer;

public class ConsumerDemo {
    public static void main(String[] args) {
        Consumer<String> consumer1 = (arg) -> System.out.println(arg + "My name is Jane.");
        Consumer<String> consumer2 = (arg) -> System.out.println(arg + "I am from Canada.");
        consumer1.andThen(consumer2).accept("Hello. ");
    }
}
```

#### Output

```
Hello. My name is Jane.
Hello. I am from Canada.
```

### `BiConsumer<T, U>`

This interface takes two parameters and returns nothing.
- `T` - the type of the first argument to the operation
- `U` - the type of the second argument to the operation

This interface has the same methods as present in the `Consumer<T>` interface.

### `BiConsumerDemo.java`

```java
import java.util.function.BiConsumer;

public class BiConsumerDemo {
    public static void main(String[] args) {
      BiConsumer<String, String> greet = (s1, s2) -> System.out.println(s1 + s2);
      greet.accept("Hello", "World");
    }
}
```

#### Output

```
HelloWorld
```

</details>


<details>
<summary>Function Interface</summary>

The following topics are covered:
- `Function<T, R>`
  - `R apply(T t)`
  - `compose(Function<? super V, ? extends T> before)`
  - `andThen(Function<? super R, ? extends V> after)`
- `BiFunction<T, U, R>`

`Function` is a category of functional interfaces that takes an object of type `T` and returns an object of type `R`.

Until now, the functional interfaces that we've discussed have either not taken any argument (`Supplier`), not returned any value (`Consumer`), or returned only a boolean (`Predicate`).

`Function` interfaces are very useful as we can specify the type of input and output.

Below are some of the interfaces that fall in this category.

![img.png](img/04.png)

This section contains a discussion of some types of `Function` functional interfaces.

### `Function<T, R>`

The function takes only one argument of type `T` and returns a result of type `R`.

The following is the list of all the methods in the `Function<T, R>` interface.

![img.png](img/05.png)

Below is an example of each method:

### `R apply(T t)`

This is the abstract method of the `Function` interface.
It takes one argument of type `T` as input and returns a value of type `R`.

In the below example, we will create a function called `lengthFunction`.
It takes a string as input and returns the length of the string as output.

### `FunctionInterfaceDemo.java`

```java
import java.util.function.Function;
 
public class FunctionInterfaceDemo {
    public static void main(String[] args) {
        // Created a function which returns the length of string.
        Function<String, Integer> lengthFunction = str -> str.length();
        System.out.println("String length: " + lengthFunction.apply("This is awesome!!"));
    }
}
```

#### Output

```
String length: 17
```

### `compose(Function<? super V, ? extends T> before)`

Returns a composed function that first applies the function provided as a parameter on the input, and then applies the function on which it is called, to the result.

### `FunctionDemo.java`

```java
import java.util.function.Function;

public class FunctionDemo {

    public static void main(String[] args) {
        // Function which adds 10 to the given element.
        Function<Integer, Integer> increment = x -> x + 10;
        // Function which doubles the given element.
        Function<Integer, Integer> multiply = y -> y * 2;
        // Since we are using compose(), multiplication will be done first and then increment will be done.
        System.out.println("compose result: " + increment.compose(multiply).apply(3));
    }
}
```

#### Output

```
compose result: 16
```

### `andThen(Function<? super R, ? extends V> after)`

This method returns a composed function that first applies the function on which it is called on the input, and then applies the function provided as parameter, to the result.



```java
import java.util.function.Function;

public class FunctionDemo {
    public static void main(String[] args) {
        Function<Integer,Integer> increment = x -> x + 10;
        Function<Integer,Integer> multiply = y -> y * 2;
        // Since we are using andThen(), increment will be done first and then multiplication will be done.
        System.out.println("andThen result: " + increment.andThen(multiply).apply(3));
    }
}
```

#### Output

```
compose result: 26
```

### `BiFunction<T, U, R>`

The `BiFunction<T, U, R>` is similar to `Function<T, R>` interface; the only difference is that the `BiFunction` interface takes in **two** parameters and returns an output.

Below is the list of methods in the `BiFunction` interface.

![img.png](img/06.png)

In the below example, we will create a `BiFunction` that takes two numbers as input and returns their sum.

```java
import java.util.function.BiFunction; 
  
public class BiFunctionInterfaceDemo { 
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        System.out.println("Sum = " + add.apply(2, 3));
    } 
}
```

#### Output

```
Sum = 5
```

</details>


<details>
<summary>Unary Operator</summary>

Explains the `Unary` operator, which is a subtype of the `Function` interface.

The following topics are covered:
- `UnaryOperator<T>`
- `IntUnaryOperator`

### `UnaryOperator<T>`

The `UnaryOperator<T>` interface represents a function that takes one argument of type `T` and returns a value of the same type.
This is similar to the `Function` interface, which is a parent to the `UnaryOperator` interface.

The `UnaryOperator` does not define any new abstract methods.
Since it extends the `Function` interface from the same package, it inherits the following method from the `Function` interface:

`T apply(T t)`

Below are the functional interfaces, which can be categorized as unary operators:

| Interface name     | Description                                                                                                         | Abstract method                        |
|--------------------|---------------------------------------------------------------------------------------------------------------------|----------------------------------------|
| `UnaryOperator<T>` | Represents an operation on a single operand that produces a result of the same type as its operand (reference type) | `T apply(T t)`                         |
| `DoubleConsumer`   | Accepts single double-value operand and produces a double-value result                                              | `double applyAsDouble(double operand)` |
| `IntConsumer`      | Accepts a single int-value operand and produces an int-value result                                                 | `int applyAsInt(int operand)`          |
| `LongConsumer`     | Accepts a single long-value operand and produces a long-value result                                                | `long applyAsLong(long operand)`       |

In the below example, we will create a lambda of unary operator type.
It will take a `Person` object as input, fill data in the object, and return the same object as the output.

```java
import java.util.function.UnaryOperator;

public class UnaryOperatorTest {
    
    public static void main(String[] args) {
        Person person = new Person();
        UnaryOperator<Person> operator = (p) -> {
            p.name = "Poroggo";
            p.age = 34;
            return p;
        };

        operator.apply(person);
        System.out.println("Person Name: " + person.getName() + " Person Age: " + person.getAge());
    }
}

class Person {
    String name;
    int age;

    Person() {}

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) { this.name = name; }

    public void setAge(int age) { this.age = age; }

    public String getName() { return name; }

    public int getAge() { return age; }
}
```

#### Output

```
Person Name: Poroggo Person Age: 3
```

### `IntUnaryOperator`

This is the primitive flavor of the `UnaryOperator`.
It takes an `int` as an argument and returns `int` as a result.
*We should always prefer using the primitive flavors of functional interfaces as boxing and unboxing are not good for performance*.

In the below example, we will create a lambda of `IntUnaryOperator` type.
It takes a number as input and returns its square.

```java
import java.util.function.IntUnaryOperator;

public class UnaryOperatorTest {
    public static void main(String[] args) {
        IntUnaryOperator operator = num -> num * num;
        System.out.println(operator.applyAsInt(25));
    }
}
```

#### Output

```
625
```

</details>

<details>
<summary>Binary operator</summary>

Binary operator functional interface in Java.

The following topics are covered:
- `BinaryOperator<T>`
  - Example

### `BinaryOperator<T>`

`BinaryOperator<T>` is a functional interface that inherits from `BiFunction<T, T, T>` interface.
The `BinaryOperator<T>` interface takes only one parameter as compared to `BiFunction<T, T, T>`, which takes three parameters (two operands' type and one result type).

Both the input objects and the result are of the same type in `BinaryOperator<T>`.

Below are the few interfaces that come under the `BinaryOperator<T>` category.

| Interface name         | Description                                                                                                                      | Abstract method                                   |
|------------------------|----------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------|
| `BinaryOperator<T>`    | Represents an operation upon two operands of the same type, producing a result of the same type as the operands (reference type) | `T apply(T t, T u)`                               |
| `DoubleBinaryOperator` | Accepts two double-value operands and produces a double-value result                                                             | `double applyAsDouble(double left, double right)` |
| `IntBinaryOperator`    | Accepts two int-value operands and produces an int-value result                                                                  | `int applyAsInt(int left, int right)`             |
| `LongBinaryOperator`   | Accepts two long-value operands and produces a long-value result.                                                                | `applyAsLong(long left, long right)`              |

### Example

```java
import java.util.function.BinaryOperator;

public class BinaryOperatorDemo {
    public static void main(String[] args) {
        Person person1 = new Person("Alex", 23);
        Person person2 = new Person("Daniel", 56);
        BinaryOperator<Person> operator = (p1, p2) -> {
            p1.name = p2.name;
            p1.age = p2.age;
            return p1;
        };

        operator.apply(person1, person2);
        System.out.println("Person Name: " + person1.getName() + " Person Age: " + person1.getAge());
    }
}

class Person {
    String name;
    int age;

    Person() {}

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) { this.name = name; }

    public void setAge(int age) { this.age = age; }

    public String getName() { return name; }

    public int getAge() { return age; }
}
```

#### Output

```
Person Name: Daniel Person Age: 56
```

</details>


<details>
<summary>Capturing lambdas</summary>

Explains what capturing lambdas are and discusses a few of the caveats of using them.

The following topics are covered:
- What is effectively final?
- Why should local variables be final or effectively final?

A lambda expression is said to be capturing if it either accesses instance variables of its enclosing class or local variables (final or effectively final) from its enclosing scope.

A lambda expression can capture the three types of variables given below:
- Static variables
- Instance variables
- Local variables

If a lambda expression captures a local variable then the variable should be either **final** or **effectively final**.

### What is effectively final?

**Effectively final** is a new concept that was introduced in Java 8.
A non-final, local variable whose value is never changed after initialization is known as **effectively final**.

Before Java 8, we cannot use a non-final, local variable in an anonymous class.
If you need to access a local variable in an anonymous class, then it should be declared as final.
This restriction is relaxed in Java 8. Now, the compiler, itself can check if the value of a variable is not changed after the assignment.
Then, it is **effectively final**.

Let's look at an example of a capturing lambda.
In the below example, our lambda is capturing a local variable called `i`.
The value of this variable is initialized once and never changed, so it is **effectively final**.

```java
import java.util.function.UnaryOperator;

public class CapturingLambdaDemo {
    public static void main(String[] args){
        int i = 5;
        UnaryOperator<Integer> operator = (input) -> input * i;
        System.out.println(operator.apply(i));
    }
}
```

#### Output

```
25
```

The below code will not compile because we have modified the value of the local variable, and it is not `final` anymore.

```java
import java.util.function.UnaryOperator;

public class CapturingLambdaDemo {
    public static void main(String[] args){
        int i = 5;
        i = 7; // Since we have changed the value of i, the below line will not compile.
        UnaryOperator<Integer> operator = (input) -> input * i;
        System.out.println(operator.apply(i));
    }
}
```

#### Output

```
CapturingLambdaDemo.java:11: error: local variables referenced from a lambda expression must be final or effectively final
        UnaryOperator<Integer> operator = (input) -> input * i; 
                                                             ^
1 error
```

The below code will compile because the variable is reassigned, but it is not a local variable.

```java
import java.util.function.UnaryOperator;

public class CapturingLambdaDemo {
    static int i = 0;
    public static void main(String[] args){
        i = 7;
        UnaryOperator<Integer> operator = (input) -> input * i;
        System.out.println(operator.apply(i));
    }
}
```

#### Output

```
49
```

### Why should local variables be final or effectively final?

Now, let's discuss why the local variable should be *final* or *effectively final* if it is used in a lambda expression.

When a local variable is used in a lambda expression, the lambda makes a copy of that variable.
This occurs because the scope of a lambda expression consists of the duration of time in which the method exists in the genericClasses.
If the lambda does not make a copy of the variable, then the variable is lost after the method is removed from the genericClasses.

Now, if the variable is not final or effectively final, it is possible that the value of the variable is changed after using it in the lambda as shown below.

```java
import java.util.function.Function;

public class CapturingLambdaDemo {
    public static void main(String[] args) {
        Function<Integer, Integer> multiplier = getMultiplier();
        System.out.println(multiplier.apply(10));
    }

    public static Function<Integer,Integer> getMultiplier() {
        int i = 5;
        // The below lambda has copied the value of i.
        Function<Integer, Integer> multiplier = t -> t * i;
        // If you change the value of i here, then the lambda will have old value.
        // So this is not allowed and code will not compile.
        i = 7;
        return multiplier;
    }
}
```

#### Output

```
CapturingLambdaDemo.java:16: error: local variables referenced from a lambda expression must be final or effectively final
        Function<Integer, Integer> multiplier = t -> t * i;
                                                         ^
1 error
```

One of the main purposes of lambdas is use in parallel computing, which means that they're really helpful when it comes to thread-safety.

The "effectively final" paradigm helps a lot with thread-safety, but not in every case.
Lambdas can't change a value of an object from enclosing scope.
But in the case of mutable object variables, a state could be changed inside lambda expressions.

Consider the following code:

```java
int[] total = new int[1];
Runnable r = () -> total[0]++;
r.run();
```

This code is legal, as the `total` variable remains "effectively final," but the object it references **will not have the same state after execution of the lambda**.

After reading this, you should have a clear idea of what **effectively final** variables are and why local variables in lambdas should be **effectively final**.

</details>