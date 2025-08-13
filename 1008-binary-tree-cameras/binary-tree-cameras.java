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
    int Camera=0;
    public int minCameraCover(TreeNode root) {
        int c=minCamera(root);
        if(c==-1){
            Camera++;
        }  
        return Camera;
    }
    public int minCamera(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=minCamera(root.left);
        int right=minCamera(root.right);
        if(left==-1 || right==-1){  //iss node pe camera ke need hai
            Camera++;
            return 1;  //Camera setup kra hai iss node pe
        }
        if(left==1 || right==1){  // inme se koi ek ke pass or yaa dono ke pass camera hai or dusra wala covered hai
            return 0;

        }
        else{
            return -1; // need a camera
        }
    }
}