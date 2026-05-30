import java.util.*;
class Solution {
    static class FenwickMax {
        int n;
        int[] bit;
        FenwickMax(int n) {
            this.n = n;
            bit = new int[n + 2];
        }
        void update(int idx, int val) {
            idx++;
            while (idx <= n + 1) {
                bit[idx] = Math.max(bit[idx], val);
                idx += idx & -idx;
            }
        }
        int query(int idx) {
            idx++;
            int res = 0;
            while (idx > 0) {
                res = Math.max(res, bit[idx]);
                idx -= idx & -idx;
            }
            return res;
        }
    }
    public List<Boolean> getResults(int[][] queries) {
        int MAX = 50000;
        TreeSet<Integer> obstacles = new TreeSet<>();
        obstacles.add(0);
        for (int[] q : queries) {
            if (q[0] == 1) {
                obstacles.add(q[1]);
            }
        }
        FenwickMax bit = new FenwickMax(MAX + 2);
        int prev = 0;
        for (int pos : obstacles) {
            if (pos == 0) continue;
            bit.update(pos, pos - prev);
            prev = pos;
        }
        List<Boolean> reversedAnswers = new ArrayList<>();
        for (int i = queries.length - 1; i >= 0; i--) {
            int[] q = queries[i];
            if (q[0] == 2) {
                int x = q[1];
                int sz = q[2];
                Integer pre = obstacles.floor(x);
                if (pre == null) pre = 0;
                int maxGap = Math.max(bit.query(pre), x - pre);
                reversedAnswers.add(maxGap >= sz);
            } else {
                int x = q[1];
                Integer left = obstacles.lower(x);
                Integer right = obstacles.higher(x);
                if (right != null) {
                    bit.update(right, right - left);
                }
                obstacles.remove(x);
            }
        }
        Collections.reverse(reversedAnswers);
        return reversedAnswers;
    }
}