package visibility.employee;

import visibility.person.Person;

public class Employee extends Person {
    public void testAccess() {
        // System.out.println(this.taxId);       // Not accessible: private to Person.
        // System.out.println(this.internalCode); // Not accessible outside visibility.person.
        System.out.println(this.name);  // Accessible to subclasses.
        System.out.println(this.email); // Public: accessible from anywhere.
    }
}
