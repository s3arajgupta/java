package practice.leetcode75;

public class oddEvenLinkedList {

    public static void main(String[] args) {

        // ListNode node5 = new ListNode(5, null);
        // ListNode node4 = new ListNode(4, node5);
        // ListNode node3 = new ListNode(3, node4);
        // ListNode node2 = new ListNode(2, node3);
        // ListNode node1 = new ListNode(1, node2);
        
        ListNode node4 = new ListNode(4, null);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        // ListNode node3 = new ListNode(3, null);
        // ListNode node2 = new ListNode(2, node3);
        // ListNode node1 = new ListNode(1, node2);

        // ListNode node2 = new ListNode(2, null);
        // ListNode node1 = new ListNode(1, node2);
        
        // ListNode node1 = new ListNode(1, null);

        ListNode res = oddEvenList(node1);

        while (res != null) {
            System.out.print(res.val + "->");
            res = res.next;
        }
        
    }

    public static ListNode oddEvenList(ListNode head) {

        if (head == null) return head;
        
        final ListNode root = new ListNode();
        root.next = head;
        
        final ListNode newRoot = new ListNode();
        ListNode newHead = head;

        if (head.next != null) {
            newHead = head.next;
            newRoot.next = newHead;
        }
        else return root.next;

        ListNode headNext, newHeadNext;
        while (newHead.next != null && newHead.next.next != null) {

            headNext = head.next.next;
            newHeadNext = newHead.next.next;
            head.next = headNext;
            newHead.next = newHeadNext;

            head = headNext;
            newHead = newHeadNext;

        }

        if (head.next.next != null) {
            headNext = head.next.next;
            head.next = headNext;
            head = headNext;
        }
        newHead.next = null;
        head.next = newRoot.next;

        return root.next;
        
    }

    // Different Program // alternating linked list from the middle

    // public static ListNode oddEvenList(ListNode head) {

    //     final ListNode root = new ListNode();
    //     root.next = head;
    //     ListNode slow = head, fast = head.next;

    //     while (fast != null && fast.next != null) {

    //         slow = slow.next;
    //         fast = fast.next.next;
            
    //     }

    //     ListNode newHead = slow.next;
    //     slow.next = null;

    //     ListNode headNext, newHeadNext;
    //     while (head != null && newHead != null){

    //         headNext = head.next;
    //         newHeadNext = newHead.next;
    //         head.next = newHead;
    //         newHead.next = headNext;

    //         head = headNext;
    //         newHead = newHeadNext;

    //     }
        
    //     return root.next;
        
    // }
    
}
