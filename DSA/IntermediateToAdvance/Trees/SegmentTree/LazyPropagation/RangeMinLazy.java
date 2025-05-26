package Java_Bootcamp.DSA.IntermediateToAdvance.Trees.SegmentTree.LazyPropagation;

public class RangeMinLazy {
    private long[] tree; // Segment tree for minimums
    private long[] lazy; // Lazy array for pending updates
    private int n; // Size of input array

    public RangeMinLazy(int[] arr) {
        n = arr.length;
        tree = new long[4 * n];
        lazy = new long[4 * n];
        build(arr, 0, 0, n - 1);
    }

    // Algorithm:
    // 1. Build a segment tree where each node stores the minimum of its range.
    // 2. For range update [l, r] with value v:
    //    - For fully covered nodes, update the minimum and mark lazy value.
    //    - For partially covered nodes, recurse to children.
    //    - Propagate lazy updates before accessing a node.
    // 3. For range query [l, r]:
    //    - Propagate lazy updates for the current node.
    //    - Return minimum for fully covered nodes or recurse for partial overlaps.
    // 4. Propagation: Apply lazy value to node’s minimum and children’s lazy values.

    // Workflow:
    // - Build: Construct the segment tree bottom-up, storing minimums in nodes.
    // - Update:
    //   - Traverse to nodes covering [l, r].
    //   - If fully covered, update minimum and mark lazy.
    //   - If partially covered, recurse and update parent minimum.
    //   - Before accessing a node, propagate any pending lazy updates.
    // - Query:
    //   - Propagate lazy updates for the current node.
    //   - Return minimum for fully covered nodes.
    //   - Combine minimums from children for partial overlaps.
    // - Propagation: Update node’s minimum, propagate to children’s lazy values, clear lazy.

    // Build the segment tree
    private void build(int[] arr, int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
            return;
        }
        int mid = (start + end) / 2;
        build(arr, 2 * node + 1, start, mid);
        build(arr, 2 * node + 2, mid + 1, end);
        tree[node] = Math.min(tree[2 * node + 1], tree[2 * node + 2]);
    }

    // Propagate lazy updates to children
    private void propagate(int node, int start, int end) {
        if (lazy[node] != 0) {
            // Update current node’s minimum
            tree[node] += lazy[node];
            if (start != end) { // Not a leaf
                // Propagate to children
                lazy[2 * node + 1] += lazy[node];
                lazy[2 * node + 2] += lazy[node];
            }
            // Clear lazy value
            lazy[node] = 0;
        }
    }

    // Range update: Add value to [l, r]
    public void update(int l, int r, int value) {
        update(0, 0, n - 1, l, r, value);
    }

    private void update(int node, int start, int end, int l, int r, int value) {
        // Apply pending updates
        propagate(node, start, end);
        // No overlap
        if (start > r || end < l) return;
        // Full overlap
        if (l <= start && end <= r) {
            tree[node] += value;
            if (start != end) {
                lazy[2 * node + 1] += value;
                lazy[2 * node + 2] += value;
            }
            return;
        }
        // Partial overlap
        int mid = (start + end) / 2;
        update(2 * node + 1, start, mid, l, r, value);
        update(2 * node + 2, mid + 1, end, l, r, value);
        tree[node] = Math.min(tree[2 * node + 1], tree[2 * node + 2]);
    }

    // Range query: Minimum in [l, r]
    public long query(int l, int r) {
        return query(0, 0, n - 1, l, r);
    }

    private long query(int node, int start, int end, int l, int r) {
        // Apply pending updates
        propagate(node, start, end);
        // No overlap
        if (start > r || end < l) return Long.MAX_VALUE;
        // Full overlap
        if (l <= start && end <= r) return tree[node];
        // Partial overlap
        int mid = (start + end) / 2;
        return Math.min(query(2 * node + 1, start, mid, l, r),
                        query(2 * node + 2, mid + 1, end, l, r));
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 3, 4, 1};
        RangeMinLazy segTree = new RangeMinLazy(arr);
        // Update [1, 3] with value 2
        segTree.update(1, 3, 2);
        // Query [1, 3]
        System.out.println("Min [1, 3]: " + segTree.query(1, 3)); // 4
        // Update [2, 4] with value -1
        segTree.update(2, 4, -1);
        // Query [0, 4]
        System.out.println("Min [0, 4]: " + segTree.query(0, 4)); // 0
    }
}