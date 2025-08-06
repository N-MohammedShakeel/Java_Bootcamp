package Java_Bootcamp.Advanced_Java.IOAndFile.FileHandling.Serialization_Deserialization; /**
 * SerializationExample.java
 * Demonstrates serialization and deserialization of a Person object.
 * Scenario: Storing and retrieving a Person object for a DSA application (e.g., saving user data).
 * Features: Methods to serialize and deserialize using ObjectOutputStream and ObjectInputStream.
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.IOException;

public class Serialization_DeserializationExample {
    // Person class implementing Serializable
    static class Person implements Serializable {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{name='" + name + "', age=" + age + "}";
        }
    }

    // Method to serialize a Person object to a file
    public static void serializePerson(Person person, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(person);
            System.out.println("Person serialized to " + fileName);
        } catch (IOException e) {
            System.err.println("Error serializing person: " + e.getMessage());
        }
    }

    // Method to deserialize a Person object from a file
    public static Person deserializePerson(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            Object obj = ois.readObject();
            if (obj instanceof Person) {
                return (Person) obj;
            } else {
                System.err.println("Invalid object type in file");
                return null;
            }
        } catch (IOException e) {
            System.err.println("Error deserializing person: " + e.getMessage());
            return null;
        } catch (ClassNotFoundException e) {
            System.err.println("Class not found: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        // Create a Person object
        Person person = new Person("Alice", 30);

        // Serialize the person
        serializePerson(person, "person.ser");

        // Deserialize the person
        Person deserializedPerson = deserializePerson("person.ser");
        if (deserializedPerson != null) {
            System.out.println("Deserialized person: " + deserializedPerson);
        }
    }
}