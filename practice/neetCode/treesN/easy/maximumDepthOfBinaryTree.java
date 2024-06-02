package practice.neetCode.treesN.easy;

import java.util.*;

import modules.TreeNode;

public class maximumDepthOfBinaryTree {

    public static void main(String args[]) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println("Max Depth of tree is: " + maxDepth(root));
                
    }

    public static int maxDepth(TreeNode root){

        if (root == null) return 0;

        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        int lvl = 0;

        while (!deque.isEmpty()) {

            for (int i = 0; i < deque.size(); i++) {
                TreeNode node = deque.removeFirst();
                if (node.left != null) deque.add(node.left);
                if (node.right != null) deque.add(node.right);
            }
            lvl += 1;
            
        }
        return lvl;
        
    }
    
    // public static int maxDepth(TreeNode root) {

    //     int depth = 0;
    //     Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
    //     stack.add(new Pair<TreeNode, Integer>(root, 1));

    //     while (!stack.isEmpty()) {
            
    //         Pair<TreeNode,Integer> p = stack.pop();
    //         TreeNode temp = p.getFirst();
    //         int tempDepth = p.getSecond();

    //         if (temp != null) {
    //             depth = Math.max(depth, tempDepth);
    //             stack.add(new Pair<TreeNode,Integer>(temp.left, tempDepth + 1));
    //             stack.add(new Pair<TreeNode,Integer>(temp.right, tempDepth + 1));
    //         }
    //     }
    //     return depth;
        
    // }

    // public static int maxDepth(TreeNode root) {

    //     if (root == null) return 0;
    //     else {
    //         int leftHeight = maxDepth(root.left);
    //         int rightHeight = maxDepth(root.right);
            
    //         return Math.max(leftHeight, rightHeight) + 1;
    //     }

    // }

}
