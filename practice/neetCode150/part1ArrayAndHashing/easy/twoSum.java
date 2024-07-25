package practice.neetCode150.part1ArrayAndHashing.easy;

import java.util.HashMap;

public class twoSum {

    public static void main(String args[]) {

        // int[] nums = new int[]{3,2,4};
        int[] nums = new int[] { 2, 5, 7, 11, 15 };
        int[] res = new int[2];

        res = twoSumFunc(nums, 18);
        System.out.println(res[0] + " " + res[1]);

    }

    static public int[] twoSumFunc(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                // System.out.println("if");
                return new int[] { map.get(diff), i };
            }
            map.put(nums[i], i);
        }
        return new int[] { -1, -1 };

    }
}
