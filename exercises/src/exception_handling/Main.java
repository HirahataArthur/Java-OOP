package exception_handling;

public class Main {

    public static void main(String[] args) {
        // An implicit exception happens automatically, like dividing by zero.
        // An explicit exception is deliberately raised by the code.


        // Put code that might cause an exception inside try.
        try {
            int result = 10 / 0;
            System.out.println(result);
        } catch (ArithmeticException e) {
            // catch runs if the division by zero causes an exception.
            System.out.println("Cannot divide by zero.");
        }

        // This exception is explicit because the code raises it with throw.
        try {
            throw new IllegalArgumentException("Name cannot be empty.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Creating a Person with an unassigned SSN range throws ErrorIdFormat.
        try {
            Person person = new Person("Alex", "000-12-3456");
            System.out.println(person.getName() + ": " + person.getId());
        } catch (ErrorIdFormat e) {
            System.out.println("Could not create person: " + e.getMessage());
        }
    }
}
