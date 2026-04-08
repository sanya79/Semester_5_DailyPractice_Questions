class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int MOD = 1_000_000_007;
        for (int[] q : queries) {
            int li = q[0];
            int ri = q[1];
            int ki = q[2];
            int vi = q[3];
            for (int idx = li; idx <= ri; idx += ki) {
                long val = nums[idx];
                val = (val * vi) % MOD;
                nums[idx] = (int) val;
            }
        }
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        return xor;
    }
}