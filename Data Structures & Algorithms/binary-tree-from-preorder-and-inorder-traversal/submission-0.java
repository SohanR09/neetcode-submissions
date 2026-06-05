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
    int preOrIdx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inOrMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            inOrMap.put(inorder[i], i);
        }

        return build(preorder, inOrMap, 0, inorder.length - 1);
    }
    private TreeNode build(int[] preOrder, Map<Integer, Integer> inOrMap, int ins, int ine){
        if(preOrder.length != inOrMap.size()){
            return null;
        }
        if(ins > ine){
            return null;
        }

        int rootVal = preOrder[preOrIdx];       // root value
        preOrIdx++;                             // increment the index
        int rootIdx = inOrMap.get(rootVal);     // root index

        TreeNode root = new TreeNode(rootVal);  // create a root node

        root.left = build(preOrder, inOrMap, ins, rootIdx - 1);
        root.right = build(preOrder, inOrMap, rootIdx + 1, ine);

        return root;
    }
}
