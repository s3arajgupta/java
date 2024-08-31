package practice.neetCode150.part6LinkedList.medium;

import java.util.HashMap;

class Node {

    int val;
    Node next;
    Node random;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }

    public Node(int val, Node next, Node random) {
        this.val = val;
        this.next = next;
        this.random = random;
    }

    public void printLinkedList(Node node) {

        while (node.next != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.print(node.val);
        System.out.println();

    }

}

public class copyListWithRandomPointer {

    public static void main(String[] args) {

        copyListWithRandomPointer sol = new copyListWithRandomPointer();

        Node node4 = new Node(1, null);
        Node node3 = new Node(10, node4);
        Node node2 = new Node(11, node3);
        Node node1 = new Node(13, node2);
        Node node0 = new Node(7, node1);

        node4.random = node0;
        node3.random = node2;
        node2.random = node4;
        node1.random = node0;
        node0.random = null;

        Node res = sol.copyRandomList(node0);
        res.printLinkedList(res);

    }

    public Node copyRandomList(Node head) {

        HashMap<Node, Node> old = new HashMap<>();

        Node curr = head;

        while (curr != null) {

            Node copyTemp = new Node(curr.val);
            old.put(curr, copyTemp);

            curr = curr.next;

        }

        curr = head;

        while (curr != null) {

            Node copy = old.get(curr);
            copy.next = old.get(curr.next);
            copy.random = old.get(curr.random);

            curr = curr.next;

        }

        return old.get(head);

    }

}