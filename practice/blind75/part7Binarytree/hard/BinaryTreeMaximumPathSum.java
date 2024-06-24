package practice.blind75.part7Binarytree.hard;

import modules.TreeNode;

public class BinaryTreeMaximumPathSum {

    public static void main(String[] args) {

        // TreeNode root = new TreeNode(1);
        // root.left = new TreeNode(2);
        // root.right = new TreeNode(3);

        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(maxPathSum(root));

    }

    public static int sumMax = 0;
    // Can be sone with global variable, by sum(root.left, sumMaxWithSplit)

    public static int maxPathSum(TreeNode root) {

        sumMax = root.val;
        sum(root);
        return sumMax;

    }

    public static int sum(TreeNode root) {

        if (root == null)
            return 0;

        int leftMax = sum(root.left);
        int rightMax = sum(root.right);
        leftMax = Math.max(leftMax, 0);
        rightMax = Math.max(rightMax, 0);

        // System.out.println(leftMax + " " + rightMax);
        // sumMax with spliting
        sumMax = Math.max(sumMax, root.val + leftMax + rightMax);

        // sumMax without spliting
        return root.val + Math.max(leftMax, rightMax);

    }

}
