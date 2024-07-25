package practice.neetCode150.part9Backtracking.medium;

import java.util.*;

public class subsets {

    public static void main(String[] args) {

        int[] nums = { 1, 2, 3 };
        System.out.println(subsetsFunc(nums));

    }

    private static List<List<Integer>> res; // ninja
    private static List<Integer> temp; // ninja

    public static List<List<Integer>> subsetsFunc(int[] nums) {

        res = new ArrayList<>();
        temp = new ArrayList<>();
        backtracking(0, nums);
        return res;

    }

    public static void backtracking(int n, int[] nums) {

        if (n == nums.length) { // n == nums.length but temp = nums.length - 1, therefore inbounds
            res.add(new ArrayList<>(temp));
            return;
        }

        // include index n in temp
        temp.add(nums[n]);
        backtracking(n + 1, nums);

        // remove index n from temp
        temp.remove(temp.size() - 1);
        backtracking(n + 1, nums);

    }

}
