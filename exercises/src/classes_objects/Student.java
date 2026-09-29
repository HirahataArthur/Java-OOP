package classes_objects;

public class Student{
    // Attributes
    private String name;
    private int age;
    // Constructor
    public Student(String name, int age){
        this.name = name;
        this.age = age;

    }
    // Methods
    public void defineName(String name){
        if(name != this.name){
            this.name = name;
            System.out.println("Now the name is: " + this.name);
        }
    }
    public void defineAge(int age ){
        if(age != this.age){
            this.age = age;
            System.out.println("Now the age is: " + this.age);
        }
    }
    public static void main() {
        Student s1 = new Student("Arthur", 19);
        s1.defineName("Maria");
    }

}
