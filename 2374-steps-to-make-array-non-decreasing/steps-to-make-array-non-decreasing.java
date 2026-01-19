import java.util.*;
class Solution {
    public int totalSteps(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n]; 
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            int maxSteps = 0;
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                maxSteps = Math.max(maxSteps + 1, dp[stack.peek()]);
                stack.pop();
            }

            dp[i] = maxSteps;
            ans = Math.max(ans, dp[i]);
            stack.push(i);
        }

        return ans;
    }
}
