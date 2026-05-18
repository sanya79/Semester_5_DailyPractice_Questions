import java.util.*;
class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if (n == 1) return 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];
        q.offer(0);
        vis[0] = true;
        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int i = q.poll();
                if (i == n - 1) return steps;
                if (i + 1 < n && !vis[i + 1]) {
                    vis[i + 1] = true;
                    q.offer(i + 1);
                }
                if (i - 1 >= 0 && !vis[i - 1]) {
                    vis[i - 1] = true;
                    q.offer(i - 1);
                }
                if (map.containsKey(arr[i])) {
                    for (int j : map.get(arr[i])) {
                        if (!vis[j]) {
                            vis[j] = true;
                            q.offer(j);
                        }
                    }
                    map.remove(arr[i]); 
                }
            }
            steps++;
        }
        return -1;
    }
}
