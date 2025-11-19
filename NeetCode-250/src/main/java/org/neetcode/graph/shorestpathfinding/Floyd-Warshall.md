# Flyod Warshall Algorithm

<b>When to use:</b><br> 
You want the shortest distance between every pair of vertices. Works with negative edges but no negative cycles.

### Input
- n: number of vertices 0..n-1
- Edge list or adjacency matrix with weights (use INF for no edge)

### Outputs
- dist[i][j]: shortest distance from i to j
- next[i][j]: first hop on a shortest path from i to j (for path reconstruction)

### Process
1. Initialize
2. Core DP triple loop
3. Negative cycle detection 
4. Path reconstruction

### Complexity
- Time : O(V^3)
- Space : O(V^3)

### Gotchas
- Use a large INF (e.g., 1e15) and long arithmetic to avoid overflow on sums.
- For undirected graphs, set bot i -> j and j -> i.
- If multiple edges between the same nodes, keep the minimum weight.

## Java  pesudocode

```
class FloydWarshallResult {
    long[][] dist;   // shortest distances
    int[][] next;    // next-hop matrix for path reconstruction
    FloydWarshallResult(long[][] dist, int[][] next) {
        this.dist = dist; this.next = next;
    }
}
FloydWarshallResult floydWarshall(int n, List<int[]> edges) {
    // Each edge: int[]{u, v, w} with u->v of weight w (w can be negative)
    final long INF = (long)1e15;

    long[][] dist = new long[n][n];
    int[][] next = new int[n][n];

    // Initialize
    for (int i = 0; i < n; i++) {
        Arrays.fill(dist[i], INF);
        Arrays.fill(next[i], -1);
        dist[i][i] = 0;
        next[i][i] = i;
    }

    // Load edges (keep min weight if multi-edges)
    for (int[] e : edges) {
        int u = e[0], v = e[1], w = e[2];
        if (w < dist[u][v]) {
            dist[u][v] = w;
            next[u][v] = v;
        }
    }

    // Core DP
    for (int k = 0; k < n; k++) {
        for (int i = 0; i < n; i++) {
            if (dist[i][k] == INF) continue;
            for (int j = 0; j < n; j++) {
                if (dist[k][j] == INF) continue;
                long cand = dist[i][k] + dist[k][j];
                if (cand < dist[i][j]) {
                    dist[i][j] = cand;
                    next[i][j] = next[i][k]; // first hop toward j via k
                }
            }
        }
    }

    // Optional: detect and propagate negative cycles
    // If a node k has dist[k][k] < 0, it is on a negative cycle.
    for (int k = 0; k < n; k++) {
        if (dist[k][k] < 0) { // k in/affected by a negative cycle
            for (int i = 0; i < n; i++) {
                if (dist[i][k] == INF) continue;
                for (int j = 0; j < n; j++) {
                    if (dist[k][j] == INF) continue;
                    // i -> ... -> k -> ... -> j can be arbitrarily small
                    dist[i][j] = Long.MIN_VALUE; // mark as -INF conceptually
                    next[i][j] = -1;
                }
            }
        }
    }

    return new FloydWarshallResult(dist, next);
}

// Reconstruct path from u to v using next-hop matrix
List<Integer> buildPath(int u, int v, int[][] next) {
    List<Integer> path = new ArrayList<>();
    if (u < 0 || v < 0 || u >= next.length || v >= next.length) return path;
    if (next[u][v] == -1) return path; // no path or affected by negative cycle
    path.add(u);
    while (u != v) {
        u = next[u][v];
        if (u == -1) { // safety for negative-cycle-marked pairs
            return new ArrayList<>();
        }
        path.add(u);
    }
    return path;
}
```

### Usage Notes:
- edges is a list of directed edges. For undirected graphs, add both (u,v,w) and (v,u,w).
- Check for negative cycles via any dist[x][x] < 0. If you don’t need propagation, you can stop at detection.
- If you prefer an adjacency matrix input, just initialize dist directly from it and set next[i][j] = j where finite.