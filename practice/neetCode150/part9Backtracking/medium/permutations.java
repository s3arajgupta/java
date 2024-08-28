package practice.neetCode150.part9Backtracking.medium;

import java.util.*;

public class permutations {

    public static void main(String[] args) {

        permutations sol = new permutations();

        int[] nums = { 1, 2, 3 };
        System.out.println(sol.permute(nums));

    }

    List<List<Integer>> results;
    List<Integer> temp;
    int[] nums;
    boolean[] used;

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

                temp.add(nums[i]);
                used[i] = true;
                backtracking();
                temp.remove(temp.size() - 1);
                used[i] = false;

            }

        }

    }

}
