class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> (b[1] - b[0]) - (a[1] - a[0]));
        int c = 0;
        int an  = 0;
        for (int[] task : tasks) {
            int act  = task[0];
            int m = task[1];
            if (c < m) {
                an  += (m - c);
                c  = m;
            }
            c -= act;
        }
        return an;
    }
}