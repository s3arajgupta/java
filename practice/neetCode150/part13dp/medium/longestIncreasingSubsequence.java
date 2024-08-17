// Ologn BST

package practice.neetCode150.part13dp.medium;

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
        int max = Integer.MIN_VALUE;

        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }

            max = Math.max(max, dp[i]);

        }
        return max;

    }

}