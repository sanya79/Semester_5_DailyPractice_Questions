class Solution {
    public int numSub(String s) {
        long count = 0;     
        long result = 0;   
        long mod = 1_000_000_007;

        for (char c : s.toCharArray()) {
            if (c == '1') {
                count++; 
                result += count;
            } else {
                count = 0;
            }
            result %= mod;
        }

        return (int) result;
    }
}
