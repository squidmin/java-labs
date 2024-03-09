package lambdas;

import java.util.function.Function;

public class ReversingStrings {

    public static void main(String[] args) {
        // Define lambda expression for reversing strings
        Function<String, String> reverseString = s -> new StringBuilder(s).reverse().toString();
        System.out.println("Reversed string: " + reverseString.apply("hello"));
    }

}
