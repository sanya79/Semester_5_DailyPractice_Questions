class Solution {
    public int maximizeWin(int[] prizePositions, int k) {
        int n = prizePositions.length;
        int[] count = new int[n];
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j < n && prizePositions[j] - prizePositions[i] <= k) {
                j++;
            }
            count[i] = j - i; 
        }
        int[] suffixMax = new int[n + 1];
        suffixMax[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            suffixMax[i] = Math.max(count[i], suffixMax[i + 1]);
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            int nextIndex = i + count[i];
            answer = Math.max(answer, count[i] + suffixMax[nextIndex]);
        }

        return answer;
    }
}
