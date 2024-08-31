package practice.neetCode150.part7Trees.medium;

import modules.TreeNode;

public class validateBinarySearchTree {

    public static void main(String[] args) {

        validateBinarySearchTree sol = new validateBinarySearchTree();

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right = new TreeNode(6);
        System.out.println(sol.isValidBST(root));

        root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        System.out.println(sol.isValidBST(root));

        root = new TreeNode(2147483647);
        System.out.println(sol.isValidBST(root));

    }

    public boolean isValidBST(TreeNode root) {

        if (root == null)
            return true;

        return dfs(root, null, null);

    }

    public boolean dfs(TreeNode root, Integer min, Integer max) { // ninja

        if (root == null)
            return true;

        if ((min != null && root.val <= min) || (max != null && root.val >= max))
            return false;

        return dfs(root.left, min, root.val) && dfs(root.right, root.val, max);

    }

}
