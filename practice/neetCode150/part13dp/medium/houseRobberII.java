package practice.neetCode150.part13dp.medium;

import java.util.Arrays;

public class houseRobberII {

    public static void main(String[] args) {

        // int[] nums = { 2, 3, 2 };
        // int[] nums = { 1, 2, 3, 1 };
        // int[] nums = { 1, 2, 3 };
        int[] nums = { 1 };
        houseRobberII sol = new houseRobberII();
        System.out.println(sol.rob(nums));
    }

    public int houseRobberI(int[] nums) {

        int rob1 = 0, rob2 = 0, temp = 0;

        // [rob1, rob2, i, i+1]
        for (int i : nums) {
            temp = Math.max(i + rob1, rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        return rob2;

    }

    public int rob(int[] nums) {

        int n = nums.length;
        if (n == 1)
            return nums[0];
        return Math.max(houseRobberI(Arrays.copyOfRange(nums, 1, n)),
                houseRobberI(Arrays.copyOfRange(nums, 0, n - 1)));
    }

}
