package collections.arraylist;

import java.util.Arrays;
import java.util.List;

public class StringJoining {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("hello", "world", "stream");
        String joinedString = String.join("", words);
        System.out.println(joinedString);

        joinedString = String.join(",", "item1", "item2", "item3");
        System.out.println(joinedString);
    }

}
