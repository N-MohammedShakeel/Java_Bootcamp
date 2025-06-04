package Java_Bootcamp.OOPs.TypeCasting;

interface Animal {
    void sound();
}

class Dog implements Animal {
    @Override
    public void sound() { System.out.println("Bark"); }
    public void fetch() { System.out.println("Fetching ball"); }
}

class Cat implements Animal {
    @Override
    public void sound() { System.out.println("Meow"); }
}

public class NonPrimitiveTypecasting {
    public static void main(String[] args) {
        // Upcasting (Implicit)
        // Purpose: Treat a subclass object as its superclass or interface type
        Dog dog = new Dog();
        Animal animal1 = dog; // Upcast to Animal
        animal1.sound(); // Output: Bark
        Object obj = dog; // Upcast to Object
        System.out.println(obj.getClass().getName()); // Output: Dog

        // Downcasting (Explicit)
        // Purpose: Access subclass-specific methods by casting back to subclass type
        Animal animal2 = new Dog();
        if (animal2 instanceof Dog) {
            Dog dog2 = (Dog) animal2; // Downcast to Dog
            dog2.fetch(); // Output: Fetching ball
        }

        // Incorrect Downcasting (Runtime Error)
        // Purpose: Demonstrate ClassCastException
        Animal animal3 = new Cat();
        try {
            Dog dog3 = (Dog) animal3; // Throws ClassCastException
        } catch (ClassCastException e) {
            System.out.println("Error: " + e.getMessage()); // Output: Error: Cat cannot be cast to Dog
        }

        // Interface Casting
        // Purpose: Show casting to/from interfaces
        Animal animal4 = new Dog();
        if (animal4 instanceof Animal) {
            animal4.sound(); // Output: Bark
        }
    }
}