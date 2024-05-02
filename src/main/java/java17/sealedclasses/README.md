### Sealed Classes in Java 17 (JEP 409)

**Overview:**
Sealed classes and interfaces restrict which other classes or interfaces may extend or implement them. Introduced in Java 17 as a final feature after being a preview in earlier versions, sealed classes help in creating more controlled hierarchies. They enhance maintainability by clearly defining which classes are allowed to be extended, and they improve security by preventing classes from being subclassed in unintended ways.

Sealed classes are declared with the `sealed` keyword, and they must provide a list of permitted subclasses using the `permits` clause. These subclasses must then choose to be either `final`, `sealed`, or `non-sealed`, explicitly stating how they fit into the class hierarchy:

- `final` prevents further subclassing.
- `sealed` allows subclassing but only from a specified set of classes.
- `non-sealed` allows unrestricted subclassing.

**Key Benefits:**
- **Controlled Extensibility:** Developers have precise control over how a class is extended within the application.
- **Clear Hierarchy:** The hierarchy of classes is clearly visible, making the code easier to understand and maintain.
- **Prevents Misuse:** Restricts the ability of external entities to extend core classes, preventing misuse or unintended behavior.

### Example and Exercise

**Objective:**
Create a sealed class hierarchy for a simple graphic system where shapes can be drawn on a screen. The base class will be a sealed class named `Shape`, and it will permit two types of shapes: `Circle` and `Rectangle`.

**Requirements:**
1. Define a `Shape` class that is sealed and specifies which classes are permitted to extend it.
2. Implement `Circle` and `Rectangle` as permitted subclasses.
3. Each shape should have a method to calculate its area.
4. Demonstrate the creation of each shape and output its area.

### Code Implementation

```java
// Define the sealed class and its permitted subclasses
public abstract sealed class Shape permits Circle, Rectangle {
    abstract double area();  // Abstract method to calculate the area of the shape
}

// Final class Circle cannot be subclassed further
public final class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

// Final class Rectangle cannot be subclassed further
public final class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }
}

// Main class to demonstrate the use of sealed classes
public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(4, 3);

        System.out.println("Area of the circle: " + circle.area());
        System.out.println("Area of the rectangle: " + rectangle.area());
    }
}
```

### Explanation
In this example:
- `Shape` is a sealed class that specifies its two possible concrete subclasses, `Circle` and `Rectangle`, using the `permits` clause.
- Both `Circle` and `Rectangle` are declared as `final`, meaning they cannot be subclassed further. This is a requirement for all classes that are listed as permitted subclasses of a sealed class unless they themselves are declared `sealed` or `non-sealed`.
- Each class implements the `area()` method, demonstrating polymorphism within a controlled class hierarchy.

This exercise and example demonstrate how Java's sealed classes can be used to design a strict and secure object-oriented hierarchy, suitable for scenarios where the extension of classes should be carefully controlled.