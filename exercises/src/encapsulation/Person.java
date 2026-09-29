package encapsulation;

public class Person {
    // Private fields can only be accessed directly from this class.
    private String name;
    private int age;

    // Initialize the person's fields when creating an instance.
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Expose name changes through a method.
    public void setName(String name) {
        this.name = name;
        System.out.println("Name set to: " + this.name);
    }

    // Expose the name without making the field public.
    public String getName() {
        return this.name;
    }
}
