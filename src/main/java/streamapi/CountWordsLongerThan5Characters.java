package streamapi;

import java.util.List;

public class CountWordsLongerThan5Characters {

    public static long countWordsLongerThanFiveChars(List<String> words) {
        return words.stream()
            .filter(word -> word.length() > 5)
            .count();
    }

    public static void main(String[] args) {
        List<String> words = List.of("apple", "banana", "orange", "pineapple", "grape");
        long count = countWordsLongerThanFiveChars(words);
        System.out.println("Words longer than 5 characters: " + count);
    }

}
