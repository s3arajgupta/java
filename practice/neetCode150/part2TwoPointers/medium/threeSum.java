package practice.neetCode150.part2TwoPointers.medium;

import java.util.*;

public class threeSum {

    public static void main(String args[]) {

        int[] nums = { -2, 0, 0, 2, 2 };
        System.out.println(threeSumFunc(nums));

    }

    public static List<List<Integer>> threeSumFunc(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        int complement = 0;

        for (int i = 0; i < nums.length - 2; i++) {

            if (i != 0 && nums[i] == nums[i - 1])
                continue;

            complement = 0 - nums[i];

            for (int j = i + 1, k = nums.length - 1; j < k;) {

                if (nums[j] + nums[k] == complement) {

                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));

                    while (j < k && nums[j] == nums[j + 1])
                        j++;
                    while (j < k && nums[k] == nums[k - 1])
                        k--;

                    j++;
                    k--;
                    continue;

                }

                if (complement > (nums[j] + nums[k])) {
                    j++;
                    continue;
                }

                if (complement < (nums[j] + nums[k])) {
                    k--;
                    continue;
                }

            }

        }

        return res;

    }

}
