package practice.neetCode.part6LinkedList.medium;

import modules.ListNode;

public class removeNthNodeFromEndofList {

    public static void main(String[] args) {

        ListNode node1 = new ListNode(5, null);
        ListNode node2 = new ListNode(4, node1);
        // ListNode node3 = new ListNode(3, node2);
        // ListNode node4 = new ListNode(2, node3);
        // ListNode node5 = new ListNode(1, node4);
        
        ListNode res = removeNthFromEnd(node2, 2);

        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
        
    }

    public static ListNode removeNthFromEnd (ListNode head, int n) {

        final ListNode root = new ListNode(0, head);
        // root.next = head;
        ListNode left = root;
        ListNode right = left.next;

        if (left.next.next == null){
            // System.out.println("if");
            return left.next.next;
        }
        else {
            // System.out.println("else");
            right = left.next.next;
        }
        
        // System.out.println(left.val);
        // System.out.println(right.val);
        
        int l = 0, r = 2;
        while (right != null) {
            if (r - l > n) {
                left = left.next;
                l++;
            }
            right = right.next;
            r++;
        }
        // System.out.println(left.val);
        // System.out.println(right.val);

        ListNode tempNode = left.next.next;
        left.next = tempNode;

        // return new ListNode();
        return root.next;
        
    }
    
}
