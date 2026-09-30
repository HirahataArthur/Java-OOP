package objects_relationships.composition;

class Engine{

    private int power;

    public Engine(int power){
        this.power = power;
    }

    public int getPower(){
        return this.power;
    }
}

class Car{
    private String model;
    // Composition: the Car owns the Engine instance. The engine cannot exist
    // independently of the car, and it is created and destroyed together with it.
    private Engine engine;

    public Car(String model, int horsepower){
        this.model = model;
        this.engine = new Engine(horsepower);
    }
    public void showDetails(){
        System.out.println("Car: " + model + "\nEngine power: " + engine.getPower() + "HP");
    }
}

public class Main{
    public static void main(String[] args){
        Car myCar = new Car("Civic", 150);
        myCar.showDetails();

    }
}
