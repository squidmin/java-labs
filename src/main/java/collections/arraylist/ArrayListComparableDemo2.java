package collections.arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Vehicle1 implements Comparable<Vehicle1> {
    String brand;
    Integer makeYear;
    public Vehicle1(String brand, Integer makeYear) {
        this.brand = brand;
        this.makeYear = makeYear;
    }
    @Override
    public int compareTo(Vehicle1 o) {
        /*
         * The compareTo() method of the Integer class can also be used:
         *   return this.makeYear.compareTo(o.makeYear);
         */
        return this.makeYear - o.makeYear;
    }
}

public class ArrayListComparableDemo2 {
    public static void main(String[] args) {
        List<Vehicle1> list = new ArrayList<>();
        list.add(new Vehicle1("Volkswagen", 2010));
        list.add(new Vehicle1("Audi", 2009));
        list.add(new Vehicle1("Ford", 2001));
        list.add(new Vehicle1("BMW", 2015));

        Collections.sort(list);
        for (Vehicle1 vehicle1 : list) {
            System.out.println("Vehicle Brand: " + vehicle1.brand + ", Vehicle Make: " + vehicle1.makeYear);
        }
    }
}
