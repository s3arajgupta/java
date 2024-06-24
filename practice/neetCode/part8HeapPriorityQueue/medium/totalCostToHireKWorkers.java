package practice.neetCode.part8HeapPriorityQueue.medium;

import java.util.PriorityQueue;

public class totalCostToHireKWorkers {

    public static void main(String[] args) {

        // int[] costs = { 17, 12, 10, 2, 7, 2, 11, 20, 8 };
        // System.out.println(totalCost(costs, 3, 4));
        // int[] costs = { 1, 2, 4, 1 };
        // System.out.println(totalCost(costs, 3, 3));
        int[] costs = { 31, 25, 72, 79, 74, 65, 84, 91, 18, 59, 27, 9, 81, 33, 17, 58 };
        System.out.println(totalCost(costs, 11, 2));

    }

    public static long totalCost(int[] costs, int k, int candidates) {

        PriorityQueue<Integer> minHeapCandidatesFromFirst = new PriorityQueue<>();
        PriorityQueue<Integer> minHeapCandidatesFromLast = new PriorityQueue<>();

        int l = 0, r = costs.length - 1;
        int sum = 0;

        while (k > 0) {

            while (minHeapCandidatesFromFirst.size() < candidates && l <= r)
                minHeapCandidatesFromFirst.add(costs[l++]);

            while (minHeapCandidatesFromLast.size() < candidates && l <= r)
                minHeapCandidatesFromLast.add(costs[r--]);

            if (!minHeapCandidatesFromFirst.isEmpty()
                    && (minHeapCandidatesFromFirst.peek() <= minHeapCandidatesFromLast.peek())) {
                sum += minHeapCandidatesFromFirst.poll();
            } else {
                sum += minHeapCandidatesFromLast.poll();
            }
            System.out.println(minHeapCandidatesFromFirst);
            System.out.println(minHeapCandidatesFromLast);

            k--;
        }

        return sum;

    }

}

// class Solution {
// public long totalCost(int[] costs, int k, int candidates) {

// Queue<Integer> pql = new PriorityQueue<>(), pqr = new PriorityQueue<>();
// int p = 0, q = costs.length - 1;
// for (int i = 0; i < candidates && p <= q; i++)
// pql.add(costs[p++]);

// for (int i = 0; i < candidates && p <= q; i++)
// pqr.add(costs[q--]);

// long total = 0;
// while (k-- > 0) {
// if (pqr.isEmpty() ||( !pql.isEmpty() && pql.peek() <= pqr.peek()) ){
// total += pql.poll();
// if (p <= q) pql.add(costs[p++]);
// } else {
// total += pqr.poll();
// if (p <= q) pqr.add(costs[q--]);
// }
// }
// return total;
// }
// }