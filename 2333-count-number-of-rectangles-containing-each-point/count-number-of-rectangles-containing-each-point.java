import java.util.*;

class Solution {
    public int[] countRectangles(int[][] rectangles, int[][] points) {
        List<Integer>[] heightBuckets = new ArrayList[101];
        for (int i = 0; i <= 100; i++) {
            heightBuckets[i] = new ArrayList<>();
        }
        for (int[] rect : rectangles) {
            int l = rect[0];
            int h = rect[1];
            heightBuckets[h].add(l);
        }
        for (int h = 1; h <= 100; h++) {
            Collections.sort(heightBuckets[h]);
        }
        int[] result = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            int count = 0;
            for (int h = y; h <= 100; h++) {
                List<Integer> list = heightBuckets[h];
                if (list.isEmpty()) continue;
                int idx = lowerBound(list, x);
                count += (list.size() - idx);
            }
            result[i] = count;
        }
        return result;
    }
    private int lowerBound(List<Integer> list, int target) {
        int low = 0, high = list.size();
        while (low < high) {
            int mid = (low + high) / 2;
            if (list.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
