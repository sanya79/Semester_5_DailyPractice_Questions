class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] trustS = new int[n + 1];
        for (int[] relation : trust) {
            int a = relation[0];
            int b = relation[1];
            trustS[a]--; 
            trustS[b]++; 
        }
        for (int person = 1; person <= n; person++) {
            if (trustS[person] == n - 1) {
                return person; 
            }
        }
        return -1; 
    }
}
