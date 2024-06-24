package practice.blind75.part9Backtracking.medium;

import java.util.*;

public class permutations {

    public static void main(String[] args) {

        int[] nums = { 1, 2, 3 };
        System.out.println(permute(nums));

    }

    private static List<List<Integer>> results;
    private static List<Integer> temp;

    public static List<List<Integer>> permute(int[] nums) {

        results = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        // for (boolean i : used) System.out.print(i + " "); // default is false.
        temp = new ArrayList<>();
        backtracking(used, temp, nums);
        return results;

    }

    public static void backtracking(boolean[] used, List<Integer> temp, int[] nums) {

        if (temp.size() == nums.length) {
            results.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (!used[i]) { // default is false, so therefore used not is true, which is if nums[i] is not
                            // used then enter.

                // If nums[i] is not used(true) in the current path, Choose the element nums[i]
                temp.add(nums[i]);
                // System.out.println(temp);
                used[i] = true; // next time the if condition will fail
                backtracking(used, temp, nums);

                temp.remove(temp.size() - 1);
                // System.out.println(temp);
                used[i] = false;

            }

        }

    }

}
