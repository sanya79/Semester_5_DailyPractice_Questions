class Solution {
    public int minimumArea(int[][] grid) {
        int a = grid.length;
        int b = grid[0].length;
        int mr = a, mar = -1;
        int mc = b, mac = -1;
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (grid[i][j] == 1) {
                    mr = Math.min(mr, i);
                    mar = Math.max(mar, i);
                    mc = Math.min(mc, j);
                    mac = Math.max(mac, j);
                }
            }
        }
        if (mar == -1) return 0;
        return (mar - mr + 1) * (mac - mc + 1);
    }
}