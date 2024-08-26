package practice.neetCode150.part8HeapPriorityQueue.medium;

import java.util.*;

public class kClosestPointsToOrigin {

    public static void main(String[] args) {

        int[][] points = { { 1, 3 }, { -2, 2 }, { 4, 5 } };
        // int[][] points = { { 1, 0 }, { 0, 1 } };

        int[][] res = kClosest(points, 2);
        for (int[] i : res)
            System.out.println(Arrays.toString(i));

    }

    public static int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                Collections.reverseOrder((a, b) -> Integer.compare((a[0] * a[0] + a[1] *
                        a[1]), (b[0] * b[0] + b[1] * b[1]))));

        for (int[] i : points) {

            maxHeap.add(i);

            if (maxHeap.size() > k)
                maxHeap.poll();

        }

        return maxHeap.toArray(new int[][] {});

    }

}
