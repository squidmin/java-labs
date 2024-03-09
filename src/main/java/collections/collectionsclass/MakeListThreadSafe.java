package collections.collectionsclass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MakeListThreadSafe {

    public static void main(String[] args) {
        // Create a non-thread-safe ArrayList
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Java");
        arrayList.add("Python");
        arrayList.add("C++");

        // Make the ArrayList thread-safe
        List<String> synchronizedList = Collections.synchronizedList(arrayList);

        // Print the synchronized list
        System.out.println("Synchronized list: " + synchronizedList);
    }

}
