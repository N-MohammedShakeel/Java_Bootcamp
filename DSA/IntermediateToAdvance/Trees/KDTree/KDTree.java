package Java_Bootcamp.DSA.IntermediateToAdvance.Trees.KDTree;

// KD Tree Implementation (2D)
// This file implements a KD Tree for 2D points, supporting spatial queries.
// Purpose: Provide a clear, readable, standalone implementation for HackWithInfy preparation, focusing on geometric operations.
// Workflow and algorithms are explained in comments for each operation, ensuring beginners can follow.
// No external dependencies; testing is embedded in the main method.
// Key Features:
// - Insert: Add a 2D point, alternating x/y splits.
// - Nearest Neighbor: Find closest point to a query.
// - Range Query: Find points in a rectangle.
// - Traversal: Preorder to list points.
// Java-Specific Notes:
// - Fixed to 2D for simplicity (k=2).
// - Null checks ensure robustness.
// - Memory managed by JVM; size is O(n).
// HackWithInfy Relevance:
// - Critical for Hard spatial problems (e.g., LeetCode #973, #732).
// - Tests understanding of space partitioning and geometric queries.
// Structure:
// - Nodes store point (x,y), split axis (x or y), and children.
// - Splits alternate between x and y by depth.

import java.util.*;

public class KDTree {
    private static class Node {
        double[] point; // 2D point: [x, y]
        int axis; // 0 for x, 1 for y
        Node left, right;

        Node(double[] point, int axis) {
            this.point = point;
            this.axis = axis;
            this.left = this.right = null;
        }
    }

    private Node root;
    private static final int K = 2; // 2D

    public KDTree() {
        root = null;
    }

    // Insert
    // Workflow: Add a 2D point, splitting on x or y based on depth.
    // Algorithm:
    // 1. Traverse based on axis comparison.
    // 2. Insert at leaf, alternate axis.
    // Time Complexity: O(log n) average.
    // Space Complexity: O(1).
    public void insert(double[] point) {
        if (point == null || point.length != K) return;
        root = insertHelper(root, point, 0);
    }
    private Node insertHelper(Node node, double[] point, int depth) {
        if (node == null) return new Node(point, depth % K);
        int axis = depth % K;
        if (point[axis] < node.point[axis]) {
            node.left = insertHelper(node.left, point, depth + 1);
        } else {
            node.right = insertHelper(node.right, point, depth + 1);
        }
        return node;
    }

    // Nearest Neighbor
    // Workflow: Find closest point to a query point.
    // Algorithm:
    // 1. Traverse to leaf (best guess).
    // 2. Backtrack, check other branch if closer point possible.
    // 3. Prune branches using distance.
    // Time Complexity: O(log n) average, O(n) worst.
    // Space Complexity: O(log n).
    public double[] nearestNeighbor(double[] target) {
        if (target == null || target.length != K || root == null) return null;
        double[] best = new double[K];
        double[] bestDist = {Double.MAX_VALUE};
        nearestHelper(root, target, 0, best, bestDist);
        return bestDist[0] == Double.MAX_VALUE ? null : best;
    }
    private void nearestHelper(Node node, double[] target, int depth, double[] best, double[] bestDist) {
        if (node == null) return;
        double dist = distance(node.point, target);
        if (dist < bestDist[0]) {
            bestDist[0] = dist;
            best[0] = node.point[0];
            best[1] = node.point[1];
        }

        int axis = depth % K;
        Node near = target[axis] < node.point[axis] ? node.left : node.right;
        Node far = near == node.left ? node.right : node.left;
        nearestHelper(near, target, depth + 1, best, bestDist);

        // Check far branch if closer point possible
        if (Math.abs(target[axis] - node.point[axis]) < bestDist[0]) {
            nearestHelper(far, target, depth + 1, best, bestDist);
        }
    }

    // Distance (Helper)
    // Workflow: Compute Euclidean distance between 2D points.
    // Time Complexity: O(1).
    private double distance(double[] p1, double[] p2) {
        return Math.sqrt(Math.pow(p1[0] - p2[0], 2) + Math.pow(p1[1] - p2[1], 2));
    }

    // Range Query
    // Workflow: Find all points in a 2D rectangle [xMin, xMax] × [yMin, yMax].
    // Algorithm:
    // 1. Check if node’s region intersects rectangle.
    // 2. Include point if in range, recurse to relevant children.
    // Time Complexity: O(n^(1-1/2) + r) ≈ O(√n + r).
    // Space Complexity: O(log n).
    public List<double[]> rangeQuery(double xMin, double xMax, double yMin, double yMax) {
        List<double[]> results = new ArrayList<>();
        rangeQueryHelper(root, xMin, xMax, yMin, yMax, 0, results);
        return results;
    }
    private void rangeQueryHelper(Node node, double xMin, double xMax, double yMin, double yMax, int depth, List<double[]> results) {
        if (node == null) return;
        double x = node.point[0], y = node.point[1];
        if (x >= xMin && x <= xMax && y >= yMin && y <= yMax) {
            results.add(node.point);
        }

        int axis = depth % K;
        double splitVal = node.point[axis];
        if (axis == 0) { // x-axis
            if (xMin <= splitVal) {
                rangeQueryHelper(node.left, xMin, xMax, yMin, yMax, depth + 1, results);
            }
            if (xMax >= splitVal) {
                rangeQueryHelper(node.right, xMin, xMax, yMin, yMax, depth + 1, results);
            }
        } else { // y-axis
            if (yMin <= splitVal) {
                rangeQueryHelper(node.left, xMin, xMax, yMin, yMax, depth + 1, results);
            }
            if (yMax >= splitVal) {
                rangeQueryHelper(node.right, xMin, xMax, yMin, yMax, depth + 1, results);
            }
        }
    }

    // Preorder Traversal
    // Workflow: Print points in preorder (Root, Left, Right).
    // Time Complexity: O(n).
    // Space Complexity: O(log n).
    public void preorder() {
        System.out.print("Preorder: ");
        preorderHelper(root);
        System.out.println();
    }
    private void preorderHelper(Node node) {
        if (node == null) return;
        System.out.printf("(%.1f, %.1f)[%s] ", node.point[0], node.point[1], node.axis == 0 ? "x" : "y");
        preorderHelper(node.left);
        preorderHelper(node.right);
    }

    // Debugging: Validate Structure
    // Workflow: Check if points are in correct regions.
    // Time Complexity: O(n).
    public boolean isValidKDTree() {
        return validateHelper(root, 0, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }
    private boolean validateHelper(Node node, int depth, double xMin, double xMax, double yMin, double yMax) {
        if (node == null) return true;
        double x = node.point[0], y = node.point[1];
        if (x < xMin || x > xMax || y < yMin || y > yMax) return false;
        int axis = depth % K;
        if (axis == 0) {
            return validateHelper(node.left, depth + 1, xMin, x, yMin, yMax) &&
                   validateHelper(node.right, depth + 1, x, xMax, yMin, yMax);
        } else {
            return validateHelper(node.left, depth + 1, xMin, xMax, yMin, y) &&
                   validateHelper(node.right, depth + 1, xMin, xMax, y, yMax);
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        System.out.println("KD Tree Operations:");
        KDTree kdt = new KDTree();
        // Insert: (2,3), (5,4), (9,6), (4,7), (7,2)
        double[][] points = {{2,3}, {5,4}, {9,6}, {4,7}, {7,2}};
        for (double[] point : points) {
            kdt.insert(point);
        }
        kdt.preorder(); // (5,4)[x] (2,3)[y] (9,6)[y] (4,7)[x] (7,2)[x]

        // Nearest neighbor
        double[] target = {3, 4.5};
        double[] nearest = kdt.nearestNeighbor(target);
        System.out.printf("Nearest to (3,4.5): (%.2f, %.2f)%n", nearest[0], nearest[1]); // (2,3)

        // Range query [2,6] × [3,7]
        List<double[]> range = kdt.rangeQuery(2, 6, 3, 7);
        System.out.print("Points in [2,6] × [3,7]: ");
        for (double[] p : range) {
            System.out.printf("(%.1f, %.1f) ", p[0], p[1]);
        }
        System.out.println(); // (2,3), (5,4), (4,7]

        // Validate
        System.out.println("Is Valid: " + kdt.isValidKDTree()); // true

        // Edge cases
        KDTree empty = new KDTree();
        System.out.println("Empty nearest: " + Arrays.toString(empty.nearestNeighbor(new double[]{1,1}))); // null
        System.out.println("Empty range: " + empty.rangeQuery(0, 1, 0, 1).size()); // 0
    }
}