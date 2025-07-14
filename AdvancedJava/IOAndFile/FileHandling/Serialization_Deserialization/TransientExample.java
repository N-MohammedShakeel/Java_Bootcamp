package Java_Bootcamp.AdvancedJava.IOAndFile.FileHandling.Serialization_Deserialization; /**
 * TransientExample.java
 * Demonstrates using the transient keyword to hide sensitive data during serialization.
 * Scenario: Serializing a Person object with a sensitive password field for a DSA application.
 * Features: Shows how transient fields are excluded from serialization.
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.IOException;

public class TransientExample {
    // Person class with transient password field
    static class Person implements Serializable {
        private String name;
        private transient String password; // transient to exclude from serialization

        public Person(String name, String password) {
            this.name = name;
            this.password = password;
        }

        @Override
        public String toString() {
            return "Person{name='" + name + "', password=" + (password != null ? "'****'" : "null") + "}";
        }
    }

    public static void main(String[] args) {
        // Create a Person object with sensitive data
        Person person = new Person("Bob", "secret123");
        System.out.println("Original person: " + person);

        // Serialize the person
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person_transient.ser"))) {
            oos.writeObject(person);
            System.out.println("Person serialized to person_transient.ser");
        } catch (IOException e) {
            System.err.println("Error serializing person: " + e.getMessage());
            return;
        }

        // Deserialize the person
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person_transient.ser"))) {
            Person deserializedPerson = (Person) ois.readObject();
            System.out.println("Deserialized person: " + deserializedPerson);
        } catch (IOException e) {
            System.err.println("Error deserializing person: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Class not found: " + e.getMessage());
        }
    }
}