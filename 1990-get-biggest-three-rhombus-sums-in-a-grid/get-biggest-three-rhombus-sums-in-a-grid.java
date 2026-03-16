import java.util.*;
class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                set.add(grid[i][j]); 
                for (int k = 1; i-k>=0 && i+k<m && j-k>=0 && j+k<n; k++) {
                    int sum = 0;
                    for (int t = 0; t < k; t++) {
                        sum += grid[i-k+t][j+t];    
                        sum += grid[i+t][j+k-t];     
                        sum += grid[i+k-t][j-t];   
                        sum += grid[i-t][j-k+t];     
                    }
                    set.add(sum);
                }
            }
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list, Collections.reverseOrder());
        int size = Math.min(3, list.size());
        int[] res = new int[size];
        for (int i = 0; i < size; i++) res[i] = list.get(i);
        return res;
    }
}