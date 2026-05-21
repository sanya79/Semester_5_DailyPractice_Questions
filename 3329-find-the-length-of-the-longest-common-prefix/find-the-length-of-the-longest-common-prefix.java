import java.util.*;
class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<String> set = new HashSet<>();
        for (int x : arr1) {
            String s = String.valueOf(x);
            for (int i = 1; i <= s.length(); i++) set.add(s.substring(0, i));
        }
        int ans = 0;
        for (int y : arr2) {
            String t = String.valueOf(y);
            for (int i = 1; i <= t.length(); i++) 
                if (set.contains(t.substring(0, i))) ans = Math.max(ans, i);
        }
        return ans;
    }
}