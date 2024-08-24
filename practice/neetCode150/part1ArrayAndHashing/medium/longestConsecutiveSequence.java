package practice.neetCode150.part1ArrayAndHashing.medium;

import java.util.HashSet;

public class longestConsecutiveSequence {

    public static void main(String args[]) {

        int[] nums = { 100, 4, 200, 201, 202, 203, 204, 205, 1, 3, 2 };
        System.out.println(longestConsecutive(nums));

    }

    public static int longestConsecutive(int[] nums) {

        if (nums.length == 0)
            return 0;

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++)
            set.add(nums[i]);

        int max = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            if (!set.contains(nums[i] - 1)) {

                while (set.contains(nums[i] + count)) {
                    count++;
                }

                if (max < count)
                    max = count;
                // count = 0; // amazing trick optimal
            }

        }

        return max;
        
    }

}
