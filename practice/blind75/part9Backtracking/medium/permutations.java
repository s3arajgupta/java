package practice.blind75.part9Backtracking.medium;

import java.util.*;

public class permutations {

    public static void main(String[] args) {

        permutations sol = new permutations();
        int[] nums = { 1, 2, 3 };
        System.out.println(sol.permute(nums));

    }

    private List<List<Integer>> results;
    private List<Integer> temp;
    private int[] nums;
    private boolean[] used; // default is false.

    public List<List<Integer>> permute(int[] nums) {

        results = new ArrayList<>();
        temp = new ArrayList<>();
        this.nums = nums;
        this.used = new boolean[nums.length];
        backtracking();
        return results;

    }

    public void backtracking() {

        if (temp.size() == nums.length) {
            results.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (!used[i]) { // default is false, so therefore used not is true, which is if nums[i] is not
                            // used then enter.

                // If nums[i] is not used(true) in the current path, Choose the element nums[i]
                temp.add(nums[i]);
                used[i] = true; // next time, the if condition will fail
                backtracking();

                temp.remove(temp.size() - 1);
                used[i] = false;

            }

        }

    }

}
