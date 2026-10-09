package final_modifier;

// Final classes
final class FinalClass{
    public void exampleMethod(){
        System.out.println("This method is inside a final' class");
    }
}

//This example wouldn't work, cause java cannot inherit from 'final' classes

/*class OtherClass extends FinalClass{
    @Override
    public void exampleMethod(){
        System.out.println("I'm trying to override the method");
    }
}
*/

// Final Methods
class Employee{
    public final void text(){
        System.out.println("I am employed");
    }
}

// This would also fail, because a final method cannot be overridden

/*class Teacher extends Employee{
    public final void text(){
        System.out.println("I am a teacher");
    }
}
*/



public class Main {
    public static void main(String[] args){
        // Final Variables
        final int x = 1;

        // In java, we can't assign new values to 'final' variables
        /*
        x += 1;
        System.out.println("Value of x: " + x);
        */


    }
}
