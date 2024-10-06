package org.example.two_hundred;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementInBST {


    public int kthSmallest(TreeNode root, int k) {
        List<Integer> inOrder = new ArrayList<Integer>();
        kthSmallest(root, k, inOrder);
        return inOrder.get(k - 1);
    }

    void kthSmallest(TreeNode root, int k, List<Integer> inOrder) {
        if (root == null) return;

        kthSmallest(root.left, k, inOrder);
        if (inOrder.size() == k) return;
        inOrder.add(root.val);
        if (inOrder.size() == k) return;
        kthSmallest(root.right, k, inOrder);
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
