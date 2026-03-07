class Solution {
    public int minFlips(String s) {
        int n = s.length();
        int a1 = 0, a2 = 0;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 2 * n; i++) {
            char c = s.charAt(i % n);
            if (c != (i % 2 == 0 ? '0' : '1')) a1++;
            if (c != (i % 2 == 0 ? '1' : '0')) a2++;
            if (i >= n) {
                char p = s.charAt((i - n) % n);
                if (p != ((i - n) % 2 == 0 ? '0' : '1')) a1--;
                if (p != ((i - n) % 2 == 0 ? '1' : '0')) a2--;
            }
            if (i >= n - 1) {
                ans = Math.min(ans, Math.min(a1, a2));
            }
        }

        return ans;
    }
}