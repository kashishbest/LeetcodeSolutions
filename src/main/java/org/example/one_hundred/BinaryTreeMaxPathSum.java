package org.example.one_hundred;

/**
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
 */
public class BinaryTreeMaxPathSum {
    int maxPathSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxPathSum;
    }

    private int helper(TreeNode node) {
        if(node == null) return 0;

        int leftSum = Math.max(helper(node.left),0);
        int rightSum = Math.max(helper(node.left),0);
        maxPathSum = Math.max(maxPathSum,node.val+leftSum+rightSum);

        return Math.max(Math.max(leftSum,rightSum)+node.val,node.val);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
