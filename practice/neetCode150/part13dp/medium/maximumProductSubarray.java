package practice.neetCode150.part13dp.medium;

public class maximumProductSubarray {

    public static void main(String[] args) {

        maximumProductSubarray sol = new maximumProductSubarray();

        int[] nums = { 2, 3, -2, 4 };
        System.out.println(sol.maxProduct(nums));

    }

    public int maxProduct(int[] nums) {

        int res = nums[0];
        int curMax = nums[0], curMin = nums[0];

        for (int i = 1; i < nums.length; i++) {

            int temp = curMax;
            curMax = Math.max(Math.max(curMax * nums[i], curMin * nums[i]), nums[i]);
            curMin = Math.min(Math.min(temp * nums[i], curMin * nums[i]), nums[i]);

            res = Math.max(res, curMax);

        }

        return res;

    }

}
