package encapsulation;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("test", 0);
        System.out.println(p1.getName());

        // Change the name through the public setter instead of accessing the private field.
        p1.setName("Arthur");
        System.out.println(p1.getName());
    }
}