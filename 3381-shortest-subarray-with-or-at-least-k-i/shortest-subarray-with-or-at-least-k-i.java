class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {

        int n = nums.length;
        int s = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {

            int currOR = 0;
            for (int j = i; j < n; j++) {

                currOR = currOR | nums[j];
                if (currOR >= k) {
                    int length = j - i + 1;
                    s = Math.min(s, length);
                    break; 
                }
            }
        }
        if (s == Integer.MAX_VALUE) {
            return -1;
        }
        return s;
    }
}
