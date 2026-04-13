class Solution {
    public int minOperations(int[] ns, int k) {
        int s = 0;
        for (int n : ns) {
            s += n;
        }
        return s % k;
    }
}