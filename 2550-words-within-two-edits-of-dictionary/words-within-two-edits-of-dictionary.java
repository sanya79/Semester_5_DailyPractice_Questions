import java.util.*;
class Solution {
    public List<String> twoEditWords(String[] q, String[] d) {
        List<String> r = new ArrayList<>();
        for (String qu : q) {
            for (String w : d) {
                if (isWithinTwoEdits(qu, w)) {
                    r.add(qu);
                    break; 
                }
            }
        }
        return r;
    }
    private boolean isWithinTwoEdits(String a, String b) {
        int d = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                d++;
                if (d > 2) return false;
            }
        }
        return true;
    }
}