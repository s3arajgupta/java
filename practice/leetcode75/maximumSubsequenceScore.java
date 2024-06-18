package practice.leetcode75;

import java.util.*;
// import modules.Pair;

public class maximumSubsequenceScore {

    public static void main(String[] args) {

        // int[] nums1 = { 1, 3, 3, 2 };
        // int[] nums2 = { 2, 1, 3, 4 };
        // System.out.println(maxScore(nums1, nums2, 3));
        // int[] nums1 = { 4, 2, 3, 1, 1 };
        // int[] nums2 = { 7, 5, 1, 9, 6 };
        // System.out.println(maxScore(nums1, nums2, 4));
        // int[] nums1 = { 1, 4 };
        // int[] nums2 = { 3, 1 };
        // System.out.println(maxScore(nums1, nums2, 2));
        int[] nums1 = { 2, 1, 14, 12 };
        int[] nums2 = { 11, 7, 13, 6 };
        System.out.println(maxScore(nums1, nums2, 3));

    }

    public static long maxScore(int[] nums1, int[] nums2, int k) {

        long maxScore = 0;
        if (k == 1) {
            for (int i = 0; i < nums1.length; i++) {
                maxScore = Math.max(maxScore, (long) nums1[i] * nums2[i]);
            }
            return maxScore;
        }

        // Create pairs of (nums1[i], nums2[i])
        int[][] pairs = new int[nums1.length][2];
        for (int i = 0; i < nums1.length; i++) {
            pairs[i] = new int[] { nums1[i], nums2[i] };
        }

        // Sort pairs by nums2 in descending order
        Arrays.sort(pairs, (a, b) -> b[1] - a[1]);

        // Min-heap to keep the smallest elements of nums1
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        long sum = 0;

        for (int i = 0; i < pairs.length; i++) {
            // Remove the smallest element if the heap is already full
            if (minHeap.size() == k) {
                sum -= minHeap.poll()[0];
            }

            // Add the current pair's nums1 value to the sum and heap
            sum += pairs[i][0];
            minHeap.add(pairs[i]);

            // Calculate max score only if we have exactly k elements in the heap
            if (minHeap.size() == k) {
                maxScore = Math.max(maxScore, sum * pairs[i][1]);
            }
        }

        return maxScore;

    }

    // public static long maxScore(int[] nums1, int[] nums2, int k) {

    // long max = 0;
    // if (k == 1) {
    // for (int i = 0; i < nums1.length; i++) {
    // max = Math.max(max, (long) nums1[i] * nums2[i]);
    // }
    // return max;
    // }

    // int[][] pairs = new int[nums1.length][2]; // ninja
    // for (int i = 0; i < nums1.length; i++) {
    // pairs[i] = new int[] { nums1[i], nums2[i] };
    // }
    // Arrays.sort(pairs, (a, b) -> b[1] - a[1]); // descending

    // PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
    // // 3 1|1 2|3 3|2 4| >> This position is the minimum in k interval
    // long sum = 0;
    // for (int i = 0; i < pairs.length; i++) {
    // // System.out.println(pairs.get(i));
    // if (minHeap.size() == k) {
    // // System.out.println("removing " + minHeap.peek());
    // sum = sum - minHeap.peek()[0];
    // minHeap.poll();
    // // System.out.println("removed " + minHeap);
    // }

    // sum = sum + pairs[i][0]; // understand this kind of scenarios.
    // minHeap.add(new int[]{pairs[i][0], pairs[i][1]});

    // if (minHeap.size() == k) {
    // max = Math.max(max, (long) sum * pairs[i][1]);
    // }
    // }

    // return max;

    // }

    // public static long maxScore(int[] nums1, int[] nums2, int k) {

    // long max = 0;
    // if (k == 1) {
    // for (int i = 0; i < nums1.length; i++) {
    // max = Math.max(max, (long) nums1[i] * nums2[i]);
    // }
    // return max;
    // }

    // // int[][] pairs = new int[nums1.length][2]; // ninja
    // // for (int i = 0; i < nums1.length; i++) {
    // // pairs[i] = new int[] { nums1[i], nums2[i] };
    // // }
    // // Arrays.sort(pairs, (a, b) -> a[1]-b[1]); // ascending ninja
    // // Arrays.sort(pairs, (a, b) -> b[1]-a[1]); // descending

    // List<Pair<Integer, Integer>> pairs = new ArrayList<>();
    // for (int i = 0; i < nums1.length; i++) {
    // pairs.add(new Pair<Integer, Integer>(nums1[i], nums2[i]));
    // }
    // // Collections.sort(pairs, (a, b) -> a.getFirst() - b.getFirst()); //
    // ascending
    // // ninja
    // // Collections.sort(pairs, (a, b) -> b.getFirst() - a.getFirst()); //
    // descending
    // Collections.sort(pairs, (a, b) -> b.getSecond() - a.getSecond());
    // // System.out.println(pairs);

    // PriorityQueue<Pair<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) ->
    // a.getFirst() - b.getFirst());
    // // 3 1|1 2|3 3|2 4| >> This position is the minimum in k interval
    // long sum = 0;
    // for (int i = 0; i < pairs.size(); i++) {
    // // System.out.println(pairs.get(i));
    // if (minHeap.size() == k) {
    // // System.out.println("removing " + minHeap.peek());
    // sum = sum - minHeap.peek().getFirst();
    // minHeap.poll();
    // // System.out.println("removed " + minHeap);
    // }

    // sum = sum + pairs.get(i).getFirst(); // understand this kind of scenarios.
    // minHeap.add(new Pair<Integer, Integer>(pairs.get(i).getFirst(),
    // pairs.get(i).getSecond()));

    // if (minHeap.size() == k) {
    // max = Math.max(max, (long) sum * pairs.get(i).getSecond());
    // }
    // }

    // return max;

    // }

    // wrong questions
    // public static long maxScore(int[] nums1, int[] nums2, int k) {

    // int max = 0;
    // if (k == 1) {
    // for (int i = 0; i < nums1.length; i++) {
    // max = Math.max(max, nums1[i] * nums2[i]);
    // }
    // return max;
    // }

    // // int[][] pairs = new int[nums1.length][2]; // ninja
    // // for (int i = 0; i < nums1.length; i++) {
    // // pairs[i] = new int[] { nums1[i], nums2[i] };
    // // }
    // // for (int[] i : pairs) System.out.print(i[0] + " " + i[1] + "|");
    // // Arrays.sort(pairs, (a, b) -> a[1]-b[1]); // ascending ninja
    // // Arrays.sort(pairs, (a, b) -> b[1]-a[1]); // descending
    // // System.out.println();
    // // for (int[] i : pairs) System.out.print(i[0] + " " + i[1] + "|");

    // List<Pair<Integer, Integer>> pairs = new ArrayList<>();
    // for (int i = 0; i < nums1.length; i++) {
    // pairs.add(new Pair<Integer, Integer>(nums1[i], nums2[i]));
    // }
    // // System.out.println(pairs);
    // // Collections.sort(pairs, (a, b) -> a.getFirst() - b.getFirst());
    // Collections.sort(pairs, (a, b) -> a.getFirst() - b.getFirst());
    // System.out.println(pairs);

    // PriorityQueue<Pair<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) ->
    // a.getSecond() - b.getSecond());
    // // 3 1|1 2|3 3|2 4|
    // // | >> This position is the minimum in k interval
    // int sum = 0;
    // for (int i = 0; i < pairs.size(); i++) {
    // // System.out.println(pairs.get(i));
    // if (minHeap.size() == k) {
    // System.out.println("removing");
    // System.out.println(minHeap);
    // sum = sum - minHeap.peek().getFirst();
    // minHeap.poll();
    // sum = sum + pairs.get(i).getFirst();
    // minHeap.add(new Pair<Integer, Integer>(pairs.get(i).getFirst(),
    // pairs.get(i).getSecond()));
    // System.out.println("removed");
    // System.out.println(minHeap);
    // } else {
    // sum = sum + pairs.get(i).getFirst();
    // minHeap.add(new Pair<Integer, Integer>(pairs.get(i).getFirst(),
    // pairs.get(i).getSecond()));
    // }
    // System.out.println("sum " + sum);
    // max = Math.max(max, sum * minHeap.peek().getSecond());
    // System.out.println(minHeap);
    // }

    // return max;

    // }

}
