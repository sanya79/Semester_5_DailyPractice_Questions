import java.util.*;
class Solution {
    public String longestWord(String[] words) {
        Set<String> built = new HashSet<>();
        Arrays.sort(words);  
        String result = "";
        for (String word : words) {
            if (word.length() == 1 || built.contains(word.substring(0, word.length() - 1))) {
                built.add(word);
                if (word.length() > result.length()) {
                    result = word;
                }
            }
        }
        return result;
    }
}
