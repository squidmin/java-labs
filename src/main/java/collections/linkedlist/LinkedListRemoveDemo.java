package collections.linkedlist;

import java.util.LinkedList;

public class LinkedListRemoveDemo {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(2);
        linkedList.add(4);
        linkedList.add(5);

        System.out.println("LinkedList before removing any element: " + linkedList);

        linkedList.remove();  // Remove the first element.
        System.out.println("LinkedList after removing the first element: " + linkedList);

        linkedList.removeLast();  // Remove the last element.
        System.out.println("LinkedList after removing the last element: " + linkedList);

        linkedList.remove(Integer.valueOf(2));  // Remove the first occurrence of 2.
        System.out.println("LinkedList after removing the first occurrence of 2: " + linkedList);

        linkedList.removeLastOccurrence(4);
        System.out.println("LinkedList after removing the last occurrence of 4: " + linkedList);
    }

}
