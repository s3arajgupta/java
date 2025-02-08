package practice.neetCode150.part15Greedy.medium;

public class maximumSubarray {

    public static void main(String[] args) {

        maximumSubarray obj = new maximumSubarray();

        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(obj.maxSubArray(nums));

    }

    public int maxSubArray(int[] nums) {

        int max = nums[0];
        int currSum = 0;

        for (int i = 0; i < nums.length; i++) {

            if (currSum < 0) // negative prefix
                currSum = 0;

            currSum = currSum + nums[i];

            if (currSum > max)
                max = currSum;

        }

        return max;

    }

}
