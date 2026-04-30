class Solution {
    public int maxPathScore(int[][] g, int k) {
        int m = g.length, n = g[0].length;
        int inf = -1000000000;
        int[][] p = new int[n][k + 1];
        int[][] c = new int[n][k + 1];
        for (int j = 0; j < n; j++) {
            java.util.Arrays.fill(p[j], inf);
            java.util.Arrays.fill(c[j], inf);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                java.util.Arrays.fill(c[j], inf);
                int v = g[i][j];
                int w = (v == 0) ? 0 : 1;
                if (i == 0 && j == 0) {
                    if (w <= k) c[j][w] = v;
                    continue;
                }
                for (int x = w; x <= k; x++) {
                    int best = inf;
                    if (i > 0 && p[j][x - w] != inf)
                        best = Math.max(best, p[j][x - w] + v);
                    if (j > 0 && c[j - 1][x - w] != inf)
                        best = Math.max(best, c[j - 1][x - w] + v);
                    c[j][x] = best;
                }
            }
            int[][] t = p;
            p = c;
            c = t;
        }
        int ans = -1;
        for (int x = 0; x <= k; x++) ans = Math.max(ans, p[n - 1][x]);
        return ans;
    }
}