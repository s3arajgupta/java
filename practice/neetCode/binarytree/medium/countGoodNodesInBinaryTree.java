package practice.neetCode.binarytree.medium;

import modules.TreeNode;

public class countGoodNodesInBinaryTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);

        System.out.println("result " + goodNodes(root));

    }

    public static int goodNodes(TreeNode root) {

        return goodNodesFunction(root, -99999);

    }

    public static int goodNodesFunction(TreeNode root, int max) {

        if (root == null)
            return 0;

        int result = root.val >= max ? 1 : 0; // ninja
        // if (root.val >= min) // unreachable code
        // return 1;
        // else
        // return 0;

        result += goodNodesFunction(root.left, Math.max(max, root.val));
        result += goodNodesFunction(root.right, Math.max(max, root.val));

        return result;

    }

}
