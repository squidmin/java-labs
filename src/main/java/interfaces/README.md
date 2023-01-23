<details>
<summary>Default methods in interfaces</summary>

## Default methods in interfaces

Learn what default methods in interfaces are and why they were introduced in Java 8.

The following topics are covered:
- Default methods
- Syntax of default methods
- How to resolve issues raised due to the default method

### What are default methods?

Before Java 8, we could only declare abstract methods in an interface. However, Java 8 introduced the concept of default methods. Default methods are methods that can have a body. The most important use of default methods in interfaces is to provide additional functionality to a given type without breaking down the implementing classes.

Before Java 8, if a new method was introduced in an interface then all the implementing classes used to break. We would need to provide the implementation of that method in all the implementing classes.

However, sometimes methods have only single implementation and there is no need to provide their implementation in each class. In that case, we can declare that method as a default in the interface and provide its implementation in the interface itself.

### Syntax of default methods

Let’s understand the syntax of default methods through an example. Here, we have an interface with one abstract and one default method:

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

As shown above, the class needs to implement only the abstract method. When we call the default method, the code defined in the interface is executed.

### How to resolve issues raised due to the default method

Although default methods are very good additions to Java and make developing a lot easier, they have one caveat that needs to be considered while coding.

To see this caveat, Let’s look at an example. Here, we have two interfaces with a default method of the same name, i.e., printSomething().

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

Now we will define a Main class that will implement both these interfaces. Before we proceed further I would like you to think about below questions:
1. Do we need to implement the `printSomething()` method in the Main class? Will the class compile if we don’t?
2. If some class calls the printSomething() method from the object of Main class then which implementation will be called? Will it call the method defined in `InterfaceA` or `InterfaceB`?

Create the `Main` class that will implement both the interfaces.

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

</details>

<details>
<summary>Static methods in interfaces</summary>

## Static methods in interfaces

Explains static methods in interfaces and why they were introduced in Java 8.

The following topics are covered:
- What are static methods in interfaces?

### What are static methods in interfaces?

The static methods in interfaces are similar to default methods but the only difference is that you can't override them. Now, why do we need static methods in interfaces if we already have default methods?

Suppose you want to provide some implementation in your interface and you don't want this implementation to be overridden in the implementing class, then you can declare the method as static.

In the below example, we'll define a `AnInterface` interface with a static method called staticMethod().

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

Also, since a static method is hidden, we can’t call it from the object of the implementing class. The below code will also not compile:

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
        AnInstance anInstance = new AnInstance();
        AnInstance.staticMethod(); // This will compile.
    }
}
```

#### Terminal output

```
This is a static method...
```

</details>