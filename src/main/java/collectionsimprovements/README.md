<details>
<summary>forEachRemaining() in Iterator</summary>

Explains the `forEachRemaining()` method, which was introduced in the iterator class in Java 8.

`Iterator` is an interface available in the `Collections` framework in `java.util package`. It is used to iterate a collection of objects. This interface has four methods, as shown in the below image. Before, Java 8 the `forEachRemaining()` method did not exist.

![img.png](img/03.png)

Below is a simple program to iterate a list using iterator before Java 8.

```java
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorDemo {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Grapes");
        fruits.add("Orange");
        
        Iterator<String> iterator = fruits.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
```

#### Output

```
Apple
Banana
Grapes
Orange
```

The above example requires a `while` loop in order to iterate through the input list via an `Iterator`. To avoid this, the `forEachRemaining()` method was introduced in Java 8. This method takes in a `Consumer` instance as a parameter.

The `Consumer` interface section mentioned that the `Consumer` interface takes in a parameter and does not return anything. This is what we require for our iterator. Below is the same example shown above, but this time we are using the `forEachRemaining()` method.

```java
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorDemo {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Grapes");
        fruits.add("Orange");

        Iterator<String> iterator = fruits.iterator();

        iterator.forEachRemaining((fruit) -> System.out.println(fruit));
    }
}
```

#### Output

```
Apple
Banana
Grapes
Orange
```

The main purpose of introducing the `forEachRemaining()` method was to make the iteration code more concise and readable.

---

The next section discusses improvements in the `Map` API.

</details>