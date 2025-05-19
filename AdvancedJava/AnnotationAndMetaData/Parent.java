package Java_Bootcamp.AdvancedJava.AnnotationAndMetaData;

// Built-in annotation examples
class Parent {
    @Deprecated(since = "17", forRemoval = true)
    public void oldMethod() {
        System.out.println("Deprecated method");
    }
}
