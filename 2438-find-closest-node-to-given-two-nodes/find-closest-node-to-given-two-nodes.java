class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];
        for (int i = 0; i < n; i++) {
            dist1[i] = -1;
            dist2[i] = -1;
        }

        traverse(edges, node1, dist1);
        traverse(edges, node2, dist2);
        int answer = -1;
        int minMaxDist = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (dist1[i] != -1 && dist2[i] != -1) {

                int maxDist = Math.max(dist1[i], dist2[i]);

                if (maxDist < minMaxDist) {
                    minMaxDist = maxDist;
                    answer = i;
                }
            }
        }

        return answer;
    }
    private void traverse(int[] edges, int start, int[] dist) {

        int current = start;
        int distance = 0;

        while (current != -1 && dist[current] == -1) {
            dist[current] = distance;
            distance++;
            current = edges[current];
        }
    }
}
