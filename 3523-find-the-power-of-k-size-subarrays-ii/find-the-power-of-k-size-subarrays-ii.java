class Solution {
    public int[] resultsArray(int[] nums, int k) {

        int n = nums.length;
        int[] result = new int[n - k + 1];
        int cc = 1; 

        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                cc++;
            } else {
                cc = 1;
            }
            if (i >= k - 1) {
                if (cc >= k) {
                    result[i - k + 1] = nums[i];
                } else {
                    result[i - k + 1] = -1;
                }
            }
        }
        if (k == 1) {
            for (int i = 0; i < n; i++) {
                result[i] = nums[i];
            }
        }
        return result;
    }
}

