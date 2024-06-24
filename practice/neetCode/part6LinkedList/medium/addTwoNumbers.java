package practice.neetCode.part6LinkedList.medium;

// import java.util.*;

import practice.leetcode75.ListNode;

public class addTwoNumbers {

    public static void main(String[] args) {
        
        // ListNode node3 = new ListNode (3, null);
        // ListNode node2 = new ListNode (4, node3);
        // ListNode node1 = new ListNode (2, node2);
        
        // ListNode node6 = new ListNode (9, null);
        // ListNode node5 = new ListNode (6, node6);
        // ListNode node4 = new ListNode (5, node5);

        // ListNode res = addTwoNumbersFunc(node1, node4);
        // ListNode res = addTwoNumbersFunc(new ListNode(0), new ListNode(0));

        
        ListNode node4 = new ListNode (9, null);
        ListNode node3 = new ListNode (9, node4);
        ListNode node2 = new ListNode (9, node3);
        ListNode node1 = new ListNode (9, node2);
        
        // ListNode node5 = new ListNode (9, null);
        ListNode node6 = new ListNode (8, null);

        ListNode res = addTwoNumbersFunc(node1, node6);

        while (res != null) {
            System.out.print(res.val + "->");
            res = res.next;
        }
        
    }

    public static ListNode reverse(ListNode head) {

        ListNode prev = null, next = null, curr = head;

        while (curr != null) {

            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            
        }

        return prev;
        
    }
    

    public static ListNode addTwoNumbersFunc(ListNode l1, ListNode l2) {

        int carry = 0;
        ListNode prev = null, res = null;
        
        while (l1 != null && l2 != null) {

            res = new ListNode((l1.val + l2.val + carry) % 10, prev);
            prev = res;
            carry = (l1.val + l2.val + carry)/10;

            // System.out.println("res.val " + res.val + " l1.val " + l1.val + " l2.val " + l2.val);
            l1 = l1.next;
            l2 = l2.next;

        }

        while (l1 != null) {
            res = new ListNode((l1.val + carry)%10, prev);
            prev = res;
            carry = (l1.val + carry)/10;
            l1 = l1.next;
        }
        while (l2 != null) {
            res = new ListNode((l2.val + carry)%10, prev);
            prev = res;
            carry = (l2.val + carry)/10;
            l2 = l2.next;
        }

        if (carry == 1) {
            res = new ListNode(carry, prev);
        }
        
        return reverse(res);

    }

    // public static ListNode addTwoNumbersFunc(ListNode l1, ListNode l2) {

    //     ListNode prev = null, res = null, carry = new ListNode(0);
        
    //     while (l1 != null && l2 != null) {

            
    //         if ((l1.val + l2.val + carry.val) > 9) {
    //             res = new ListNode((l1.val + l2.val + carry.val) % 10, prev);
    //             prev = res;
    //             carry.val = 1;
    //         }
    //         else {
    //             if (carry.val == 1) {
    //                 res = new ListNode((l1.val + l2.val + carry.val) % 10, prev);
    //                 prev = res;
    //                 carry.val = 0;
    //             }
    //             else{
    //                 res = new ListNode((l1.val + l2.val + carry.val) % 10, prev);
    //                 prev = res;
    //             }
    //         }

    //         System.out.println("res.val " + res.val + " l1.val " + l1.val + " l2.val " + l2.val);
    //         l1 = l1.next;
    //         l2 = l2.next;

    //     }

    //     while (l1 != null) {
    //         res = new ListNode((l1.val + carry.val)%10, prev);
    //         prev = res;
    //         carry.val = (l1.val + carry.val)/10;
    //         l1 = l1.next;
    //     }
    //     while (l2 != null) {
    //         res = new ListNode((l2.val + carry.val)%10, prev);
    //         prev = res;
    //         carry.val = (l2.val + carry.val)/10;
    //         l2 = l2.next;
    //     }

    //     if (carry.val == 1) {
    //         carry.next = res;
    //         res = carry;
    //     }
        
    //     return reverse(res);

    // }
    
}
