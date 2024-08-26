package practice.neetCode150.part6LinkedList.medium;

import modules.ListNode;

public class addTwoNumbers {

    public static void main(String[] args) {

        addTwoNumbers sol = new addTwoNumbers();

        // ListNode node3 = new ListNode(3, null);
        // ListNode node2 = new ListNode(4, node3);
        // ListNode node1 = new ListNode(2, node2);
        // ListNode node6 = new ListNode(9, null);
        // ListNode node5 = new ListNode(6, node6);
        // ListNode node4 = new ListNode(5, node5);
        // ListNode res = sol.addTwoNumbersFunc(node1, node4);

        ListNode node4 = new ListNode(9, null);
        ListNode node3 = new ListNode(9, node4);
        ListNode node2 = new ListNode(9, node3);
        ListNode node1 = new ListNode(9, node2);
        ListNode node5 = new ListNode(9, null);
        ListNode res = sol.addTwoNumbersFunc(node1, node5);

        res.printLinkedList(res);

    }

    public ListNode addTwoNumbersFunc(ListNode l1, ListNode l2) {

        int carry = 0;
        ListNode prev = null, res = null;

        while (l1 != null && l2 != null) {

            res = new ListNode((l1.val + l2.val + carry) % 10, prev);
            prev = res;
            carry = (l1.val + l2.val + carry) / 10;

            l1 = l1.next;
            l2 = l2.next;

        }

        while (l1 != null) {

            res = new ListNode((l1.val + carry) % 10, prev);
            prev = res;
            carry = (l1.val + carry) / 10;
            l1 = l1.next;

        }

        while (l2 != null) {

            res = new ListNode((l2.val + carry) % 10, prev);
            prev = res;
            carry = (l2.val + carry) / 10;
            l2 = l2.next;

        }

        if (carry == 1)
            res = new ListNode(carry, prev);

        return res.reverseList(res);

    }

}
