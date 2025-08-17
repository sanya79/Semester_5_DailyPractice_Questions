class Solution {
    public int primePalindrome(int n) {
        if (n <= 2) return 2;
        if (n <= 3) return 3;
        if (n <= 5) return 5;
        if (n <= 7) return 7;
        if (n <= 11) return 11;
        int len = String.valueOf(n).length();
        if ((len & 1) == 0) len++;
        for (; len <= 9; len += 2) {
            int k = len / 2;                         
            int start = (int)Math.pow(10, k);         
            int end   = (int)Math.pow(10, k + 1) - 1; 
            for (int root = start; root <= end; root++) {
                int candidate = makeOddPalindrome(root);
                if (candidate >= n && isPrime(candidate)) {
                    return candidate;
                }
            }
        }
        return -1; 
    }
    private static int makeOddPalindrome(int left) {
        int x = left / 10;   
        int res = left;
        while (x > 0) {
            res = res * 10 + (x % 10);
            x /= 10;
        }
        return res;
    }
    private static boolean isPrime(int x) {
        if (x < 2) return false;
        if (x % 2 == 0) return x == 2;
        if (x % 3 == 0) return x == 3;
        int i = 5;
        while ((long)i * i <= x) {
            if (x % i == 0 || x % (i + 2) == 0) return false;
            i += 6;
        }
        return true;
    }
}

