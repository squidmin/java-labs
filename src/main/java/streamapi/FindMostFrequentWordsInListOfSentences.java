package streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindMostFrequentWordsInListOfSentences {

    public static List<String> mostFrequentWords(List<String> sentences) {
        return sentences.stream()
            .flatMap(sentence -> Arrays.stream(sentence.split("\\s+")))
            .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()))
            .entrySet().stream()
            .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
            .limit(5)
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> sentences = List.of(
            "Java is a programming language",
            "Java is used in web development",
            "Python is also a programming language",
            "Java and Python are popular languages"
        );

        List<String> frequentWords = mostFrequentWords(sentences);
        System.out.println("Most frequent words: " + frequentWords);
    }

}
