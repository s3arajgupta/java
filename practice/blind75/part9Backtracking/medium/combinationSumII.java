// System.out.println("Reverse sorted array: " + Arrays.toString(sortedNumbers));
package practice.blind75.part9Backtracking.medium;

import java.util.*;

public class combinationSumII {

    public static void main(String[] args) {

        int[] candidates = { 10, 1, 2, 7, 6, 1, 5 };
        System.out.println("result " + combinationSumFunc(candidates, 8));

    }

    private static List<List<Integer>> combinations;
    private static List<Integer> temp;

    public static List<List<Integer>> combinationSumFunc(int[] candidates, int target) {

        combinations = new ArrayList<>();
        temp = new ArrayList<>();
        Arrays.sort(candidates);
        // backtracking(0, temp, 0, target, candidates);

        // Arrays.sort(candidates, Collections.reverseOrder()); // doesn't work on int[]
        // candidates = Arrays.stream(candidates)
        // .boxed()
        // .sorted(Comparator.reverseOrder())
        // .mapToInt(Integer::intValue)
        // .toArray();
        // System.out.println(Arrays.toString(candidates)); // ninja
        backtracking(candidates.length - 1, temp, target, candidates);
        return combinations;

    }

    public static void backtracking(int n, List<Integer> temp, int target, int[] candidates) { // better than 2nd
                                                                                               // BackTracking Function

        if (target == 0) {
            combinations.add(new ArrayList<>(temp));
            return;
        }
        if (target < 0 || n < 0)
            return;

        temp.add(candidates[n]);
        // System.out.println(temp);
        backtracking(n - 1, temp, target - candidates[n], candidates);
        temp.remove(temp.size() - 1);
        // System.out.println(temp);
        while (n >= 1 && candidates[n] == candidates[n - 1])
            n--;
        backtracking(n - 1, temp, target, candidates);

    }

    // public static void backtracking(int n, List<Integer> temp, int sumTotal, int
    // target, int[] candidates) {

    // if (sumTotal == target) {
    // combinations.add(new ArrayList<>(temp));
    // return;
    // }
    // if (sumTotal > target || n >= candidates.length)
    // return;

    // temp.add(candidates[n]);
    // // System.out.println(temp);
    // backtracking(n + 1, temp, sumTotal + candidates[n], target, candidates);
    // temp.remove(temp.size() - 1);
    // // System.out.println(temp);
    // while (n < candidates.length - 1 && candidates[n] == candidates[n + 1])
    // n++;
    // backtracking(n + 1, temp, sumTotal, target, candidates);

    // }

}
