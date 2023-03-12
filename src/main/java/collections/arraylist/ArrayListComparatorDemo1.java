package collections.arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Vehicle3 {
    String brand;
    Integer makeYear;
    public Vehicle3(String brand, Integer makeYear) {
        super();
        this.brand = brand;
        this.makeYear = makeYear;
    }
}

class BrandComparator implements Comparator<Vehicle3> {
    @Override
    public int compare(Vehicle3 o1, Vehicle3 o2) {
        return o1.brand.compareTo(o2.brand);
    }
}

class MakeYearComparator implements Comparator<Vehicle3> {
    @Override
    public int compare(Vehicle3 o1, Vehicle3 o2) {
        return o1.makeYear.compareTo(o2.makeYear);
    }
}

public class ArrayListComparatorDemo1 {

    public static void main(String[] args) {
        List<Vehicle3> list = new ArrayList<>();
        list.add(new Vehicle3("Volkswagen", 2010));
        list.add(new Vehicle3("Audi", 2009));
        list.add(new Vehicle3("Ford", 2001));
        list.add(new Vehicle3("BMW", 2015));

        System.out.println("Sorting by brand name.");
        Collections.sort(list, new BrandComparator());
        for (Vehicle3 vehicle : list) {
            System.out.println("Vehicle Brand: " + vehicle.brand + ", Vehicle Make: " + vehicle.makeYear);
        }

        System.out.println("Sorting by make year.");
        Collections.sort(list, new MakeYearComparator());
        for (Vehicle3 vehicle : list) {
            System.out.println("Vehicle Brand: " + vehicle.brand + ", Vehicle Make: " + vehicle.makeYear);
        }
    }

}
