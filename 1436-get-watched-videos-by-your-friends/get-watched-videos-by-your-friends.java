import java.util.*;

class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos,int[][] friends,int id, int level) {

        int n = friends.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(id);
        visited[id] = true;
        int currLevel = 0;
        while (!queue.isEmpty() && currLevel < level) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int person = queue.poll();
                for (int f : friends[person]) {
                    if (!visited[f]) {
                        visited[f] = true;
                        queue.offer(f);
                    }
                }
            }
            currLevel++;
        }
        Map<String, Integer> freq = new HashMap<>();
        while (!queue.isEmpty()) {
            int person = queue.poll();
            for (String video : watchedVideos.get(person)) {
                freq.put(video, freq.getOrDefault(video, 0) + 1);
            }
        }
        List<String> result = new ArrayList<>(freq.keySet());
        result.sort((a, b) -> {
            if (!freq.get(a).equals(freq.get(b)))
                return freq.get(a) - freq.get(b);
            return a.compareTo(b);
        });

        return result;
    }
}
