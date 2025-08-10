class Solution {
    public static int subtractProductAndSum(int n) {
        int p = 1;
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            p *= digit;
            sum += digit;
            n /= 10;
        }
        return p - sum;
    }
}
