class Solution {
    public int maximumAmount(int[][] coins) {
        int m = coins.length, n = coins[0].length;
        int[][] prev = new int[n][3];
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < 3; k++) {
                prev[j][k] = Integer.MIN_VALUE;
            }
        }
        if (coins[0][0] >= 0) {
            for (int k = 0; k < 3; k++) {
                prev[0][k] = coins[0][0];
            }
        } else {
            prev[0][0] = coins[0][0];
            prev[0][1] = 0;
            prev[0][2] = 0;
        }
        for (int j = 1; j < n; j++) {
            for (int k = 0; k < 3; k++) {
                prev[j][k] = Integer.MIN_VALUE;
                if (prev[j - 1][k] != Integer.MIN_VALUE) {
                    prev[j][k] = Math.max(prev[j][k], prev[j - 1][k] + coins[0][j]);
                }
                if (coins[0][j] < 0 && k > 0 && prev[j - 1][k - 1] != Integer.MIN_VALUE) {
                    prev[j][k] = Math.max(prev[j][k], prev[j - 1][k - 1]);
                }
            }
        }
        for (int i = 1; i < m; i++) {
            int[][] curr = new int[n][3];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 3; k++) {
                    curr[j][k] = Integer.MIN_VALUE;
                    if (prev[j][k] != Integer.MIN_VALUE) {
                        curr[j][k] = Math.max(curr[j][k], prev[j][k] + coins[i][j]);
                    }
                    if (coins[i][j] < 0 && k > 0 && prev[j][k - 1] != Integer.MIN_VALUE) {
                        curr[j][k] = Math.max(curr[j][k], prev[j][k - 1]);
                    }
                    if (j > 0) {
                        if (curr[j - 1][k] != Integer.MIN_VALUE) {
                            curr[j][k] = Math.max(curr[j][k], curr[j - 1][k] + coins[i][j]);
                        }
                        if (coins[i][j] < 0 && k > 0 && curr[j - 1][k - 1] != Integer.MIN_VALUE) {
                            curr[j][k] = Math.max(curr[j][k], curr[j - 1][k - 1]);
                        }
                    }
                }
            }
            prev = curr;
        }
        int res = Integer.MIN_VALUE;
        for (int k = 0; k < 3; k++) {
            res = Math.max(res, prev[n - 1][k]);
        }
        return res;
    }
}