class Solution {
    public String largestMerge(String word1, String word2) {
        int i = 0, j = 0;
        int n = word1.length(), m = word2.length();
        StringBuilder sb = new StringBuilder(n + m);

        while (i < n && j < m) {
            if (isGreater(word1, i, word2, j)) {
                sb.append(word1.charAt(i++));
            } else {
                sb.append(word2.charAt(j++));
            }
        }

        while (i < n) sb.append(word1.charAt(i++));
        while (j < m) sb.append(word2.charAt(j++));

        return sb.toString();
    }
    private boolean isGreater(String a, int i, String b, int j) {
        int n = a.length(), m = b.length();

        while (i < n && j < m) {
            if (a.charAt(i) != b.charAt(j)) {
                return a.charAt(i) > b.charAt(j);
            }
            i++;
            j++;
        }
        return (n - i) > (m - j);
    }
}

