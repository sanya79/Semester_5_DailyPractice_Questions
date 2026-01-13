class Solution {
    public int largestPrime(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        if (n >= 0) isPrime[0] = false;
        if (n >= 1) isPrime[1] = false;

        for (int i = 2; i * i <= n; i++)
            if (isPrime[i])
                for (int j = i * i; j <= n; j += i)
                    isPrime[j] = false;

        int sum = 0, ans = 0;
        for (int i = 2; i <= n; i++) {
            if (!isPrime[i]) continue;
            sum += i;
            if (sum > n) break;
            if (isPrime[sum]) ans = sum;
        }
        return ans;
    }
}
