package practice.streamapi;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Employee {
    private final String name;
    private final int age;
    private final String title;
    public Employee(String name, int age, String title) {
        this.name = name;
        this.age = age;
        this.title = title;
    }
}

public class FindAverageAgeOfEmployeesByDepartment {

    public static Map<String, Double> averageAgeByDepartment(List<Employee> employees) {
        return null;
    }

    public static void main(String[] args) {
        List<Employee> employees = List.of(
            new Employee("Alice", 25, "HR"),
            new Employee("Bob", 30, "Finance"),
            new Employee("Charlie", 28, "HR"),
            new Employee("David", 35, "Finance")
        );

        Map<String, Double> averageAgeByDept = averageAgeByDepartment(employees);
        averageAgeByDept.forEach((dept, avgAge) ->
            System.out.println("Average age in " + dept + ": " + avgAge));
    }

}
