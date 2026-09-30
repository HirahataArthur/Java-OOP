package objects_relationships.aggregation;
import java.util.ArrayList;
import java.util.List;

class Teacher{

    private String name;

    public Teacher(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}

class Department{
    private String name;
    // Aggregation: Department has a collection of teachers, but teachers can exist
    // independently of the department. The department is the owner of the list,
    // but the Teacher objects are not destroyed when the department is removed.

    public List<Teacher> teachers; // Collection of teachers

    public Department(String name){
        this.name = name;
        this.teachers = new ArrayList<>();
    }

    public void addTeacher(Teacher teacher){
        teachers.add(teacher);
    }

    public void listTeachers(){
        System.out.println("Department of " + name + ":");
        for(Teacher p  : teachers){
            System.out.println("- " +p.getName());
        }
    }
}

public class Main{
    public static void main(String[] args){
        Teacher teacher1 = new Teacher("Patricia");
        Teacher teacher2 = new Teacher("André");

        Department dep1 = new Department("Computing");
        dep1.addTeacher(teacher1);
        dep1.addTeacher(teacher2);

        dep1.listTeachers();
    }
}