package Java_Bootcamp.OOP.Encapsulation;

// Java program to demonstrate the Encapsulation.
class Person {
    // Encapsulating the name and age
    // only approachable and used using
    // methods defined
    private String name;
    private int age;

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }

    public void setAge(int age) {
        if (age > 18)
            this.age = age;
    }

}