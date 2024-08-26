package practice.neetCode150.part6LinkedList.hard;

import modules.ListNode;
// import java.util.PriorityQueue;

public class MergekSortedLists {

    public static void main(String[] args) {

        MergekSortedLists sol = new MergekSortedLists();

        ListNode root3 = new ListNode(5);
        ListNode root2 = new ListNode(4, root3);
        ListNode root1 = new ListNode(1, root2);
        ListNode root6 = new ListNode(4);
        ListNode root5 = new ListNode(3, root6);
        ListNode root4 = new ListNode(1, root5);
        ListNode root7 = new ListNode(6);
        ListNode root8 = new ListNode(2, root7);

        ListNode[] lists = new ListNode[] { root1, root4, root8 };
        ListNode res = sol.mergeKLists(lists);
        res.printLinkedList(res);

    }

    // PriorityQueue
    // public ListNode mergeKLists(ListNode[] lists) {

    // PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) ->
    // Integer.compare(a.val, b.val));

    // for (ListNode tempHead : lists) {

    // if (tempHead != null)
    // minHeap.add(tempHead);

    // }

    // final ListNode root = new ListNode();
    // ListNode curr = root;

    // while (!minHeap.isEmpty()) {

    // ListNode node = minHeap.poll();
    // curr.next = node;
    // curr = curr.next;

    // if (node.next != null)
    // minHeap.add(node.next);

    // }

    // return root.next;

    // }

    // Divide and Conquer
    public ListNode mergeKLists(ListNode[] lists) {

        int size = lists.length;

        if (lists == null || size == 0)
            return null;

        int i = 0, interval = 1;

        while (interval < size) {

            i = 0;

            while (i + interval < size) {

                lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
                // lists[i].printLinkedList(lists[i]);
                i = i + 2 * interval;

            }

            interval = interval * 2;

        }

        return size > 0 ? lists[0] : null;

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        final ListNode root = new ListNode(-1);
        ListNode curr = root;

        while (list1 != null && list2 != null) {

            if (list1.val < list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }

            curr = curr.next;

        }

        curr.next = (list1 != null) ? list1 : list2;

        return root.next;

    }

}
