package practice.neetCode150.part7Trees.medium;

import modules.TreeNode;

public class diameterOfBinaryTree {

    public static void main(String[] args) {

        diameterOfBinaryTree sol = new diameterOfBinaryTree();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(5);
        root.right = new TreeNode(3);

        System.out.println(sol.diameterOfBinaryTreeFunc(root));

    }

    public int result = -1;

    public int diameterOfBinaryTreeFunc(TreeNode root) {

        diameter(root);
        return result;

    }

    public int diameter(TreeNode root) {

        if (root == null)
            return -1;

        int left = 1 + diameter(root.left);
        int right = 1 + diameter(root.right);

        result = Math.max(result, left + right);

        return Math.max(left, right);

    }

}
