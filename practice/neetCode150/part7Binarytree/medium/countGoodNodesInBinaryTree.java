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

        System.out.println("result " + sol.goodNodes(root));

    }

    public int goodNodes(TreeNode root) {

        return goodNodesFunction(root, -99999);

    }

    public int goodNodesFunction(TreeNode root, int max) {

        if (root == null)
            return 0;

        int result = root.val >= max ? 1 : 0; // ninja

        result += goodNodesFunction(root.left, Math.max(max, root.val));
        result += goodNodesFunction(root.right, Math.max(max, root.val));

        return result;

    }

}
