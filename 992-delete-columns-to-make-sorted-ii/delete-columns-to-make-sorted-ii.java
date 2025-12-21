class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
       
        boolean[] sorted = new boolean[n - 1];
        int deletions = 0;

      
        for (int col = 0; col < strs[0].length(); col++) {
            int i;
            
            for (i = 0; i < n - 1; i++) {
             
              
                if (!sorted[i] && strs[i].charAt(col) > strs[i + 1].charAt(col)) {
                    deletions++;
                    break;
                }
            }
        
            if (i < n - 1) {
                continue;
            }

            for (i = 0; i < n - 1; i++) {
                if (!sorted[i] &&
                    strs[i].charAt(col) < strs[i + 1].charAt(col)) {
                    sorted[i] = true;
                }
            }
        }

        return deletions;
    }
}
