class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        int i = 0;
        while (i + 1 < n && nums[i] < nums[i + 1]) i++;
        int p = i;
        while (i + 1 < n && nums[i] > nums[i + 1]) i++;
        int q = i;
        while (i + 1 < n && nums[i] < nums[i + 1]) i++;
        return i == n - 1 && p > 0 && q > p && q < n - 1;
    }
}