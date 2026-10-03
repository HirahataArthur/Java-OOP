package polymorphism;

import java.util.Calendar;

// Runs the employee ID generation example.
public class Main {
    // Both variables have the Employee type; director will refer to a Director object.
    private static Employee employee;
    private static Employee director;

    public static void main(String[] args) {
        // Calendar months are zero-based, so NOVEMBER represents month 10.
        Calendar birthDate = Calendar.getInstance();
        birthDate.set(1980, Calendar.NOVEMBER, 23);

        // Create a regular employee and generate an ID.
        employee = new Employee("Clara Silva", birthDate, 211456937L, null);
        employee.generateEmployeeId();

        // Polymorphism in action: the reference type is Employee, but the Director override runs.
        director = new Director("Marco Antonio", birthDate, 901564098L, null);
        director.generateEmployeeId();

        // The public getter allows the IDs to be read outside the class.
        System.out.println("The director's employee ID is: " + director.getEmployeeId());
        System.out.println("The employee's employee ID is: " + employee.getEmployeeId());
    }
}