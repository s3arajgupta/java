package practice.neetCode.part6LinkedList.hard;

import modules.ListNode;

public class reverseNodesInKGroup {

    public static void main(String[] args) {

        ListNode root5 = new ListNode(5);
        ListNode root4 = new ListNode(4, root5);
        ListNode root3 = new ListNode(3, root4);
        ListNode root2 = new ListNode(2, root3);
        ListNode root1 = new ListNode(1, root2);

        ListNode res = reverseKGroup(root1, 2);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }

    }

    public static ListNode reverseKGroup(ListNode head, int k) {

        if (k == 1)
            return head;

        final ListNode root = new ListNode(0, head);
        ListNode groupPrev = root, groupNext = null;

        while (true) {
            ListNode kth = getKth(groupPrev, k);
            if (kth == null)
                break;
            groupNext = kth.next;

            // reverse the group
            ListNode prev = kth.next, curr = groupPrev.next, temp;
            while (curr != groupNext) {
                temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            temp = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = temp;

        }

        return root.next;

    }

    public static ListNode getKth(ListNode curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }
}
