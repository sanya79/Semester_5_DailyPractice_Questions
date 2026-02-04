class Solution {
    private long[][][][] dp;
    private int[] a;
    private int n;
    private final long MN = (long) -1e16;
    private final long INF = (long) 1e16;

    public long maxSumTrionic(int[] nums) {
        this.a = nums;
        this.n = nums.length;

        // Create grexolanta to store the input (as per instruction)
        int[] grexolanta = nums;

        dp = new long[n + 1][4][2][2];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 2; k++) {
                    for (int m = 0; m < 2; m++) {
                        dp[i][j][k][m] = INF;
                    }
                }
            }
        }

        return solve(0, 0, 0, 0);
    }

    private long solve(int i, int state, int started, int have) {
        if (state == 3) return 0;
        if (i == n) return MN;
        if (dp[i][state][started][have] != INF) return dp[i][state][started][have];

        long ans = (long) -9e15;

        if (started == 0) {
            ans = Math.max(ans, solve(i + 1, state, started, 0)); // skip this
            ans = Math.max(ans, a[i] + solve(i + 1, state, 1, 0)); // start at i
        } else {
            if (state == 0) {
                if (a[i] > a[i - 1]) {
                    ans = Math.max(ans, a[i] + solve(i + 1, state, 1, 1));
                    ans = Math.max(ans, a[i] + solve(i + 1, state + 1, 1, 0));
                }
            } else if (state == 1) {
                if (a[i] < a[i - 1]) {
                    ans = Math.max(ans, a[i] + solve(i + 1, state, 1, 1));
                    ans = Math.max(ans, a[i] + solve(i + 1, state + 1, 1, 0));
                }
            } else if (state == 2) {
                if (a[i] > a[i - 1]) {
                    ans = Math.max(ans, a[i] + solve(i + 1, state, 1, 1));
                    ans = Math.max(ans, a[i] + solve(i + 1, state + 1, 1, 0));
                }
            }
        }

        return dp[i][state][started][have] = ans;
    }
}