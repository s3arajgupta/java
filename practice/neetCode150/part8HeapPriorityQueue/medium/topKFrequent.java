package practice.neetCode150.part8HeapPriorityQueue.medium;

import java.util.*;

public class topKFrequent {

    public static void main(String args[]) {

        int k = 3;
        int[] nums = new int[] { 1, 1, 1, 2, 2, 3, 5, 5 };
        // int[] nums = new int[]{6,6,6,6,6,6};

        System.out.print(Arrays.toString(topKFrequentFunc(nums, k)));

    }

    public static int[] topKFrequentFunc(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        for (Map.Entry<Integer, Integer> x : map.entrySet()) {

            pq.add(x);

            if (pq.size() > k)
                pq.poll();

        }

        int[] topk = new int[k];
        int i = 0;

        while (!pq.isEmpty()) {

            topk[i] = pq.poll().getKey();
            i++;

        }

        return topk;

    }

}
