package practice.neetCode150.part6LinkedList.medium;

import modules.ListNode;

public class removeNthNodeFromEndofList {

    public static void main(String[] args) {

        ListNode node1 = new ListNode(5, null);
        ListNode node2 = new ListNode(4, node1);
        ListNode node3 = new ListNode(3, node2);
        ListNode node4 = new ListNode(2, node3);
        ListNode node5 = new ListNode(1, node4);

        node5.printLinkedList(node5);
        ListNode res = removeNthFromEnd(node5, 2);
        res.printLinkedList(res);

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        final ListNode root = new ListNode(-1, head);
        ListNode slow = root, fast = head;

        for (int i = 0; i < n; i++)
            fast = fast.next;

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        ListNode delNode = slow.next;
        slow.next = slow.next.next;
        delNode.next = null;

        return root.next;

    }

}
