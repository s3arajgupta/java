package practice.neetCode150.part9Backtracking.medium;

import java.util.*;

public class subsetsII {

    public static void main(String[] args) {

        subsetsII sol = new subsetsII();

        int[] nums = { 1, 2, 2 };
        System.out.println(sol.subsetsWithDup(nums));

    }

    List<List<Integer>> results;
    List<Integer> temp;
    int[] nums;

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        results = new ArrayList<>();
        temp = new ArrayList<>();
        this.nums = nums;

        Arrays.sort(nums); // sorted order is must because we don't want the element included in one
                           // decision to appear in other branches.
        backtracking(0);
        return results;

    }

    public void backtracking(int n) {

        if (n == nums.length) {

            results.add(new ArrayList<>(temp));
            return;

        }

        temp.add(nums[n]);
        backtracking(n + 1); // adding next elements which include nums[n] once, including duplicates
                             // elements
        temp.remove(temp.size() - 1); // clearing temp for other nums elements.

        while (n < nums.length - 1 && nums[n] == nums[n + 1])
            n++;
        backtracking(n + 1);

    }

}
