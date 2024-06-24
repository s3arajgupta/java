package practice.leetcode75;

import modules.TreeNode;

/**
 * LongestZigZagPathInABinaryTree
 */
public class LongestZigZagPathInABinaryTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(1);
        root.right.right.left = new TreeNode(1);
        root.right.right.right = new TreeNode(1);
        root.right.right.left.right = new TreeNode(1);
        root.right.right.left.right.right = new TreeNode(1);

        System.out.println(longestZigZag(root));

    }

    public static int max;
    // dir = 0 left;
    // dir = 1 right;

    public static int longestZigZag(TreeNode root) {

        if (root == null)
            return 0;

        max = 0;
        backtrack(0, root, 0);
        backtrack(1, root, 0);

        return max;

    }

    public static void backtrack(int currDir, TreeNode root, int curLen) {

        max = curLen > max ? curLen : max;

        if (currDir == 1) { //
            if (root.left != null)
                backtrack(1 - currDir, root.left, curLen + 1);
            if (root.right != null)
                backtrack(1 - currDir, root.right, 0);
        }
        if (currDir == 0) {
            if (root.left != null)
                backtrack(1 - currDir, root.left, 0);
            if (root.right != null)
                backtrack(1 - currDir, root.right, curLen + 1);
        }

    }

}