class Solution {
    static final long MOD = 1_000_000_007;
    public static int monkeyMove(int n) {
        long totalWays = modPow(2, n, MOD);
        long noCollision = 2;
        long result = (totalWays - noCollision + MOD) % MOD;
        return (int) result;
    }

    private static long modPow(long base, long exp, long mod) {
        long result = 1;
        base %= mod;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }
}
