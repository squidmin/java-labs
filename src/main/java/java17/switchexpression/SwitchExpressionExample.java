package java17.switchexpression;

public class SwitchExpressionExample {
    public static void main(String[] args) {
        String day = "TUESDAY";

        // Using switch expression to determine the type of the day
        String typeOfDay = switch (day) {
            case "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY" -> "Weekday";
            case "SATURDAY", "SUNDAY" -> "Weekend";
            default -> throw new IllegalArgumentException("Invalid day: " + day);
        };

        System.out.println(day + " is a " + typeOfDay);
    }
}
