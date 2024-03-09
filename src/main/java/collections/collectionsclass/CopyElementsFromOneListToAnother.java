package collections.collectionsclass;

import java.util.ArrayList;
import java.util.Collections;

public class CopyElementsFromOneListToAnother {

    public static void main(String[] args) {
        // Create a source list
        ArrayList<Integer> sourceList = new ArrayList<>();
        sourceList.add(1);
        sourceList.add(2);
        sourceList.add(3);

        // Create a destination list
        ArrayList<Integer> destinationList = new ArrayList<>();

        // Copy elements from sourceList to destinationList
        Collections.copy(destinationList, sourceList);

        // Print the destination list
        System.out.println("Destination list: " + destinationList);
    }

}
