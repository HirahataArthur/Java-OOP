package exception_handling;

// A checked exception used when an SSN has an invalid format or number range.
class ErrorIdFormat extends Exception {
    private static final long serialVersionUID = 1L;

    ErrorIdFormat(String message) {
        super(message);
    }
}

class Person {
    private String name;
    private String id;

    // Constructor
    public Person(String name, String id) throws ErrorIdFormat {
        this.name = name;
        // Validate the initial ID using the same rules as later updates.
        updateID(id);
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    
    public boolean updateID(String id) throws ErrorIdFormat {
        // Do not change the stored ID unless validation succeeds.
        idCheck(id);
        String digits = id.replace("-", "");
        this.id = digits.substring(0, 3) + "-" + digits.substring(3, 5) + "-" + digits.substring(5);
        return true;
    }

    public boolean idCheck(String id) throws ErrorIdFormat {
        // Accept nine digits with or without the standard hyphens.
        if (id == null || !id.matches("[0-9]{9}|[0-9]{3}-[0-9]{2}-[0-9]{4}")) {
            throw new ErrorIdFormat("SSN must contain 9 digits, optionally formatted as XXX-XX-XXXX.");
        }

        // The SSA does not assign SSNs with these area, group, or serial numbers.
        String digits = id.replace("-", "");
        int areaNumber = Integer.parseInt(digits.substring(0, 3));
        int groupNumber = Integer.parseInt(digits.substring(3, 5));
        int serialNumber = Integer.parseInt(digits.substring(5));

        if (areaNumber == 0 || areaNumber == 666 || areaNumber >= 900
                || groupNumber == 0 || serialNumber == 0) {
            throw new ErrorIdFormat("SSN contains a number range that the SSA does not assign.");
        }

        // Passing these checks confirms the format and range, not the person's identity.
        return true;
    }
}
public class ThrowableExtends{
    public static void main(String args[]){
        try {
            Person p1 = new Person("Arthur", "030-12-3486");
            System.out.println(p1.getName() + ": " + p1.getId());
        } catch (ErrorIdFormat e) {
            System.out.println("Could not create person: " + e.getMessage());
        }
    }
}
