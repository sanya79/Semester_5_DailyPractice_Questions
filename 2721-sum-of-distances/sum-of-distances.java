import java.util.*;
class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] res = new long[n]; 
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        for (List<Integer> in : map.values()) {
            int m = in.size();
            long[] p = new long[m + 1];
            for (int i = 0; i < m; i++) {
                p[i + 1] = p[i] + in.get(i);
            }
            for (int i = 0; i < m; i++) {
                int idx = in.get(i);
                long l = (long) i * idx - p[i];
                long r = (p[m] - p[i + 1]) - (long)(m - i - 1) * idx;
                res[idx] = l + r;
            }
        }   
        return res;
    }
}