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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // if the nodes exist or not
        if(!checkNodesExist(root, p) && !checkNodesExist(root, q)){
            return null;
        }
        // check for the lca
        return LCA(root, p, q);
    }
    private TreeNode LCA(TreeNode root, TreeNode x, TreeNode y){
        if(root == null){
            return null;
        }
        if(root.val == x.val || root.val == y.val){
            return root;
        }
        
        TreeNode la = LCA(root.left, x, y);
        TreeNode ra = LCA(root.right, x, y);

        if(la != null && ra != null){
            return root;
        }

        return la == null ? ra : la;
    }

    private boolean checkNodesExist(TreeNode root, TreeNode node){
        if(root == null){
            return false;
        }
        if(root.val == node.val){
            return true;
        }
        boolean leftNode = checkNodesExist(root.left, node);
        boolean rightNode = checkNodesExist(root.right, node);

        return leftNode || rightNode;
    }
}
