package collections.linkedlist;

import java.util.Collections;
import java.util.LinkedList;

public class LinkedListSortDemo {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.add(20);
        linkedList.add(2);
        linkedList.add(12);
        linkedList.add(40);
        linkedList.add(76);
        linkedList.add(41);
        linkedList.add(53);

        System.out.println("List before sorting:");
        System.out.println(linkedList);
        System.out.println();

        Collections.sort(linkedList);

        System.out.println("List after sorting:");
        System.out.println(linkedList);
    }

}
