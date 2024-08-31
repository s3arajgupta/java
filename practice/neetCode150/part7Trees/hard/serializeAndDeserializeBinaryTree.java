package practice.neetCode150.part7Trees.hard;

import java.util.*;
import modules.TreeNode;

public class serializeAndDeserializeBinaryTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        serializeAndDeserializeBinaryTree obj = new serializeAndDeserializeBinaryTree();

        System.out.println(obj.serialize(root));
        TreeNode ans = obj.deserialize(obj.serialize(root));
        ans.printTree(ans);

    }

    public String serialize(TreeNode root) {

        if (root == null)
            return "";

        List<String> list = new ArrayList<>();
        serializeDFS(root, list);

        // list = new ArrayList<>();
        // serializeBFS(root, list);

        return String.join(",", list);

    }

    public void serializeDFS(TreeNode root, List<String> list) {

        if (root == null) {

            list.add("N");
            return;

        }

        list.add(String.valueOf(root.val));

        serializeDFS(root.left, list);
        serializeDFS(root.right, list);

    }

    public void serializeBFS(TreeNode root, List<String> list) {

        if (root == null)
            return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();

            if (node == null) {

                list.add("N");
                continue;

            }

            list.add(String.valueOf(node.val));

            queue.add(node.left);
            queue.add(node.right);

        }

    }

    int n;

    public TreeNode deserialize(String str) {

        if (str == null || str.isEmpty())
            return null;

        String parts[] = str.split(",");

        this.n = 0;

        return deserializeDFS(parts);
        // return deserializeBFS(parts);

    }

    public TreeNode deserializeDFS(String[] parts) {

        if (parts.length <= n)
            return null;

        String part = parts[this.n];

        if (part.equals("N")) {

            this.n++;
            return null;

        }

        TreeNode node = new TreeNode(Integer.parseInt(part));
        this.n++;

        node.left = deserializeDFS(parts);
        node.right = deserializeDFS(parts);

        return node;

    }

    public TreeNode deserializeBFS(String[] parts) {

        if (parts.length == 0)
            return null;

        TreeNode root = new TreeNode(Integer.parseInt(parts[0]));

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;

        while (!queue.isEmpty() && i < parts.length) {

            TreeNode node = queue.poll();

            if (!parts[i].equals("N")) {

                node.left = new TreeNode(Integer.parseInt(parts[i]));
                queue.add(node.left);

            }
            i++;

            if (i < parts.length && !parts[i].equals("N")) {

                node.right = new TreeNode(Integer.parseInt(parts[i]));
                queue.add(node.right);

            }
            i++;

        }

        return root;

    }

}
