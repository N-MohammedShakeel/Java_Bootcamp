package Java_Bootcamp.OOPs.Record;

record Person(String name, int age) implements Printable {
    @Override
    public void print() {
        System.out.println("Person: " + name + ", Age: " + age);
    }
}
