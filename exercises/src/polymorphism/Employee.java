package polymorphism;

import java.util.Calendar;
import java.util.UUID;

// Base class for employees and specialized employee types such as Director.
public class Employee {
    // Employee details are private so they can only be accessed directly here.
    private final String name;
    private final Calendar birthDate;
    private final long socialSecurityNumber;
    private final Address address;

    // Subclasses can read and update the ID while other packages cannot access it directly.
    protected String employeeId;

    // Store the employee's information; address may be null when it is not provided.
    public Employee(String name, Calendar birthDate, long socialSecurityNumber, Address address) {
        this.name = name;
        this.birthDate = birthDate;
        this.socialSecurityNumber = socialSecurityNumber;
        this.address = address;
    }

    // Base implementation; subclasses can override this method to generate IDs differently.
    protected void generateEmployeeId() {
        employeeId = "Undefined";
    }

    // Expose the ID without making the field public.
    public String getEmployeeId() {
        return employeeId;
    }

    // No-argument overload: replace the current ID by calling the overridable generator.
    protected void changeEmployeeId() {
        generateEmployeeId();
    }

    // Overload with an argument to replace the current ID with a supplied value.
    protected void changeEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
}
