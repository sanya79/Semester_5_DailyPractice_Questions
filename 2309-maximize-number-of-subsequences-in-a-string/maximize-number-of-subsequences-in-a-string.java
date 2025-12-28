class Solution {
    public long maximumSubsequenceCount(String text, String pattern) {
        char x = pattern.charAt(0);
        char y = pattern.charAt(1);

        long countX = 0;
        long countY = 0;
        long subseq = 0;
        for (char c : text.toCharArray()) {
            if (c == y) {
                subseq += countX;
                countY++;
            }
            if (c == x) {
                countX++;
            }
        }
        long addX = subseq + countY;
        long addY = subseq + countX;
        
        return Math.max(addX, addY);
    }
}
