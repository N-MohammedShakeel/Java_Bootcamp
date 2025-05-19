package Java_Bootcamp.AdvancedJava.AnnotationAndMetaData;// Java Fundamentals: Annotations and Metadata
// Aligned with Oracle Certified Professional: Java SE 17 Developer syllabus

/*
Annotations and Metadata Overview
--------------------------------
- Annotations are a form of metadata introduced in Java 5, providing data about code without affecting its execution.
- Syntax: @AnnotationName(key=value)
- Purpose: Provide information to compilers, tools, frameworks, or runtime processing (e.g., configuration, validation).
- Key Features:
  - Declared using @interface.
  - Applied to classes, methods, fields, parameters, etc.
  - Processed at compile-time or runtime using reflection or annotation processors.
- Categories:
  - Built-in annotations: Provided by Java (e.g., @Override, @Deprecated).
  - Custom annotations: User-defined for specific purposes.
  - Meta-annotations: Annotations applied to other annotations (e.g., @Retention, @Target).

1. Built-in Annotations
----------------------
- Common Built-in Annotations:
  a. @Override:
     - Indicates a method overrides a superclass or interface method.
     - Compile-time check to prevent errors (e.g., misspelled method names).
     - Example: @Override public String toString() { ... }
  b. @Deprecated:
     - Marks a class, method, or field as obsolete.
     - Compiler generates warnings when used; can include since and forRemoval attributes (Java 9+).
     - Example: @Deprecated(since="17", forRemoval=true)
  c. @SuppressWarnings:
     - Suppresses specific compiler warnings (e.g., "unchecked", "deprecation").
     - Example: @SuppressWarnings("unchecked")
  d. @FunctionalInterface:
     - Ensures an interface has exactly one abstract method (SAM).
     - Example: @FunctionalInterface interface MyFunc { void method(); }
  e. @SafeVarargs:
     - Suppresses unchecked warnings for varargs methods with non-reifiable types.
     - Example: @SafeVarargs public static <T> void print(T... items) { ... }
- Notes:
  - Built-in annotations are in java.lang and java.lang.annotation packages.
  - Some affect compilation (@Override), others provide runtime metadata (@Deprecated).
  - Use @SuppressWarnings sparingly with specific categories to maintain code quality.

2. Custom Annotations
--------------------
- Definition:
  - Create using @interface, specifying elements (like methods) for annotation parameters.
  - Example:
    @interface MyAnnotation {
        String value();
        int priority() default 1;
    }
- Usage:
  - Apply to code elements (e.g., classes, methods) with @MyAnnotation(value="test").
  - Access at runtime using reflection (java.lang.reflect).
- Meta-Annotations:
  - @Retention: Specifies how long the annotation is retained.
    - RetentionPolicy.SOURCE: Compile-time only (e.g., @Override).
    - RetentionPolicy.CLASS: Stored in .class file, not available at runtime.
    - RetentionPolicy.RUNTIME: Available at runtime via reflection.
  - @Target: Restricts where the annotation can be applied (e.g., ElementType.METHOD, ElementType.TYPE).
  - @Documented: Includes annotation in Javadoc.
  - @Inherited: Allows subclasses to inherit the annotation from superclasses.
  - @Repeatable: Allows multiple instances of the annotation (Java 8+).
- Notes:
  - Elements can have default values; types are limited (primitives, String, Class, enums, annotations, or arrays thereof).
  - Use RUNTIME retention for runtime processing; SOURCE or CLASS for tools/processors.

3. Annotation Processing
-----------------------
- Mechanism to process annotations at compile-time using the Annotation Processing Tool (APT).
- Purpose: Generate code, validate code, or produce resources based on annotations.
- Steps:
  a. Create an annotation (e.g., @MyAnnotation).
  b. Write a processor extending javax.annotation.processing.AbstractProcessor.
  c. Register the processor using a service provider (META-INF/services).
  d. Compile with -processor flag or build tools (e.g., Maven).
- Key Components:
  - javax.annotation.processing.Processor: Interface for annotation processors.
  - RoundEnvironment: Provides access to annotated elements.
  - ProcessingEnvironment: Provides utilities (e.g., Messager for errors, Filer for code generation).
- Example Use Cases:
  - Frameworks like Spring (@Autowired) or Hibernate (@Entity) use annotation processors.
  - Generating boilerplate code (e.g., Lombok).
- Notes:
  - Requires understanding of Java Compiler API and javax.lang.model.
  - Processors run during compilation, not runtime.
  - Use build tools (Maven/Gradle) to simplify processor integration.
*/


// Custom annotation definition

// Simple annotation processor simulation (reflection-based, not compile-time)

import jdk.jfr.Category;

import java.lang.reflect.Method;

public class AnnotationsAndMetadata {
    public static void main(String[] args) {
        try {
            // Example 1: Built-in Annotations
            System.out.println("Example 1: Built-in Annotations");
            Child child = new Child();
            System.out.println("Child toString: " + child); // Uses @Override
            @SuppressWarnings("deprecation")
            Parent parent = new Parent();
            parent.oldMethod(); // Compiler warns unless suppressed

            // Example 2: Custom Annotation with Reflection
            System.out.println("\nExample 2: Custom Annotation (Task)");
            Class<?> workflowClass = Workflow.class;
            for (Method method : workflowClass.getDeclaredMethods()) {
                Task task = method.getAnnotation(Task.class);
                if (task != null) {
                    System.out.println("Method: " + method.getName());
                    System.out.println("Description: " + task.description());
                    System.out.println("Priority: " + task.priority());
                }
            }

            // Example 3: Repeatable Annotations
            System.out.println("\nExample 3: Repeatable Annotations (Category)");
            Category[] categories = workflowClass.getAnnotationsByType(Category.class);
            System.out.print("Categories: ");
            for (Category category : categories) {
                System.out.print(category.value() + " ");
            }
            System.out.println();

            // Example 4: Simulating Annotation Processing
            System.out.println("\nExample 4: Simulating Annotation Processing");
            for (Method method : workflowClass.getDeclaredMethods()) {
                if (method.isAnnotationPresent(Task.class)) {
                    Task task = method.getAnnotation(Task.class);
                    if (task.priority() > 1) {
                        System.out.println("High-priority task: " + task.description());
                        method.invoke(new Workflow()); // Execute high-priority method
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Error during reflection or method invocation: " + e.getMessage());
            e.printStackTrace();
        }
    }
}