class Solution {
    public long minEnd(int n, int x) {
        long ans = x;
        long k = n - 1;
        int b = 0;

        while (k > 0) {
            if (((ans >> b) & 1) == 0) {
                if ((k & 1) == 1) {
                    ans |= (1L << b);
                }
                k >>= 1;
            }
            b++;
        }

        return ans;
    }
}
