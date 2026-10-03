package object_references;

class Student{

    private String name;
    private int age;

    public Student(String name, int age){

        this.name = name;
        this.age = age;
    }

    public void defineName(String name){
        this.name = name;
    }

    public void defineAge(int age){
        this.age = age;
    }

    public String getName(){
        return this.name;
    }
}

public class Main {
    private Student s1, s2;

    public Main() {
        s1 = new Student("Carl", 8);
        s2 = new Student("Lisa", 9);

        System.out.println("s1's name is: " + s1.getName());
        System.out.println("s2's name is: " + s2.getName());

        // Both variables refer to different objects at this point.
        // The assignment below makes s2 reference the same object as s1.
        s2 = s1;
        s2.defineName("Nicholas");

        // Since s1 and s2 now point to the same object, changing s2 also changes s1.
        System.out.println("s1's name is: " + s1.getName());

        // Passing an object reference to a method keeps the same object instance.
        manipulateStudent(s1);
        System.out.println("s1's name is: " + s1.getName());
    }

    public void manipulateStudent(Student student) {
        student.defineName("John");
    }

    public static void main(String[] args) {
        Main r = new Main();
        System.out.println("-end-");
    }
}