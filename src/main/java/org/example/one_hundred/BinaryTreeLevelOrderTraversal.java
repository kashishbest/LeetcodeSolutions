package org.example.one_hundred;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {


    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.EMPTY_LIST;
        }
        Deque<TreeNode> currentLevel = new LinkedList<>();
        Deque<TreeNode> nextLevel;
        List<List<Integer>> result = new ArrayList<>();
        currentLevel.add(root);
        while (!currentLevel.isEmpty()) {
            List<Integer> currentResult = new ArrayList<>();
            nextLevel = new LinkedList<>();
            while (!currentLevel.isEmpty()) {
                TreeNode node = currentLevel.removeFirst();
                currentResult.add(node.val);
                if (node.left != null) nextLevel.add(node.left);
                if (node.right != null) nextLevel.add(node.right);
            }
            currentLevel = nextLevel;
            result.add(currentResult);
        }
        return result;
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
