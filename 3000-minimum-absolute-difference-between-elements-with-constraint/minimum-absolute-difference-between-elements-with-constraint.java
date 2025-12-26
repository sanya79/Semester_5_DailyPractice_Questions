import java.util.*;
class Solution {
    public int minAbsoluteDifference(List<Integer> nums, int x) {

        if (x == 0) return 0;

        List<Integer> s = new ArrayList<>();
        int ans = Integer.MAX_VALUE;

        for (int i = x; i < nums.size(); i++) {
            int v = nums.get(i - x);
            int p = Collections.binarySearch(s, v);
            if (p < 0) p = -p - 1;
            s.add(p, v);

            int c = nums.get(i);
            p = Collections.binarySearch(s, c);
            if (p < 0) p = -p - 1;
            if (p > 0) ans = Math.min(ans, c - s.get(p - 1));
            if (p < s.size()) ans = Math.min(ans, s.get(p) - c);
        }
        return ans;
    }
}
