package interfaces;

@FunctionalInterface
interface StringTransformer {
    String transform(String input);
}

public class FunctionalInterfaceAnnotation {

    public static void main(String[] args) {
        // Uppercase transformation using lambda expression
        StringTransformer uppercase = input -> input.toUpperCase();
        System.out.println("Uppercase: " + uppercase.transform("hello"));

        // Lowercase transformation using lambda expression
        StringTransformer lowercase = input -> input.toLowerCase();
        System.out.println("Lowercase: " + lowercase.transform("WORLD"));

        // Reverse transformation using lambda expression
        StringTransformer reverse = input -> new StringBuilder(input).reverse().toString();
        System.out.println("Reverse: " + reverse.transform("Java"));

        // Custom transformation using lambda expression
        StringTransformer custom = input -> input.replaceAll("a", "@");
        System.out.println("Custom: " + custom.transform("banana"));
    }

}
