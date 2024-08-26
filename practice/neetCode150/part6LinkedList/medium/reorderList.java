package practice.neetCode150.part6LinkedList.medium;

import modules.ListNode;

public class reorderList {

    public static void main(String[] args) {

        reorderList sol = new reorderList();

        ListNode node1 = new ListNode(5, null);
        ListNode node2 = new ListNode(4, node1);
        ListNode node3 = new ListNode(3, node2);
        ListNode node4 = new ListNode(2, node3);
        ListNode node5 = new ListNode(1, node4);
        sol.reorderListFunc(node5);
        sol.reorderListFunc(node4);
        sol.reorderListFunc(node2);

    }

    public ListNode reverse(ListNode curr) {

        ListNode prev = null, next = null;

        while (curr != null) {

            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

        }

        return prev;

    }

    public void reorderListFunc(ListNode head) {

        final ListNode root = head;
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode head2 = slow.next;
        slow.next = null;
        head2 = reverse(head2);

        ListNode nexthead1 = null, nexthead2 = null;

        while (head2 != null) {

            nexthead1 = head.next;
            nexthead2 = head2.next;

            head.next = head2;
            head2.next = nexthead1;

            head = nexthead1;
            head2 = nexthead2;

        }

        root.printLinkedList(root);

    }

}
