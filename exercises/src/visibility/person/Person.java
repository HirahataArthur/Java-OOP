package visibility.person;

public class Person {
    private String taxId;       // Only accessible inside Person.
    String internalCode;        // Package-private: accessible only within visibility.person.
    protected String name;      // Accessible within the package and by subclasses.
    public String email;        // Accessible from any class.
}
