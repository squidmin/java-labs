package java17.sealedclasses;

// Define the sealed class and its permitted subclasses
public abstract sealed class Shape permits Circle, Rectangle {
    abstract double area(); // Abstract method to calculate the area of the shape
}
