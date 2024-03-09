package generics;

import java.util.EnumMap;

class EnumMapExample {
    enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }
}

public class GenericsWithEnumsAndAnnotations {

    public static void main(String[] args) {
        EnumMap<EnumMapExample.Day, String> appointments = new EnumMap<>(EnumMapExample.Day.class);
        appointments.put(EnumMapExample.Day.MONDAY, "Meeting at 10 AM");
        appointments.put(EnumMapExample.Day.WEDNESDAY, "Lunch at 12 PM");

        System.out.println("Appointments for Monday: " + appointments.get(EnumMapExample.Day.MONDAY));
        System.out.println("Appointments for Wednesday: " + appointments.get(EnumMapExample.Day.WEDNESDAY));
    }

}
