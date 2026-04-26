class Solution {
    private int rows, cols;
    private char[][] grid;
    private boolean[][] visited;
    public boolean containsCycle(char[][] grid) {
        this.grid = grid;
        rows = grid.length;
        cols = grid[0].length;
        visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j]) {
                    if (dfs(i, j, -1, -1, grid[i][j])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private boolean dfs(int x, int y, int pX, int pY, char ch) {
        visited[x][y] = true;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx < 0 || ny < 0 || nx >= rows || ny >= cols) {
                continue;
            }
            if (grid[nx][ny] != ch) {
                continue;
            }
            if (nx == pX && ny == pY) {
                continue;
            }
            if (visited[nx][ny]) {
                return true;
            }
            if (dfs(nx, ny, x, y, ch)) {
                return true;
            }
        }
        return false;
    }
}