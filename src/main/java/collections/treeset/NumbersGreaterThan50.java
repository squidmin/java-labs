package collections.treeset;

import java.util.Arrays;
import java.util.TreeSet;

public class NumbersGreaterThan50 {

    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        Arrays.stream(DataFixture.numbers).forEach(set::add);
        System.out.println("Fetching all the elements greater than 50: " + set.tailSet(50));
    }

}
