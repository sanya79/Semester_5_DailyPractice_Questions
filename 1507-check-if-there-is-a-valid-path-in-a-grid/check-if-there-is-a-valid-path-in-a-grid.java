class Solution {
    static int[][] d = {
        {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };
    static int[][] p = {
        {},
        {2, 3},
        {0, 1},
        {2, 1},
        {3, 1},
        {2, 0},
        {3, 0}
    };
    public boolean hasValidPath(int[][] g) {
        int m = g.length, n = g[0].length;
        boolean[][] v = new boolean[m][n];
        int[] q = new int[m * n];
        int f = 0, r = 0;
        q[r++] = 0;
        v[0][0] = true;
        while (f < r) {
            int x = q[f++], i = x / n, j = x % n;
            if (i == m - 1 && j == n - 1) return true;
            for (int k : p[g[i][j]]) {
                int ni = i + d[k][0], nj = j + d[k][1];
                if (ni < 0 || nj < 0 || ni >= m || nj >= n || v[ni][nj]) continue;
                int o = k ^ 1;
                for (int t : p[g[ni][nj]]) {
                    if (t == o) {
                        v[ni][nj] = true;
                        q[r++] = ni * n + nj;
                        break;
                    }
                }
            }
        }
        return false;
    }
}