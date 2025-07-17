package Java_Bootcamp.OOPs.ClassObjects; /**
 * ClassTypesExample.java
 * Demonstrates different types of classes in Java: normal, abstract, interface, nested/inner,
 * anonymous, enum, and record.
 * Scenario: Managing a simple graph data structure for a DSA application.
 * Features: Examples of each class type with clear, DSA-relevant implementations.
 */
import java.util.Comparator;

// Interface: Defines graph operations (related concept)
interface Graph {
    void addEdge(int from, int to);
    void printGraph();
}

// Normal Class: Concrete implementation of a graph
class SimpleGraph implements Graph {
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
}

// Abstract Class: Base class for graph implementations
abstract class AbstractGraph implements Graph {
    abstract void logOperation(String operation);
    void describe() {
        System.out.println("This is an abstract graph");
    }
}

// Nested/Inner Class: Graph with a node inner class
class GraphWithNodes {
    private int vertices;

    // Inner Class (non-static)
    class Node {
        private int id;

        Node(int id) {
            this.id = id;
        }

        void display() {
            System.out.println("Node ID: " + id + " in graph with " + vertices + " vertices");
        }
    }

    public GraphWithNodes(int vertices) {
        this.vertices = vertices;
    }

    Node createNode(int id) {
        return new Node(id);
    }
}

// Enum Class: Represents graph traversal states
enum TraversalState {
    UNVISITED, VISITED, PROCESSING;

    void describe() {
        System.out.println("State: " + this);
    }
}

// Record Class: Represents a graph vertex with coordinates
record Vertex(int id, int x, int y) {
    double distanceTo(Vertex other) {
        return Math.sqrt(Math.pow(x - other.x, 2) + Math.pow(y - other.y, 2));
    }
}

public class ClassTypesExample {
    public static void main(String[] args) {
        // Normal Class: Using SimpleGraph
        SimpleGraph graph = new SimpleGraph(3);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.printGraph();

        // Abstract Class: Extending AbstractGraph
        AbstractGraph abstractGraph = new AbstractGraph() {
            @Override
            public void addEdge(int from, int to) {
                System.out.println("Adding edge in abstract graph: " + from + " -> " + to);
            }

            @Override
            public void printGraph() {
                System.out.println("Printing abstract graph");
            }

            @Override
            void logOperation(String operation) {
                System.out.println("Log: " + operation);
            }
        };
        abstractGraph.addEdge(0, 1);
        abstractGraph.describe();

        // Interface: Already used with SimpleGraph and AbstractGraph

        // Nested/Inner Class: Using GraphWithNodes
        GraphWithNodes graphWithNodes = new GraphWithNodes(4);
        GraphWithNodes.Node node = graphWithNodes.createNode(1);
        node.display();

        // Anonymous Class: Using Comparator for reverse sorting
        Comparator<Integer> reverseComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        };
        Integer[] numbers = {5, 3, 8};
        java.util.Arrays.sort(numbers, reverseComparator);
        System.out.println("Sorted numbers (reverse): " + java.util.Arrays.toString(numbers));

        // Enum Class: Using TraversalState
        TraversalState state = TraversalState.VISITED;
        state.describe();

        // Record Class: Using Vertex
        Vertex v1 = new Vertex(1, 0, 0);
        Vertex v2 = new Vertex(2, 3, 4);
        System.out.println("Vertex: " + v1);
        System.out.println("Distance between vertices: " + v1.distanceTo(v2));
    }
}