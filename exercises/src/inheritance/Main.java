package inheritance;

// Base class: shared identity information for every person.
class Person{
    private String name;
    private int id;

    public Person(String name, int id){
        this.name = name;
        this.id = id;
    }
    public void getInfo(){
        System.out.println("Name: " + name + "| ID: " + id);
    }
}

// Employed adds salary to the information inherited from Person.
class Employed extends Person{
    protected double salary;
    public Employed(String name, int id, double salary){
        super(name, id); // Calls for 'Person' constructor
        this.salary = salary;
    }
    public double getSalary(){
        return salary;
    }
}

// Teacher inherits both a person's identity and an employee's salary.
class Teacher extends Employed {
    protected int payHour;
    public Teacher(String name, int id, double salary, int payHour){
        super(name, id, salary);
        this.payHour = payHour;
    }
}

// Commissioned teachers include their commission in the inherited salary.
class CommissionedTeacher extends Teacher{
    private double commission;

    public CommissionedTeacher(String name, int id, double salary, int payHour, double commission){
        super(name, id, salary, payHour);
        this.commission = commission;
    }
    @Override
    public double getSalary(){
        // Add the commission to the base salary provided by Employed.
        return super.getSalary() + commission;
    }
}
public class Main{
    public static void main(String[] args){
        Teacher teacher_0 = new Teacher("Alicia", 189, 1900, 25);
        System.out.print("Teacher_0 salary: " + teacher_0.getSalary());
        CommissionedTeacher teacher_1 = new CommissionedTeacher("Joseph", 190, 1900, 25, 500);
        System.out.print("Teacher_1 salary: " + teacher_1.getSalary());
    }
}