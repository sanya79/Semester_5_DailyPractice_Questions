import java.util.*;

class Solution {
    public int maximumLength(String s) {
        int n = s.length();
        List<Integer>[] blocks = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            blocks[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; ) {
            int j = i;
            while (j < n && s.charAt(j) == s.charAt(i)) j++;
            blocks[s.charAt(i) - 'a'].add(j - i);
            i = j;
        }

        int ans = -1;
        for (int c = 0; c < 26; c++) {
            if (blocks[c].isEmpty()) continue;

            Collections.sort(blocks[c], Collections.reverseOrder());

            int a = blocks[c].get(0);
            int b = blocks[c].size() > 1 ? blocks[c].get(1) : 0;
            int d = blocks[c].size() > 2 ? blocks[c].get(2) : 0;
            ans = Math.max(ans, a - 2);
            ans = Math.max(ans, Math.min(a - 1, b));
            ans = Math.max(ans, d);
        }
        return ans <= 0 ? -1 : ans;
    }
}
