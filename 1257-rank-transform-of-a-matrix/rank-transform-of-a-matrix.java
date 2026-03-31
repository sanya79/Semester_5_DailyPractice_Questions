import java.util.*;
class Solution {
    public int[][] matrixRankTransform(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        Map<Integer, List<int[]>> map = new TreeMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map.computeIfAbsent(matrix[i][j], k -> new ArrayList<>())
                   .add(new int[]{i, j});
            }
        }
        int[] rowMax = new int[m];
        int[] colMax = new int[n];
        int[][] result = new int[m][n];
        for (int value : map.keySet()) {
            List<int[]> cells = map.get(value);
            UnionFind uf = new UnionFind(m + n);
            for (int[] cell : cells) {
                int r = cell[0], c = cell[1];
                uf.union(r, c + m);
            }
            Map<Integer, List<int[]>> groups = new HashMap<>();
            for (int[] cell : cells) {
                int root = uf.find(cell[0]);
                groups.computeIfAbsent(root, k -> new ArrayList<>())
                      .add(cell);
            }
            for (List<int[]> group : groups.values()) {
                int rank = 0;
                for (int[] cell : group) {
                    int r = cell[0], c = cell[1];
                    rank = Math.max(rank, Math.max(rowMax[r], colMax[c]));
                }
                rank++; 
                for (int[] cell : group) {
                    int r = cell[0], c = cell[1];
                    result[r][c] = rank;
                    rowMax[r] = rank;
                    colMax[c] = rank;
                }
            }
        }
        return result;
    }
    class UnionFind {
        int[] parent;
        UnionFind(int size) {
            parent = new int[size];
            for (int i = 0; i < size; i++) parent[i] = i;
        }
        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }
        void union(int x, int y) {
            parent[find(x)] = find(y);
        }
    }
}