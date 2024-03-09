package collections.arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Student implements Comparable<Student> {

    private final String name;
    private final String gpa;

    public Student(String name, String gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    @Override
    public int compareTo(Student student) {
        return this.gpa.compareTo(student.gpa);
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(List.of(
            new Student("Jeff", "3.4"),
            new Student("Xian", "3.9"),
            new Student("Geoff", "3.2")
        ));
        Collections.sort(students);
        students.forEach(student -> System.out.println("Name: " + student.name + "; GPA: " + student.gpa));
    }

}
