// Java Fundamentals: Packages and Imports
// Aligned with Oracle Certified Professional: Java SE 17 Developer syllabus

/*
1. Creating and Using Packages
-----------------------------
- Package:
  - A namespace that organizes related classes and interfaces to avoid naming conflicts and improve code maintainability.
  - Declared at the top of a Java file using the 'package' keyword.
  - Syntax tying class to package: package packageName;
  - Example: package com.example.utils;
- Creating Packages:
  - Define a package in the source file (e.g., package com.example;).
  - Directory structure must match package name (e.g., com/example for com.example).
  - Example: A class in package com.example.utils is stored in src/com/example/utils/.
- Using Packages:
  - Access classes in the same package directly.
  - Access classes in different packages using fully qualified names (e.g., com.example.utils.Helper) or import statements.
  - Example: com.example.utils.Helper helper = new com.example.utils.Helper();
- Notes:
  - Package names typically use lowercase and follow a reverse domain naming convention (e.g., com.company.project).
  - Default package (no package declaration) is discouraged for production code.
  - Access modifiers (public, protected, default, private) control class/member visibility across packages.
*/

/*
2. Import Statements (Static Imports, Wildcard Imports)
-----------------------------------------------------
- Import Statements:
  - Allow referencing classes/interfaces from other packages without using fully qualified names.
  - Syntax: import packageName.ClassName;
  - Example: import java.util.Scanner;
- Wildcard Imports:
  - Import all classes in a package using an asterisk (*).
  - Syntax: import packageName.*;
  - Example: import java.util.*; // Imports all classes in java.util
  - Notes:
    - Does not import subpackages or non-class types.
    - Can reduce readability if overused; prefer specific imports when possible.
- Static Imports:
  - Import static members (fields, methods) of a class to use them without the class name.
  - Syntax: import static packageName.ClassName.staticMember;
  - Example: import static java.lang.Math.PI;
  - Wildcard static import: import static packageName.ClassName.*;
  - Example: import static java.lang.Math.*; // Imports all static members of Math
- Notes:
  - Imports are resolved at compile time; they do not affect runtime performance.
  - Avoid naming conflicts by using specific imports or fully qualified names.
  - Java automatically imports java.lang.* (e.g., String, System) without explicit import.
*/

// Note: For demonstration, assume this file is in package com.example.main
// Other classes are assumed to be in com.example.utils and com.example.models
package Java_Bootcamp.JavaBasics.Packages;

// Static import
import static java.lang.Math.PI;
// Wildcard static import
import static java.lang.Math.*;

// Main class in com.example.main package
public class PackagesAndImportsDemo {
    public static void main(String[] args) {
        // Example 1: Using a class from another package (com.example.utils)
        System.out.println("Using Package (com.example.utils):");
        Helper.printMessage("Hello from Helper class"); // Accessed via import

        // Example 2: Using classes from another package (com.example.models)
        System.out.println("\nUsing Package (com.example.models) with Wildcard Import:");
        Person person = new Person("John Doe");
        System.out.println("Person Name: " + person.getName());

        // Example 3: Using static imports
        System.out.println("\nUsing Static Imports:");
        System.out.println("Value of PI: " + PI); // Accessed without Math.PI
        System.out.println("Square root of 16: " + sqrt(16)); // Accessed without Math.sqrt

        // Example 4: Fully qualified name (no import needed)
        System.out.println("\nUsing Fully Qualified Name:");
    }
}