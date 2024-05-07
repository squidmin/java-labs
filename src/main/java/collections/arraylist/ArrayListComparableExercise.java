package collections.arraylist;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ArrayListComparableExercise {

    static class Employee implements Comparable<Employee> {
        String name;
        int age;
        String country;
        public Employee(String name, int age, String country) {
            this.name = name;
            this.age = age;
            this.country = country;
        }
        @Override
        public int compareTo(Employee employee) { return this.country.compareTo(employee.country); }

        @Override
        public String toString() { return "{ " + name + ", " + age + ", " + country + " }"; }
    }

    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Alex", 23, "USA"));
        list.add(new Employee("Dave", 34, "India"));
        list.add(new Employee("Carl", 21, "USA"));
        list.add(new Employee("Joe", 56, "Russia"));
        list.add(new Employee("Amit", 64, "China"));
        list.add(new Employee("Ryan", 19, "Brazil"));

        /* Print the names of all employees whose age is over 50. */
        System.out.println("Print the names of all employees whose age is over 50.");
        System.out.println("-".repeat(30));
        list.stream().filter(e -> e.age > 50).map(e -> e.name).forEach(System.out::println);

        System.out.println();

        /* Remove all the Employees from the List who reside in the USA. */
        System.out.println("Remove all the Employees from the List who reside in the USA.");
        System.out.println("-".repeat(30));
        System.out.println("List before removal:");
        list.forEach(e -> System.out.println(e.name));
        list.removeIf(e -> e.country.equalsIgnoreCase("USA"));
        System.out.println("List after removal:");
        list.forEach(e -> System.out.println(e.name));

        /* .iterator() can also be used to remove the elements. */
//        Iterator<Employee> itr = list.iterator();
//        while(itr.hasNext()) {
//            if(itr.next().country.equals("USA")) {
//                itr.remove();
//            }
//        }

        System.out.println();

        /* Sort all the employees by country name. */
        System.out.println("Sort all the employees by country name.");
        System.out.println("-".repeat(30));
        System.out.println("List before sorting:");
        list.forEach(System.out::println);
        list.sort(Comparator.naturalOrder());
        System.out.println("List after sorting:");
        list.forEach(System.out::println);

        /* Instead of implementing Comparator, Collections.sort() can be called, passing a list and a BiFunction to compare elements. */
//        Collections.sort(list, (e1, e2) -> e1.country.compareTo(e2.country));
    }

}
