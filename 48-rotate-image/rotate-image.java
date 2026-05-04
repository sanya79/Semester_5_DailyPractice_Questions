class Solution {
    public void rotate(int[][] m) {
        int n = m.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int t = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = t;
            }
        }
        for (int i = 0; i < n; i++) {
            reverseRow(m, i);
        }
    }
    private void reverseRow(int[][] matrix, int r) {
        int l = 0;
        int ri = matrix.length - 1;
        while (l < ri) {
            int t = matrix[r][l];
            matrix[r][l] = matrix[r][ri];
            matrix[r][ri] = t;
            l++;
            ri--;
        }
    }
    private static void printMatrix(int[][] matrix) {
        for (int[] r : matrix) {
            for (int val : r) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}