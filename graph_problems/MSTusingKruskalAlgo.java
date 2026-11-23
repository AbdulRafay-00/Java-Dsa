/*
 * MST using Kruskal's Algorithm
 *
 * Key properties of an MST:
 *   1. It must NOT contain a cycle.
 *   2. It must have exactly (V - 1) edges.
 *   3. It must connect all vertices.
 *
 * Steps:
 *   Step 1: Sort all edges in non-decreasing order of weight.
 *   Step 2: Initialize DSU (Union-Find), each vertex in its own set.
 *   Step 3: Pick the smallest unused edge (u, v, w).
 *   Step 4: If find(u) != find(v), add the edge and union(u, v).
 *           Otherwise skip it (it would form a cycle).
 *   Step 5: Repeat until the MST has (V - 1) edges.
 *   Step 6: Return the MST edges and total weight.
 *
 * Time Complexity: O(E log E)
 * Space Complexity: O(V + E)
 */
