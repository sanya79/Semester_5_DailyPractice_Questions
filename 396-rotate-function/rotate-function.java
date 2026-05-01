class Solution {
    public int maxRotateFunction(int[] nu) {
        int n = nu.length;
        long s = 0, f0 = 0;
        for (int i = 0; i < n; i++) {
            s += nu[i];
            f0 += (long) i * nu[i];
        }
        long m = f0;
        long fk = f0;
        for (int k = 1; k < n; k++) {
            fk = fk + s - (long) n * nu[n - k];
            m = Math.max(m, fk); 
        }
        return (int) m;
    }
}
