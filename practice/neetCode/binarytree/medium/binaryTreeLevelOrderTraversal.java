package practice.neetCode.binarytree.medium;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import modules.TreeNode;

public class binaryTreeLevelOrderTraversal {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(levelOrder(root));
        
    }

    public static List<List<Integer>> levelOrder (TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);

        while (deque.size() != 0) { //ninja
            List<Integer> lvl = new ArrayList<>();
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.removeFirst();
                if (node.left != null) deque.add(node.left);
                if (node.right != null) deque.add(node.right);
                lvl.add(node.val);
            }
            res.add(lvl);
        }
        
        return res;
    }
    
}
