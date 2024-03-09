package generics;

class Calculator<T extends Number> {
    public T add(T a, T b) {
        return (T) (Number) (a.doubleValue() + b.doubleValue());
    }

    public T subtract(T a, T b) {
        return (T) (Number) (a.doubleValue() - b.doubleValue());
    }

    public T multiply(T a, T b) {
        return (T) (Number) (a.doubleValue() * b.doubleValue());
    }

    public T divide(T a, T b) {
        return (T) (Number) (a.doubleValue() / b.doubleValue());
    }
}

public class BoundedTypeParameters {

    public static void main(String[] args) {
        Calculator<Integer> integerCalculator = new Calculator<>();
        System.out.println("Addition: " + integerCalculator.add(5, 3));
        System.out.println("Subtraction: " + integerCalculator.subtract(5, 3));
        System.out.println("Multiplication: " + integerCalculator.multiply(5, 3));
        System.out.println("Division: " + integerCalculator.divide(5, 3));
    }

}
