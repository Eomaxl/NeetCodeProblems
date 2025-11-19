# Solution:

Scenario: Given a graph with weighted edges, you're tasked with finding the shortest path between two nodes.

Clue: Look for problems where you need to optimize distance or traversal time between two points.

## Dijkstra Algorithm:
Step-by-step (single-source shortest paths)

When to use: Weighted graph with non-negative edge weights.

Inputs
n: number of vertices labeled 0..n-1
adj: adjacency list, where each adj[u] has edges (v, w) (to, weight)
src: source vertex

Outputs
dist[v]: shortest distance from src to v (∞ if unreachable)
parent[v]: predecessor of v on a shortest path (or -1/null if none)

#### Process

1. Initialize
- Set all dist[v] = +∞, parent[v] = -1.
- Set dist[src] = 0.
- Push (0, src) into a min-priority queue keyed by distance.

2. Main loop
- While the priority queue isn’t empty:
  - Pop (d, u) with the smallest d. 
  - Lazy skip: if d > dist[u], continue (an outdated entry). 
  - For each edge (u → v, weight w):
    - If dist[u] + w < dist[v]:
      - Update dist[v] = dist[u] + w.
      - Set parent[v] = u.
      - Push (dist[v], v) into the queue.

3. (Optional) Early stop
- If you only need the distance to a specific target, you can stop once u == target is popped (because that’s the final shortest distance).

4. Path reconstruction (optional)
- To get the actual path to some t: follow parent[t] backwards until -1, then reverse the list.

#### Complexity
- Using an adjacency list + binary heap PQ: O((V + E) log V) time, O(V) space for dist/parent plus O(V) PQ entries (amortized).

#### Gotchas
- Negative weights are not allowed (use Bellman-Ford or Johnson if needed).
- Use long for distances if sums can overflow int.
- Zero-weight edges are fine.

### Java pseudocode
```
// Edge representation
class Edge {
    int to;
    int w; // weight (>= 0)
    Edge(int to, int w) { this.to = to; this.w = w; }
}

// Node for PQ
class Node {
    int v;
    long dist; // use long to avoid overflow
    Node(int v, long dist) { this.v = v; this.dist = dist; }
}

Pair<long[], int[]> dijkstra(int n, List<List<Edge>> adj, int src) {
    long[] dist = new long[n];
    int[] parent = new int[n];

    
    Arrays.fill(dist, Long.MAX_VALUE);
    Arrays.fill(parent, -1);
    dist[src] = 0;

    PriorityQueue<Node> pq = new PriorityQueue<>(
        (a, b) -> Long.compare(a.dist, b.dist)
    );
    pq.add(new Node(src, 0));

    while (!pq.isEmpty()) {
        Node cur = pq.poll();
        int u = cur.v;
        long d = cur.dist;

        // skip stale entries
        if (d != dist[u]) continue;

        // relax edges
        for (Edge e : adj.get(u)) {
            int v = e.to;
            long nd = d + e.w;
            if (nd < dist[v]) {
                dist[v] = nd;
                parent[v] = u;
                pq.add(new Node(v, nd));
            }
        }
    }
    return new Pair<>(dist, parent);
    }

    // Optional: reconstruct path from src to target
    List<Integer> buildPath(int target, int[] parent) {
    List<Integer> path = new ArrayList<>();
    for (int v = target; v != -1; v = parent[v]) path.add(v);
    Collections.reverse(path);
    // if you want to detect "unreachable", check if path.get(0) is the src externally
    return path;
}

```

