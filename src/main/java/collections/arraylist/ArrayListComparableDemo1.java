package collections.arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Employee implements Comparable<Employee> {
    String name;
    int age;
    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public int compareTo(Employee employee) {
        /*
         * Sort the employees based on age in ascending order.
         * Returns a negative integer, zero, or a positive integer according to whether the age of this Employee
         *   is less than, equal to, or greater than the specified object.
         */
        return this.age - employee.age;
    }
}

public class ArrayListComparableDemo1 {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Jane", 29));
        list.add(new Employee("Alex", 54));
        list.add(new Employee("Matt", 19));
        list.add(new Employee("Roy", 72));

        Collections.sort(list);
        for (Employee emp : list) {
            System.out.println("Employee Name: " + emp.name + ", Employee Age: " + emp.age);
        }
    }
}
