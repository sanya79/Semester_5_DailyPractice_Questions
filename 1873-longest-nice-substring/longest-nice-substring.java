class Solution {
    public String longestNiceSubstring(String s) {
        if (s == null || s.length() < 2) return "";
        return helper(s);
    }
    
    private String helper(String s) {
        if (s.length() < 2) return "";
        
        // Build a set of all characters in the current string
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        
        // Try to find any character that does not have both cases
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!(set.contains(Character.toLowerCase(c)) &&
                  set.contains(Character.toUpperCase(c)))) {
                // Split around this invalid character
                String left = helper(s.substring(0, i));
                String right = helper(s.substring(i + 1));
                // Return the longer (or the left if same length)
                return left.length() >= right.length() ? left : right;
            }
        }
        
        // If every character has both upper and lower, the whole string is nice
        return s;
    }
}
