class Solution {
    public int minMoves(int[] nums, int l) {
        int n = nums.length;
        int[] d = new int[2 * l + 2];
        for (int i = 0; i < n / 2; i++) {
            int a = nums[i], b = nums[n - 1 - i];
            int ll = Math.min(a, b) + 1;
            int h = Math.max(a, b) + l;
            d[2] += 2;
            d[ll] -= 1;
            d[a + b] -= 1;
            d[a + b + 1] += 1;
            d[h + 1] += 1;
        }
        int r = Integer.MAX_VALUE, c = 0;
        for (int i = 2; i <= 2 * l; i++) {
            c += d[i];
            r = Math.min(r, c);
        }
        return r;
    }
}
