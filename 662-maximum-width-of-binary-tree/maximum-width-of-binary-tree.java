/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Queue<Pair> q = new LinkedList<>();
        int width = 0;
        q.add(new Pair(root, 0)); 
        while (!q.isEmpty()) {
            int size = q.size();
            long minIndex = q.peek().idx;
            long first = 0, last = 0;
            for (int i = 0; i < size; i++) {
                Pair current = q.poll();
                long curIndex = current.idx - minIndex; 
                if (i == 0) first = curIndex;
                if (i == size - 1) last = curIndex;
                if (current.node.left != null) {
                    q.add(new Pair(current.node.left, curIndex * 2 + 1));
                }
                if (current.node.right != null) {
                    q.add(new Pair(current.node.right, curIndex * 2 + 2));
                }
            }
            width = Math.max(width, (int)(last - first + 1));
        }
        return width;
    }
}

class Pair {
    TreeNode node;
    long idx;
    public Pair(TreeNode node, long idx) {
        this.node = node;
        this.idx = idx;
    }
}
