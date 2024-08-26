package practice.neetCode150.part7Binarytree.medium;

import modules.TreeNode;

public class countGoodNodesInBinaryTree {

    public static void main(String[] args) {

        countGoodNodesInBinaryTree sol = new countGoodNodesInBinaryTree();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);

        System.out.println(sol.goodNodes(root));

    }

    public int goodNodes(TreeNode root) {

        return goodNodesFunction(root, Integer.MIN_VALUE);

    }

    public int goodNodesFunction(TreeNode node, int max) {

        if (node == null)
            return 0;

        int result = node.val >= max ? 1 : 0;

        result += goodNodesFunction(node.left, Math.max(max, node.val));
        result += goodNodesFunction(node.right, Math.max(max, node.val));

        return result;

    }

}
