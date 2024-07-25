package practice.neetCode150.part9Backtracking.medium;

import java.util.*;

public class combinationSum {

    public static void main(String[] args) {

        combinationSum sol = new combinationSum(); // ninja
        int[] candidates = { 2, 3, 6, 7 };
        Arrays.sort(candidates); // Sorting the candidates array initially can help in early termination of the
                                 // recursion when the current candidate exceeds the target.
        System.out.println("result " + sol.combinationSumFunc(candidates, 7));

    }

    private List<List<Integer>> combinations;
    private List<Integer> temp;
    // private int target; // global doesn't work with static
    private int[] candidates; // global doesn't work with static

    public List<List<Integer>> combinationSumFunc(int[] candidates, int target) {

        combinations = new ArrayList<>();
        temp = new ArrayList<>();
        Arrays.sort(candidates);
        // this.target = target;
        this.candidates = candidates;
        // backtracking(0, 0);
        backtracking(candidates.length - 1, target);
        return combinations;

    }

    // backtracking(0, 0);
    // public void backtracking(int n, int sumTotal) {

    // if (sumTotal == target) {
    // combinations.add(new ArrayList<>(temp));
    // return;
    // }
    // // if (sumTotal > target) // n == candidates.length unnecessary because for
    // loop
    // // handles this.
    // // return; not neccessary

    // for (int i = n; i < candidates.length; i++) { // adding new candidates[n];

    // if (sumTotal + candidates[i] > target) // sorting helped here. Also (sumTotal
    // > target)
    // break; // continue; for -ves // ninja

    // // adding same candidates[i];
    // temp.add(candidates[i]);
    // // for duplicates candidates // 2nd backtracking condition
    // backtracking(i, sumTotal + candidates[i]);
    // // removing same candidates[i];
    // temp.remove(temp.size() - 1); // temp.remove(setList.get(i)); doesn't work
    // }

    // }

    // backtracking(candidates.length - 1, target);
    public void backtracking(int n, int target) {

        if (target == 0) {
            combinations.add(new ArrayList<>(temp));
            return;
        }
        // if (sumTotal > target) // n == candidates.length unnecessary because for loop
        // handles this.
        // return; not neccessary

        for (int i = n; i >= 0; i--) { // adding new candidates[n];

            if (target - candidates[i] < 0) // sorting helped here. Also (sumTotal > target)
                continue;

            // adding same candidates[i];
            temp.add(candidates[i]);
            // for duplicates candidates // 2nd backtracking condition
            backtracking(i, target - candidates[i]);
            // removing same candidates[i];
            temp.remove(temp.size() - 1); // temp.remove(setList.get(i)); doesn't work
        }

    }

}
