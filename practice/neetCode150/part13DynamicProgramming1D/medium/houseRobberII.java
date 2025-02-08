package practice.neetCode150.part13DynamicProgramming1D.medium;

public class houseRobberII {

    public static void main(String[] args) {

        houseRobberII sol = new houseRobberII();

        int[] nums = { 1, 2, 3, 1 };
        System.out.println(sol.rob(nums));

    }

    public int houseRobberI(int[] nums, int start, int end) {

        int rob1 = 0, rob2 = 0, temp = 0;

        for (int i = start; i <= end; i++) {

            temp = Math.max(nums[i] + rob1, rob2);
            rob1 = rob2;
            rob2 = temp;

        }

        return rob2;

    }

    public int rob(int[] nums) {

        int n = nums.length;

        if (n == 1)
            return nums[0];

        // Rob houses 1 to n-1 (skip the first house)
        int max1 = houseRobberI(nums, 0, n - 2);
        // Rob houses 2 to n (skip the last house)
        int max2 = houseRobberI(nums, 1, n - 1);

        return Math.max(max1, max2);

    }

}
