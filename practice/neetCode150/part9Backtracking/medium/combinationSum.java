package practice.neetCode150.part9Backtracking.medium;

import java.util.*;

public class combinationSum {

    public static void main(String[] args) {

        combinationSum sol = new combinationSum();

        int[] candidates = { 2, 3, 6, 7 };
        System.out.println("result " + sol.combinationSumFunc(candidates, 7));

    }

    List<List<Integer>> combinations;
    List<Integer> temp;
    int[] candidates;
    int target;

    public List<List<Integer>> combinationSumFunc(int[] candidates, int target) {

        combinations = new ArrayList<>();
        temp = new ArrayList<>();

        this.candidates = candidates;
        Arrays.sort(candidates);
        this.target = target;

        backtracking1(0, 0);
        backtracking2(candidates.length - 1, target);
        return combinations;

    }

    // backtracking(0, 0);
    public void backtracking1(int n, int sumTotal) {

        if (sumTotal == target) {

            combinations.add(new ArrayList<>(temp));
            return;

        }

        for (int i = n; i < candidates.length; i++) {

            if (sumTotal + candidates[i] > target) // Also (sumTotal < 0)
                break; // continue; for -ves // ninja

            temp.add(candidates[i]);
            backtracking1(i, sumTotal + candidates[i]);
            temp.remove(temp.size() - 1);

        }

    }

    // backtracking(candidates.length - 1, target);
    public void backtracking2(int n, int target) {

        if (target == 0) {

            combinations.add(new ArrayList<>(temp));
            return;

        }

        for (int i = n; i >= 0; i--) {

            if (target - candidates[i] < 0) // Also (sumTotal > target)
                continue; // break; for +ves // ninja

            temp.add(candidates[i]);
            backtracking2(i, target - candidates[i]);
            temp.remove(temp.size() - 1);

        }

    }

}
