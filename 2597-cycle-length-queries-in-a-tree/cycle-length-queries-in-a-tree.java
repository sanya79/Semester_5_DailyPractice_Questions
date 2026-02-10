class Solution {
    public int[] cycleLengthQueries(int n, int[][] queries) {
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int p = queries[i][0];
            int q = queries[i][1];
            int steps = 0;
            while (p != q) {
                if (p > q) {
                    p /= 2;
                } else {
                    q /= 2;
                }
                steps++;
            }
            res[i] = steps + 1;
        }
        return res;
    }
}
