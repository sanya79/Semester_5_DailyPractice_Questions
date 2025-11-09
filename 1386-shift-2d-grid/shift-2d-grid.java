import java.util.*;
public class Solution {
    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int total = m * n;
        k = k % total; 
        List<List<Integer>> result = new ArrayList<>();
        int[] flat = new int[total];
        int idx = 0;
        for (int[] row : grid) {
            for (int val : row) {
                flat[idx++] = val;
            }
        }
        int[] shifted = new int[total];
        for (int i = 0; i < total; i++) {
            shifted[(i + k) % total] = flat[i];
        }
        idx = 0;
        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(shifted[idx++]);
            }
            result.add(row);
        }
        return result;
    }
}
