import java.util.*;
class Solution {
    public String arrangeWords(String text) {
        text = text.toLowerCase();
        String[] w = text.split(" ");
        Arrays.sort(w, (a, b) -> a.length() - b.length());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < w.length; i++) {
            if (i > 0) sb.append(" ");
            sb.append(w[i]);
        }
        sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        return sb.toString();
    }
}
