import java.util.*;
class Solution {
    public boolean isGood(int[] a) {
        int n = Arrays.stream(a).max().getAsInt();
        if (a.length != n + 1) return false;
        int[] b = new int[n + 1];
        for (int i = 1; i < n; i++) b[i - 1] = i;
        b[n - 1] = n; b[n] = n;
        Arrays.sort(a); Arrays.sort(b);
        return Arrays.equals(a, b);
    }
}
