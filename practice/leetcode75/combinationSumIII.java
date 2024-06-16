package practice.leetcode75;

import java.util.*;

public class combinationSumIII {

    public static void main(String[] args) {

        System.out.println("result " + combinationSum3(3, 7));
        System.out.println("result " + combinationSum3(2, 1));

    }

    public static List<List<Integer>> combinationSum3(int k, int n) {

        result = new ArrayList<>();
        backtracking(1, 0, k, n, new ArrayList<>());
        return result;

    }

    public static List<List<Integer>> result;

    public static void backtracking(int start, int sumTotal, int k, int target, List<Integer> temp) {

        if (target == sumTotal && temp.size() == k) {
            result.add(new ArrayList<>(temp));
            return;
        }
        if (target < sumTotal) // Not Neccessary because it deplays next iteration
            return;

        for (int i = start; i <= 9; i++) {

            temp.add(i);
            backtracking(i + 1, sumTotal + i, k, target, temp);
            temp.remove(temp.size() - 1);

        }

        // public static List<List<Integer>> combinationSum3(int k, int n) {

        // result = new ArrayList<>();
        // temp = new ArrayList<>();
        // boolean[] used = new boolean[10];
        // System.out.println(Arrays.toString(used));
        // backtracking(0, k, n, temp, used);
        // return result;

        // }

        // public static List<List<Integer>> result;
        // public static List<Integer> temp;
        // public static Integer sumTotal;

        // public static void backtracking(int sumTotal, int k, int target,
        // List<Integer> temp, boolean[] used) {

        // if (target == sumTotal && temp.size() == k) {
        // result.add(new ArrayList<>(temp));
        // return;
        // }
        // if (target < sumTotal)
        // return;

        // for (int i = 1; i < 10; i++) {
        // if (!used[i]) {

        // used[i] = true;
        // temp.add(i);
        // backtracking(sumTotal + i, k, target, temp, used);
        // temp.remove(temp.size() - 1);
        // used[i] = false;

        // }
        // }

    }

}
