package exception_handling;

public class Main {

    public static void main(String[] args) {
        // Put code that might cause an exception inside try.
        try {
            int result = 10 / 0;
            System.out.println(result);
        } catch (ArithmeticException e) {
            // catch runs if the division by zero causes an exception.
            System.out.println("Cannot divide by zero.");
        }
    }
}
