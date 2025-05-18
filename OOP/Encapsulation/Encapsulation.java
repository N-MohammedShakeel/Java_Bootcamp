package Java_Bootcamp.OOP.Encapsulation;// Java Fundamentals: Encapsulation
// Aligned with Oracle Certified Professional: Java SE 17 Developer syllabus

/*
1. Access Modifiers
------------------
- Control the visibility and accessibility of class members (fields, methods, constructors).
- Types:
  - public: Accessible from everywhere.
  - private: Accessible only within the same class.
  - protected: Accessible within the same package and in subclasses (even in different packages).
  - default (package-private): Accessible only within the same package if no modifier is specified.
- Notes:
  - Use the most restrictive modifier possible to enforce encapsulation.
  - Example: private int age; // Only accessible within the class
  - Default access is implied when no modifier is used (e.g., int age;).
*/

/*
2. Getters and Setters
----------------------
- Methods to access and modify private fields safely.
- Getters:
  - Retrieve the value of a private field.
  - Syntax: public Type getFieldName() { return fieldName; }
  - Example: public int getAge() { return age; }
- Setters:
  - Update the value of a private field, often with validation.
  - Syntax: public void setFieldName(Type value) { this.fieldName = value; }
  - Example: public void setAge(int age) { if (age >= 0) this.age = age; }
- Notes:
  - Encapsulate fields by making them private and providing public getters/setters.
  - Setters can include logic to enforce constraints (e.g., age must be non-negative).
  - Use 'this' to distinguish instance fields from parameters.
*/

/*
3. Data Hiding Principles
-------------------------
- Core concept of encapsulation: Hide internal data (fields) and expose only necessary interfaces (methods).
- Benefits:
  - Protects data integrity by controlling access.
  - Allows internal implementation changes without affecting external code.
  - Reduces system complexity by hiding details.
- Implementation:
  - Declare fields as private to prevent direct access.
  - Provide controlled access via public getters/setters or other methods.
  - Example: A class with private fields (e.g., balance) and public methods (e.g., deposit, withdraw) to manage access.
- Notes:
  - Avoid exposing fields directly (e.g., public int age;).
  - Use encapsulation to ensure data consistency and security.
*/

public class Encapsulation {
    // Private fields (data hiding)
    private String name;
    private int age;
    private double balance;

    // Constructor
    public Encapsulation(String name, int age, double balance) {
        this.name = name;
        setAge(age); // Use setter for validation
        setBalance(balance); // Use setter for validation
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getBalance() {
        return balance;
    }

    // Setters with validation
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Invalid name provided.");
        }
    }

    public void setAge(int age) {
        if (age >= 0 && age <= 120) {
            this.age = age;
        } else {
            System.out.println("Invalid age provided.");
        }
    }

    public void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        } else {
            System.out.println("Invalid balance provided.");
        }
    }

    // Example method to demonstrate controlled access
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount + ", New Balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public static void main(String[] args) {
        // Example: Creating an object and using encapsulation
        System.out.println("Encapsulation Example:");
        Encapsulation account = new Encapsulation("John Doe", 30, 1000.0);

        // Accessing fields via getters
        System.out.println("Name: " + account.getName());
        System.out.println("Age: " + account.getAge());
        System.out.println("Balance: " + account.getBalance());

        // Modifying fields via setters with validation
        account.setName(""); // Invalid name
        account.setAge(-5); // Invalid age
        account.setBalance(-100); // Invalid balance
        account.setName("Jane Doe"); // Valid
        account.setAge(25); // Valid
        account.setBalance(2000.0); // Valid

        // Verify changes
        System.out.println("\nAfter Updates:");
        System.out.println("Name: " + account.getName());
        System.out.println("Age: " + account.getAge());
        System.out.println("Balance: " + account.getBalance());

        // Using method to modify balance
        account.deposit(500.0); // Valid deposit
        account.deposit(-50.0); // Invalid deposit
    }
}