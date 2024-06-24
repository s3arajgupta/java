package practice.neetCode.part8HeapPriorityQueue.medium;

import java.util.*;

public class kClosestPointsToOrigin {

    public static void main(String[] args) {

        int[][] points = { { 1, 3 }, { -2, 2 }, { 4, 5 } };
        // int[][] points = { { 1, 0 }, { 0, 1 } };

        int[][] res = kClosest(points, 2);
        for (int[] i : res)
            for (int j : i)
                System.out.print(j + " ");

    }

    public static int[][] kClosest(int[][] points, int k) {

        // PriorityQueue<int[]> maxHeap = new PriorityQueue<>();
        // PriorityQueue<Pair<Integer, Integer>> maxHeap = new
        // PriorityQueue<>();
        // PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
        // (a, b) -> Integer.compare((a[0] * a[0] + a[1] * a[1]), (b[0] * b[0] + b[1] *
        // b[1]))); // ninja
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                Collections.reverseOrder((a, b) -> Integer.compare((a[0] * a[0] + a[1] *
                        a[1]), (b[0] * b[0] + b[1] * b[1])))); // ninja
        // System.out.println("maxHeap " + maxHeap);

        for (int[] i : points) {

            maxHeap.add(i);
            if (maxHeap.size() > k)
                maxHeap.poll();

        }
        // System.out.println(maxHeap);
        int[][] res = new int[k][2];
        // int[] curr = new int[2]; // Avoid Creating New Arrays Inside the Loop
        // for (int i = 0; i < k; i++) {
        // curr = maxHeap.poll();
        // res[i][0] = curr[0];
        // res[i][1] = curr[1];
        // System.out.println(res[i][0] + " " + res[i][1]);
        // }

        int i = 0;
        while (!maxHeap.isEmpty()) {
            res[i++] = maxHeap.poll();
        }

        return res;

    }

}
