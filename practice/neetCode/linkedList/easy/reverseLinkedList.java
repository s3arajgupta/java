/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */


package practice.neetCode.linkedList.easy;

import java.util.*;

import practice.neetCode.linkedList.ListNode;

public class reverseLinkedList {


    public static void main (String args[]) {

        // Insertion at 1st index
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = null;

        ListNode curr = node1;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }

        System.out.println("rev ");
        ListNode rev = reverseList(node1);        
        while (rev != null) {
            System.out.print(rev.val + " ");
            rev = rev.next;
        }

    }

    public static ListNode reverseList (ListNode head) {

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
