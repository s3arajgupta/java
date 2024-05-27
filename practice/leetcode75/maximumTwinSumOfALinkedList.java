package practice.leetcode75;

public class maximumTwinSumOfALinkedList {

    public static void main(String[] args) {

        // ListNode node5 = new ListNode(5, null);
        // ListNode node4 = new ListNode(4, node5);
        // ListNode node3 = new ListNode(3, node4);
        // ListNode node2 = new ListNode(2, node3);
        // ListNode node1 = new ListNode(1, node2);
        
        // ListNode node4 = new ListNode(1, null);
        // ListNode node3 = new ListNode(2, node4);
        // ListNode node2 = new ListNode(4, node3);
        // ListNode node1 = new ListNode(5, node2);
        
        ListNode node4 = new ListNode(3, null);
        ListNode node3 = new ListNode(2, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(4, node2);

        // ListNode node2 = new ListNode(10000, null);
        // ListNode node1 = new ListNode(1, node2);
        
        // ListNode node1 = new ListNode(1, null);

        System.out.println(pairSum(node1));

    }

    public static ListNode reverse(ListNode head) {

        ListNode prev = null, next= head;

        while (head != null) {

            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
            
        }

        return prev;

    }

    public static int pairSum (ListNode head) {
        
        final ListNode root = new ListNode();
        root.next = head;

        ListNode slow = head, fast = head.next;

        while (fast != null && fast.next != null) { // Understand difference between different types of slow and fast pointer
            slow = slow.next;
            fast = fast.next.next;
        }
        // System.out.println(slow.val);

        ListNode newRoot = slow.next;
        slow.next = null;

        ListNode reverse = reverse(newRoot);

        int max = Integer.MIN_VALUE;
        head = root.next;
        while (head != null) {
            max = Math.max(max, head.val + reverse.val);
            head = head.next;
            reverse = reverse.next;
        }
        
        return max;
    }
    
}
