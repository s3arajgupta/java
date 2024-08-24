package practice.neetCode150.part7Binarytree.easy;

import modules.TreeNode;

public class balancedBinaryTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(7);
        root.right.right.right.right = new TreeNode(7);

        System.out.println(isBalanced(root));

    }

    public static boolean isBalanced(TreeNode root) {

        if (root == null)
            return true;

        int left = height(root.left);
        // System.out.println("Total left " + left);
        int right = height(root.right);
        // System.out.println("Total right " + right);
        
        return Math.abs(right - left) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        
    }
    
    public static int height(TreeNode root) {
        
        if (root == null)
        return 0;
        
        int left = height(root.left);
        // System.out.println("left " + left);
        int right = height(root.right);
        // System.out.println("right " + right);
        return 1 + Math.max(left, right);

    }

}
