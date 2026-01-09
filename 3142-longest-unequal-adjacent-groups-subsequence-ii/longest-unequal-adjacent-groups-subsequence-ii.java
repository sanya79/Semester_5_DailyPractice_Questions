import java.util.*;
class Solution {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        int[] dp = new int[n];
        int[] parent = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1);

        int bestLen = 1;
        int bestEnd = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (groups[i] != groups[j]
                        && words[i].length() == words[j].length()
                        && hamming(words[i], words[j]) == 1) {

                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        parent[i] = j;
                    }
                }
            }

            if (dp[i] > bestLen) {
                bestLen = dp[i];
                bestEnd = i;
            }
        }
        List<String> result = new ArrayList<>();
        int cur = bestEnd;
        while (cur != -1) {
            result.add(words[cur]);
            cur = parent[cur];
        }
        Collections.reverse(result);
        return result;
    }
    private int hamming(String a, String b) {
        int dist = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) dist++;
        }
        return dist;
    }
}
