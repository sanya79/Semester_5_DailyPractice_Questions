import java.util.*;

class Solution {
    public long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);

        long sum = 0;
        long curr = 1;   // smallest missing positive
        int i = 0;

        while (i < nums.length && k > 0) {
            if (nums[i] < curr) {
                i++;
                continue;
            }

            if (nums[i] == curr) {
                curr++;
                i++;
                continue;
            }

            // nums[i] > curr → gap exists
            long count = Math.min(k, nums[i] - curr);
            sum += (curr + (curr + count - 1)) * count / 2;

            k -= count;
            curr += count;
        }

        // still need to add more numbers
        if (k > 0) {
            sum += (curr + (curr + k - 1)) * k / 2;
        }

        return sum;
    }
}
