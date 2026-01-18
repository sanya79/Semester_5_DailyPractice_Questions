import java.util.*;

class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;

        Map<Integer, Integer> evenMap = new HashMap<>();
        Map<Integer, Integer> oddMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                evenMap.put(nums[i], evenMap.getOrDefault(nums[i], 0) + 1);
            } else {
                oddMap.put(nums[i], oddMap.getOrDefault(nums[i], 0) + 1);
            }
        }
        int[][] evenTop = getTopTwo(evenMap);
        int[][] oddTop = getTopTwo(oddMap);
        if (evenTop[0][0] != oddTop[0][0]) {
            return n - (evenTop[0][1] + oddTop[0][1]);
        }
        int option1 = n - (evenTop[0][1] + oddTop[1][1]);
        int option2 = n - (evenTop[1][1] + oddTop[0][1]);

        return Math.min(option1, option2);
    }
    private int[][] getTopTwo(Map<Integer, Integer> map) {
        int[][] res = new int[][]{{-1, 0}, {-1, 0}};

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() > res[0][1]) {
                res[1] = res[0];
                res[0] = new int[]{e.getKey(), e.getValue()};
            } else if (e.getValue() > res[1][1]) {
                res[1] = new int[]{e.getKey(), e.getValue()};
            }
        }
        return res;
    }
}
