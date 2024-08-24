package practice.neetCode150.part7Binarytree.medium;

import modules.TreeNode;

public class lowestCommonAncestor {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(9);

        root.right = new TreeNode(3);

        System.out.println(lowestCommonAncestorFunc(root, new TreeNode(2), new TreeNode(6)).val);
    }

    public static TreeNode lowestCommonAncestorFunc(TreeNode root, TreeNode p, TreeNode q) {

        if (p.val < root.val && q.val < root.val)
            return lowestCommonAncestorFunc(root.left, p, q);
        if (p.val > root.val && q.val > root.val)
            return lowestCommonAncestorFunc(root.right, p, q);

        return root;

    }

}
