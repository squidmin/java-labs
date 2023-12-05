package sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SortNamesAndNumerals {

    private static final Map<Character, Integer> ROMAN_VALUES = Map.of(
        'I', 1,
        'V', 5,
        'X', 10,
        'L', 50,
        'C', 100,
        'D', 500,
        'M', 1000
    );

    private static void sortNamesAndNumerals(List<String> list) {
        list.sort((s1, s2) -> {
            String[] split1 = s1.split(" ");
            String[] split2 = s2.split(" ");

            int nameCompare = split1[0].compareTo(split2[0]);
            if (nameCompare != 0) {
                return nameCompare;
            }

            int numeral1 = romanToInt(split1[1]);
            int numeral2 = romanToInt(split2[1]);

            return Integer.compare(numeral1, numeral2);
        });
    }

    private static int romanToInt(String s) {
        int sum = 0;
        int prevValue = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int value = ROMAN_VALUES.get(s.charAt(i));

            if (value < prevValue) {
                sum -= value;
            } else {
                sum += value;
            }
            prevValue = value;
        }

        return sum;
    }

    public static void main(String[] args) {
        List<String> namesAndNumerals = new ArrayList<>(List.of("John X", "Alice V", "John IX", "Alice IV"));
        sortNamesAndNumerals(namesAndNumerals);
        System.out.println(namesAndNumerals);
    }

}
