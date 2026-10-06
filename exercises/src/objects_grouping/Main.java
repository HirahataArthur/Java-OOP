package objects_grouping;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Student {
    private final String name;
    private final String department;

    public Student(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Alice", "Computer Science"),
                new Student("Bob", "Mathematics"),
                new Student("Carol", "Computer Science"),
                new Student("David", "Mathematics"),
                new Student("Eve", "Physics"),
                new Student("Arthur", "Data Analysis")
        );

        // Stream the students and group each object by its department.
        // LinkedHashMap keeps departments in the order they first appear.
        Map<String, List<Student>> studentsByDepartment = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getDepartment,
                        LinkedHashMap::new,
                        Collectors.toList()
                ));

        // Print each department and the students grouped under it.
        studentsByDepartment.forEach((department, departmentStudents) -> {
            System.out.println(department + ":");
            departmentStudents.forEach(student ->
                    System.out.println("- " + student.getName()));
        });
    }
}
