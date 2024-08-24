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
