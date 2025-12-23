class Solution {
    public int findMinimumOperations(String s1, String s2, String s3) {
        int total = s1.length() + s2.length() + s3.length();
        int minLength = Math.min(
            Math.min(s1.length(), s2.length()),
            s3.length()
        );
        int i = 0;
        while (i < minLength
           && s1.charAt(i) == s2.charAt(i)
           && s2.charAt(i) == s3.charAt(i)) {
            i++;
        }
        if (i == 0) {
            return -1;
        }
        return total - 3 * i;
    }
}
