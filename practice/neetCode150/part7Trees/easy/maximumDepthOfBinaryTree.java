package practice.neetCode150.part7Trees.easy;

import java.util.*;
import modules.*;

public class maximumDepthOfBinaryTree {

    public static void main(String args[]) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(maxDepth(root));

    }

    public static int maxDepth(TreeNode root) {

        if (root == null)
            return 0;

        Deque<TreeNode> deque = new LinkedList<>();
        int lvl = 0, size = 0;

        deque.add(root);

        while (!deque.isEmpty()) {

            size = deque.size();

            for (int i = 0; i < size; i++) {

                TreeNode node = deque.removeFirst();

                if (node.left != null)
                    deque.add(node.left);
                if (node.right != null)
                    deque.add(node.right);

            }

            lvl += 1;

        }

        return lvl;

    }

    // public static int maxDepth(TreeNode root) {

    //     if (root == null)
    //         return 0;

    //     Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
    //     int lvl = 0;

    //     stack.add(new Pair<TreeNode, Integer>(root, 1));

    //     while (!stack.isEmpty()) {

    //         Pair<TreeNode, Integer> p = stack.pop();
    //         TreeNode temp = p.getFirst();
    //         int tempDepth = p.getSecond();

    //         if (temp != null) {

    //             lvl = Math.max(lvl, tempDepth);
    //             stack.add(new Pair<TreeNode, Integer>(temp.left, tempDepth + 1));
    //             stack.add(new Pair<TreeNode, Integer>(temp.right, tempDepth + 1));

    //         }

    //     }

    //     return lvl;

    // }

    // public static int maxDepth(TreeNode root) {

    //     if (root == null)
    //         return 0;

    //     int leftHeight = maxDepth(root.left);
    //     int rightHeight = maxDepth(root.right);

    //     return Math.max(leftHeight, rightHeight) + 1;

    // }

}
