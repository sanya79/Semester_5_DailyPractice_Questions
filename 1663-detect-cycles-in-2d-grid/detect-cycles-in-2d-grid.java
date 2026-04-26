class Solution {
    private int r, c;
    private char[][] grid;
    private boolean[][] v;
    public boolean containsCycle(char[][] grid) {
        this.grid = grid;
        r = grid.length;
        c = grid[0].length;
        v = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!v[i][j]) {
                    if (dfs(i, j, -1, -1, grid[i][j])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private boolean dfs(int x, int y, int pX, int pY, char ch) {
        v[x][y] = true;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx < 0 || ny < 0 || nx >= r || ny >= c) {
                continue;
            }
            if (grid[nx][ny] != ch) {
                continue;
            }
            if (nx == pX && ny == pY) {
                continue;
            }
            if (v[nx][ny]) {
                return true;
            }
            if (dfs(nx, ny, x, y, ch)) {
                return true;
            }
        }
        return false;
    }
}