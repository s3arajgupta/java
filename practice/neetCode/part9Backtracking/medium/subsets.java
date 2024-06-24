package practice.neetCode.part9Backtracking.medium;

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

        if (n >= nums.length) { // True base condition and other false condition
            // List<Integer> list = new ArrayList<>(temp);
            // res.add(list);
            res.add(new ArrayList<>(temp)); // ninja
            return;
        }

        // include index i
        temp.add(nums[n]);
        backtracking(n + 1, nums);

        // remove index i
        temp.remove(temp.size() - 1);
        backtracking(n + 1, nums);

    }

}
