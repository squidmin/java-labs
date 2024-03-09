package lambdas;

import java.util.function.Predicate;

public class CombiningPredicates {

    public static void main(String[] args) {
        // Define predicates
        Predicate<Integer> isEven = n -> n % 2 == 0;
        Predicate<Integer> isPositive = n -> n > 0;

        // Combine predicates using lambda expression
        Predicate<Integer> isEvenAndPositive = isEven.and(isPositive);

        // Test combined predicate
        System.out.println("Is 6 even and positive? " + isEvenAndPositive.test(6));
        System.out.println("Is -5 even and positive? " + isEvenAndPositive.test(-5));
    }

}
