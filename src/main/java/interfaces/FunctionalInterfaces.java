package interfaces;

@FunctionalInterface
interface Calculator {
    int calculate(int a, int b);
}

public class FunctionalInterfaces {

    public static void main(String[] args) {
        // Addition using lambda expression
        Calculator addition = (a, b) -> a + b;
        System.out.println("Addition: " + addition.calculate(5, 3));

        // Subtraction using lambda expression
        Calculator subtraction = (a, b) -> a - b;
        System.out.println("Subtraction: " + subtraction.calculate(10, 4));

        // Multiplication using lambda expression
        Calculator multiplication = (a, b) -> a * b;
        System.out.println("Multiplication: " + multiplication.calculate(6, 7));

        // Division using lambda expression
        Calculator division = (a, b) -> {
            if (b != 0) {
                return a / b;
            } else {
                throw new ArithmeticException("Cannot divide by zero");
            }
        };
        System.out.println("Division: " + division.calculate(20, 5));
    }

}
