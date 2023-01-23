<details>
<summary>Lambda basics</summary>

The following topics are covered:
- Lambda expression definition
- How to write a lambda expression

### What is a lambda expression?

Java is an object-oriented language. By introducing lambdas in Java 8, the authors of Java tried to add elements of functional programming in Java. Now you might be wondering what the difference between object-oriented programming and functional programming is?

In object-oriented programming, objects and classes are the main entities. If we create a function then it should exist within a class. A function has no meaning outside the scope of the class object.

In functional programming, functions can exist outside the scope of an object. We can assign them to a reference variable and we can also pass them to other methods as a parameter.

A lambda expression is just an *anonymous function*, i.e., a function with **no name** and that is **not bound to an identifier**. We can pass it to other methods as parameters, therefore, using the power of functional programming in Java.

### How to write a lambda expression

It might be difficult to understand what lambda is and how to write a lambda without looking at an example. So, let’s look at an example first, and then we will revisit what we just read.

In the below example, we have a functional interface called `AFunctionalInterface`. There are two classes `ClassA` and `ClassB` that implement this interface.

#### AFunctionalInterface

```java
@FunctionalInterface
public interface AFunctionalInterface {
    void execute();
}
```

#### ClassA

```java
public class ClassA implements AFunctionalInterface {
    // Overriding the execute() method from AFunctionalInterface interface.
    @Override
    public void execute() {
        System.out.println("Namaste");
    }
}
```

#### ClassB

```java
public class ClassB implements AFunctionalInterface {
    // Overriding the execute() method from AFunctionalInterface interface.
    @Override
    public void execute() {
        System.out.println("Hi");
    }
}
```

Here, we have another class called `ClassC`. This class has a method called `wish(AFunctionalInterface functionalInterface)` which takes `AFunctionalInterface` as a parameter, and based on the type of object passed, prints the output of the `execute()` method.

#### ClassC

```java
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

When we run the `ClassC` class, we get the below output:

```
Namaste
Hi
```

This is a classic object-oriented programming example. Now, what if we want our `ClassC` class to greet in all the languages available?

Do we need to create a class for each concrete entity, e.g., `ClassD`, `ClassE`, `ClassF`, etc?

Isn't it possible that we don't create any class and just send a function to the `wish(AFunctionalInterface functionalInterface)` method?

Our `wish(AFunctionalInterface functionalInterface)` method will directly execute the function that is provided to it and print the output.

This is possible through anonymous classes. We will quickly see how this can be done through an anonymous class, and then jump straight back into lambdas.

In the below example, we will change the `ClassC` class to use an anonymous class.

#### AFunctionalInterface

```java
@FunctionalInterface
public interface AFunctionalInterface {
    void execute();
}
```

#### ClassC

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

In the above example, we don’t need to create a class for each language. We can use an anonymous class, and that does the trick for us in the example above. However, don’t you think that this code is still cumbersome? Although the class is anonymous, we are still creating a class.

To make our code less cumbersome, let’s remove all the unnecessary code step-by-step and create our first lambda expression.

**Step 1**: The compiler knows that the `wish(AFunctionalInterface functionalInterface)` method takes in a parameter of type `AFunctionalInterface`. So, we don’t need to specifically create an anonymous class of type `AFunctionalInterface`.

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

**Step 2**: We know that the `AFunctionalInterface` interface has only one method. So, we don’t need to provide the method name. We are only concerned with the method body.

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

**Step 3**: The compiler can understand that the body does not return anything. So, mentioning the return type is redundant. We can also remove the `public` declaration.

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

Please note that we add a `->` between the empty brackets and the method body. This is how a lambda expression is declared.

There still is one more improvement we can make. Since the method body contains only a single line, the curly braces are also unnecessary.

#### AFunctionalInterface

```java
@FunctionalInterface
public interface AFunctionalInterface {
    void execute();
}
```

#### ClassC

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

To recap, when we write a lambda expression, we are basically sending a function as a method parameter, and it is directly getting executed.

Note that lambda expressions are not compiled to anonymous inner classes. Instead, lambdas get wrapped inside new classes generated during runtime.

</details>
