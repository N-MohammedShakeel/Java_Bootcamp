package Java_Bootcamp.DSA.IntermediateToAdvance.Graph.CustomImplementation;

import java.util.*;

// Graph.java
// Custom implementation of a graph using adjacency matrix representation
// Supports directed and undirected graphs with basic operations, adjacency matrix printing, BFS, and DFS
// Uses LinkedList for BFS queue and ArrayList for traversal results

public class Graph {
    private int[][] adjMatrix; // Adjacency matrix for graph
    private int vertexCount;   // Number of vertices in the graph
    private boolean isDirected; // Flag to indicate if graph is directed
    private Map<Integer, Integer> vertexToIndex; // Maps vertex labels to matrix indices
    private Map<Integer, Integer> indexToVertex; // Maps matrix indices to vertex labels

    // Constructor to initialize graph with a maximum capacity
    // Time: O(n^2), Space: O(n^2) where n is maxVertices
    public Graph(int maxVertices, boolean isDirected) {
        this.adjMatrix = new int[maxVertices][maxVertices];
        this.vertexCount = 0;
        this.isDirected = isDirected;
        this.vertexToIndex = new HashMap<>();
        this.indexToVertex = new HashMap<>();
    }

    // Adds a vertex to the graph
    // Time: O(1), Space: O(1)
    public void addVertex(int vertex) {
        if (vertexToIndex.containsKey(vertex) || vertexCount >= adjMatrix.length) {
            return; // Vertex already exists or max capacity reached
        }
        vertexToIndex.put(vertex, vertexCount);
        indexToVertex.put(vertexCount, vertex);
        vertexCount++;
    }

    // Adds an edge between two vertices
    // Time: O(1), Space: O(1)
    public void addEdge(int source, int destination) {
        // Add vertices if they don't exist
        addVertex(source);
        addVertex(destination);

        // Get matrix indices for source and destination
        int srcIndex = vertexToIndex.get(source);
        int destIndex = vertexToIndex.get(destination);

        // Add edge from source to destination
        adjMatrix[srcIndex][destIndex] = 1;

        // If undirected, add reverse edge
        if (!isDirected) {
            adjMatrix[destIndex][srcIndex] = 1;
        }
    }

    // Removes a vertex and its associated edges
    // Time: O(V^2), Space: O(1)
    public void removeVertex(int vertex) {
        if (!vertexToIndex.containsKey(vertex)) return;

        int index = vertexToIndex.get(vertex);

        // Shift rows and columns to remove the vertex
        for (int i = index; i < vertexCount - 1; i++) {
            for (int j = 0; j < vertexCount; j++) {
                adjMatrix[i][j] = adjMatrix[i + 1][j];
            }
        }
        for (int j = index; j < vertexCount - 1; j++) {
            for (int i = 0; i < vertexCount; i++) {
                adjMatrix[i][j] = adjMatrix[i][j + 1];
            }
        }

        // Clear the last row and column
        for (int i = 0; i < vertexCount; i++) {
            adjMatrix[vertexCount - 1][i] = 0;
            adjMatrix[i][vertexCount - 1] = 0;
        }

        // Update mappings
        vertexToIndex.remove(vertex);
        indexToVertex.remove(index);
        for (int i = index; i < vertexCount - 1; i++) {
            int v = indexToVertex.get(i + 1);
            vertexToIndex.put(v, i);
            indexToVertex.put(i, v);
            indexToVertex.remove(i + 1);
        }
        vertexCount--;
    }

    // Removes an edge between two vertices
    // Time: O(1), Space: O(1)
    public void removeEdge(int source, int destination) {
        if (!vertexToIndex.containsKey(source) || !vertexToIndex.containsKey(destination)) {
            return;
        }

        int srcIndex = vertexToIndex.get(source);
        int destIndex = vertexToIndex.get(destination);

        // Remove edge from source to destination
        adjMatrix[srcIndex][destIndex] = 0;

        // If undirected, remove reverse edge
        if (!isDirected) {
            adjMatrix[destIndex][srcIndex] = 0;
        }
    }

    // Prints the adjacency matrix with vertex labels
    // Time: O(V^2), Space: O(1)
    public void printAdjacencyMatrix() {
        if (vertexCount == 0) {
            System.out.println("Graph is empty");
            return;
        }

        // Print header row with vertex labels
        System.out.print("  ");
        for (int i = 0; i < vertexCount; i++) {
            System.out.print(indexToVertex.get(i) + " ");
        }
        System.out.println();

        // Print matrix rows with vertex labels
        for (int i = 0; i < vertexCount; i++) {
            System.out.print(indexToVertex.get(i) + " ");
            for (int j = 0; j < vertexCount; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Performs Breadth-First Search (BFS) starting from a vertex
    // Uses LinkedList for queue and ArrayList for result
    // Time: O(V^2), Space: O(V)
    public ArrayList<Integer> bfs(int startVertex) {
        ArrayList<Integer> result = new ArrayList<>();
        if (!vertexToIndex.containsKey(startVertex)) return result;

        Set<Integer> visited = new HashSet<>();
        LinkedList<Integer> queue = new LinkedList<>();

        int startIndex = vertexToIndex.get(startVertex);
        visited.add(startVertex);
        queue.offer(startVertex);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            result.add(vertex);

            int index = vertexToIndex.get(vertex);
            for (int j = 0; j < vertexCount; j++) {
                if (adjMatrix[index][j] == 1 && !visited.contains(indexToVertex.get(j))) {
                    int neighbor = indexToVertex.get(j);
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        return result;
    }

    // Performs Depth-First Search (DFS) starting from a vertex
    // Uses ArrayList for result and recursion for traversal
    // Time: O(V^2), Space: O(V)
    public ArrayList<Integer> dfs(int startVertex) {
        ArrayList<Integer> result = new ArrayList<>();
        if (!vertexToIndex.containsKey(startVertex)) return result;

        Set<Integer> visited = new HashSet<>();
        dfsHelper(startVertex, visited, result);
        return result;
    }

    private void dfsHelper(int vertex, Set<Integer> visited, ArrayList<Integer> result) {
        visited.add(vertex);
        result.add(vertex);

        int index = vertexToIndex.get(vertex);
        for (int j = 0; j < vertexCount; j++) {
            if (adjMatrix[index][j] == 1 && !visited.contains(indexToVertex.get(j))) {
                dfsHelper(indexToVertex.get(j), visited, result);
            }
        }
    }

    // Main method for testing the graph implementation
    public static void main(String[] args) {
        // Test case: Create an undirected graph with max 5 vertices
        Graph graph = new Graph(5, false);

        // Add vertices and edges
        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);

        // Print adjacency matrix
        System.out.println("Adjacency Matrix:");
        graph.printAdjacencyMatrix();
        // Expected:
        //   0 1 2 3
        // 0 0 1 1 0
        // 1 1 0 0 1
        // 2 1 0 0 1
        // 3 0 1 1 0

        // Perform BFS starting from vertex 0
        System.out.println("\nBFS from vertex 0: " + graph.bfs(0));
        // Expected: [0, 1, 2, 3] (order may vary slightly among neighbors)

        // Perform DFS starting from vertex 0
        System.out.println("DFS from vertex 0: " + graph.dfs(0));
        // Expected: [0, 1, 3, 2] (order may vary slightly)

        // Remove edge between 1 and 3
        graph.removeEdge(1, 3);
        System.out.println("\nAdjacency Matrix after removing edge (1,3):");
        graph.printAdjacencyMatrix();
        // Expected:
        //   0 1 2 3
        // 0 0 1 1 0
        // 1 1 0 0 0
        // 2 1 0 0 1
        // 3 0 0 1 0

        // Remove vertex 2
        graph.removeVertex(2);
        System.out.println("\nAdjacency Matrix after removing vertex 2:");
        graph.printAdjacencyMatrix();
        // Expected:
        //   0 1 3
        // 0 0 1 0
        // 1 1 0 0
        // 3 0 0 0
    }
}