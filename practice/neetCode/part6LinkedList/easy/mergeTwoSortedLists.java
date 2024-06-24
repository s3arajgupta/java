// Recursion version is left

package practice.neetCode.part6LinkedList.easy;

import modules.ListNode;

public class mergeTwoSortedLists {

    public static void main(String[] args) {

        ListNode node1 = new ListNode(4, null);
        ListNode node2 = new ListNode(2, node1);
        ListNode node3 = new ListNode(1, node2);
        ListNode node4 = new ListNode(4, null);
        ListNode node5 = new ListNode(3, node4);
        ListNode node6 = new ListNode(1, node5);

        ListNode list1 = node3;
        ListNode list2 = node6;
        // while (node3 != null) {
        //     System.out.print(node3.val + " ");
        //     node3 = node3.next;
        // }
        // System.out.println();
        // while (node6 != null) {
        //     System.out.print(node6.val + " ");
        //     node6 = node6.next;
        // }
            
        ListNode res = new ListNode();
        res = mergeTwoLists(list1, list2);

        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
        
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2){

        final ListNode root = new ListNode();
        ListNode prev = root;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                prev.next = list1;
                list1 = list1.next;
            }
            else {
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;
        }

        prev.next = (list1 != null) ? list1 : list2;        

        return root.next;

    }
}
