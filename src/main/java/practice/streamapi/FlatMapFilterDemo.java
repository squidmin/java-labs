package practice.streamapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlatMapFilterDemo {

    public static void main(String[] args) {
        List<List<String>> list = new ArrayList<>();
        list.add(Arrays.asList("a","b","c"));
        list.add(Arrays.asList("d","e","f"));
        list.add(Arrays.asList("g","h","i"));
        list.add(Arrays.asList("j","k","l"));

        // Created a stream from the list.

        // Flattened the stream.

        // Applied filter on flattened stream.

    }

}