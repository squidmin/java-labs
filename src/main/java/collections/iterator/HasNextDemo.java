package collections.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;

public class HasNextDemo {

    public static void run(int endRange) {
        List<Integer> ints = new ArrayList<>();
        IntStream.range(0, endRange).forEach(ints::add);
        Iterator<Integer> iterator = ints.iterator();
        while (iterator.hasNext()) { System.out.println(iterator.next()); }
    }

    public static void main(String[] args) {
        run(8);
    }

}
