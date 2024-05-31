package java17.patternmatchinginstanceof;

public class PatternMatchingExample {

    public static void main(String[] args) {
        Object obj = "This is a string.";

        // Traditional way
        if (obj instanceof String) {
            String s = (String) obj;
            System.out.println("Traditional way: " + s.toUpperCase());
        }

        // Using pattern matching for instanceof
        if (obj instanceof String s) {
            System.out.println("Pattern matching way: " + s.toUpperCase());
        }
    }

}
