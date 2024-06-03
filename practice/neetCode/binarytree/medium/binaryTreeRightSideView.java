package practice.neetCode.binarytree.medium;

import java.util.*;

import modules.TreeNode;

public class binaryTreeRightSideView {

    public static void main(String args[]) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(15);
        root.right = new TreeNode(70);
        root.right.right = new TreeNode(4);

        System.out.println(rightSideView(root));

    }

    public static List<Integer> rightSideView(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        if (root == null)
            return list;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);

        while (deque.size() != 0) {
            int size = deque.size();
            TreeNode node = new TreeNode();
            for (int i = 0; i < size; i++) {
                node = deque.removeFirst();
                if (node.left != null)
                    deque.add(node.left);
                if (node.right != null)
                    deque.add(node.right);
            }
            list.add(node.val);
            // System.out.println(list);

        }

        return list;

    }

}
