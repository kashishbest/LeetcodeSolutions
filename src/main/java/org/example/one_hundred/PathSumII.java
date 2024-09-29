package org.example.one_hundred;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {


    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> solution = new ArrayList<>();
        backtrack(root, targetSum, 0, new ArrayList<Integer>(), solution);
        return solution;
    }

    private void backtrack(TreeNode root, int targetSum, int currentSum, List<Integer> current, List<List<Integer>> solution) {
        if (root == null) return;

        current.add(root.val);
        currentSum += root.val;
        if (currentSum == targetSum && root.left == null && root.right == null) {
            solution.add(new ArrayList<>(current));
            current.remove(current.size() - 1);
            return;
        }
        backtrack(root.left, targetSum, currentSum, current, solution);
        backtrack(root.right, targetSum, currentSum, current, solution);
        current.remove(current.size() - 1);

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
