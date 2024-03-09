package lambdas;

import java.util.function.Function;

public class ChainingFunctions {

    public static void main(String[] args) {
        // Define functions
        Function<Integer, Integer> doubleNumber = n -> n * 2;
        Function<Integer, Integer> squareNumber = n -> n * n;

        // Chain functions using lambda expression
        Function<Integer, Integer> doubleThenSquare = doubleNumber.andThen(squareNumber);

        // Test chained function
        System.out.println("Result of double then square: " + doubleThenSquare.apply(5));
    }

}
