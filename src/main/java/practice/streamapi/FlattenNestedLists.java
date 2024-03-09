package practice.streamapi;

import java.util.ArrayList;
import java.util.List;

public class FlattenNestedLists {

    public static void main(String[] args) {
        List<List<Integer>> nestedLists = new ArrayList<>();
        nestedLists.add(List.of(1, 2, 3));
        nestedLists.add(List.of(4, 5));
        nestedLists.add(List.of(6, 7, 8));

//        List<Integer> flattenedList = flattenNestedLists(nestedLists);
//        System.out.println("Flattened list: " + flattenedList);
    }

}
