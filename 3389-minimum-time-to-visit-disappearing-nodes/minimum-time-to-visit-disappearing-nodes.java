import java.util.*;

class Solution {
    static class Edge {
        int to;
        int w;
        Edge(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }

    static class State {
        int node;
        long time;
        State(int node, long time) {
            this.node = node;
            this.time = time;
        }
    }

    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        List<Edge>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for (int[] e : edges) {
            graph[e[0]].add(new Edge(e[1], e[2]));
            graph[e[1]].add(new Edge(e[0], e[2]));
        }

        long INF = Long.MAX_VALUE / 2;
        long[] dist = new long[n];
        Arrays.fill(dist, INF);
        PriorityQueue<State> pq = new PriorityQueue<>(
                (a, b) -> Long.compare(a.time, b.time)
        );
        if (disappear[0] <= 0) return new int[n];
        dist[0] = 0;
        pq.offer(new State(0, 0));

        while (!pq.isEmpty()) {
            State cur = pq.poll();
            int u = cur.node;
            long t = cur.time;

            if (t != dist[u]) continue;

            for (Edge e : graph[u]) {
                int v = e.to;
                long newTime = t + e.w;
                if (newTime < disappear[v] && newTime < dist[v]) {
                    dist[v] = newTime;
                    pq.offer(new State(v, newTime));
                }
            }
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = (dist[i] == INF) ? -1 : (int) dist[i];
        }

        return ans;
    }
}
