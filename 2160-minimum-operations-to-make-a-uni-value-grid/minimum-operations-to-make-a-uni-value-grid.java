import java.util.*;
class Solution {
    public int minOperations(int[][] g, int x) {
        List<Integer> a = new ArrayList<>();
        int r = g[0][0] % x;
        for (int[] i : g) {
            for (int j : i) {
                if (j % x != r) return -1;
                a.add(j);
            }
        }
        Collections.sort(a);
        int m = a.get(a.size() / 2), s = 0;
        for (int v : a) {
            s += Math.abs(v - m) / x;
        }
        return s;
    }
}