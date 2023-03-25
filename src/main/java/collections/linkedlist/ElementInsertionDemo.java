package collections.linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ElementInsertionDemo {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(3);
        linkedList.add(1);
        linkedList.addLast(5);
        System.out.println(linkedList);

        System.out.println("-".repeat(30));

        linkedList.addFirst(0);
        System.out.println(linkedList);

        System.out.println("-".repeat(30));

        linkedList.add(2, 20);
        System.out.println(linkedList);

        System.out.println("-".repeat(30));

        List<Integer> list = new ArrayList<>();
        list.add(101);
        list.add(102);
        list.add(103);

        linkedList.addAll(3, list);
        System.out.println(linkedList);
    }

}
