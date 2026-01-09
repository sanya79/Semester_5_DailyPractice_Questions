class Solution {
    public int maximumLength(int[] nums, int k) {
        int ans = 1;

        for (int r = 0; r < k; r++) {
            int[] dp = new int[k];

            for (int num : nums) {
                int cur = num % k;
                int prev = (r - cur + k) % k;
                dp[cur] = Math.max(dp[cur], dp[prev] + 1);
                ans = Math.max(ans, dp[cur]);
            }
        }

        return ans;
    }
}
