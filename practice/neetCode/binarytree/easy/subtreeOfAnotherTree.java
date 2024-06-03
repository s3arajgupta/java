package practice.neetCode.binarytree.easy;

import modules.TreeNode;

public class subtreeOfAnotherTree {

    public static void main(String[] args) {

        // TreeNode root = new TreeNode(3);
        // root.left = new TreeNode(4);
        // root.left.left = new TreeNode(2);
        // root.left.right = new TreeNode(1);

        // TreeNode subRoot = new TreeNode(4);
        // subRoot.left = new TreeNode(2);
        // subRoot.right = new TreeNode(1);
        
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);

        TreeNode subRoot = new TreeNode(1);

        System.out.println(isSubtree(root, subRoot));
        
    }

    public static boolean isSubtree (TreeNode root, TreeNode subRoot) {
        if (subRoot == null || isSametree(root, subRoot)) return true;
        if (root == null) return false;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public static boolean isSametree (TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) return true;
        if(root == null || subRoot == null || root.val != subRoot.val) return false;
        return isSametree(root.left, subRoot.left) && isSametree(root.right, subRoot.right);
    }
    
}
