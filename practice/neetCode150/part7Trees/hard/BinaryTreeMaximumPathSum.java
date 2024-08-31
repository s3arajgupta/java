package practice.neetCode150.part7Trees.hard;

import modules.TreeNode;

public class BinaryTreeMaximumPathSum {

    public static void main(String[] args) {

        BinaryTreeMaximumPathSum sol = new BinaryTreeMaximumPathSum();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(sol.maxPathSum(root));

        root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(sol.maxPathSum(root));

    }

    int sumMax = 0;

    public int maxPathSum(TreeNode root) {

        if (root == null)
            return -1;

        sumMax = root.val;

        sum(root);
        return sumMax;

    }

    public int sum(TreeNode node) {

        if (node == null)
            return 0;

        int leftMax = sum(node.left);
        int rightMax = sum(node.right);

        leftMax = Math.max(leftMax, 0);
        rightMax = Math.max(rightMax, 0);

        sumMax = Math.max(sumMax, node.val + leftMax + rightMax);

        return node.val + Math.max(leftMax, rightMax);

    }

}
