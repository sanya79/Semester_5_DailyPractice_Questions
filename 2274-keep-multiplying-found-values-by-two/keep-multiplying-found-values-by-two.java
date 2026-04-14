class Solution {
    public int findFinalValue(int[] nm, int o) {
        while (true) {
            int i;
            int n = nm.length;
            for (i = 0; i < n; i++) {
                if (nm[i] == o) {
                    o = o * 2;
                    break;
                }
            }
            if (i == n) {
                return o;
            }
        }
    }
}