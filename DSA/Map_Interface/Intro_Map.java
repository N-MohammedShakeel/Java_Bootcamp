package java_BASIC_OOPS_DSA_PROJECTS_PROBLEMS.DSA.Map_Interface;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Intro_Map {

//    The Map data structure in Java is implemented by two interfaces:

//    Map Interface
//    SortedMap Interface

//    The three primary classes that implement these interfaces are,
//    HashMap
//    TreeMap
//    LinkedHashMap

    public static void main(String[] args) {

        // Create a Map using HashMap
        Map<String, Integer> m1 = new HashMap<>();

//        Map<String, Integer> m2 = new LinkedHashMap<>();
//
//        Map<String, Integer> m3 = new TreeMap<>();

        // Adding key-value pairs to the map
        m1.put("ms1", 1);
        m1.put("ms2", 2);
        m1.put("ms3", 3);

        System.out.println("Map elements: " + m1);

        // Iterating over Map using for each loop
        for (Map.Entry<String, Integer> e : m1.entrySet())

            System.out.println(e.getKey() + " "
                    + e.getValue());
    }
}