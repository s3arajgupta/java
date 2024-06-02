package practice.neetCode.linkedList.medium;

import modules.ListNode;

public class reorderList {

    public static void main(String[] args) {
        
        ListNode node1 = new ListNode(5, null);
        ListNode node2 = new ListNode(4, node1);
        ListNode node3 = new ListNode(3, node2);
        ListNode node4 = new ListNode(2, node3);
        ListNode node5 = new ListNode(1, node4);

        // while (node5 != null) {
        //     System.out.print(node5.val);
        //     node5 = node5.next;
        // }

        reorderListFunc(node5);
        reorderListFunc(node4);
        reorderListFunc(node2);
        
    }

    public static ListNode reverse (ListNode head) {

        ListNode prev = null;
        ListNode next;

        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;

    }

    public static void reorderListFunc (ListNode head) {

        final ListNode root = head;
        ListNode slow = head, fast = slow.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // System.out.println("slow.val " + slow.val);
        // System.out.println("fast.val " + fast.val);

        ListNode medium = slow.next;
        // System.out.println("medium " + slow.next.val);
        slow.next = null;
        ListNode reverse = reverse(medium);
        // System.out.println("reverse " + reverse.val);
        // System.out.println("reverse " + reverse.next.val);

        ListNode nexthead, nextreverse = head;
        while (reverse != null) {
            nexthead = head.next;
            nextreverse = reverse.next;

            head.next = reverse;
            reverse.next = nexthead;
            head = nexthead;
            reverse = nextreverse;
        }
        

        head = root;
        // System.out.print("test: ");
        // while (head != null) {
        //     System.out.print(head.val);
        //     head = head.next;
        // }
        // System.out.println();
        
    }
    
}
