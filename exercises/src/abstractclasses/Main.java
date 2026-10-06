package abstractclasses;

// Abstract base class for animals.
abstract class Animal {
    // Abstract method: each concrete animal must provide its own sound.
    public abstract void makeSound();

    // Concrete method inherited and reused by every subclass.
    public void sleep() {
        System.out.println("Zzz...");
    }
}

// Concrete subclass that provides the dog-specific sound.
class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Bark!");
    }
}

// Concrete subclass that provides the cat-specific sound.
class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }
}

public class Main {
    public static void main(String[] args) {
        // Polymorphism: abstractclasses.Animal references point to different concrete animal objects.
        Animal myDog = new Dog();
        Animal myCat = new Cat();

        // The overridden method is selected for the actual abstractclasses.Dog object.
        myDog.makeSound();
        // This concrete method is inherited from abstractclasses.Animal.
        myDog.sleep();

        // The overridden method is selected for the actual abstractclasses.Cat object.
        myCat.makeSound();
        // This concrete method is inherited from abstractclasses.Animal.
        myCat.sleep();
    }
}