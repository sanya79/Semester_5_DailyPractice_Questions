class Solution {
    public int countPrimeSetBits(int left, int right) {
        int count = 0;
        boolean[] isPrime = new boolean[33];
        isPrime[2] = true;
        isPrime[3] = true;
        isPrime[5] = true;
        isPrime[7] = true;
        isPrime[11] = true;
        isPrime[13] = true;
        isPrime[17] = true;
        isPrime[19] = true;
        isPrime[23] = true;
        isPrime[29] = true;
        isPrime[31] = true;
        for (int i = left; i <= right; i++) {
            int bits = Integer.bitCount(i); 
            if (isPrime[bits]) {
                count++;
            }
        }
        return count;
    }
}
