package interfaces;

// Interface definition
interface Vehicle {
    default void start() {
        System.out.println("Starting the vehicle...");
    }
}

interface Convertible {
    default void openRoof() {
        System.out.println("Opening the roof...");
    }
}

// Car class implementing Vehicle interface
class Car implements Vehicle, Convertible {
    // Custom implementation of start method for Car
    @Override
    public void start() {
        System.out.println("Starting the car...");
    }
    @Override
    public void openRoof() {
        System.out.println("Opening the car's roof...");
    }
}

// Motorcycle class implementing Vehicle interface
class Motorcycle implements Vehicle {
    // Custom implementation of start method for Motorcycle
    @Override
    public void start() {
        System.out.println("Starting the motorcycle...");
    }
}

// Main class to test the implementations
public class DefaultMethods {
    public static void main(String[] args) {
        // Creating instances of Car and Motorcycle
        Car car = new Car();
        Motorcycle motorcycle = new Motorcycle();

        // Calling start method for Car and Motorcycle
        car.start();
        car.openRoof();
        motorcycle.start();
    }
}
