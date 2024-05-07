package collections.arraylist.exercises;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class MergingAndDeduplicatingArrayLists {

    public static void main(String[] args) {
        // Create two ArrayLists with some predefined values and duplicates across the lists
        List<String> list1 = new ArrayList<>(List.of("apple", "banana", "cherry"));
        List<String> list2 = new ArrayList<>(List.of("banana", "dragonfruit", "apple", "elderberry"));

        // Merge the two lists into a new list
        List<String> mergedList = new ArrayList<>(list1);
        mergedList.addAll(list2);

        // Use a LinkedHashSet to remove duplicates and preserve order
        Set<String> set = new LinkedHashSet<>(mergedList);
        List<String> deduplicatedList = new ArrayList<>(set);

        // Print the deduplicated list
        System.out.println("Merged and Deduplicated List:");
        deduplicatedList.forEach(System.out::println);
    }

}
