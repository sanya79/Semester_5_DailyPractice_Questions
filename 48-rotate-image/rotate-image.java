class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            reverseRow(matrix, i);
        }
    }
    private void reverseRow(int[][] matrix, int row) {
        int left = 0;
        int right = matrix.length - 1;
        while (left < right) {
            int temp = matrix[row][left];
            matrix[row][left] = matrix[row][right];
            matrix[row][right] = temp;
            left++;
            right--;
        }
    }
    // public static void main(String[] args) {
    //     Solution solution = new Solution();

    //     // Example test case 1
    //     int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    //     solution.rotate(matrix1);
    //     printMatrix(matrix1); // Output: [[7, 4, 1], [8, 5, 2], [9, 6, 3]]
    //     int[][] matrix2 = {
    //         {5, 1, 9, 11},
    //         {2, 4, 8, 10},
    //         {13, 3, 6, 7},
    //         {15, 14, 12, 16}
    //     };
    //     solution.rotate(matrix2);
    //     printMatrix(matrix2); 
    // }
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}