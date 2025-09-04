class Solution {
    public int change(int amount, int[] coin) {
        int[][] dp = new int[coin.length + 1][amount + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1; 
        }
        for (int i = 1; i < dp.length; i++) {
            for (int am = 1; am < dp[0].length; am++) {
                int inc = 0, exc = 0;
                if (am >= coin[i - 1]) {
                    inc = dp[i][am - coin[i - 1]]; 
                }
                exc = dp[i - 1][am]; 
                dp[i][am] = inc + exc;
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
    public static int Coin_Change(int[] coin, int amount, int i, int[][] dp) {
        if (amount == 0) {
            return 1;
        }
        if (i == coin.length) {
            return 0;
        }
        if (dp[amount][i] != -1) {
            return dp[amount][i];
        }
        int inc = 0, exc = 0;
        if (amount >= coin[i]) {
            inc = Coin_Change(coin, amount - coin[i], i, dp); 
        }
        exc = Coin_Change(coin, amount, i + 1, dp);
        return dp[amount][i] = inc + exc;
        
    }
}