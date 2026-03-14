class Solution {
    public String getHappyString(int n, int k) {
        int total = 3 * (1 << (n - 1));
        if (k > total) return "";
        StringBuilder result = new StringBuilder();
        char prev = '#';
        for (int i = 0; i < n; i++) {
            for (char c : new char[]{'a','b','c'}) {
                if (c == prev) continue;
                int remaining = n - i - 1;
                int block = 1 << remaining;
                if (k > block) {
                    k -= block;
                } else {
                    result.append(c);
                    prev = c;
                    break;
                }
            }
        }
        return result.toString();
    }
}