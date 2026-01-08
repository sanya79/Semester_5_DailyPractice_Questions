class Solution {
    public int countHousePlacements(int n) {
        final long MOD = 1_000_000_007;

        long prev2 = 1; 
        long prev1 = 2;

        for (int i = 2; i <= n; i++) {
            long curr = (prev1 + prev2) % MOD;
            prev2 = prev1;
            prev1 = curr;
        }

        long oneSide = prev1;
        return (int)((oneSide * oneSide) % MOD);
    }
}
