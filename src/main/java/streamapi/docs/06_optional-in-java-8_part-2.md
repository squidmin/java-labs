# `Optional` in Java 8: Part 2

Discuss some of the methods added in `Optional` class and discuss their functionalities.

The following topics will be covered:
1) `isPresent()`
2) `ifPresent(Consumer<? super T> consumer)`
3) `get()`
4) `orElse(T other)`
5) `orElseGet(Supplier<? extends T> other)`
6) `orElseThrow(Supplier<? extends T> other)`
7) `Optional<T> filter(Predicate<? super T> predicate)`
8) `map(Function<? super T, ? extends U> mapper)`
9) `flatMap(Function<? super T, Optional<U>> mapper)`

In the previous section, we looked at the `Optional<T>` class. You learned what an `Optional` is and how to create it.

In this section, we will look at all the operations that we can perform using an `Optional`.

Below is the list of methods available in the `Optional` class.

![img.png](docs/img/02.png)

### 1) `isPresent()`

The `isPresent()` method is used to check if the optional contains a value or if it is `null`.

The method `isPresent()` returns the value `true` in case the `id` of the `Optional` objects contains a non-null value. Otherwise, it returns a `false` value.

```java
Optional<Person> optional = getPerson();
if (optional.isPresent()) {
    System.out.println(optional.get.getName())
}
```

### 1) `ifPresent(Consumer<? super T> consumer)`

Here is the syntax of the `ifPresent()` method.

`public void ifPresent(Consumer<? super T> consumer)`

It takes in a `Consumer` as a parameter and returns nothing. When `ifPresent()` is called, if a value is present, the specified consumer is invoked with the value. Otherwise, nothing happens.

```java
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class StreamDemo {
    Map<Integer, Employee> empMap = new HashMap<>();
    public void populateEmployee() {
        empMap.put(123, new Employee("Alex", 23, 12000));
    }
    public Optional<Employee> getEmployee(Integer employeeId) {
        // Before returning the employee object we are wrapping it into an Optional
        return Optional.ofNullable(empMap.get(employeeId));
    }
    public static void main(String[] args) {
        StreamDemo demo = new StreamDemo();
        demo.populateEmployee();
        Optional<Employee> emp = demo.getEmployee(123);
        emp.ifPresent(System.out::println);
    }
}

class Employee {
    ...
}
```

#### Output

```
Employee{name='Alex', age=23, salary=12000}
```

### 3) `get()`

The `get()` method returns a value if it is present in this `Optional`. Otherwise, it throws `NoSuchElementException`.

It is risky to use this method without checking if the value is present or not using `isPresent()` method.

```java
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        Optional<String> optional = Optional.ofNullable(null);
        // This will throw exception because optional contains a null value.
        System.out.println(optional.get());
    }
}
```

#### Output

```
Exception in thread "main" java.util.NoSuchElementException: No value present
	at java.util.Optional.get(Optional.java:135)
	at OptionalDemo.main(OptionalDemo.java:11)
```

### 3) `orElse(T other)`

This method returns the value present in the optional. If no value is present, then a default value provided as a parameter is returned.

```java
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        Optional<String> optional = Optional.ofNullable(null);
        // This will return the default value.
        System.out.println(optional.orElse("default string"));
    }
}
```

#### Output

```
default string
```

### 5) `orElseGet(Supplier<? extends T> other)`

This method returns the value present in the optional. If no value is present, then the value calculated from the supplier provided as a parameter is returned.

```java
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OptionalDemo {
    public static String getDefaultValue() { return "default"; }
    public static void main(String[] args) {
        Optional<String> optional = Optional.ofNullable(null);
        // This will return the default value.
        System.out.println(optional.orElseGet(OptionalDemo::getDefaultValue));
    }
}
```

#### Output

```
default
```

### 6) `orElseThrow(Supplier<? extends T> other)`

This method returns the value present in the optional. If no value is present, then it throws the exception created by the provided supplier.

```java
import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        Optional<String> optional = Optional.ofNullable(null);
        // This will throw exception
        try {
            System.out.println(optional.orElseThrow(() -> new Exception("Resource not found.")));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
```

#### Output

```
java.lang.Exception: Resource not found.
	at OptionalDemo.lambda$main$0(OptionalDemo.java:10)
	at java.util.Optional.orElseThrow(Optional.java:290)
	at OptionalDemo.main(OptionalDemo.java:10)
```

### 7) `Optional<T> filter(Predicate<? super T> predicate)`

The `filter()` method is used to check if the value in our optional matches a particular condition. If yes, then the optional with the value is returned. Otherwise, an empty optional is returned.

```java
import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        Optional<String> optional = Optional.ofNullable("orange");
        // Since the filter condition is matched, this will return the optional.
        System.out.println(optional.filter(str -> str.equals("orange")));
        // Since the filter condition is not matched, this will return empty optional.
        System.out.println(optional.filter(str -> str.equals("apple")));
    }
}
```

#### Output

```
Optional[orange]
Optional.empty
```

### 8) `map(Function<? super T, ? extends U> mapper)`

As per Java docs,

<blockquote>“if a value is present, apply the provided mapping function to it, and if the result is non-null, return an Optional describing the result. Otherwise, return an empty Optional.”</blockquote>

```java
import java.util.*;

public class StreamDemo {
    public static void main(String[] args) {
        // Creating an Optional of Employee object.
        Optional<Employee> optional = Optional.of(new Employee("Adam", 54, 20000));
        optional
                .map(emp -> emp.getSalary()) // Fetching the salary from employee object.
                .filter(sal -> sal > 10000) // Checking if the salary is greater than 10000.
                .ifPresent(System.out::println);
    }
}

class Employee {
    ...
}
```

#### Output

```
20000
```

### 9) `flatMap(Function<? super T, Optional<U>> mapper)`

Similar to the `map()` method, we also have the `flatMap()` method as an alternative for transforming values.

The difference is that the `map` transforms values only when they are unwrapped, whereas `flatMap` takes a wrapped value and unwraps it before transforming it.

Let's take the same example that we discussed while looking at `map()`. There is a slight modification though. The `getSalary()` method will return `Optional<Integer>`, so the return type of the `optional.map(emp -> emp.getSalary())` operation will be `Optional<Optional<Integer>>`.

`Optional<Optional<Integer>> op1 = optional.map(emp -> emp.getSalary());`

If we don't need a nested `Optional`, then we can use a `flatMap()`.

`Optional<Integer> op1 = optional.flatMap(emp -> emp.getSalary());`

Here is the complete code example.

```java
import java.util.*;

public class OptionalDemo {
    public static void main(String[] args) {
        // Creating an Optional of Employee object.
        Optional<Employee> optional = Optional.of(new Employee("Adam", 54, 20000));
        optional.flatMap(emp -> emp.getSalary())
                .filter(sal -> sal > 10000)
                .ifPresent(System.out::println);
    }
}

class Employee {
    ...
}
```

---

The following section discusses slicing operations in `Stream`.
