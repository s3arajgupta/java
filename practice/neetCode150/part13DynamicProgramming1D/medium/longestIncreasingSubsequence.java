package practice.neetCode150.part13DynamicProgramming1D.medium;

import java.util.Arrays;

public class longestIncreasingSubsequence {

    public static void main(String[] args) {

        longestIncreasingSubsequence sol = new longestIncreasingSubsequence();

        int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
        System.out.println(sol.lengthOfLIS(nums));

    }

    public int lengthOfLIS(int[] nums) {

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        int maxSoFar = Integer.MIN_VALUE;

        for (int i = nums.length - 1; i >= 0; i--) {

            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] < nums[j])
                    dp[i] = Math.max(dp[i], 1 + dp[j]);

            }

            maxSoFar = Math.max(maxSoFar, dp[i]);

        }

        return maxSoFar;

    }

    // public int lengthOfLIS(int[] nums) {

    //     int[] tail = new int[nums.length];
    //     int size = 0;

    //     for (int i : nums) {

    //         int left = 0, right = size - 1;

    //         while (left <= right) {

    //             int mid = left + (right - left) / 2;

    //             if (tail[mid] < i)
    //                 left = mid + 1;

    //             else
    //                 right = mid - 1;

    //         }

    //         tail[left] = i;

    //         if (left == size)
    //             size++;

    //     }

    //     return size;

    // }

}
