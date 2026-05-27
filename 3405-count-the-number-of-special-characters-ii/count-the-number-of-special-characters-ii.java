class Solution {
    public int numberOfSpecialChars(String word) {
        boolean[] lower = new boolean[26];
        boolean[] upper = new boolean[26];
        boolean[] invalid = new boolean[26];

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (Character.isLowerCase(c)) {
                int idx = c - 'a';
                if (upper[idx]) invalid[idx] = true; 
                lower[idx] = true;
            } else {
                int idx = Character.toLowerCase(c) - 'a';
                upper[idx] = true;
            }
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (lower[i] && upper[i] && !invalid[i]) count++;
        }
        return count;
    }
}
