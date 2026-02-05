class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int[] freq = new int[101];
        for (int i = 0; i < k; i++) {
            freq[nums[i] + 50]++;
        }
        result[0] = getBeauty(freq, x);
        for (int i = k; i < n; i++) {
            freq[nums[i] + 50]++;           
            freq[nums[i - k] + 50]--;       
            result[i - k + 1] = getBeauty(freq, x);
        }
        return result;
    }
    private int getBeauty(int[] freq, int x) {
        int count = 0;
        for (int v = -50; v < 0; v++) {
            count += freq[v + 50];
            if (count >= x) {
                return v;
            }
        }
        return 0;
    }
}
