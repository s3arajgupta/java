package practice.neetCode150.part7Trees.easy;

import modules.TreeNode;

public class invertBinaryTree {

    public static void main(String args[]) {

        invertBinaryTree sol = new invertBinaryTree();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        root.printTree(root);
        root = sol.invertTree(root);
        root.printTree(root);

    }

    public TreeNode invertTree(TreeNode root) {

        if (root == null)
            return null;

        TreeNode node = new TreeNode(root.val);

        node.right = invertTree(root.left);
        node.left = invertTree(root.right);

        return node;

    }

}
