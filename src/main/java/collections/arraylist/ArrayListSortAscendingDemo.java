package collections.arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListSortAscendingDemo {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(36);
        list.add(15);
        list.add(11);
        list.add(83);
        list.add(37);
        list.add(97);

        Collections.sort(list);
        System.out.println("ArrayList is in ascending order: " + list);
    }

}
