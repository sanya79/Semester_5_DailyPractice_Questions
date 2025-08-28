import java.util.*;
class Solution {
    public List<List<String>> groupAnagrams(String[] arr) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String word : arr) {
            String key = getKey(word);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }
        return new ArrayList<>(map.values());
    }
    public static String getKey(String s) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int f : freq) {
            sb.append(f).append('#'); 
        }
        return sb.toString();
    }
}
