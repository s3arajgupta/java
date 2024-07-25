package practice.neetCode150.part9Backtracking.medium;

import java.util.*;

public class combinationSumII {

    public static void main(String[] args) {

        combinationSumII sol = new combinationSumII();
        int[] candidates = { 10, 1, 2, 7, 6, 1, 5 };
        System.out.println("result " + sol.combinationSumFunc(candidates, 8));

    }

    private List<List<Integer>> combinations;
    private List<Integer> temp;
    private int target;
    private int[] candidates;

    public List<List<Integer>> combinationSumFunc(int[] candidates, int target) {

        combinations = new ArrayList<>();
        temp = new ArrayList<>();

        this.target = target;
        this.candidates = candidates;
        Arrays.sort(candidates);
        backtracking1(0, 0);

        // this.target = target;
        // this.candidates = candidates;
        // Arrays.sort(candidates);
        // Collections.reverse(Arrays.asList(candidates)); // not necessary but it feels
        // good to write.
        // backtracking2(candidates.length - 1, target);
        return combinations;

    }

    // backtracking(0, 0);
    public void backtracking1(int n, int sumTotal) {

        if (sumTotal == target) {
            combinations.add(new ArrayList<>(temp));
            return;
        }

        for (int i = n; i < candidates.length; i++) {

            if (sumTotal + candidates[i] > target)
                break;

            temp.add(candidates[i]);
            backtracking1(i + 1, sumTotal + candidates[i]);
            temp.remove(temp.size() - 1);

            while (i < candidates.length - 1 && candidates[i] == candidates[i + 1])
                i++;

        }

    }

    // backtracking2(0, target);
    // slower because, we cannot reverse int[], therefore we have to iterate from
    // the back
    // backtracking2(candidates.length - 1, target);
    public void backtracking2(int n, int target) { // backtracking2 optimization is needed

        if (target == 0) {
            combinations.add(new ArrayList<>(temp));
            return;
        }

        for (int i = n; i >= 0; i--) {

            if (target - candidates[i] < 0) {
                continue;
            }

            temp.add(candidates[i]);
            backtracking2(i - 1, target - candidates[i]);
            temp.remove(temp.size() - 1);

            while (i > 0 && candidates[i] == candidates[i - 1])
                i--;

        }

    }

}
