package exception_handling;

public class ThrowThrowsFinally {

    public static void main(String[] args) {
        try {
            checkAge(16);
        } catch (InvalidAgeException e) {
            // A caller handles the checked exception declared by checkAge.
            System.out.println("Could not continue: " + e.getMessage());
        } finally {
            // finally runs after try/catch whether an exception occurred or not.
            // It is commonly used for cleanup, such as closing a resource.
            System.out.println("Age check finished.");
        }
    }

    // throws declares that this method may pass this checked exception to its caller.
    private static void checkAge(int age) throws InvalidAgeException {
        if (age < 18) {
            // throw creates and raises an exception at this point in the method.
            throw new InvalidAgeException("You must be at least 18.");
        }

        System.out.println("Age accepted.");
    }

    private static class InvalidAgeException extends Exception {
        private static final long serialVersionUID = 1L;

        private InvalidAgeException(String message) {
            super(message);
        }
    }
}
