import java.util.*;
class Solution {
    public int maximumJumps(int[] a, int t) {
        int n = a.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == -1) continue;
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(a[j] - a[i]) <= t) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
        }
        return dp[n - 1];
    }
}
