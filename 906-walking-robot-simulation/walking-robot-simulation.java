import java.util.*;
class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        int d = 0;
        int x = 0, y = 0;
        int maxDist = 0;
        Set<Long> set = new HashSet<>();
        for (int[] o : obstacles) {
            long key = ((long)o[0] << 32) | (o[1] & 0xffffffffL);
            set.add(key);
        }
        for (int cmd : commands) {
            if (cmd == -1) {
                d = (d + 1) % 4; 
            } else if (cmd == -2) {
                d = (d + 3) % 4; 
            } else {
                for (int i = 0; i < cmd; i++) {
                    int nx = x + dirs[d][0];
                    int ny = y + dirs[d][1];
                    long key = ((long)nx << 32) | (ny & 0xffffffffL);
                    if (set.contains(key)) {
                        break; 
                    }
                    x = nx;
                    y = ny;
                    
                    maxDist = Math.max(maxDist, x * x + y * y);
                }
            }
        }
        return maxDist;
    }
}