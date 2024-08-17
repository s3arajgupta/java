package practice.neetCode150.part13dp.medium;

import java.util.HashSet;
import java.util.Set;

public class partitionEqualSubsetSum {

    public static void main(String[] args) {

        partitionEqualSubsetSum sol = new partitionEqualSubsetSum();
        int[] nums = { 1, 5, 11, 5 };
        System.out.println(sol.canPartition(nums));

    }

    public boolean canPartition(int[] nums) {

        int sum = 0;
        for (int i : nums)
            sum += i;
        if (sum % 2 == 1)
            return false;

        Set<Integer> dp = new HashSet<>();
        dp.add(0); // if nums is empty.
        int target = sum / 2;

        // for (int i = nums.length - 1; i >= 0; i--) {
        for (int num : nums) {
            Set<Integer> dpNext = new HashSet<>(dp);
            for (int t : dp) {
                dpNext.add(t + num);
                if (dpNext.contains(target))
                    return true;
            }
            // dp = new HashSet<>(dpNext);
            dp = dpNext; // faster

        }
        // return dp.contains(target) ? true : false;
        return dp.contains(target);

    }

}
