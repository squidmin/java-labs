package generics;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
abstract class GeometricObject {

    private String color = "white";
    private boolean filled;
    private Date dateCreated;

    public GeometricObject() {
        dateCreated = new Date();
    }

    public GeometricObject(String color, boolean filled) {
        dateCreated = new Date();
        this.color = color;
        this.filled = filled;
    }

    public double getArea() { return -1; }  // Default implementation; meant to be overridden.

}

@Getter
@Setter
class Rectangle extends GeometricObject {
    private double width, height;
    public Rectangle() {}
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    @Override
    public double getArea() {
        return width * height;
    }
}

@Getter
@Setter
class Circle extends GeometricObject {
    private double radius;
    public Circle() {}
    public Circle(double radius) {
        this.radius = radius;
    }
    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }
    @Override
    public double getArea() {
        return radius * radius * Math.PI;
    }
}


public class BoundedTypeDemo {

    public static <E extends GeometricObject> boolean equalArea(E object1, E object2) {
        return object1.getArea() == object2.getArea();
    }

    public static void main(String[] args) {
        GeometricObject rectangle = new Rectangle(2, 2);
        GeometricObject circle = new Circle(2);
        System.out.println("Same area? " + BoundedTypeDemo.<GeometricObject>equalArea(rectangle, circle));  // false
        System.out.println("Same area? " + BoundedTypeDemo.<GeometricObject>equalArea(rectangle, rectangle));  // false
    }

}