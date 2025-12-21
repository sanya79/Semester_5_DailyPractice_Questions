class Solution {
    private long k;

    public String smallestPalindrome(String s, int k) {
        this.k = k;

        int[] freq = new int[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;

        char mid = 0;
        for (int i = 0; i < 26; i++) {
            if ((freq[i] & 1) == 1) mid = (char) ('a' + i);
            freq[i] >>= 1;
        }

        int halfLen = s.length() / 2;
        long total = count(freq, halfLen);
        if (total < k) return "";

        StringBuilder left = new StringBuilder();

        for (int pos = 0; pos < halfLen; pos++) {
            for (int c = 0; c < 26; c++) {
                if (freq[c] == 0) continue;

                freq[c]--;
                long ways = count(freq, halfLen - pos - 1);

                if (ways < this.k) {
                    this.k -= ways;
                    freq[c]++;
                } else {
                    left.append((char) ('a' + c));
                    break;
                }
            }
        }

        String right = new StringBuilder(left).reverse().toString();
        return left.toString() + (mid == 0 ? "" : mid) + right;
    }

    // Count permutations of multiset, capped at k
    private long count(int[] freq, int len) {
        long res = 1;
        int used = 0;

        for (int c : freq) {
            if (c == 0) continue;
            res = res * comb(used + c, c);
            if (res > k) return k + 1;
            used += c;
        }
        return res;
    }
    private long comb(int n, int k) {
        k = Math.min(k, n - k);
        long res = 1;
        for (int i = 1; i <= k; i++) {
            res = res * (n - k + i) / i;
            if (res > this.k) return this.k + 1;
        }
        return res;
    }
}
