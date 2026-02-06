class Solution {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int j = 0;
        int maxWindow = 1;

        for (int i = 0; i < n; i++) {
            while ((long) nums[i] > (long) nums[j] * k) {
                j++;
            }
            maxWindow = Math.max(maxWindow, i - j + 1);
        }
        return n - maxWindow;
    }
}

