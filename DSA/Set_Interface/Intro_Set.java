package java_BASIC_OOPS_DSA_PROJECTS_PROBLEMS.DSA.Set_Interface;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// Java Program to Implementing Set Interface
public class Intro_Set {
    public static void main(String args[])
    {

        // Create a Set using HashSet
        Set<String> s = new HashSet<>();

        s.add("ms");
        s.add("ms1");

        // Displaying the Set
        System.out.println("Set Elements: " + s);
//-------------------------------------------------------------------------------------------------

        // Demonstrating Set using HashSet
        // Declaring object of type String
        Set<String> s1 = new HashSet<String>();

        // Adding elements to the Set
        // using add() method
        s1.add("Geeks");
        s1.add("For");
        s1.add("Geeks");
        s1.add("Example");
        s1.add("Set");

        // Printing elements of HashSet object
        System.out.println(s);

//-------------------------------------------------------------------------------------------------

        // Creating an object of Set class
        // Declaring object of Integer type
        Set<Integer> a = new HashSet<Integer>();

        // Adding all elements to List
        a.addAll(Arrays.asList(
                new Integer[] { 1, 3, 2, 4, 8, 9, 0 }));

        // Again declaring object of Set class
        // with reference to HashSet
        Set<Integer> b = new HashSet<Integer>();

        b.addAll(Arrays.asList(
                new Integer[] { 1, 3, 7, 5, 4, 0, 7, 5 }));


        // To find union
        Set<Integer> u = new HashSet<Integer>(a);
        u.addAll(b);
        System.out.print("Union of the two Set");
        System.out.println(u);

        // To find intersection
        Set<Integer> i = new HashSet<Integer>(a);
        i.retainAll(b);
        System.out.print("Intersection of the two Set");
        System.out.println(i);

        // To find the symmetric difference
        Set<Integer> d = new HashSet<Integer>(a);
        d.removeAll(b);
        System.out.print("Difference of the two Set");
        System.out.println(d);
    }
}
