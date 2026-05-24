import java.util.*;
public class Solution {
    private int[] dp;
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        dp = new int[n];
        Arrays.fill(dp, -1);
        int ans = 1;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dfs(arr, d, i));
        }
        return ans;
    }
    private int dfs(int[] arr, int d, int i) {
        if (dp[i] != -1) return dp[i];
        int res = 1;
        for (int j = i + 1; j <= i + d && j < arr.length; j++) {
            if (arr[j] >= arr[i]) break;
            res = Math.max(res, 1 + dfs(arr, d, j));
        }
        for (int j = i - 1; j >= i - d && j >= 0; j--) {
            if (arr[j] >= arr[i]) break;
            res = Math.max(res, 1 + dfs(arr, d, j));
        }
        return dp[i] = res;
    }
}
