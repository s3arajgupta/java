package practice.neetCode150.part7Binarytree.medium;

import modules.TreeNode;

public class validateBinarySearchTree {

    public static void main(String[] args) {

        // TreeNode root = new TreeNode(2);
        // root.left = new TreeNode(1);
        // root.right = new TreeNode(2);

        // TreeNode root = new TreeNode(5);
        // root.left = new TreeNode(1);
        // root.right = new TreeNode(4);
        // root.right.left = new TreeNode(3);
        // root.right = new TreeNode(6);
        
        TreeNode root = new TreeNode(2147483647);
        System.out.println(isValidBST(root));
        
    }

    public static boolean isValidBST (TreeNode root) {
        if (root == null) return true;
        // return dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return dfs(root, null, null); // ninja
    }

    public static boolean dfs(TreeNode root, Integer left, Integer right) { // ninja

        if (root == null) return true;

        if ((left != null && root.val <= left) || ( right != null && root.val >= right)) return false;

        return dfs (root.left, left, root.val) && dfs (root.right, root.val, right);
        
    }
    
    // public static boolean isValidBST (TreeNode root) {

    //     if (root == null) return true;
    //     if (root.left != null && (root.val < root.left.val)) return false;
    //     if (root.right != null && (root.val > root.right.val)) return false;
    //     return isValidBST(root.left) && isValidBST(root.right);

    // }
    
}
