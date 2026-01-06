import java.util.*;
class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        Set<Integer> forbiddenSet = new HashSet<>();
        for (int f : forbidden) {
            forbiddenSet.add(f);
        }
        boolean[][] visited = new boolean[6001][2];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        int jumps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int pos = curr[0];
                int back = curr[1];

                if (pos == x) {
                    return jumps;
                }
                int forward = pos + a;
                if (forward <= 6000 &&
                    !forbiddenSet.contains(forward) &&
                    !visited[forward][0]) {

                    visited[forward][0] = true;
                    queue.offer(new int[]{forward, 0});
                }
                int backward = pos - b;
                if (back == 0 &&
                    backward >= 0 &&
                    !forbiddenSet.contains(backward) &&
                    !visited[backward][1]) {

                    visited[backward][1] = true;
                    queue.offer(new int[]{backward, 1});
                }
            }
            jumps++;
        }

        return -1;
    }
}
