import java.util.*;

class Solution {
    public int minLength(int[] nums, int k) {
        int n = nums.length;
        int[] freq = new int[100001]; 
        
        int left = 0;
        long distinctSum = 0;
        int ans = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {
            int val = nums[right];
            if (freq[val] == 0) {
                distinctSum += val;
            }
            freq[val]++;
            while (distinctSum >= k) {
                ans = Math.min(ans, right - left + 1);
                
                int removeVal = nums[left];
                freq[removeVal]--;
                if (freq[removeVal] == 0) {
                    distinctSum -= removeVal;
                }
                left++;
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
