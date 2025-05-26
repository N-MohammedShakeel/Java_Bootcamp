# Prefix Sum in Depth: A Guide for DSA Preparation

## 1. What is Prefix Sum?
Prefix sum is a precomputation technique that involves creating an array (or matrix for 2D) where each element stores the cumulative sum (or other aggregation) of elements up to that index. This allows for efficient computation of range queries, such as the sum of elements in a subarray [l, r], in O(1) time after O(n) preprocessing.

- **Key Idea**: Precompute cumulative sums so that range queries can be answered using simple arithmetic (e.g., sum[l, r] = prefix[r] - prefix[l-1]).
- **Applications**: Range sum queries, range minimum/maximum queries, counting elements in a range, and problems involving subarrays or submatrices.
- **Advantages**:
  - Reduces range query time from O(n) to O(1) after O(n) preprocessing.
  - Simplifies problems involving cumulative properties.
  - Versatile for 1D and 2D data.

## 2. How Prefix Sum Works
### 2.1 1D Prefix Sum
For an array `arr` of size n:
- Compute prefix sum array `prefix` where `prefix[i]` = sum of `arr[0]` to `arr[i]`.
- Formula: `prefix[i] = prefix[i-1] + arr[i]` (with `prefix[-1] = 0`).
- Range sum query [l, r]: `sum = prefix[r] - prefix[l-1]` (if l > 0, else `prefix[r]`).

### 2.2 2D Prefix Sum
For a 2D matrix `mat` of size m x n:
- Compute prefix sum matrix `prefix` where `prefix[i][j]` = sum of all elements in submatrix from (0,0) to (i,j).
- Formula: `prefix[i][j] = mat[i][j] + prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1]` (to avoid double-counting).
- Range sum query for submatrix [(r1,c1), (r2,c2)]:
  - `sum = prefix[r2][c2] - prefix[r2][c1-1] - prefix[r1-1][c2] + prefix[r1-1][c1-1]`.

## 3. When to Use Prefix Sum
Use prefix sum when:
- The problem requires frequent range queries (e.g., sum, count, min/max) on a static array or matrix.
- You need to compute cumulative properties (e.g., subarray sums, submatrix sums).
- The input data does not change, or updates are infrequent (for dynamic updates, use segment trees or Fenwick trees).
- Common problems:
  - Subarray Sum Equals K (LeetCode #560)
  - Range Sum Query (LeetCode #303)
  - 2D Range Sum Query (LeetCode #304)
  - Counting subarrays with a given property.

## 4. Prefix Sum Template
### 4.1 1D Prefix Sum
```java
int[] computePrefixSum(int[] arr) {
    int n = arr.length;
    int[] prefix = new int[n];
    prefix[0] = arr[0];
    for (int i = 1; i < n; i++) {
        prefix[i] = prefix[i-1] + arr[i];
    }
    return prefix;
}
// Range query [l, r]
int rangeSum(int[] prefix, int l, int r) {
    return l == 0 ? prefix[r] : prefix[r] - prefix[l-1];
}
```

### 4.2 2D Prefix Sum
```java
int[][] compute2DPrefixSum(int[][] mat) {
    int m = mat.length, n = mat[0].length;
    int[][] prefix = new int[m][n];
    prefix[0][0] = mat[0][0];
    // Fill first row
    for (int j = 1; j < n; j++) prefix[0][j] = prefix[0][j-1] + mat[0][j];
    // Fill first column
    for (int i = 1; i < m; i++) prefix[i][0] = prefix[i-1][0] + mat[i][0];
    // Fill rest
    for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {
            prefix[i][j] = mat[i][j] + prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1];
        }
    }
    return prefix;
}
// Range query [(r1,c1), (r2,c2)]
int rangeSum2D(int[][] prefix, int r1, int c1, int r2, int c2) {
    int sum = prefix[r2][c2];
    if (c1 > 0) sum -= prefix[r2][c1-1];
    if (r1 > 0) sum -= prefix[r1-1][c2];
    if (r1 > 0 && c1 > 0) sum += prefix[r1-1][c1-1];
    return sum;
}
```

## 5. Applications
- **1D Range Queries**: Compute sum, count, or other properties of subarrays.
- **2D Range Queries**: Compute sum or count in submatrices.
- **Subarray Problems**: Find subarrays with a given sum or property.
- **Binary Search on Prefix Sums**: Find ranges satisfying a condition (e.g., sum ≤ k).
- **Difference Array**: Reverse of prefix sum for range updates (not covered here).

## 6. Time and Space Complexity
- **1D Prefix Sum**:
  - Precomputation: O(n)
  - Query: O(1)
  - Space: O(n) for prefix array
- **2D Prefix Sum**:
  - Precomputation: O(m * n)
  - Query: O(1)
  - Space: O(m * n) for prefix matrix

## 7. Common Pitfalls
- **Index Out of Bounds**: Ensure l > 0 when computing `prefix[r] - prefix[l-1]` or use conditionals.
- **Overflow**: Use `long` for large sums to avoid integer overflow.
- **Edge Cases**: Handle empty ranges, single-element ranges, or invalid indices.
- **2D Coordinates**: Double-check inclusion/exclusion in submatrix calculations.
- **Static Data**: Prefix sum is best for static arrays; for frequent updates, consider segment trees or Fenwick trees.

## 8. Java-Specific Tips
- Use `long[]` for prefix sums to handle large values.
- Initialize prefix arrays carefully, especially for 2D cases.
- Use helper methods for range queries to improve readability.
- Validate input indices to prevent ArrayIndexOutOfBoundsException.
- For large inputs, ensure array sizes are sufficient.

## 9. Practice Problems
1. Range Sum Query - Immutable (LeetCode #303)
2. Subarray Sum Equals K (LeetCode #560)
3. Range Sum Query 2D - Immutable (LeetCode #304)
4. Count Subarrays with Sum < K (GeeksforGeeks)
5. Maximum Sum Subarray (Kadane’s Algorithm with prefix sum variant)

## 10. Optimization Techniques
- **Combine with Hashing**: Use a HashMap to store prefix sums for problems like Subarray Sum Equals K.
- **Binary Search**: Use prefix sums with binary search to find ranges satisfying a condition.
- **Difference Array**: For range updates on static arrays, use difference arrays (inverse of prefix sum).
- **Sparse Prefix Sums**: For sparse data, store only non-zero prefix sums in a map.

## 11. Limitations
- **Static Data**: Prefix sums are inefficient for frequent updates; use segment trees or Fenwick trees instead.
- **Non-Additive Queries**: Less effective for non-cumulative properties (e.g., median, mode) unless adapted.
- **Memory**: Requires O(n) or O(m * n) extra space.

## 12. Resources
- **Books**:
  - "Competitive Programming" by Steven Halim
  - "Introduction to Algorithms" by Cormen (CLRS)
- **Online Platforms**:
  - LeetCode (Array, Prefix Sum tags)
  - GeeksforGeeks (Prefix Sum section)
  - Codeforces (Problems tagged with "prefix sum")
- **Tutorials**:
  - GeeksforGeeks Prefix Sum Articles
  - LeetCode Discuss for problem-specific solutions
  - YouTube channels like Tushar Roy or William Fiset

## 13. Conclusion
Prefix sum is a simple yet powerful technique for optimizing range queries in static arrays or matrices. By precomputing cumulative sums, it enables O(1) query times, making it ideal for problems like subarray sums or 2D range sums. Practice the provided examples and explore related problems to master this technique.

Happy coding!