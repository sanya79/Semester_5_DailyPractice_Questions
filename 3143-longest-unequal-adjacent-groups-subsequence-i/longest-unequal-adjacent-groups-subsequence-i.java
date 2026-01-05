import java.util.*;
class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> result = new ArrayList<>();
        Integer lastGroup = null;

        for (int i = 0; i < words.length; i++) {
            if (lastGroup == null || groups[i] != lastGroup) {
                result.add(words[i]);
                lastGroup = groups[i];
            }
        }

        return result;
    }
}
