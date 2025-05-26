Java Object Lifecycle
=====================

Overview
--------
- The object lifecycle in Java describes the stages an object goes through from creation to destruction.
- Managed by the Java Virtual Machine (JVM), particularly the garbage collector.
- Understanding the lifecycle is crucial for memory management and resource handling in Java applications.

Stages of Object Lifecycle
-------------------------
1. Creation:
   - An object is created using the `new` keyword, allocating memory in the heap.
   - Process:
     a. Class loading: The JVM loads the class if not already loaded.
     b. Memory allocation: Space is allocated for the object's fields and metadata.
     c. Initialization:
        - Instance fields are set to default values (0, null, false, etc.).
        - Instance initializers and constructors are executed.
     d. Reference assignment: The object reference is returned to the program.
   - Example: `MyClass obj = new MyClass();`
   - Notes:
     - Constructors may call other constructors or methods.
     - Exceptions during creation (e.g., OutOfMemoryError) can occur.

2. In Use:
   - The object is actively used by the program via its reference.
   - Activities:
     - Accessing fields, calling methods, passing the object to methods.
     - The object may be referenced by multiple variables or collections.
   - Example: `obj.someMethod();`
   - Notes:
     - Objects remain in memory as long as they are reachable (referenced directly or indirectly).
     - Thread safety is critical if the object is shared across threads.

3. Unreachable:
   - An object becomes unreachable when no live references point to it.
   - Causes:
     - Reference variables are set to null (e.g., `obj = null;`).
     - References go out of scope (e.g., local variables in a method).
     - Objects are removed from collections or their containing objects are unreachable.
   - Example: `obj = null; // Object is now unreachable`
   - Notes:
     - Unreachable objects are eligible for garbage collection.
     - Weak references (e.g., WeakReference) allow objects to become unreachable sooner.

4. Garbage Collection:
   - The JVM's garbage collector reclaims memory from unreachable objects.
   - Process:
     a. Marking: Identifies reachable objects; unreachable ones are marked for collection.
     b. Sweeping: Frees memory occupied by unreachable objects.
     c. Optional compacting: Reorganizes memory to reduce fragmentation.
   - Finalization:
     - Before reclamation, the `finalize()` method (if overridden) may be called.
     - Deprecated in Java 9; avoid using finalize() due to unpredictability.
   - Notes:
     - Garbage collection is non-deterministic; the JVM decides when to run it.
     - Use `System.gc()` to suggest garbage collection, but it’s not guaranteed.
     - Tools like try-with-resources or cleaners (Java 9+) are preferred for resource cleanup.

5. Destruction:
   - The object's memory is fully reclaimed, and it no longer exists in memory.
   - No explicit destruction in Java (unlike C++); handled by the garbage collector.
   - Example: After garbage collection, the object is gone.
   - Notes:
     - No manual memory deallocation (no `delete` equivalent).
     - Memory leaks can occur if objects remain reachable unnecessarily.

Best Practices
--------------
- Initialize objects properly in constructors to avoid invalid states.
- Use try-with-resources for objects implementing AutoCloseable (e.g., streams).
- Nullify references when objects are no longer needed to aid garbage collection.
- Avoid relying on finalize(); use explicit cleanup methods or cleaners.
- Monitor memory usage in large applications to prevent OutOfMemoryError.
- Use weak or soft references for cache-like structures to allow garbage collection.

Example
-------
class MyClass {
    String name;
    MyClass(String name) {
        this.name = name;
        System.out.println(name + " created");
    }
}

public class Main {
    public static void main(String[] args) {
        MyClass obj = new MyClass("Object1"); // Creation
        obj.name = "Updated"; // In Use
        obj = null; // Unreachable
        System.gc(); // Suggest garbage collection
        // Object may be collected and destroyed
    }
}

References
----------
- Oracle Java Documentation
- Java SE 17 Developer Guide
- Effective Java by Joshua Bloch