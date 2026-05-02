class Solution {
    public int rotatedDigits(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (isGood(i)) {
                count++;
            }
        }
        return count;
    }
    private static boolean isGood(int num) {
        boolean hasDifferentDigit = false;
        int current = num;
        while (current > 0) {
            int digit = current % 10;
            if (digit == 3 || digit == 4 || digit == 7) {
                return false;
            }
            if (digit == 2 || digit == 5 || digit == 6 || digit == 9) {
                hasDifferentDigit = true;
            }
            current /= 10;
        }
        return hasDifferentDigit;
    }
}
