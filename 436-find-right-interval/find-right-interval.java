import java.util.*;
class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] result = new int[n];
        int[][] startWithIndex = new int[n][2];
        for (int i = 0; i < n; i++) {
            startWithIndex[i][0] = intervals[i][0];
            startWithIndex[i][1] = i;
        }
        Arrays.sort(startWithIndex, Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < n; i++) {
            int target = intervals[i][1];
            int idx = binarySearch(startWithIndex, target);
            result[i] = (idx == -1) ? -1 : startWithIndex[idx][1];
        }
        return result;
    }
    private int binarySearch(int[][] starts, int target) {
        int left = 0, right = starts.length - 1;
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (starts[mid][0] >= target) {
                ans = mid;
                right = mid - 1; 
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
