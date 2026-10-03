package inheritance.multipleInheritance;

// Interfaces define actions a class agrees to provide, without defining its state.
interface Teacher {
    void teachClass();
}

interface Principal {
    void manageSchool();
}

interface TeacherPrincipal extends Teacher, Principal {
    void coordinateMeeting();
}

// A class can implement multiple interfaces, combining their required behaviors.
class SchoolAdmin implements TeacherPrincipal {
    @Override
    public void teachClass() {
        System.out.println("Teaching a class.");
    }

    @Override
    public void manageSchool() {
        System.out.println("Managing the school.");
    }

    @Override
    public void coordinateMeeting() {
        System.out.println("Coordinating a meeting.");
    }
}

public class Main {
    public static void main(String[] args) {
        SchoolAdmin schoolAdmin = new SchoolAdmin();
        schoolAdmin.teachClass();
        schoolAdmin.manageSchool();
        schoolAdmin.coordinateMeeting();
    }
}