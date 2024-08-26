package practice.neetCode150.part6LinkedList.easy;

import modules.ListNode;

public class reverseLinkedList {

    public static void main(String args[]) {

        reverseLinkedList sol = new reverseLinkedList();

        ListNode node3 = new ListNode(3, null);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        node1.printLinkedList(node1);
        node1 = sol.reverseList(node1);
        // node1 = node1.reverseList(node1);
        node1.printLinkedList(node1);

    }

    public ListNode reverseList(ListNode head) {

        return dfs(head, null);

    }

    public ListNode dfs(ListNode node, ListNode prev) {

        if (node == null)
            return prev;

        ListNode nextNode = node.next;
        node.next = prev;

        return dfs(nextNode, node);

    }

}
