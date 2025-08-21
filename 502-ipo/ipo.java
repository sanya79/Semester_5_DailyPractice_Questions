import java.util.PriorityQueue;
import java.util.Arrays;

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int[][] arr = new int[profits.length][2];
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = capital[i];
            arr[i][1] = profits[i];
        }
        return IPO(arr, k, w);
    }

    public static int IPO(int[][] arr, int k, int w) {
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        for (int i = 0; i < arr.length || !pq.isEmpty();) {
            while (i < arr.length && w >= arr[i][0]) {
                pq.add(arr[i]);
                i++;
            }
            if (pq.isEmpty() || k == 0) return w;
            w += pq.poll()[1];
            k--;
        }
        return w;
    }
}
