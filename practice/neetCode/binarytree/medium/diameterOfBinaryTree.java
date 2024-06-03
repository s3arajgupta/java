package practice.neetCode.binarytree.medium;

import modules.TreeNode;

public class diameterOfBinaryTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(5);
        root.right = new TreeNode(3);

        System.out.println(diameterOfBinaryTreeFunc(root));

    }

    public static int result = -1;

    public static int diameterOfBinaryTreeFunc(TreeNode root) {

        diameter(root);
        return result;

    }

    public static int diameter(TreeNode root) {

        if (root == null)
            return -1;

        int left = 1 + diameter(root.left);
        int right = 1 + diameter(root.right);
        result = Math.max(result, left + right);
        return Math.max(left, right);

    }

    // public static int diameterOfBinaryTreeFunc(TreeNode root) {

    // if (root == null)
    // return 0;
    // diameter(root);
    // return max;

    // }

    // public static Integer max = 0;
    // public static Integer result = -1;

    // public static int diameter(TreeNode root) {

    // if (root == null)
    // return result;

    // int left = diameter(root.left);
    // int right = diameter(root.right);

    // max = Math.max(max, left + right + 2);
    // // int height = 1 + Math.max(left, right);

    // return 1 + Math.max(left, right);

    // }

    // public static int diameterOfBinaryTreeFunc(TreeNode root) {

    // Integer lcounter = 0;
    // if (root == null)
    // return lcounter;

    // Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
    // Pair<TreeNode, Integer> pair = new Pair<>(root, lcounter);
    // stack.add(pair);

    // if (!stack.isEmpty()) {

    // Pair<TreeNode, Integer> node = stack.pop();

    // if (node != null) {
    // }
    // }
    // }

}
