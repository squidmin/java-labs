package timeapi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertDates {

    public static List<String> preprocessDate(List<String> dates) {
        return dates.stream()
            .map(ConvertDates::convertDate)
            .collect(Collectors.toList());
    }

    private static String convertDate(String date) {
        String[] parts = date.split(" ");
        String day = parts[0].replaceAll("[^0-9]", "");
        String month = getMonthNumber(parts[1]);
        String year = parts[2];

        LocalDate parsedDate = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
        return parsedDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    private static String getMonthNumber(String month) {
        return switch (month) {
            case "Jan" -> "01";
            case "Feb" -> "02";
            case "Mar" -> "03";
            case "Apr" -> "04";
            case "May" -> "05";
            case "Jun" -> "06";
            case "Jul" -> "07";
            case "Aug" -> "08";
            case "Sep" -> "09";
            case "Oct" -> "10";
            case "Nov" -> "11";
            case "Dec" -> "12";
            default -> throw new IllegalArgumentException();
        };
    }

    public static void main(String[] args) {
        List<String> dates = Arrays.asList("1st Mar 1974", "22nd Jan 2013", "7th Apr 1904");
        List<String> convertedDates = preprocessDate(dates);
        convertedDates.forEach(System.out::println);
    }

}
