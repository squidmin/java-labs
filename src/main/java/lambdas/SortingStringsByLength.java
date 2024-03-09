package lambdas;

import java.util.Arrays;

public class SortingStringsByLength {

    public static void main(String[] args) {
        String[] words = {"apple", "banana", "orange", "grape"};

        // Sort strings by length using lambda expression
        Arrays.sort(words, (s1, s2) -> s1.length() - s2.length());

        // Print sorted array
        System.out.println(Arrays.toString(words));
    }

}
