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
    public boolean isValidBST(TreeNode root) {
        return isValidBSTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private boolean isValidBSTree(TreeNode root, int min, int max){
        if(root  == null){
            return true;
        }

        if(root.val < min || root.val > max){
            return false;
        }

        boolean left = isValidBSTree(root.left, min, root.val - 1);
        boolean right = isValidBSTree(root.right, root.val + 1, max);

        return left && right;
    }
}
