package practice.neetCode.binarytree.easy;

import modules.TreeNode;

public class invertBinaryTree {

    // public static void main(String args[]) {

    //     TreeNode root = new TreeNode(3);
    //     root.left = new TreeNode(9);
    //     root.right = new TreeNode(20);
    //     root.right.left = new TreeNode(15);
    //     root.right.right = new TreeNode(7);

    //     System.out.println("Max Depth of tree is: " + invertTree(root));
                
    // }

    public TreeNode invertTree(TreeNode root) {

        if (root == null) return null;

        TreeNode node = new TreeNode(root.val);

        // swap the chidren
        // int temp = root.left;
        // root.left = root.right;
        // root.right = temp;

        // recursive calls && DFS
        node.right = invertTree(root.left);
        node.left = invertTree(root.right);
        return node;
        
    }
    
}
