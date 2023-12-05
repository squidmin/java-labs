package collections.treeset;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class SmallestAndLargestNumberInArray {

    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        Arrays.stream(DataFixture.numbers).forEach(set::add);
        System.out.println("Largest number in the array: " + set.stream().sorted(Comparator.reverseOrder()).toList().get(0));
        System.out.println("Smallest number in the array: " + set.stream().sorted().toList().get(0));
    }

}
