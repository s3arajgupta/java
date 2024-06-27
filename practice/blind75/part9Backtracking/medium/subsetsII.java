package practice.blind75.part9Backtracking.medium;

import java.util.*;

public class subsetsII {

    public static void main(String[] args) {

        subsetsII sol = new subsetsII();
        int[] nums = { 1, 2, 2 };
        System.out.println(sol.subsetsWithDup(nums));

    }

    private List<List<Integer>> results;
    private List<Integer> temp;
    private int[] nums;

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

        temp.add(nums[n]); // all subsets which include nums[n].
        backtracking(n + 1); // adding next elements which include nums[n] once, include duplicates elements
                             // also.
        temp.remove(temp.size() - 1); // clearing temp for other nums elements.

        // skipping same elements, we use a while loop to skip those.
        while (n < nums.length - 1 && nums[n] == nums[n + 1])
            n++;
        backtracking(n + 1);

    }

}
