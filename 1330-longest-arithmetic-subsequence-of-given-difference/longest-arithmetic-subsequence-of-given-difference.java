import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> dp = new HashMap<>();
        int maxLen = 1;

        for (int x : arr) {
            int prev = dp.getOrDefault(x - difference, 0);
            int curr = prev + 1;
            dp.put(x, curr);
            maxLen = Math.max(maxLen, curr);
        }

        return maxLen;
    }
}
