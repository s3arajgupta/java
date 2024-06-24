package practice.blind75.part6LinkedList.medium;
// package practice.neetCode.linkedList.medium;

// import java.util.HashMap;

// import practice.neetCode.linkedList.ListNode;

// // Definition for a Node.
// class Node {
//     int val;
//     ListNode next;
//     ListNode random;

//     public Node(int val) {
//         this.val = val;
//         this.next = null;
//         this.random = null;
//     }
//     public Node(int val, ListNode next, ListNode random) {
//         this.val = val; this.next = next; this.random = random;
//     }
// }

// public class copyListWithRandomPointer {

//     public Node copyRandomList(Node head) {

//         Node curr = head;
//         HashMap<Node, Node> oldToCopy = new HashMap<>();
//         // oldToCopy.put(null, null); // no need in java, by default it is null

//         while (curr != null) {
//             Node newNode = new Node(curr.val);
//             oldToCopy.put(curr, newNode);
//             curr = curr.next;
//         }
        
//         curr = head;
//         while (curr != null){
//             oldToCopy.get(curr).next = oldToCopy.get(curr.next);
//             oldToCopy.get(curr).random = oldToCopy.get(curr.random);
//             curr = curr.next;
//         }

//         return oldToCopy.get(head);
        
//     }
// }