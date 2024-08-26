package practice.neetCode150.part7Binarytree.medium;

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

        if (root == null)
            return new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();

        deque.add(root);

        while (deque.size() != 0) {

            int size = deque.size();

            for (int i = 0; i < size; i++) {

                TreeNode node = deque.removeFirst();

                if (i == size - 1)
                    list.add(node.val);
                if (node.left != null)
                    deque.add(node.left);
                if (node.right != null)
                    deque.add(node.right);

            }

        }

        return list;

    }

}
