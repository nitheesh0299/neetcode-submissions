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

    public void invertTreeHelper(TreeNode root){
        if(root==null)
            return;
        invertTree(root.left);
        invertTree(root.right);

        TreeNode dummy = root.left;
        root.left = root.right;
        root.right = dummy;
    }

    public TreeNode invertTree(TreeNode root) {
        invertTreeHelper(root);
        return root;
    }
}
