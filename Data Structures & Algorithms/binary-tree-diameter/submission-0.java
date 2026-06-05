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
    private int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        DBT(root);
        return diameter;
    }
    private int DBT(TreeNode root){
        if(root == null){
            return -1;
        }
        int lh = DBT(root.left);
        int rh = DBT(root.right);
        diameter = Math.max(diameter, lh + rh + 2);
        return Math.max(lh, rh) + 1;
    }
}
