import java.util.*;

class Solution {
    int[] val = new int[26];
    boolean[] used = new boolean[10];
    boolean[] noZero = new boolean[26];
    String[] words;
    String res;
    public boolean isSolvable(String[] words, String result) {
        this.words = words;
        this.res = result;
        Arrays.fill(val, -1);
        for (String w : words)
            if (w.length() > 1) noZero[w.charAt(0) - 'A'] = true;
        if (result.length() > 1)
            noZero[result.charAt(0) - 'A'] = true;

        int max = result.length();
        for (String w : words) max = Math.max(max, w.length());
        if (result.length() < max) return false;

        return dfs(0, 0, 0);
    }

    boolean dfs(int col, int row, int carry) {
        if (col == res.length())
            return carry == 0;
        if (row == words.length) {
            char rc = charAt(res, col);
            int id = rc - 'A';
            int digit = carry % 10;

            if (val[id] != -1)
                return val[id] == digit && dfs(col + 1, 0, carry / 10);

            if (used[digit] || (digit == 0 && noZero[id])) return false;

            val[id] = digit;
            used[digit] = true;
            if (dfs(col + 1, 0, carry / 10)) return true;
            val[id] = -1;
            used[digit] = false;
            return false;
        }
        if (col >= words[row].length())
            return dfs(col, row + 1, carry);

        char c = charAt(words[row], col);
        int id = c - 'A';

        if (val[id] != -1)
            return dfs(col, row + 1, carry + val[id]);

        for (int d = 0; d <= 9; d++) {
            if (used[d] || (d == 0 && noZero[id])) continue;

            val[id] = d;
            used[d] = true;
            if (dfs(col, row + 1, carry + d)) return true;
            val[id] = -1;
            used[d] = false;
        }
        return false;
    }

    char charAt(String s, int col) {
        return s.charAt(s.length() - 1 - col);
    }
}
