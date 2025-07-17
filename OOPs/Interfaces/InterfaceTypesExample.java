package Java_Bootcamp.OOPs.Interfaces; /**
 * InterfaceTypesExample.java
 * Demonstrates the four types of interfaces in Java: normal, functional, marker, and nested.
 * Scenario: Managing a simple graph data structure for a DSA application.
 * Features: Examples of each interface type with clear, DSA-relevant implementations.
 */
import java.io.Serializable;
import java.util.function.Predicate;

// Normal Interface: Defines operations for a graph
interface Graph {
    void addEdge(int from, int to);
    void printGraph();
    default void describe() {
        System.out.println("This is a graph with edges");
    }
}

// Functional Interface: Defines a condition for filtering nodes
@FunctionalInterface
interface NodeFilter {
    boolean test(int nodeId);
    default void printFilter() {
        System.out.println("Filtering nodes");
    }
}

// Marker Interface: Marks classes as taggable for special treatment
interface Taggable {
    // Empty interface
}

// Nested Interface: Defines a node within a graph
interface GraphOperations {
    void processGraph();
    interface Node {
        int getId();
        void display();
    }
}

// Graph implementation class
class SimpleGraph implements Graph, Taggable, Serializable {
    private int[][] adjacencyMatrix;
    private int vertices;

    public SimpleGraph(int vertices) {
        this.vertices = vertices;
        this.adjacencyMatrix = new int[vertices][vertices];
    }

    @Override
    public void addEdge(int from, int to) {
        if (from >= 0 && from < vertices && to >= 0 && to < vertices) {
            adjacencyMatrix[from][to] = 1;
            System.out.println("Added edge from " + from + " to " + to);
        }
    }

    @Override
    public void printGraph() {
        System.out.println("Graph adjacency matrix:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Nested interface implementation
    class GraphNode implements GraphOperations.Node {
        private int id;

        public GraphNode(int id) {
            this.id = id;
        }

        @Override
        public int getId() {
            return id;
        }

        @Override
        public void display() {
            System.out.println("Node ID: " + id);
        }
    }
}

public class InterfaceTypesExample {
    public static void main(String[] args) {
        // Normal Interface: Using Graph
        SimpleGraph graph = new SimpleGraph(3);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.printGraph();
        graph.describe(); // Default method

        // Functional Interface: Using NodeFilter with lambda
        NodeFilter evenNodeFilter = (nodeId) -> nodeId % 2 == 0;
        System.out.println("Is node 2 even? " + evenNodeFilter.test(2));
        evenNodeFilter.printFilter();

        // Marker Interface: Checking if graph is Taggable
        if (graph instanceof Taggable) {
            System.out.println("Graph is taggable");
        }

        // Nested Interface: Using GraphOperations.Node
        GraphOperations.Node node = graph.new GraphNode(1);
        node.display();
    }
}