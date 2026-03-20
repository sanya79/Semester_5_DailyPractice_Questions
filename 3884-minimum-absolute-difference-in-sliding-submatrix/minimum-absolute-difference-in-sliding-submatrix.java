import java.util.*;

class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][] ans = new int[m - k + 1][n - k + 1];

        for (int i = 0; i <= m - k; i++) {
            // Build first window in this row
            TreeMap<Integer, Integer> map = new TreeMap<>();
            
            for (int r = i; r < i + k; r++) {
                for (int c = 0; c < k; c++) {
                    add(map, grid[r][c]);
                }
            }

            ans[i][0] = getMinDiff(map);

            // Slide right
            for (int j = 1; j <= n - k; j++) {
                // Remove left column
                for (int r = i; r < i + k; r++) {
                    remove(map, grid[r][j - 1]);
                }

                // Add right column
                for (int r = i; r < i + k; r++) {
                    add(map, grid[r][j + k - 1]);
                }

                ans[i][j] = getMinDiff(map);
            }
        }

        return ans;
    }

    private void add(TreeMap<Integer, Integer> map, int val) {
        map.put(val, map.getOrDefault(val, 0) + 1);
    }

    private void remove(TreeMap<Integer, Integer> map, int val) {
        if (map.get(val) == 1) map.remove(val);
        else map.put(val, map.get(val) - 1);
    }

    private int getMinDiff(TreeMap<Integer, Integer> map) {
        int prev = Integer.MIN_VALUE;
        int minDiff = Integer.MAX_VALUE;

        for (int val : map.keySet()) {
            if (prev != Integer.MIN_VALUE) {
                minDiff = Math.min(minDiff, val - prev);
            }
            prev = val;

            // Early exit
            if (minDiff == 0) return 0;
        }

        return minDiff == Integer.MAX_VALUE ? 0 : minDiff;
    }
}