package java17.sealedclasses;

// Main class to demonstrate the use of sealed classes
public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(4, 3);

        System.out.println("Area of the circle: " + circle.area());
        System.out.println("Area of the rectangle: " + rectangle.area());
    }
}
