## Instances

<details>
<summary>Default methods in interfaces</summary>

## Default methods in interfaces

Learn what default methods in interfaces are and why they were introduced in Java 8.

The following topics are covered:
- Default methods
- Syntax of default methods
- How to resolve issues raised due to the default method

### What are default methods?

Before Java 8, we could only declare abstract methods in an interface.
However, Java 8 introduced the concept of default methods.
Default methods are methods that can have a body.
The most important use of default methods in interfaces is to provide additional functionality to a given type without breaking down the implementing classes.

Before Java 8, if a new method was introduced in an interface then all the implementing classes used to break.
We would need to provide the implementation of that method in all the implementing classes.

However, sometimes methods have only single implementation and there is no need to provide their implementation in each class.
In that case, we can declare that method as a default in the interface and provide its implementation in the interface itself.

### Syntax of default methods

Let’s understand the syntax of default methods through an example.
Here, we have an interface with one abstract and one default method:

```java
public interface AnInterface {
    
    void abstractMethod();
    
    default void defaultMethod() {
        System.out.println("Executing defaultMethod...");
    }
    
}
```

Now create a class which implements the `AnInterface` interface.

```java
public class AnInstance implements AnInterface {

    @Override
    public void abstractMethod() {
        System.out.println("Executing abstractMethod...");
    }

    public static void main(String[] args) {
        AnInstance anInstance = new AnInstance();
        anInstance.abstractMethod();
        anInstance.defaultMethod();
    }

}
```

As shown above, the class needs to implement only the abstract method.
When we call the default method, the code defined in the interface is executed.

### How to resolve issues raised due to the default method

Although default methods are very good additions to Java and make developing a lot easier, they have one caveat that needs to be considered while coding.

To see this caveat, Let's look at an example. Here, we have two interfaces with a default method of the same name, i.e., `printSomething()`.

#### InterfaceA:

```java
public interface InterfaceA {
    default void printSomething() {
        System.out.println("I am inside `InterfaceA`");
    }
}
```

#### InterfaceB

```java
public interface InterfaceB {
    default void printSomething() {
        System.out.println("I am inside `InterfaceB`");
    }
}
```

Now a `Main` class will be defined, which will implement both of these interfaces.

Before going any further, think about the below questions:
1. Do we need to implement the `printSomething()` method in the `Main` class? If not, will the class still compile?
2. If the `printSomething()` method is called from an instance of `Main` class, then which implementation will be called?
   Will it call the method defined in `InterfaceA` or `InterfaceB`?

Create the `Main` class that will implement both of the interfaces.

#### Main.java

```java
public class Main implements InterfaceA, InterfaceB {

}
```

The above class will not compile because of the "**Diamond problem**" in Java.

#### Terminal output

```
Main.java:1: error: class Main inherits unrelated defaults for printSomething() from types InterfaceA and InterfaceB
public class Main implements InterfaceA, InterfaceB {
       ^
1 error
```

To resolve the compilation issue, we will have to implement the `printSomething()` method as shown below:

#### Main.java

```java
public class Main implements InterfaceA, InterfaceB {

    @Override
    public void printSomething() {
        // Option 1 -> Provide our own implementation.
        System.out.println("I am inside Main class");

        // Option 2 -> Use existing implementation from InterfaceA or InterfaceB or both.
        InterfaceA.super.printSomething();
        InterfaceB.super.printSomething();
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.printSomething();
    }
    
}
```

#### Terminal output

```
I am inside Main class
I am inside `InterfaceA`
I am inside `InterfaceB`
```

Just as with regular interfaces, extending different functional interfaces with the same default method can be problematic for the reasons described above.

Adding too many default methods to an interface is not a very good architectural decision.
It should be considered a compromise, only to be used when required for upgrading existing interfaces without breaking backward compatibility.

To summarize, default methods in functional interfaces should not be overused. 

</details>

<details>
<summary>Static methods in interfaces</summary>

## Static methods in interfaces

Explains static methods in interfaces and why they were introduced in Java 8.

The following topics are covered:
- What are static methods in interfaces?

### What are static methods in interfaces?

The static methods in interfaces are similar to default methods but the only difference is that you can't override them.
Now, why do we need static methods in interfaces if we already have default methods?

Suppose you want to provide some implementation in your interface and you don't want this implementation to be overridden in the implementing class, then you can declare the method as static.

In the below example, we'll define a `AnInterface` interface with a static method called `staticMethod()`.

```java
public interface AnInterface {
    static void staticMethod(){
        System.out.println("This is a static method...");
    }
}
```

Declare a class `AnInstance` which implements the `AnInterface` interface.

```java
public class AnInstance implements AnInterface {

    @Override
    public void staticMethod() {
        System.out.println("This is a static method...");
    }

    public static void main(String[] args) {
        AnInstance anInstance = new AnInstance();
        anInstance.staticMethod();
    }

}
```

In the above interface, we get a compilation error in the `AnInstance` class because a static method cannot be overridden.

```
AnInstance.java:3: error: method does not override or implement a method from a supertype
    @Override
    ^
1 error
```

Also, since a static method is hidden, we can't call it from the object of the implementing class.
The below code will also not compile:

#### AnInterface.java

```java
public interface AnInterface {
    static void staticMethod() {
        System.out.println("This is a static method...");
    }
}
```

#### AnInstance.java

```java
public class AnInstance implements AnInterface {
    public static void main(String[] args) {
        AnInstance anInstance = new AnInstance();
        anInstance.staticMethod();  // This will not compile.
    }
}
```

#### Terminal output

```
AnInstance.java:6: error: cannot find symbol
        anInstance.staticMethod();  // This will not compile.
           ^
  symbol:   method staticMethod()
  location: variable anInstance of type AnInstance
1 error
```

The below class will compile because we are calling the static method that is defined in the interface from the interface reference.

#### AnInterface.java

```java
public interface AnInterface {
    static void staticMethod() {
        System.out.println("This is a static method...");
    }
}
```

#### AnInstance.java

```java
public class AnInstance implements AnInterface {
    public static void main(String[] args) {
        AnInstance anInstance = new AnInstance();  // Can't use this instance to call the interface's static method.
        AnInterface.staticMethod(); // This will compile.
    }
}
```

#### Terminal output

```
This is a static method...
```

</details>

<details>
<summary>Functional Interfaces in Java</summary>

## Functional Interfaces in Java

Explains the concept of functional interfaces which were introduced in Java 8.

The following topics are covered:
- What are functional interfaces?
- What is the `@FunctionalInterface` annotation?

### What are functional interfaces?

An interface that has a **single abstract method** is called a *functional interface*.

While an interface can have one or more default methods, it should have only **one abstract method** to be called a functional interface.

Java 8 has defined the `java.util.function` package, containing lots of functional interfaces.
Some functional interfaces defined in Java 8 are **Predicate**, **Consumer**, **Supplier**, **Function**, etc.

The functional interface is used by **lambda expressions**.

### What is the `@FunctionalInterface` annotation?

Any interface that has only one abstract method can be annotated with the `@FunctionalInterface` annotation.

This is *not mandatory*, but if an interface *is* annotated with the `@FunctionalInterface` annotation and someone tries to add another abstract method to the interface, then the compiler will throw an error.
Below is an example of a functional interface.

```java
@FunctionalInterface
public interface Functional {
    void doSomething();

    default void foo() {
        System.out.println("foo");
    }
}
```

If we try to add one more abstract method in the above interface, the compiler shows an error.
If an interface is annotated with `@FunctionalInterface` annotation but does not contain even a single abstract method, then also the compiler will complain.

### Avoid overloading methods with functional interfaces as parameters

Methods should have different names to avoid collisions.

```java
public interface Processor {
    String process(Callable<String> c) throws Exception;
    String process(Supplier<String> s);
}

public class ProcessorImpl implements Processor {
    @Override
    public String process(Callable<String> c) throws Exception {
        // implementation details
    }

    @Override
    public String process(Supplier<String> s) {
        // implementation details
    }
}
```

At first glance this seems reasonable, but any attempt to execute either of the `ProcessorImpl`'s methods:

```
String result = processor.process(() -> "abc");
```

Ends with an error with the following message:

```
reference to process is ambiguous
both method process(java.util.concurrent.Callable<java.lang.String>) 
in com.squidmin.interfaces.ProcessorImpl 
and method process(java.util.function.Supplier<java.lang.String>) 
in com.squidmin.interfaces.ProcessorImpl match
```

To solve this problem, we have two options. The first option is to use methods with different names:

```
String processWithCallable(Callable<String> c) throws Exception;

String processWithSupplier(Supplier<String> s);
```

The second option is to perform casting manually, which is not preferred:

```
String result = processor.process((Supplier<String>) () -> "abc");
```

</details>
