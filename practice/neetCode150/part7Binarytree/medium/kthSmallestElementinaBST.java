package practice.neetCode150.part7Binarytree.medium;

import java.util.*;

import modules.TreeNode;

public class kthSmallestElementinaBST {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        System.out.println(kthSmallest(root, 1));

    }

    public static int kthSmallest(TreeNode root, int k) {

        if (root == null || k <= 0) { // they might not give any constrainst
            return -1;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        TreeNode node = stack.peek();

        while (!stack.isEmpty()) {

            // while (node.left != null) {
            while (node != null && node.left != null) {
                node = node.left;
                stack.add(node);
            }

            node = stack.pop(); // only pop when no left element
            k--;
            if (k == 0)
                return node.val;

            node = node.right; // otherwise add right node to stack
            if (node != null) {
                stack.add(node);
            }

        }
        return -1;

    }

}
