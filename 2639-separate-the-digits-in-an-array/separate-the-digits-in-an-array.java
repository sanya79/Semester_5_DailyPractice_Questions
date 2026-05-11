import java.util.*;
class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int num : nums) {
            String s = String.valueOf(num);
            for (char c : s.toCharArray()) {
                result.add(c - '0'); 
            }
        }
        int[] a = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            a[i] = result.get(i);
        }
        return a;
    }
}
