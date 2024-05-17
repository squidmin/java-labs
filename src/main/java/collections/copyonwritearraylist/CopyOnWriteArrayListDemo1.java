package collections.copyonwritearraylist;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListDemo1 {

    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        // Create an iterator
        Iterator<String> itr = list.iterator();
        // Add elements after creating the iterator. ConcurrentModificationException will not be thrown.
        list.add("Papaya");

        // Iterating the list via the iterator that was created earlier. "Papaya" will not be present.
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        System.out.println("Again getting the iterator");
        // Again getting the iterator. This time "Papaya" will be present.
        itr = list.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }

}
