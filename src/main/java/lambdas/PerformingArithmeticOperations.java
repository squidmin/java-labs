package lambdas;

public class PerformingArithmeticOperations {

    interface MathOperation {
        int operate(int a, int b);
    }

    public static void main(String[] args) {
        // Define lambda expression for addition
        MathOperation addition = (a, b) -> a + b;
        System.out.println("Addition: " + addition.operate(5, 3));

        // Define lambda expression for subtraction
        MathOperation subtraction = (a, b) -> a - b;
        System.out.println("Subtraction: " + subtraction.operate(5, 3));
    }

}
