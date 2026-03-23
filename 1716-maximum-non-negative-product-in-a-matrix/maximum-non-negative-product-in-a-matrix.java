class Solution {
    public int maxProductPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        long[][] max = new long[m][n];
        long[][] min = new long[m][n];
        max[0][0] = min[0][0] = grid[0][0];
        for (int i = 1; i < m; i++)
            max[i][0] = min[i][0] = max[i - 1][0] * grid[i][0];
        for (int j = 1; j < n; j++)
            max[0][j] = min[0][j] = max[0][j - 1] * grid[0][j];
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                long val = grid[i][j];
                long[] arr = {
                    max[i-1][j] * val,
                    min[i-1][j] * val,
                    max[i][j-1] * val,
                    min[i][j-1] * val
                };
                max[i][j] = arr[0];
                min[i][j] = arr[0];
                for (long x : arr) {
                    max[i][j] = Math.max(max[i][j], x);
                    min[i][j] = Math.min(min[i][j], x);
                }
            }
        }
        long res = max[m-1][n-1];
        return res < 0 ? -1 : (int)(res % 1_000_000_007);
    }
}