class Solution {
    public String alphabetBoardPath(String target) {
        StringBuilder sb = new StringBuilder();
        int r = 0, c = 0;
        for (char ch : target.toCharArray()) {
            int idx = ch - 'a';
            int nr = idx / 5;
            int nc = idx % 5;
            while (r > nr) {
                sb.append('U');
                r--;
            }
            while (c > nc) {
                sb.append('L');
                c--;
            }
            while (r < nr) {
                sb.append('D');
                r++;
            }
            while (c < nc) {
                sb.append('R');
                c++;
            }

            sb.append('!');
        }

        return sb.toString();
    }
}
