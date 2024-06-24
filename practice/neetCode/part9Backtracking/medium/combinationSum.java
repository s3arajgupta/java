// Sorting Candidates:
// Sorting the candidates array initially can help in early termination of the recursion when the current candidate exceeds the target.

// Distinct
// what is decision tree?
// elimination backtracking when target is found
// handling duplicates
// temp.remove(setList.get(n)); // in List<Integer> removing works like array subset.remove(subset.size() - 1);

package practice.neetCode.part9Backtracking.medium;

import java.util.*;

public class combinationSum {

    public static void main(String[] args) {

        int[] candidates = { 2, 3, 6, 7 };
        System.out.println("result " + combinationSumFunc(candidates, 7));

    }

    private static List<List<Integer>> combinations;
    private static List<Integer> temp;

    public static List<List<Integer>> combinationSumFunc(int[] candidates, int target) {

        combinations = new ArrayList<>();
        temp = new ArrayList<>();
        backtracking(0, temp, 0, target, candidates);
        return combinations;

    }

    public static void backtracking(int n, List<Integer> temp, int sumTotal, int target, int[] candidates) {

        if (sumTotal == target) {
            // System.out.println("answer " + temp);
            combinations.add(new ArrayList<>(temp));
            return;
        }
        if (n >= candidates.length || sumTotal > target)
            return;

        // adding same candidates[n];
        temp.add(candidates[n]);
        backtracking(n, temp, sumTotal + candidates[n], target, candidates);

        // removing same candidates[n];
        temp.remove(temp.size() - 1);
        
        // adding new candidates[n];
        backtracking(n + 1, temp, sumTotal, target, candidates);

    }

    // private static List<List<Integer>> combinations;
    // private static List<Integer> sumList;

    // public static List<List<Integer>> combinationSumFunc(int[] candidates, int
    // target) {

    // combinations = new ArrayList<>();
    // sumList = new ArrayList<>();
    // backtracking(0, candidates, target);
    // return combinations;

    // }

    // public static void backtracking(int n, int[] candidates, int target) {

    // if (n >= candidates.length) {
    // int sum = 0;
    // for (int i = 0; i < sumList.size(); i++) {
    // sum += sumList.get(i);
    // }
    // if (sum == target)
    // combinations.add(new ArrayList<>(sumList));
    // // combinations.add(new ArrayList<>(sumList));
    // return;
    // }

    // sumList.add(candidates[n]);
    // backtracking(n + 1, candidates, target);

    // sumList.remove(sumList.size() - 1);
    // backtracking(n + 1, candidates, target);

    // }

}
