class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int maxDiff = 0;

        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            maxDiff = Math.max(maxDiff, diff[i]);
        }

        long[] freq = new long[maxDiff + 1];
        for (int d : diff) freq[d]++;

        long k = (long) k1 + k2;

        for (int d = maxDiff; d > 0 && k > 0; d--) {
            if (freq[d] == 0) continue;

            long move = Math.min(k, freq[d]);
            freq[d] -= move;
            freq[d - 1] += move;
            k -= move;
        }

        long ans = 0;
        for (int d = 0; d <= maxDiff; d++) {
            ans += freq[d] * d * d;
        }
        return ans;
    }
}