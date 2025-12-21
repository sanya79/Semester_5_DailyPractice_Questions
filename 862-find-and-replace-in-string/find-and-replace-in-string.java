class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int n = s.length();
        int[] match = new int[n];
        Arrays.fill(match, -1);
        for (int i = 0; i < indices.length; i++) {
            int idx = indices[i];
            if (s.startsWith(sources[i], idx)) {
                match[idx] = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < n) {
            if (match[i] != -1) {
                int k = match[i];
                sb.append(targets[k]);
                i += sources[k].length();
            } else {
                sb.append(s.charAt(i));
                i++;
            }
        }
        return sb.toString();
    }
}
