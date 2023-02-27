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
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        else if (root.left != null || root.right != null)
            return Math.abs(getHeight(root.left) - getHeight(root.right)) < 2 && isBalanced(root.left) && isBalanced(root.right);
        else
            return true;
    }

    private int getHeight(TreeNode root) {
        if (root == null) return 0;

        if (root.left == null && root.right == null)
            return 1;
        else
            return Math.max( 1 + getHeight(root.left), 1 + getHeight(root.right));
    }
}
