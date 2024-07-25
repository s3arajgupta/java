// import java.util.PriorityQueue;
// import java.util.Collections;

// // Create a PriorityQueue with a custom comparator to obtain the largest element
// PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

// // Add elements to the maxHeap
// maxHeap.offer(10);
// maxHeap.offer(5);
// maxHeap.offer(20);

// // Obtain the largest element without removing it
// int largest = maxHeap.peek();
// System.out.println("Largest element: " + largest); // Output: 20

// // Alternatively, if you want to retrieve and remove the largest element
// largest = maxHeap.poll();
// System.out.println("Largest element (after poll): " + largest); // Output: 20

// PriorityQueue<Integer> minHeap = new PriorityQueue<>();
// // Add elements to the minHeap
// // ...
// List<Integer> tempList = new ArrayList<>(minHeap);
// Collections.reverse(tempList);
// int largest = tempList.get(0); // Largest element

package practice.neetCode150.part8HeapPriorityQueue.easy;

import java.util.Collections;
import java.util.PriorityQueue;

public class lastStoneWeight {

    public static void main(String[] args) {

        // int[] stones = { 2, 7, 4, 1, 8, 1 };
        // int[] stones = { 1 };
        int[] stones = { 2, 2 };
        System.out.println(lastStoneWeightFunc(stones));

    }

    public static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    public static int lastStoneWeightFunc(int[] stones) {

        for (int i : stones)
            maxHeap.add(i);

        recur();

        return maxHeap.peek();

    }

    public static void recur() {

        // System.out.println(maxHeap);

        if (maxHeap.size() == 1)
            return;

        int x = maxHeap.poll();
        int y = maxHeap.poll();

        int collide = x == y ? 0 : x - y;

        if (collide != 0)
            maxHeap.add(collide);
        else
            maxHeap.add(0);

        recur();

    }

}
