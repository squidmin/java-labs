package collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;

public class IteratorDemo {

    public static void iterate(int endRange) {
        List<Integer> ints = new ArrayList<>();
        IntStream.range(0, endRange).forEach(ints::add);
        Iterator<Integer> iterator = ints.iterator();
        while (iterator.hasNext()) { System.out.println(iterator.next()); }
    }

}
