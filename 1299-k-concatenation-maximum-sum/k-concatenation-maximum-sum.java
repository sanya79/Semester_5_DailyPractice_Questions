class Solution {
    public int kConcatenationMaxSum(int[] arr, int k) {
        final int MOD = 1_000_000_007;
        long totalSum = 0;
        long maxPrefix = 0;
        long maxSuffix = 0;
        long maxSub = 0;
        long curr = 0;
        for (int num : arr) {
            totalSum += num;
            
            curr = Math.max(curr + num, num);
            maxSub = Math.max(maxSub, curr);
            
            maxPrefix = Math.max(maxPrefix, totalSum);
        }
        curr = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            curr += arr[i];
            maxSuffix = Math.max(maxSuffix, curr);
        }
        long result;
        if (k == 1) {
            result = maxSub;
        } else if (totalSum > 0) {
            result = maxSuffix + maxPrefix + (k - 2) * totalSum;
            result = Math.max(result, maxSub);
        } else {
            result = Math.max(maxSub, maxSuffix + maxPrefix);
        }
        
        return (int)(result % MOD);
    }
}
