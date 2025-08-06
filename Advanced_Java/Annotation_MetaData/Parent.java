package Java_Bootcamp.Advanced_Java.Annotation_MetaData;

// Built-in annotation examples
class Parent {
    @Deprecated(since = "17", forRemoval = true)
    public void oldMethod() {
        System.out.println("Deprecated method");
    }
}
