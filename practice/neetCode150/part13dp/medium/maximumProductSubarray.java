package practice.neetCode150.part13dp.medium;

public class maximumProductSubarray {

    public static void main(String[] args) {

        maximumProductSubarray sol = new maximumProductSubarray();
        // int[] nums = { 2, 3, -2, 4 };
        int[] nums = { 0, 10, 10, 10, 10, 10, 10, 10, 10, 10, -10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 0 };
        System.out.println(sol.maxProduct(nums));

    }

    public int maxProduct(int[] nums) {

        if (nums.length == 0)
            return 0; // edge
        if (nums.length == 1)
            return nums[0]; // edge

        int res = nums[0], curMax = nums[0], curMin = nums[0], n = nums.length, temp;

        for (int i = 1; i < n; i++) {

            if (nums[i] < 0) {
                temp = curMax;
                curMax = curMin;
                curMin = temp;
            }

            curMax = Math.max(curMax * nums[i], nums[i]);
            curMin = Math.min(curMin * nums[i], nums[i]);

            res = Math.max(res, curMax);
        }

        return res;

    }

    // public int maxProduct(int[] nums) {

    //     if (nums.length == 0)
    //         return 0; // edge
    //     if (nums.length == 1)
    //         return nums[0]; // edge

    //     int res = nums[0], temp;
    //     int curMax = nums[0], curMin = nums[0];

    //     for (int i = 1; i < nums.length; i++) {

    //         // edge 0 not needed

    //         if (nums[i] < 0) {
    //             temp = curMax;
    //             curMax = curMin;
    //             curMin = temp;
    //         }

    //         curMax = Math.max(nums[i], curMax * nums[i]);
    //         curMin = Math.min(nums[i], curMin * nums[i]);
    //         // System.out.println(curMax + " " + curMin);
    //         res = Math.max(res, curMax);

    //     }

    //     return res;

    // }

    // public int maxProduct(int[] nums) {
    // if (nums.length == 1)
    // return nums[0];

    // int res = nums[0];
    // int max = 1;
    // int min = 1;

    // for (int n : nums) {
    // int tmp = max * n;
    // max = Math.max(n, Math.max(tmp, min * n));
    // min = Math.min(n, Math.min(tmp, min * n));
    // res = Math.max(res, max);
    // }
    // return res;
    // }

}
