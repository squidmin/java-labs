package streamapi;

import java.util.ArrayList;
import java.util.List;

public class ConstructorReferencesDemo {

    static class Employee {
        String name;
        int age;
        int salary;
        Employee(String name) { this.name = name; }
        Employee(String name, int age, int salary) {
            this.name = name;
            this.age = age;
            this.salary = salary;
        }

        public String getName() { return name; }
        public int getAge() { return age; }
        public int getSalary() { return salary; }

        @Override
        public String toString() {
            return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
        }
    }

    public int getLength(String str) { return str.length(); }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("we");
        list.add("understand that");
        list.add("Java 8");
        list.add("is");
        list.add("dated");

        // Code without constructor reference
        list.stream()
            .map(name -> new Employee(name))
            .forEach(System.out::println);

        // Code with constructor reference
        list.stream()
            .map(Employee::new)
            .forEach(System.out::println);
    }

}
