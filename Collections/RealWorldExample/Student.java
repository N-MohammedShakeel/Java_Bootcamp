package Java_Bootcamp.Collections.RealWorldExample;

// Class to represent a Student (for student records demo)
class Student {
    private String id;
    private String name;
    private double gpa;

    public Student(String id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name=" + name + ", gpa=" + gpa + "}";
    }
}
