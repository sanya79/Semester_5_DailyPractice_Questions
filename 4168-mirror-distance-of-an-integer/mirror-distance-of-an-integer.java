class Solution {
    public int mirrorDistance(int n) {
        int r = 0;
        int o = n;
        while (n > 0) {
            int d = n % 10;
            r = r * 10 + d;
            n /= 10;
        }
        return Math.abs(o - r);
    }
}