class Solution {
    public long maxStrength(int[] nums) {
        int n = nums.length;
        long max = Long.MIN_VALUE;
        for (int mask = 1; mask < (1 << n); mask++) {
            long product = 1;
            boolean used = false;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    product *= nums[i];
                    used = true;
                }
            }

            if (used) {
                max = Math.max(max, product);
            }
        }

        return max;
    }
}
