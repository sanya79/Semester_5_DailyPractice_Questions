import java.util.*;

class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> evenMap = new HashMap<>();
            Map<Integer, Integer> oddMap = new HashMap<>();
            int distinctEven = 0;
            int distinctOdd = 0;

            for (int j = i; j < n; j++) {
                int val = nums[j];

                if (val % 2 == 0) {
                    evenMap.put(val, evenMap.getOrDefault(val, 0) + 1);
                    if (evenMap.get(val) == 1) {
                        distinctEven++;
                    }
                } else {
                    oddMap.put(val, oddMap.getOrDefault(val, 0) + 1);
                    if (oddMap.get(val) == 1) {
                        distinctOdd++;
                    }
                }

                if (distinctEven == distinctOdd) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }
}
