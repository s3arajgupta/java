package practice.neetCode.linkedList.hard;

import modules.ListNode;
import java.util.*;

public class MergekSortedLists {

    public static void main(String[] args) {

        // List<List<Integer>> lists = new ArrayList<>();
        // lists.add(Arrays.asList(1, 4, 5));
        // lists.add(Arrays.asList(1, 3, 4));
        // lists.add(Arrays.asList(2, 6));

        ListNode root5 = new ListNode(5);
        ListNode root4 = new ListNode(4, root5);
        ListNode root1 = new ListNode(1, root4);

        ListNode root6 = new ListNode(6);
        ListNode root3 = new ListNode(3, root6);
        ListNode root2 = new ListNode(2, root3);

        ListNode[] lists = new ListNode[] { root2, root1 };
        ListNode res = mergeKLists(lists);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }

    }

    public static ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        final ListNode root = new ListNode();
        ListNode head = root;

        for (ListNode tempHead : lists) {

            while (tempHead != null) {
                minHeap.add(tempHead.val);
                tempHead = tempHead.next;
            }

        }
        System.out.println("minHeap " + minHeap);

        while (!minHeap.isEmpty()) {
            ListNode node = new ListNode(minHeap.poll());
            head.next = node;
            head = head.next;
        }

        return root.next;

    }
}
