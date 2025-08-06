Annotations and Metadata Program Explanation
=========================================

Program Overview
---------------
This Java program demonstrates the use of annotations and metadata, aligning with the Oracle Certified Professional: Java SE 17 Developer syllabus. It showcases built-in annotations, custom annotations, repeatable annotations, and runtime annotation processing using reflection. The program consists of several classes in the `java_bootcamp.advancedjava.annotationandmetadata` package, each serving a specific purpose in illustrating annotation concepts.

Program Flow
-----------
The program is executed through the `AnnotationsAndMetadata` class, which contains the `main` method. It is divided into four examples, each highlighting different aspects of annotations:

1. **Example 1: Built-in Annotations**
   - Creates a `Child` object and calls its `toString` method, demonstrating the `@Override` annotation.
   - Creates a `Parent` object and calls its `oldMethod`, which is marked with `@Deprecated`. The `@SuppressWarnings("deprecation")` annotation is used to suppress the deprecation warning.
   - Output:
     - Prints "Child toString: Child object".
     - Calls `oldMethod`, printing "Deprecated method".

2. **Example 2: Custom Annotation (Task)**
   - Uses reflection to inspect the `Workflow` class for methods annotated with `@Task`.
   - For each annotated method, prints the method name, description, and priority from the `@Task` annotation.
   - Output:
     - For `process`: "Method: process", "Description: Process data", "Priority: 2".
     - For `validate`: "Method: validate", "Description: Validate input", "Priority: 1".

3. **Example 3: Repeatable Annotations (Category)**
   - Retrieves all `@Category` annotations on the `Workflow` class using `getAnnotationsByType`.
   - Prints the `value` of each `@Category` annotation.
   - Output:
     - "Categories: Processing Critical".

4. **Example 4: Simulating Annotation Processing**
   - Iterates through `Workflow` methods, checking for `@Task` annotations.
   - For methods with a `priority` greater than 1, prints the task description and invokes the method using reflection.
   - Output:
     - "High-priority task: Process data".
     - Invokes `process`, printing "Processing data".

The program wraps all operations in a try-catch block to handle potential reflection-related exceptions (e.g., `IllegalAccessException`, `InvocationTargetException`).

Annotation Usage
---------------
Below is a detailed explanation of each annotation used in the program, including its purpose and application:

1. **@Override**
   - **Package**: `java.lang`
   - **Purpose**: Indicates that a method overrides a method in a superclass or interface. It ensures the method signature matches the overridden method, catching errors at compile-time (e.g., typos in method names).
   - **Usage**: Applied to the `toString` method in the `Child` class, which overrides `Object.toString()`.
   - **Effect**: The compiler verifies that `toString` is correctly overridden. In the program, calling `child.toString()` returns "Child object".
   - **Meta-Annotations**: `@Retention(RetentionPolicy.SOURCE)`, `@Target(ElementType.METHOD)` (defined in JDK).

2. **@Deprecated**
   - **Package**: `java.lang`
   - **Purpose**: Marks a class, method, or field as obsolete, generating a compiler warning when used. Since Java 9, it supports `since` and `forRemoval` attributes to indicate the version and removal intent.
   - **Usage**: Applied to `oldMethod` in the `Parent` class with `@Deprecated(since="17", forRemoval=true)`.
   - **Effect**: The compiler warns when `oldMethod` is called unless suppressed. In the program, the warning is suppressed using `@SuppressWarnings("deprecation")`.
   - **Meta-Annotations**: `@Retention(RetentionPolicy.RUNTIME)`, `@Target({ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.MODULE, ElementType.PACKAGE, ElementType.PARAMETER, ElementType.TYPE})`, `@Documented`.

3. **@SuppressWarnings**
   - **Package**: `java.lang`
   - **Purpose**: Suppresses specific compiler warnings, such as "unchecked" or "deprecation", to reduce noise in the build output.
   - **Usage**:
     - In `AnnotationsAndMetadata`, `@SuppressWarnings("deprecation")` suppresses the warning for calling `Parent.oldMethod`.
     - In `Workflow`, `@SuppressWarnings("unchecked")` is applied to the `process` method (though no unchecked operations occur in this example, it’s illustrative).
   - **Effect**: Prevents compiler warnings for the specified categories, improving code readability.
   - **Meta-Annotations**: `@Retention(RetentionPolicy.SOURCE)`, `@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.CONSTRUCTOR, ElementType.LOCAL_VARIABLE, ElementType.MODULE})`.

4. **@Retention**
   - **Package**: `java.lang.annotation`
   - **Purpose**: Specifies how long an annotation is retained (compile-time, class file, or runtime).
   - **Usage**: Applied to custom annotations `Task`, `Category`, and `Categories` with `RetentionPolicy.RUNTIME`.
   - **Effect**: Makes the annotations available at runtime for reflection-based processing, as seen in `AnnotationsAndMetadata` when inspecting `Task` and `Category` annotations.
   - **Meta-Annotations**: `@Retention(RetentionPolicy.RUNTIME)`, `@Target(ElementType.ANNOTATION_TYPE)`.

5. **@Target**
   - **Package**: `java.lang.annotation`
   - **Purpose**: Restricts the types of Java elements an annotation can be applied to (e.g., methods, classes).
   - **Usage**:
     - `@Target(ElementType.METHOD)` on `Task`, restricting it to methods.
     - `@Target(ElementType.TYPE)` on `Category` and `Categories`, restricting them to classes, interfaces, or enums.
   - **Effect**: Ensures annotations are used correctly, with the compiler enforcing the specified targets.
   - **Meta-Annotations**: `@Retention(RetentionPolicy.RUNTIME)`, `@Target(ElementType.ANNOTATION_TYPE)`.

6. **@Repeatable**
   - **Package**: `java.lang.annotation`
   - **Purpose**: Allows multiple instances of an annotation to be applied to the same element, requiring a container annotation.
   - **Usage**: Applied to `Category` with `@Repeatable(Categories.class)`, enabling multiple `@Category` annotations on `Workflow`.
   - **Effect**: The `Categories` container holds multiple `Category` annotations, accessible via `getAnnotationsByType(Category.class)`. In the program, `Workflow` has `@Category("Processing")` and `@Category("Critical")`.
   - **Meta-Annotations**: `@Retention(RetentionPolicy.RUNTIME)`, `@Target(ElementType.ANNOTATION_TYPE)`.

7. **@Task** (Custom Annotation)
   - **Purpose**: Marks methods with a description and priority, simulating a task management system.
   - **Usage**: Applied to `process` and `validate` methods in `Workflow` with attributes `description` and `priority`.
   - **Effect**: The program uses reflection to read `description` and `priority`, printing them and invoking high-priority methods. For example, `process` has `description="Process data"` and `priority=2`.
   - **Meta-Annotations**:
     - `@Retention(RetentionPolicy.RUNTIME)`: Enables runtime access.
     - `@Target(ElementType.METHOD)`: Restricts to methods.

8. **@Category** (Custom Annotation)
   - **Purpose**: Categorizes classes or interfaces, allowing multiple categories via `@Repeatable`.
   - **Usage**: Applied to `Workflow` with `@Category("Processing")` and `@Category("Critical")`.
   - **Effect**: The program retrieves and prints category values ("Processing Critical") using `getAnnotationsByType`.
   - **Meta-Annotations**:
     - `@Retention(RetentionPolicy.RUNTIME)`: Enables runtime access.
     - `@Target(ElementType.TYPE)`: Restricts to types.
     - `@Repeatable(Categories.class)`: Allows multiple instances.

9. **@Categories** (Custom Container Annotation)
   - **Purpose**: Acts as a container for multiple `@Category` annotations, required for `@Repeatable`.
   - **Usage**: Declared with a `value` element returning an array of `Category` annotations.
   - **Effect**: Automatically managed by the Java runtime to store multiple `@Category` annotations on `Workflow`.
   - **Meta-Annotations**:
     - `@Retention(RetentionPolicy.RUNTIME)`: Enables runtime access.
     - `@Target(ElementType.TYPE)`: Restricts to types.

Additional Notes
---------------
- **Reflection**: The program uses `java.lang.reflect` to inspect annotations and invoke methods at runtime, simulating how frameworks like Spring or Hibernate process annotations.
- **File Structure**: Each class (`Task`, `Category`, `Categories`, `Workflow`, `Parent`, `Child`, `AnnotationsAndMetadata`) should be in its own `.java` file in the `java_bootcamp.advancedjava.annotationandmetadata` package.
- **Error Handling**: The `main` method includes a try-catch block to handle reflection-related exceptions, ensuring robustness.
- **Improvements**: For production, consider using a real annotation processor (extending `javax.annotation.processing.AbstractProcessor`) instead of reflection for compile-time processing, as mentioned in the overview.

This program effectively demonstrates the power of annotations for metadata, compile-time checks, and runtime processing, making it a valuable learning tool for Java developers.