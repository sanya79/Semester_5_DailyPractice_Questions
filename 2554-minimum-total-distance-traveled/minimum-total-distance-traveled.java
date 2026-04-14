import java.util.*;
class Solution {
    public long minimumTotalDistance(List<Integer> r, int[][] fa) {
        Collections.sort(r);
        Arrays.sort(fa, Comparator.comparingInt(a -> a[0]));
        int n = r.size();
        int m = fa.length;
        long[][] dp = new long[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Long.MAX_VALUE / 2);
        }
        dp[0][0] = 0;
        for (int j = 1; j <= m; j++) {
            int pos = fa[j - 1][0];
            int limit = fa[j - 1][1];
            for (int i = 0; i <= n; i++) {
                dp[i][j] = dp[i][j - 1];
                long cost = 0;
                for (int k = 1; k <= Math.min(limit, i); k++) {
                    cost += Math.abs(r.get(i - k) - pos);
                    dp[i][j] = Math.min(
                        dp[i][j],
                        dp[i - k][j - 1] + cost
                    );
                }
            }
        }
        return dp[n][m];
    }
}