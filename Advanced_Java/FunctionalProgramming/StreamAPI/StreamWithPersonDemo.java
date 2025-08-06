package Java_Bootcamp.Advanced_Java.FunctionalProgramming.StreamAPI;

import java.util.*;
import java.util.stream.*;

class Person {
    private String name;
    private int age;
    private String city;
    private double salary;

    public Person(String name, int age, String city, double salary) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + ", city='" + city + "', salary=" + salary + "}";
    }
}

public class StreamWithPersonDemo {
    public static void main(String[] args) {
        // Sample data: List of Person objects
        List<Person> people = Arrays.asList(
            new Person("Alice", 30, "New York", 75000),
            new Person("Bob", 25, "Los Angeles", 60000),
            new Person("Charlie", 35, "New York", 80000),
            new Person("Diana", 28, "Chicago", 65000),
            new Person("Eve", 40, "Los Angeles", 90000)
        );

        // Example 1: Filter people older than 30
        System.out.println("Example 1: People older than 30");
        List<Person> olderThan30 = people.stream()
            .filter(p -> p.getAge() > 30)
            .toList();
        olderThan30.forEach(System.out::println);
        System.out.println();

        // Example 2: Map to names and convert to uppercase
        System.out.println("Example 2: Names in uppercase");
        List<String> namesUpper = people.stream()
            .map(p -> p.getName().toUpperCase())
            .toList();
        namesUpper.forEach(System.out::println);
        System.out.println();

        // Example 3: Sort by salary (descending)
        System.out.println("Example 3: Sorted by salary (descending)");
        List<Person> sortedBySalary = people.stream()
            .sorted((p1, p2) -> Double.compare(p2.getSalary(), p1.getSalary()))
            .toList();
        sortedBySalary.forEach(System.out::println);
        System.out.println();

        // Example 4: Group by city
        System.out.println("Example 4: Group by city");
        Map<String, List<Person>> groupedByCity = people.stream()
            .collect(Collectors.groupingBy(Person::getCity));
        groupedByCity.forEach((city, list) -> {
            System.out.println(city + ":");
            list.forEach(p -> System.out.println("  " + p));
        });
        System.out.println();

        // Example 5: Average salary
        System.out.println("Example 5: Average salary");
        double averageSalary = people.stream()
            .mapToDouble(Person::getSalary)
            .average()
            .orElse(0.0);
        System.out.printf("Average salary: %.2f%n", averageSalary);
        System.out.println();

        // Example 6: Find person with highest salary
        System.out.println("Example 6: Person with highest salary");
        Optional<Person> highestSalaryPerson = people.stream()
            .max(Comparator.comparingDouble(Person::getSalary));
        highestSalaryPerson.ifPresent(p -> System.out.println("Highest salary: " + p));
        System.out.println();

        // Example 7: Count people in each city
        System.out.println("Example 7: Count people in each city");
        Map<String, Long> cityCounts = people.stream()
            .collect(Collectors.groupingBy(Person::getCity, Collectors.counting()));
        cityCounts.forEach((city, count) -> System.out.println(city + ": " + count));
        System.out.println();

        // Example 8: Concatenate names with salaries above 70000
        System.out.println("Example 8: Concatenate names with salaries > 70000");
        String highEarners = people.stream()
            .filter(p -> p.getSalary() > 70000)
            .map(Person::getName)
            .collect(Collectors.joining(", "));
        System.out.println("High earners: " + highEarners);
        System.out.println();

        // Example 9: Parallel stream for large dataset simulation
        System.out.println("Example 9: Parallel stream (filter age < 35)");
        List<Person> youngPeople = people.stream()
            .parallel()
            .filter(p -> p.getAge() < 35)
            .toList();
        youngPeople.forEach(System.out::println);
        System.out.println();

        // Example 10: Custom reduction to sum salaries by city
        System.out.println("Example 10: Sum salaries by city");
        Map<String, Double> salaryByCity = people.stream()
            .collect(Collectors.groupingBy(
                Person::getCity,
                Collectors.reducing(0.0, Person::getSalary, Double::sum)
            ));
        salaryByCity.forEach((city, total) -> System.out.printf("%s: %.2f%n", city, total));
    }


}