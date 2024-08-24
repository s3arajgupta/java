package practice.neetCode150.part1ArrayAndHashing.medium;

import java.util.Arrays;

public class productOfArrayExceptSelf {

    public static void main(String args[]) {

        int[] nums = { 1, 2, 3, 4 };
        System.out.println(Arrays.toString(productExceptSelf(nums)));

    }

    public static int[] productExceptSelf(int[] nums) {

        int[] lhs = new int[nums.length];
        int[] rhs = new int[nums.length];

        int product;
        lhs[0] = 1;
        rhs[nums.length - 1] = 1;

        product = lhs[0];
        for (int i = 1; i < nums.length; i++) {
            product *= nums[i - 1];
            lhs[i] = product;
        }

        product = rhs[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            product *= nums[i + 1];
            rhs[i] = product;
        }

        for (int i = 0; i < nums.length; i++)
            nums[i] = lhs[i] * rhs[i];

        return nums;

    }

}
