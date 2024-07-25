package practice.neetCode150.part3SlidingWindow.hard;

import java.util.*;

public class slidingWindowMaximum {

    public static void main(String args[]) {

        int[] arr = new int[] { 1, 3, -1, -3, 5, 3, 6, 7 };
        int[] res = maxSlidingWindow(arr, 4);
        // int[] arr = new int[] { 1 };
        // int[] res = maxSlidingWindow(arr, 1);
        // int[] arr = new int[] { 1, -1 };
        // int[] res = maxSlidingWindow(arr, 1);
        for (int c : res)
            System.out.print(c + " ");

    }

    public static int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> deque = new LinkedList<>();

        int r = 0, l = 0, n = nums.length;
        int res[] = new int[n - k + 1];

        while (r < n) {

            if (!deque.isEmpty() && deque.peekFirst() < r - k + 1)
                deque.removeFirst();

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[r]) {
                deque.removeLast();
            }
            deque.add(r);

            if (r >= k - 1) {
                res[l++] = nums[deque.peekFirst()];
            }
            r++;

        }

        return res;

    }

    // public static int[] maxSlidingWindow(int[] nums, int k) {

    // if (k == 0)
    // return nums;
    // if (k == 1)
    // return nums;

    // int[] res = new int[nums.length - k + 1];

    // HashMap<Integer, Integer> map = new HashMap<>();
    // int l = 0;
    // for (int r = 0; r < nums.length; r++) {

    // map.put(r, nums[r]);

    // if (r - l + 1 == k) {
    // // System.out.println("if");
    // res[l] = Collections.max(map.values());
    // map.remove(l);
    // l++;
    // }
    // }

    // return res;
    // }

}
