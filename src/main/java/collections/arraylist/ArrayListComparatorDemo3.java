package collections.arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Vehicle5 {
    String brand;
    Integer makeYear;

    public Vehicle5(String brand, Integer makeYear) {
        super();
        this.brand = brand;
        this.makeYear = makeYear;
    }
}

public class ArrayListComparatorDemo3 {

    public static void main(String[] args) {
        List<Vehicle5> list = new ArrayList<>();
        list.add(new Vehicle5("Volkswagen", 2010));
        list.add(new Vehicle5("Audi", 2009));
        list.add(new Vehicle5("Ford", 2001));
        list.add(new Vehicle5("BMW", 2015));
        System.out.println("Sorting by brand name");
        Collections.sort(list, (o1, o2) -> o1.brand.compareTo(o2.brand));
        //list.sort(Comparator.comparing(o -> o.brand));  // List.sort() can also be used with Comparator.comparing().

        for (Vehicle5 vehicle : list) {
            System.out.println("Vehicle Brand: " + vehicle.brand + ", Vehicle Make: " + vehicle.makeYear);
        }
    }

}
