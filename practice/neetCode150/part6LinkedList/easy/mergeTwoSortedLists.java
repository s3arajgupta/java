package practice.neetCode150.part6LinkedList.easy;

import modules.ListNode;

public class mergeTwoSortedLists {

    public static void main(String[] args) {

        ListNode node1 = new ListNode(4, null);
        ListNode node2 = new ListNode(2, node1);
        ListNode node3 = new ListNode(1, node2);
        ListNode node4 = new ListNode(4, null);
        ListNode node5 = new ListNode(3, node4);
        ListNode node6 = new ListNode(1, node5);

        ListNode list1 = node3;
        ListNode list2 = node6;
        list1.printLinkedList(list1);
        list2.printLinkedList(list2);

        ListNode res = mergeTwoLists(list1, list2);
        res.printLinkedList(res);

    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        final ListNode root = new ListNode(-1);
        ListNode curr = root;

        while (list1 != null && list2 != null) {

            if (list1.val < list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }

            curr = curr.next;

        }

        curr.next = (list1 != null) ? list1 : list2;

        return root.next;

    }

}
