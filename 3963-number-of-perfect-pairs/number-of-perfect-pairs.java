class Solution {
    public long perfectPairs(int[] nums) {
        int n = nums.length;
        long[] a = new long[n];
        for (int i = 0; i < n; i++) a[i] = Math.abs((long) nums[i]);
        Arrays.sort(a);

        long ans = 0;
        int r = 0;
        for (int l = 0; l < n; l++) {
            while (r < n && a[r] <= 2 * a[l]) r++;
            ans += Math.max(0, r - l - 1);
        }
        return ans;
    }
}
