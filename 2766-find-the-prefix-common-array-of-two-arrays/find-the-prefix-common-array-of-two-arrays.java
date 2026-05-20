import java.util.*;
class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] r = new int[n];
        boolean[] sA = new boolean[n + 1];
        boolean[] sB = new boolean[n + 1];
        int c = 0;
        for (int i = 0; i < n; i++) {
            sA[A[i]] = true;
            sB[B[i]] = true;
            if (sB[A[i]]) c++;
            if (sA[B[i]] && A[i] != B[i]) c++;
            r[i] = c;
        }
        return r;
    }
}
