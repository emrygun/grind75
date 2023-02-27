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
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        return Math.max(Math.max(diameterOfBinaryTree(root.right), diameterOfBinaryTree(root.left)), maxPath(root));
    }

    private int maxPath(TreeNode node) {
        return maxLenOfNode(node.left) + maxLenOfNode(node.right);
    }

    private int maxLenOfNode(TreeNode node) {
        if (node == null) return 0;

        return 1 + Math.max(maxLenOfNode(node.left), maxLenOfNode(node.right));
    }

}
