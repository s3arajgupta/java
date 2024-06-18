package practice.leetcode75;

import modules.TreeNode;

public class DeleteNodeInABST {

    // public static void printTree(TreeNode root) {

    // if (root == null) {
    // System.out.println("null");
    // return;
    // }

    // Deque<TreeNode> deque = new LinkedList<>();
    // deque.add(root);

    // while (deque.size() != 0) {

    // int size = deque.size();
    // for (int i = 0; i < size; i++) {
    // TreeNode node = deque.removeFirst();
    // if (node.left != null)
    // deque.add(node.left);
    // if (node.right != null)
    // deque.add(node.right);
    // System.out.print(node.val + " ");
    // // System.out.println(deque);
    // }

    // }
    // }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(7);

        TreeNode res = deleteNode(root, 7);
        System.out.println(res.val);
        // printTree(res);
    }

    public static TreeNode deleteNode(TreeNode root, int key) {

        TreeNode curr;
        if (root == null)
            return root;

        if (key > root.val)
            root.right = deleteNode(root.right, key);
        else if (key < root.val)
            root.left = deleteNode(root.left, key);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // Find Min from right subtree
            curr = root.right;
            while (curr.left != null) {
                curr = curr.left;
            }
            root.val = curr.val;
            root.right = deleteNode(root.right, root.val);

        }

        return root;
    }

}
