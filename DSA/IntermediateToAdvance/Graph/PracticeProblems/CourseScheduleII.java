package Java_Bootcamp.DSA.IntermediateToAdvance.Graph.PracticeProblems;

import java.util.*;

public class CourseScheduleII {
    // LeetCode Link: https://leetcode.com/problems/course-schedule-ii/
    // Problem Description:
    // Given numCourses and prerequisites (directed edges), return the order of courses
    // to take to finish all courses. If impossible due to a cycle, return empty array.

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Algorithm:
        // 1. Model the problem as a DAG where courses are vertices and prerequisites are edges.
        // 2. Use DFS-based topological sort to order courses.
        // 3. Detect cycles by tracking vertices in the current recursion stack.
        // 4. Return topological order or empty array if cycle exists.

        // Workflow:
        // - Create adjacency list for directed graph.
        // - Initialize visited and recursion stack arrays.
        // - For each unvisited course, run DFS:
        //   - Mark course as in recursion stack.
        //   - Explore prerequisites; if unvisited, recurse; if in stack, cycle detected.
        //   - Add course to stack after exploration.
        // - If cycle detected, return empty array.
        // - Pop stack to get topological order and return as array.

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            adj.get(pre[1]).add(pre[0]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];
        Stack<Integer> stack = new Stack<>();
        boolean hasCycle = false;

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (dfs(i, adj, visited, recStack, stack)) {
                    hasCycle = true;
                    break;
                }
            }
        }

        if (hasCycle) return new int[0];

        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result[i] = stack.pop();
        }
        return result;
    }

    private boolean dfs(int v, List<List<Integer>> adj, boolean[] visited, boolean[] recStack, Stack<Integer> stack) {
        visited[v] = true;
        recStack[v] = true;

        for (int neighbor : adj.get(v)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, adj, visited, recStack, stack)) return true;
            } else if (recStack[neighbor]) {
                return true; // Cycle detected
            }
        }

        recStack[v] = false;
        stack.push(v);
        return false;
    }

    public static void main(String[] args) {
        CourseScheduleII solution = new CourseScheduleII();
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[] order = solution.findOrder(numCourses, prerequisites);
        System.out.println("Course order: " + Arrays.toString(order)); // Output: [0, 1, 2, 3]
    }
}