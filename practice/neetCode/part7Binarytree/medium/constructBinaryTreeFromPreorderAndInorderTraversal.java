package practice.neetCode.part7Binarytree.medium;

import java.util.*;

import modules.TreeNode;

public class constructBinaryTreeFromPreorderAndInorderTraversal {

    public static void printTree(TreeNode root) {
        if (root == null) {
            System.out.println(" null ");
            return;
        }
        System.out.println(root.val);
        printTree(root.left);
        printTree(root.right);
    }

    public static void main(String[] args) {

        int[] preorder = { 3, 9, 20, 15, 7 };
        int[] inorder = { 9, 3, 15, 20, 7 };

        TreeNode root = buildTree(preorder, inorder);
        printTree(root);
    }

    public static HashMap<Integer, Integer> map = new HashMap<>();

    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        for (int i = 0; i < preorder.length; i++) {
            map.put(inorder[i], i); // Inorder Positions
        }

        return builder(preorder, 0, 0, inorder.length - 1);

    }

    public static TreeNode builder(int[] preorder, int preorderIndex, int inorderLow, int inorderHigh) {

        if (preorderIndex > preorder.length - 1 || inorderLow > inorderHigh)
            return null;

        int curr = preorder[preorderIndex];
        TreeNode root = new TreeNode(curr);
        int mid = map.get(curr);

        root.left = builder(preorder, preorderIndex + 1, inorderLow, mid - 1);
        root.right = builder(preorder, preorderIndex + (mid - inorderLow) + 1, mid + 1, inorderHigh);

        return root;

    }

    // public static TreeNode buildTree(int[] preorder, int[] inorder) {

    // if (preorder.length == 0 || inorder.length == 0) {
    // return null;
    // }

    // TreeNode root = new TreeNode(preorder[0]);
    // // int mid = Arrays.binarySearch(preorder, preorder[0]);
    // int mid = -1;
    // for (int i = 0; i < preorder.length; i++)
    // if (preorder[0] == inorder[i]) {
    // mid = i;
    // break;
    // }
    // root.left = buildTree(Arrays.copyOfRange(preorder, 1, mid + 1),
    // Arrays.copyOfRange(inorder, 0, mid)); // jutsu
    // root.right = buildTree(Arrays.copyOfRange(preorder, mid + 1,
    // preorder.length),
    // Arrays.copyOfRange(inorder, mid + 1, inorder.length));

    // return root; // return final tree

    // }

}
