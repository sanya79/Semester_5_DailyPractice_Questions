class Solution {
    public int[] movesToStamp(String stamp, String target) {
        char[] S = stamp.toCharArray();
        char[] T = target.toCharArray();
        boolean[] visited = new boolean[target.length()];
        List<Integer> res = new ArrayList<>();
        int stars = 0;

        while (stars < T.length) {
            boolean doneReplace = false;

            for (int i = 0; i <= T.length - S.length; i++) {
                if (!visited[i] && canReplace(T, S, i)) {
                    stars = replace(T, S.length, i, stars);
                    visited[i] = true;
                    res.add(i);
                    doneReplace = true;
                    if (stars == T.length) break;
                }
            }

            if (!doneReplace) return new int[0]; 
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++)
            ans[i] = res.get(res.size() - 1 - i);

        return ans;
    }

    private boolean canReplace(char[] T, char[] S, int pos) {
        for (int i = 0; i < S.length; i++) {
            if (T[pos + i] != '?' && T[pos + i] != S[i]) {
                return false;
            }
        }
        return true;
    }

    private int replace(char[] T, int len, int pos, int stars) {
        for (int i = 0; i < len; i++) {
            if (T[pos + i] != '?') {
                T[pos + i] = '?';
                stars++;
            }
        }
        return stars;
    }
}
