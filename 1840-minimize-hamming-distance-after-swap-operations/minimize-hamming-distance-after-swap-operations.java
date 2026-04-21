import java.util.*;
class Solution {
    public int minimumHammingDistance(int[] s, int[] t, int[][] a) {
        int n = s.length;
        UF u = new UF(n);
        for (int[] e : a) u.u(e[0], e[1]);
        Map<Integer, Map<Integer, Integer>> m = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int r = u.f(i);
            m.putIfAbsent(r, new HashMap<>());
            Map<Integer, Integer> c = m.get(r);
            c.put(s[i], c.getOrDefault(s[i], 0) + 1);
        }
        int d = 0;
        for (int i = 0; i < n; i++) {
            int r = u.f(i);
            Map<Integer, Integer> c = m.get(r);

            if (c.getOrDefault(t[i], 0) > 0) {
                c.put(t[i], c.get(t[i]) - 1);
            } else {
                d++;
            }
        }

        return d;
    }

    class UF {
        int[] p, r;

        UF(int n) {
            p = new int[n];
            r = new int[n];
            for (int i = 0; i < n; i++) p[i] = i;
        }
        int f(int x) {
            if (p[x] != x) p[x] = f(p[x]);
            return p[x];
        }
        void u(int x, int y) {
            int px = f(x), py = f(y);
            if (px == py) return;

            if (r[px] < r[py]) p[px] = py;
            else if (r[px] > r[py]) p[py] = px;
            else {
                p[py] = px;
                r[px]++;
            }
        }
    }
}