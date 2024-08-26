package practice.neetCode150.part7Binarytree.medium;

import java.util.*;
import modules.*;

public class constructBinaryTreeFromPreorderAndInorderTraversal {

    public static void main(String[] args) {

        constructBinaryTreeFromPreorderAndInorderTraversal sol = new constructBinaryTreeFromPreorderAndInorderTraversal();

        int[] preorder = { 3, 9, 20, 15, 7 };
        int[] inorder = { 9, 3, 15, 20, 7 };

        TreeNode root = sol.buildTree(preorder, inorder);
        root.printTree(root);

    }

    public HashMap<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);

        return builder(preorder, 0, 0, inorder.length - 1);

    }

    public TreeNode builder(int[] preorder, int preorderIndex, int inorderLow, int inorderHigh) {

        if (preorderIndex > preorder.length - 1 || inorderLow > inorderHigh)
            return null;

        int curr = preorder[preorderIndex];
        TreeNode root = new TreeNode(curr);

        int mid = map.get(curr);

        root.left = builder(preorder, preorderIndex + 1, inorderLow, mid - 1);
        root.right = builder(preorder, preorderIndex + (mid - inorderLow) + 1, mid + 1, inorderHigh);

        return root;

    }

}
