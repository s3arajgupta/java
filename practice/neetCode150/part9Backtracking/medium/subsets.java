package practice.neetCode150.part9Backtracking.medium;

import java.util.*;

public class subsets {

    public static void main(String[] args) {

        subsets sol = new subsets();

        int[] nums = { 1, 2, 3 };
        System.out.println(sol.subsetsFunc(nums));

    }

    List<List<Integer>> res;
    List<Integer> temp;

    public List<List<Integer>> subsetsFunc(int[] nums) {

        res = new ArrayList<>();
        temp = new ArrayList<>();

        backtracking(0, nums);
        return res;

    }

    public void backtracking(int n, int[] nums) {

        if (n == nums.length) {

            res.add(new ArrayList<>(temp));
            return;

        }

        temp.add(nums[n]);
        backtracking(n + 1, nums);

        temp.remove(temp.size() - 1);
        backtracking(n + 1, nums);

    }

}
