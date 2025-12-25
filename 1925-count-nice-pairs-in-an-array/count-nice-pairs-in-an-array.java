import java.util.*;
class Solution {
    static final int MOD = 1_000_000_007;
    public int countNicePairs(int[] nums) {
        Map<Integer, Long> map = new HashMap<>();
        long ans = 0;
        for (int num : nums) {
            int key = num - reverse(num);
            ans = (ans + map.getOrDefault(key, 0L)) % MOD;
            map.put(key, map.getOrDefault(key, 0L) + 1);
        }
        return (int) ans;
    }
    private int reverse(int x) {
        int rev = 0;
        while (x > 0) {
            rev = rev * 10 + (x % 10);
            x /= 10;
        }
        return rev;
    }
}
