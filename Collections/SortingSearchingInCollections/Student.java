package Java_Bootcamp.Collections.SortingSearchingInCollections;

// Class to represent a Student (used for Comparable and Comparator demos)
class Student implements Comparable<Student> {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    // Implement Comparable for natural ordering (by score, ascending)
    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.score, other.score);
    }

    @Override
    public String toString() {
        return name + ": " + score;
    }
}
