package Java_Bootcamp.Advanced_Java.Annotation_MetaData;

// Class using custom annotations
@Category("Processing")
@Category("Critical")
class Workflow {
    @Task(description = "Process data", priority = 2)
    @SuppressWarnings("unchecked")
    public void process() {
        System.out.println("Processing data");
    }

    @Task(description = "Validate input")
    public void validate() {
        System.out.println("Validating input");
    }
}