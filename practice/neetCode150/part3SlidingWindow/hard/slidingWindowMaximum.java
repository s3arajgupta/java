package practice.neetCode150.part3SlidingWindow.hard;

import java.util.*;

public class slidingWindowMaximum {

    public static void main(String args[]) {

        int[] arr = new int[] { 1, 3, -1, -3, 5, 3, 6, 7 };
        System.out.println(Arrays.toString(maxSlidingWindow(arr, 4)));

    }

    // optimal
    public static int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> deque = new LinkedList<>();

        int r = 0, l = 0, n = nums.length;
        int res[] = new int[n - k + 1];

        while (r < n) {

            // pop smaller values from the deque
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[r])
                deque.removeLast();

            deque.add(r);

            // remove first value for out of bounds
            if (!deque.isEmpty() && deque.peekFirst() < r - k + 1)
                deque.removeFirst();

            // valid window
            if (r + 1 >= k) {
                res[l] = nums[deque.peekFirst()];
                l++;
            }

            r++;

        }

        return res;

    }

    // public static int[] maxSlidingWindow(int[] nums, int k) {

    //     if (k == 0)
    //         return new int[] {};

    //     if (k == 1)
    //         return nums;

    //     HashMap<Integer, Integer> map = new HashMap<>();
    //     int[] res = new int[nums.length - k + 1];
    //     int l = 0, r = 0;

    //     while (r < nums.length) {

    //         map.put(r, nums[r]);

    //         if (r - l + 1 == k) {
    //             res[l] = Collections.max(map.values());
    //             map.remove(l);
    //             l++;
    //         }

    //         r++;
    //     }

    //     return res;

    // }

}
