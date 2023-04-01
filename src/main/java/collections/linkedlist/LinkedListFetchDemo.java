package collections.linkedlist;

import java.util.LinkedList;

public class LinkedListFetchDemo {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);

        System.out.println(linkedList.getFirst());  // 1
        System.out.println(linkedList.getLast());  // 5
        System.out.println(linkedList.get(2));  // 3
    }

}
