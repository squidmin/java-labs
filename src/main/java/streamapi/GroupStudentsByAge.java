package streamapi;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Student {

    private final String name;
    private final int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

}

public class GroupStudentsByAge {

    public static Map<Integer, List<Student>> groupStudentsByAge(List<Student> students) {
        return students.stream()
            .collect(Collectors.groupingBy(Student::getAge));
    }

    public static void main(String[] args) {
        List<Student> students = List.of(
            new Student("Alice", 20),
            new Student("Bob", 22),
            new Student("Charlie", 20),
            new Student("David", 22)
        );

        Map<Integer, List<Student>> groupedByAge = groupStudentsByAge(students);
        groupedByAge.forEach((age, studentList) -> {
            System.out.println("Age " + age + ": " + studentList.stream()
                .map(Student::getName)
                .toList());
        });
    }

}
