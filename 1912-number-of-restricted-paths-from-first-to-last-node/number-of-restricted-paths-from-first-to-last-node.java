import java.util.*;

class Solution {
    static final int MOD = 1_000_000_007;
    List<int[]>[] graph;
    long[] dist;
    Integer[] dp;

    public int countRestrictedPaths(int n, int[][] edges) {
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();

        for (int[] e : edges) {
            graph[e[0]].add(new int[]{e[1], e[2]});
            graph[e[1]].add(new int[]{e[0], e[2]});
        }
        dist = new long[n + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dijkstra(n);
        dp = new Integer[n + 1];
        return dfs(1, n);
    }
    private void dijkstra(int n) {
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.offer(new long[]{0, n});
        dist[n] = 0;

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long d = cur[0];
            int u = (int) cur[1];

            if (d > dist[u]) continue;

            for (int[] nei : graph[u]) {
                int v = nei[0];
                int w = nei[1];
                if (dist[v] > d + w) {
                    dist[v] = d + w;
                    pq.offer(new long[]{dist[v], v});
                }
            }
        }
    }
    private int dfs(int u, int n) {
        if (u == n) return 1;
        if (dp[u] != null) return dp[u];

        int ways = 0;
        for (int[] nei : graph[u]) {
            int v = nei[0];
            if (dist[u] > dist[v]) {
                ways = (ways + dfs(v, n)) % MOD;
            }
        }

        return dp[u] = ways;
    }
}
