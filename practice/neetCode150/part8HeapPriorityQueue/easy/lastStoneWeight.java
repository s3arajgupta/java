package practice.neetCode150.part8HeapPriorityQueue.easy;

import java.util.*;

public class lastStoneWeight {

    public static void main(String[] args) {

        lastStoneWeight sol = new lastStoneWeight();

        int[] stones = { 2, 7, 4, 1, 8, 1 };
        System.out.println(sol.lastStoneWeightFunc(stones));

    }

    PriorityQueue<Integer> maxHeap;

    public int lastStoneWeightFunc(int[] stones) {

        maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i : stones)
            maxHeap.add(i);

        recur();

        return maxHeap.peek();

    }

    public void recur() {

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
