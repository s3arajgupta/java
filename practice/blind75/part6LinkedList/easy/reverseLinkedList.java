// Recursion version is left ?

package practice.blind75.part6LinkedList.easy;

import modules.ListNode;

public class reverseLinkedList {

    public static void main(String args[]) {

        ListNode node3 = new ListNode(3, null);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        ListNode curr = node1;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }

        System.out.println();
        curr = reverseList(node1);
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }

    }

    public static ListNode reverseList(ListNode head) {

        ListNode curNode = head, nextNode = null, prevNode = null;
        while (curNode != null) {
            nextNode = curNode.next;
            curNode.next = prevNode;
            prevNode = curNode;
            curNode = nextNode;
        }
        return prevNode;

    }

}
