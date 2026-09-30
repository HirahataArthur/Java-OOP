package objects_relationships.association;

// Car and Driver exist independently. neither class owns or creates the other
class Car{
    private String model;

    public Car(String model){
        this.model = model;
    }
    public String getModel(){
        return this.model;
    }
}

// A Driver is associated with a Car when it uses one in drive()
class Driver{

    private String name;

    public Driver(String name){
        this.name = name;
    }

    public void drive(Car car){
        System.out.println(this.name + " is driving a " + car.getModel());
    }
}

public class Main{
    public static void main(String[] args){
        Car myCar = new Car("Ferrari");
        Car myCar2 = new Car("Mustang");
        Driver john = new Driver("John");

        john.drive(myCar);
        john.drive(myCar2);
    }
}