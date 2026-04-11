import java.util.*;
class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        int minD = Integer.MAX_VALUE;
        for (List<Integer> indices : map.values()) {
            if (indices.size() < 3) continue;
            for (int i = 0; i <= indices.size() - 3; i++) {
                int l = indices.get(i);
                int r = indices.get(i + 2);
                int d = 2 * (r - l);
                minD = Math.min(minD, d);
            }
        }
        return minD == Integer.MAX_VALUE ? -1 : minD;
    }
}