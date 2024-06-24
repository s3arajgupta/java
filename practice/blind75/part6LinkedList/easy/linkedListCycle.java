// proof ?

package practice.blind75.part6LinkedList.easy;

import modules.ListNode;

public class linkedListCycle {

    public static void main(String[] args) {

        ListNode node1 = new ListNode(3, null);
        ListNode node2 = new ListNode(2, node1);
        ListNode node3 = new ListNode(0, node2);
        ListNode node4 = new ListNode(-4, node3);
        node1.next = node4;

        System.out.println(hasCycle(node4));

    }

    public static boolean hasCycle(ListNode head) {

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow)
                return true;
        }

        return false;

    }

}
