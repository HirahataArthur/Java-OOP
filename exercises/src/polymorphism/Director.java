package polymorphism;

import java.util.Calendar;
import java.util.UUID;

// A director is a specialized employee and inherits its employee details and ID field.
public class Director extends Employee {
    // Forward the director's details to the Employee constructor.
    public Director(String name, Calendar birthDate, long socialSecurityNumber, Address address) {
        super(name, birthDate, socialSecurityNumber, address);
    }

    // Polymorphism: this override gives Directors different behavior for the same method.
    // Java selects this implementation at runtime when the actual object is a Director.
    @Override
    protected void generateEmployeeId() {
        employeeId = "E-" + UUID.randomUUID();
    }

    // Override the no-argument version to generate a new director ID.
    @Override
    protected void changeEmployeeId() {
        generateEmployeeId();
    }

    // Override the one-argument version to assign a specific director ID.
    @Override
    protected void changeEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
}
