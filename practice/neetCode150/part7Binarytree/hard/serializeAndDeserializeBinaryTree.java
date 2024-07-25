// Brainstrom BFS

package practice.neetCode150.part7Binarytree.hard;

import modules.TreeNode;
import java.util.*;

public class serializeAndDeserializeBinaryTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        serializeAndDeserializeBinaryTree ser = new serializeAndDeserializeBinaryTree();
        serializeAndDeserializeBinaryTree deser = new serializeAndDeserializeBinaryTree();
        TreeNode ans = deser.deserialize(ser.serialize(root));
        printTree(ans);
    }

    public static void printTree(TreeNode root) {

        System.out.println("Output");
        if (root == null)
            return;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.removeFirst();
                System.out.print(node.val + " ");
                if (node.left != null)
                    deque.add(node.left);
                if (node.right != null)
                    deque.add(node.right);
            }
            System.out.println();
        }
    }

    private int i;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if (root == null)
            return "";
        List<String> list = new ArrayList<>();
        serializeDFS(root, list);

        return String.join("#", list);

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

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if (data == null || data.isEmpty()) {
            System.out.println("*" + data + "*");
            return null;
        }

        String parts[] = data.split("#"); // ninja
        if (parts.length == 0)
            return new TreeNode();
        i = 0; // resets i before calling again.
        return deserializeDFS(parts);

    }

    public TreeNode deserializeDFS(String[] parts) {

        if (i >= parts.length){
            System.out.println("*" + parts.length + "*");
            System.out.println("*" + i + "*");
            return null;
        }

        String part = parts[this.i];

        if (part.equals("N")) { // ninja
            this.i++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(part));
        this.i++; // ninja
        node.left = deserializeDFS(parts);
        node.right = deserializeDFS(parts);

        return node;
    }

    // // Encodes a tree to a single string.
    // public String serialize(TreeNode root) {

    // if (root == null)
    // return "";

    // StringBuilder res = new StringBuilder();
    // Deque<TreeNode> deque = new LinkedList<>();
    // deque.add(root);

    // while (!deque.isEmpty()) {
    // int size = deque.size();
    // for (int i = 0; i < size; i++) {
    // TreeNode node = deque.removeFirst();
    // res.append(String.valueOf(node.val) + "#");
    // if (node.left != null)
    // deque.add(node.left);
    // else
    // res.append("N#");
    // if (node.right != null)
    // deque.add(node.right);
    // else
    // res.append("N#");
    // }
    // System.out.println(res);
    // }

    // return res.toString();

    // }

    // // Decodes your encoded data to tree.
    // public TreeNode deserialize(String data) {

    // String parts[] = data.split("#"); // ninja
    // if (parts.length == 0)
    // return new TreeNode();

    // Deque<String> deque = new LinkedList<>();
    // deque.add(parts[0]);
    // int c = 0;
    // while (!deque.isEmpty()) {
    // int size = deque.size();
    // for (int i = 0; i < size; i++) {
    // TreeNode node = new TreeNode(Integer.parseInt(parts[c]));
    // }
    // }

    // return new TreeNode();

    // }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));